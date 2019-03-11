package fluffy.imageprocessing;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class OpenCvFaceDetection extends OpenCvDetection {

	public OpenCvFaceDetection(String xmlModelFile) {
		// "C:\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml"
		super(xmlModelFile);		
	}
	
	public Mat detecte(Mat m) {
		MatOfRect faceDetections = new MatOfRect();
		this.classifier.detectMultiScale(m, faceDetections);

		for (Rect rect : faceDetections.toArray()) {
			Imgproc.rectangle(m,
					new Point(rect.x, rect.y),
					new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 
					3 
			);
		}
		
		// TODO : return object with matrix, and face detected count
		return m;
	}

}
