/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.network.camera.decorator;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import fluffy.network.camera.exception.EmptyImageException;

public class Camera implements ICamera {

	public Camera(String link) {
		this.link = link;
		this.camera = new VideoCapture();
	}

	@Override
	public boolean open() {
		if (this.link != "") {
			this.camera.open(this.link);
		} else {
			this.camera.open(0);
		}

		return this.camera.isOpened();
	}
	
	@Override
	public void release() {
		this.camera.release();
	}

	@Override
	public Mat getImage() throws EmptyImageException {
		Mat frame = new Mat();
		if(!camera.grab())
			throw new EmptyImageException("Grab errror");
		
		if(camera.retrieve(frame)) {
			if(!camera.read(frame)) 
				throw new EmptyImageException("Read error");
		}
		else {
			throw new EmptyImageException("Retrieve error");
		}

		return frame;
	}

	// FIXME : peut-être que le problème expected boundary vient de là
	/*@Override
	protected void finalize() throws Throwable {
		if (this.camera.isOpened())
			this.camera.release();
	}*/

	private VideoCapture camera;
	private String link;
}
