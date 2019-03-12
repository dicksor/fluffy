package fluffy.network.camera;

import org.opencv.core.Mat;

public interface ICamera {

	public Mat getImage();
	
	public boolean open();
	
	public void release();
	
}
