
package fluffy.imageprocessing;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.dnn.Dnn;
import org.opencv.dnn.Net;
import org.opencv.imgproc.Imgproc;
import org.opencv.utils.Converters;

// Based on : https://github.com/suddh123/YOLO-object-detection-in-java/blob/code/yolo.java
public class OpenCvYoloDetection
	{

	public OpenCvYoloDetection(String model, String config, float confThreshold)
		{
		this.support = new PropertyChangeSupport(this);
		this.classes = new LinkedList<String>();
		this.readClasses();
		this.net = Dnn.readNet(model, config);
		this.confThreshold = confThreshold;
		this.detectedClasses = new ConcurrentHashMap<String, AtomicInteger>();
		}

	public Mat feedForward(Mat image)
		{
		ConcurrentMap<String, AtomicInteger> stats = new ConcurrentHashMap<String, AtomicInteger>();

		Size sz = new Size(288, 288);

		List<Mat> result = new ArrayList<>();
		List<String> outBlobNames = getOutputNames();

		Mat blob = Dnn.blobFromImage(image, 0.00392, sz, new Scalar(0), true, false);
		this.net.setInput(blob);

		this.net.forward(result, outBlobNames);

		List<Integer> clsIds = new ArrayList<Integer>();
		List<Float> confs = new ArrayList<Float>();
		List<Rect> rects = new ArrayList<Rect>();
		for(int i = 0; i < result.size(); ++i)
			{
			Mat level = result.get(i);

			for(int j = 0; j < level.rows(); ++j)
				{
				Mat row = level.row(j);
				Mat scores = row.colRange(5, level.cols());
				Core.MinMaxLocResult mm = Core.minMaxLoc(scores);
				float confidence = (float)mm.maxVal;
				Point classIdPoint = mm.maxLoc;
				if (confidence > confThreshold)
					{
					int centerX = (int)(row.get(0, 0)[0] * image.cols());
					int centerY = (int)(row.get(0, 1)[0] * image.rows());
					int width = (int)(row.get(0, 2)[0] * image.cols());
					int height = (int)(row.get(0, 3)[0] * image.rows());
					int left = centerX - width / 2;
					int top = centerY - height / 2;

					clsIds.add((int)classIdPoint.x);
					confs.add(confidence);
					rects.add(new Rect(left, top, width, height));
					}
				}
			}

		if (confs.size() > 0)
			{
			float nmsThresh = 0.5f;
			MatOfFloat confidences = new MatOfFloat(Converters.vector_float_to_Mat(confs));
			Rect[] boxesArray = rects.toArray(new Rect[0]);
			MatOfRect boxes = new MatOfRect(boxesArray);
			MatOfInt indices = new MatOfInt();
			Dnn.NMSBoxes(boxes, confidences, confThreshold, nmsThresh, indices);

			int[] ind = indices.toArray();
			final Scalar RED_COLOR = new Scalar(0, 0, 255);
			for(int i = 0; i < ind.length; ++i)
				{
				int idx = ind[i];
				Rect box = boxesArray[idx];
				Imgproc.rectangle(image, box.tl(), box.br(), new Scalar(0, 0, 255), 2);
				String predictionLabel = this.classes.get(clsIds.get(idx));
				stats.putIfAbsent(predictionLabel, new AtomicInteger(0));
				stats.get(predictionLabel).incrementAndGet();
				Imgproc.putText(image, predictionLabel, box.tl(), Imgproc.FONT_HERSHEY_SIMPLEX, 2, RED_COLOR);
				}

			support.firePropertyChange("detectionStatistic", this.detectedClasses, stats);
			this.detectedClasses = stats;
			this.detectedClasses.clear();

			Mat resizedImage = new Mat();
			Imgproc.resize(image, resizedImage, image.size());
			return resizedImage;
			}

		return image;
		}

	public void addPropertyChangeListener(PropertyChangeListener pcl)
		{
		support.addPropertyChangeListener(pcl);
		}

	public void removePropertyChangeListener(PropertyChangeListener pcl)
		{
		support.removePropertyChangeListener(pcl);
		}

	private List<String> getOutputNames()
		{
		List<String> names = new ArrayList<String>();

		List<Integer> outLayers = this.net.getUnconnectedOutLayers().toList();
		List<String> layersNames = this.net.getLayerNames();

		outLayers.forEach((item) -> names.add(layersNames.get(item - 1)));

		return names;
		}

	private void readClasses()
		{

		final String DEP = "ext\\yolov\\yolov3.txt";
		final String DEV = "..\\PDeploy\\Deploy\\ext\\yolov\\yolov3.txt";
		try (Stream<String> stream = Files.lines(Paths.get(DEP)))
			{
			stream.forEach((predictionClass) -> this.classes.add(predictionClass));
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		}

	private Net net;
	private List<String> classes;
	private float confThreshold;
	private PropertyChangeSupport support;
	private ConcurrentMap<String, AtomicInteger> detectedClasses;

	}
