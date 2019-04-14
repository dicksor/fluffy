package fluffy.network.camera.decorator;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.camera.exception.EmptyImageException;

public class CameraZoom extends CameraDecorator {

	public CameraZoom(ICamera camera, double scale) {
		super(camera);
		this.scale = scale;
	}
	
	@Override
	public Mat getImage() throws EmptyImageException {
		return this.getImageWithZoom(super.getImage());
	}
	
	private Mat getImageWithZoom(Mat m) {
		return OpenCvUtil.zoomImage(m, this.scale);
	}
	
	private double scale;

}
