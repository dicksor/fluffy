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

import fluffy.imageprocessing.OpenCvUtil;

public class CameraZoom extends CameraDecorator {

	public CameraZoom(ICamera camera, double scale) {
		super(camera);
		this.scale = scale;
	}
	
	@Override
	public Mat getImage() {
		return this.getImageWithZoom(super.getImage());
	}
	
	private Mat getImageWithZoom(Mat m) {
		return OpenCvUtil.zoomImage(m, this.scale);
	}
	
	private double scale;

}
