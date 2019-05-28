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

public class OperatorZoom extends AbstractOperator {

	public OperatorZoom(boolean isActive, int scale) {
		super(isActive);
		this.scale = scale;
	}

	@Override
	public Mat operate(Mat image) {
		return OpenCvUtil.zoomImage(image, this.scale);
	}
	
	public void setScale(int scale) {
		this.scale = scale;
	}
	
	private int scale;

}
