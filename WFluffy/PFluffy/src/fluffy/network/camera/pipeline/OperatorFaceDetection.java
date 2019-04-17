package fluffy.network.camera.pipeline;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvFaceDetection;

public class OperatorFaceDetection extends AbstractOperator {

	public OperatorFaceDetection(boolean isActive) {
		super(isActive);
		this.faceDetection = new OpenCvFaceDetection("C:\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml");
	}

	@Override
	public Mat operate(Mat image) {
		return this.faceDetection.detecte(image);
	}
	
	private OpenCvFaceDetection faceDetection;

}
