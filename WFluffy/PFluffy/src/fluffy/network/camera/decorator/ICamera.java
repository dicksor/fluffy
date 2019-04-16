package fluffy.network.camera.decorator;

import org.opencv.core.Mat;

import fluffy.network.camera.exception.EmptyImageException;

public interface ICamera {

	public Mat getImage() throws EmptyImageException;
	
	public boolean open();
	
	public void release();
	
}
