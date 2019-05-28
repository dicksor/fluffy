/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.network.camera;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import fluffy.network.camera.exception.EmptyImageException;

public class Camera implements Runnable {

	public Camera(String link, String name) {
		this.support = new PropertyChangeSupport(this);
		this.link = link;
		this.name = name;
		this.camera = new VideoCapture();
		this.image = new Mat();
		this.isRunning = true;
	}

	public boolean open() {
		if (this.link != "") {
			this.camera.open(this.link);
		} else {
			this.camera.open(0);
		}
		return this.camera.isOpened();
	}

	public void release() {
		this.camera.release();

	}

	public void stopThread() {
		this.isRunning = false;
	}

	@Override
	public void run() {
		while (this.isRunning) {
			try {
				this.getImage();
			} catch (EmptyImageException e) {
				e.printStackTrace();
			}
		}
	}

	public void getImage() throws EmptyImageException {
		Mat frame = new Mat();
		if (!camera.grab()) {
			throw new EmptyImageException("Grab errror");
		}

		if (camera.retrieve(frame)) {
			if (!camera.read(frame)) {
				throw new EmptyImageException("Read error");
			} else {
				support.firePropertyChange(this.name, this.image, frame);
				this.image = frame;
			}
		} else {
			throw new EmptyImageException("Retrieve error");
		}
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	@Override
	protected void finalize() throws Throwable {
		if (this.camera.isOpened()) {
			this.camera.release();
		}
	}

	private VideoCapture camera;
	private String name;
	private String link;
	private PropertyChangeSupport support;
	private Mat image;
	private boolean isRunning;
}
