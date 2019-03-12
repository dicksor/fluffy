package fluffy.network.camera;

import org.opencv.core.Mat;

public abstract class CameraDecorator implements ICamera {

	public CameraDecorator(ICamera camera) {
		this.camera = camera;
	}

	@Override
	public Mat getImage() {
		return this.camera.getImage();
	}
	
	@Override
	public boolean open() {
		return this.camera.open();
	}
	
	@Override
	public void release() {
		this.camera.release();
	}

	private ICamera camera;

}
