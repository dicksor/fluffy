/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.imageprocessing;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;

/**
 * This class is used to detect faces on an image using OpenCv's provided cascade model
 */
public class OpenCvFaceDetection extends OpenCvDetection {

	public OpenCvFaceDetection() {
		super("C:\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml");
	}

	public MatOfRect detecte(Mat m) {
		MatOfRect faceDetections = new MatOfRect();
		this.classifier.detectMultiScale(m, faceDetections);
		return faceDetections;
	}

}
