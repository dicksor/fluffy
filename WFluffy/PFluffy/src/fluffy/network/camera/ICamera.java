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

public interface ICamera {

	public Mat getImage();
	
	public boolean open();
	
	public void release();
	
}
