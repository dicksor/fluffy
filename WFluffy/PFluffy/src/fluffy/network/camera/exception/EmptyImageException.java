/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.network.camera.exception;

public class EmptyImageException extends Exception {

	public EmptyImageException() {
		super();
	}

	public EmptyImageException(String message) {
		super(message);
	}

	public EmptyImageException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyImageException(Throwable cause) {
		super(cause);
	}

}
