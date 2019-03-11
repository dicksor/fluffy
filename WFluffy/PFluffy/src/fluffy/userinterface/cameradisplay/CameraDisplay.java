package fluffy.userinterface.cameradisplay;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.Camera;

public abstract class CameraDisplay implements Runnable {

	public CameraDisplay(JLabel cameraDisplay, Camera camera) {
		this.isRunning = true;
		this.cameraDisplay = cameraDisplay;
		this.camera = camera;
	}
	
	@Override
	public void run() {
		while (this.isRunning) {
			Mat matCam = camera.getImage();
			BufferedImage imgCam = OpenCvUtil.matToBufferedImage(matCam);
			ImageIcon imgIcn = new ImageIcon(imgCam);
			this.cameraDisplay.setIcon(imgIcn);
		}
	}

	protected boolean isRunning;
	protected JLabel cameraDisplay;
	protected Camera camera;

}
