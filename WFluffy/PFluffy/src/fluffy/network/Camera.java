package fluffy.network;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class Camera {

	public Camera(String link) {
		this.link = link;
		this.camera = new VideoCapture();
	}

	public boolean open() {
		this.camera.open(this.link);

		return this.camera.isOpened();
	}

	public void release() {
		// TODO : check for error
		this.camera.release();
	}

	public Mat getImage() {
		// TODO : test error
		Mat frame = new Mat();

		camera.grab();
		camera.retrieve(frame);
		camera.read(frame);

		return frame;
	}

	@Override
	protected void finalize() throws Throwable {
		if (this.camera.isOpened())
			this.camera.release();
	}

	private VideoCapture camera;
	private String link;

}
