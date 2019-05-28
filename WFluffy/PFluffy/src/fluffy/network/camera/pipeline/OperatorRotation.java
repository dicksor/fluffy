/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.network.camera.pipeline;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvUtil;

public class OperatorRotation extends AbstractOperator {
	
	public OperatorRotation(boolean isActive, double angle) {
		super(isActive);
		this.angle = angle;
	}

	@Override
	public Mat operate(Mat image) {
		return OpenCvUtil.rotateImage(image, this.angle);
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	private double angle;

}
