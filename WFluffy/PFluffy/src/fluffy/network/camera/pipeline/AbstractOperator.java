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

public abstract class AbstractOperator {
	
	public AbstractOperator(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean isActive() {
		return this.isActive;
	}
	
	public abstract Mat operate(Mat image);
	
	private boolean isActive;
	
}
