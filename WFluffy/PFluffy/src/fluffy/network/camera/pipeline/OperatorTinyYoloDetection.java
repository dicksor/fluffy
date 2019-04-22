package fluffy.network.camera.pipeline;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvYoloDetection;

public class OperatorTinyYoloDetection extends AbstractOperator {

	public OperatorTinyYoloDetection(boolean isActive) {
		super(isActive);
		this.openCvTinyYoloDetection = new OpenCvYoloDetection("yolov3\\yolov3tiny.weights", "yolov3\\yolov3tiny.cfg", 0.30f);
	}

	@Override
	public Mat operate(Mat image) {
		return this.openCvTinyYoloDetection.feedForward(image);
	}

	private OpenCvYoloDetection openCvTinyYoloDetection;
}
