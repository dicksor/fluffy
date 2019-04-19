/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.network.camera.pipeline;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import fluffy.imageprocessing.OpenCvFaceDetection;

public class OperatorFaceDetection extends AbstractOperator {

	public OperatorFaceDetection(boolean isActive) {
		super(isActive);
		this.faceDetection = new OpenCvFaceDetection();
	}

	@Override
	public Mat operate(Mat image) {
		MatOfRect faceDetections = faceDetection.detecte(image);
		for (Rect rect : faceDetections.toArray()) {
			Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 3);
		}
		return image;
	}
	
	private OpenCvFaceDetection faceDetection;

}
