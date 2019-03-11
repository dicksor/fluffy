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
		this.lbCameraDisplay = cameraDisplay;
		this.camera = camera;
	}
	
	@Override
	public void run() {
		while (this.isRunning) {
			Mat matCam = camera.getImage();
			BufferedImage imgCam = OpenCvUtil.matToBufferedImage(matCam);
			ImageIcon imgIcn = new ImageIcon(imgCam);
			this.lbCameraDisplay.setIcon(imgIcn);
		}
	}
	
	public void setIsRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	protected boolean isRunning;
	protected JLabel lbCameraDisplay;
	protected Camera camera;

}
