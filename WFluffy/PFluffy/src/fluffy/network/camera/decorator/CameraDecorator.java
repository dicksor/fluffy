package fluffy.network.camera.decorator;

import org.opencv.core.Mat;

import fluffy.network.camera.exception.EmptyImageException;

public abstract class CameraDecorator implements ICamera {

	public CameraDecorator(ICamera camera) {
		this.camera = camera;
	}

	@Override
	public Mat getImage() throws EmptyImageException {
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
