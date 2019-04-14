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

public class CameraRotation extends CameraDecorator {

	public CameraRotation(ICamera camera, double angle) {
		super(camera);
		this.angle = angle;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	@Override
	public Mat getImage() {
		return this.getImageWithRotation(super.getImage());
	}
	
	private Mat getImageWithRotation(Mat m) {
		return OpenCvUtil.rotateImage(m, this.angle);
	}
	
	private double angle;

}
