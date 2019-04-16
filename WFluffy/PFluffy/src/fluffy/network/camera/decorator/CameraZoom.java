/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.network.camera.decorator;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.camera.exception.EmptyImageException;

public class CameraZoom extends CameraDecorator {

	public CameraZoom(ICamera camera, int scale) {
		super(camera);
		this.scale = scale;
	}

	@Override
	public Mat getImage() throws EmptyImageException {
		return this.getImageWithZoom(super.getImage());
	}
	
	public void setScale(int scaleFactor) {
		this.scale = scaleFactor;
	}

	private Mat getImageWithZoom(Mat m) {
		return OpenCvUtil.zoomImage(m, this.scale);
	}

	private int scale;

}
