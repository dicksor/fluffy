/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.imageprocessing.snapshot;

import java.beans.PropertyChangeListener;
import org.opencv.core.Mat;

public abstract class SnapshotTaker implements PropertyChangeListener {
	
	protected void setImage(Mat image) {
		this.image = image;
	}
	
	protected Mat getImage() {
		return this.image;
	}
	
	private Mat image;

}
