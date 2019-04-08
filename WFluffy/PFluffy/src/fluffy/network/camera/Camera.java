package fluffy.network.camera;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class Camera implements ICamera {

	public Camera(String link) {
		this.link = link;
		this.camera = new VideoCapture();
	}

	@Override
	public boolean open() {
		// TODO : remove when not in dev
		if (this.link != "") {
			this.camera.open(this.link);
		} else {
			// Open Webcam
			this.camera.open(0);
		}

		return this.camera.isOpened();
	}
	
	@Override
	public void release() {
		// TODO : check for error
		this.camera.release();
	}

	@Override
	public Mat getImage() {
		// TODO : test error
		Mat frame = new Mat();

		camera.grab();
		camera.retrieve(frame);
		camera.read(frame);
		System.out.println(frame.size());
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
