package fluffy.network.camera;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvFaceDetection;

public class CameraFaceDetection extends CameraDecorator {

	public CameraFaceDetection(ICamera camera) {
		super(camera);
		this.faceDetection = new OpenCvFaceDetection("C:\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml", camera);
	}

	@Override
	public Mat getImage() {
		return this.getImageWithFaceDetection(super.getImage());
	}

	private Mat getImageWithFaceDetection(Mat m) {
		return this.faceDetection.detecte(m);
	}

	private OpenCvFaceDetection faceDetection;

}
