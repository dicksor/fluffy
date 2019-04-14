package fluffy.network.camera.decorator;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvFaceDetection;
import fluffy.network.camera.exception.EmptyImageException;

public class CameraFaceDetection extends CameraDecorator {

	public CameraFaceDetection(ICamera camera) {
		super(camera);
		this.faceDetection = new OpenCvFaceDetection("C:\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml");
	}
	
	@Override
	public Mat getImage() throws EmptyImageException {
		return this.getImageWithFaceDetection(super.getImage());
	}
	
	private Mat getImageWithFaceDetection(Mat m) {
		return this.faceDetection.detecte(m);
	}
	
	private OpenCvFaceDetection faceDetection;
	
}
