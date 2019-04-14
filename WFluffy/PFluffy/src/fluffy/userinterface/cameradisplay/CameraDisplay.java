/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.cameradisplay;

import java.awt.image.BufferedImage;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.camera.ICamera;

public class CameraDisplay implements Runnable {

	public CameraDisplay(JLabel cameraDisplay, ICamera camera, Boolean isPreview) {
		this.isRunning = true;
		this.lbCameraDisplay = cameraDisplay;
		this.camera = camera;
		this.isPreview = isPreview;
		this.lock = new ReentrantLock();
	}

	@Override
	public void run() {
		while (this.isRunning) {
			lock.lock();
			Mat matCam = camera.getImage();
			lock.unlock();
			if (isPreview) {
				Imgproc.resize(matCam, matCam, new Size(150, 150));
			}
			BufferedImage imgCam = OpenCvUtil.matToBufferedImage(matCam);
			ImageIcon imgIcn = new ImageIcon(imgCam);
			this.lbCameraDisplay.setIcon(imgIcn);
		}
	}

	// TODO : Faut il fermer le thread si on ferme la fen�tre ?
	public void setIsRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	private volatile boolean isRunning;
	private JLabel lbCameraDisplay;
	private ICamera camera;
	private Boolean isPreview;
	private Lock lock;

}
