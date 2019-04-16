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
