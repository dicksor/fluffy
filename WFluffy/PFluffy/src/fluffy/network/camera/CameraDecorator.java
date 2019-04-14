/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
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
