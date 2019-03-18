package fluffy.userinterface.cameradisplay;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.camera.ICamera;

public class CameraDisplay implements Runnable {

	public CameraDisplay(JLabel cameraDisplay, ICamera camera) {
		this.doStop = false;
		this.lbCameraDisplay = cameraDisplay;
		this.camera = camera;
	}
	
	public synchronized boolean isRunning() {
		return this.doStop == false;
	}
	
    public synchronized void doStop() {
        this.doStop = false;
    }
    
    public synchronized void setCamera(ICamera camera) {
    	this.camera = camera;
    }
	
	@Override
	public void run() {
		while (this.keepRunning()) {
			Mat matCam = camera.getImage();
			BufferedImage imgCam = OpenCvUtil.matToBufferedImage(matCam);
			ImageIcon imgIcn = new ImageIcon(imgCam);
			this.lbCameraDisplay.setIcon(imgIcn);
		}
	}
	
	private synchronized boolean keepRunning() {
        return this.doStop == false;
    }

	private boolean doStop;
	private JLabel lbCameraDisplay;
	private ICamera camera;

}
