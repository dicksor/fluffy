package fluffy.network.camera.pipeline;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvYoloDetection;

public class OperatorYoloDetection extends AbstractOperator {

	public OperatorYoloDetection(boolean isActive) {
		super(isActive);
		this.yoloDetection = new OpenCvYoloDetection();
	}

	@Override
	public Mat operate(Mat image) {
		return this.yoloDetection.feedForward(image);
	}
	
	private OpenCvYoloDetection yoloDetection;

}
