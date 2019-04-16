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
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.camera.decorator.ICamera;
import fluffy.network.camera.exception.EmptyImageException;

public class CameraDisplay implements Runnable {

	public CameraDisplay(JLabel cameraDisplay, ICamera camera, Boolean isPreview) {
		this.isRunning = true;
		this.lbCameraDisplay = cameraDisplay;
		this.camera = camera;
		this.isPreview = isPreview;
	}

	@Override
	public void run() {
		while (this.isRunning) {
			Mat matCam = null;
			try {
				matCam = camera.getImage();
				if (isPreview) {
					Imgproc.resize(matCam, matCam, new Size(150, 150));
				}
				BufferedImage imgCam = OpenCvUtil.matToBufferedImage(matCam);
				ImageIcon imgIcn = new ImageIcon(imgCam);
				this.lbCameraDisplay.setIcon(imgIcn);
			} catch (EmptyImageException e) {
				System.out.println("Empty image");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setIsRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	private volatile boolean isRunning;
	private JLabel lbCameraDisplay;
	private ICamera camera;
	private Boolean isPreview;

}
