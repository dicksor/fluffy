
package fluffy.imageprocessing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import fluffy.imageprocessing.snapshot.AutoSnapshotTaker;
import fluffy.network.camera.ICamera;

public class OpenCvFaceDetection extends OpenCvDetection
	{

	SimpleDateFormat format;
	Date dateCapture;
	Date dateActuelle;
	String strDateCapture;

	public OpenCvFaceDetection(String xmlModelFile, ICamera camera)
		{
		// "C:\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml"
		super(xmlModelFile);

		this.camera = camera;

		try
			{
			format = new SimpleDateFormat("HH.mm.ss");
			dateCapture = format.parse(format.format(new Date()));
			}
		catch (ParseException e)
			{
			e.printStackTrace();
			}
		}

	public Mat detecte(Mat m)
		{
		MatOfRect faceDetections = new MatOfRect();
		this.classifier.detectMultiScale(m, faceDetections);

		try
			{
			dateActuelle = format.parse(format.format(new Date()));
			long difference = dateActuelle.getTime() - dateCapture.getTime();

			if(difference >= DELAY_BETWEEN_CAPTURE)
				{
				String strDateCapture = format.format(new Date());
				dateCapture = format.parse(strDateCapture);
				Thread snapThread = new Thread(new AutoSnapshotTaker(camera, strDateCapture));
				snapThread.start();
				}
			}
		catch (ParseException e)
			{
			e.printStackTrace();
			}

		for(Rect rect:faceDetections.toArray())
			{
			Imgproc.rectangle(m, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 3);
			}

		// TODO : return object with matrix, and face detected count
		return m;
		}

	ICamera camera;
	private static final long DELAY_BETWEEN_CAPTURE = 5000;//temps en milliseconde
	}
