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

	public CameraDisplay(JLabel cameraDisplay, ICamera camera, Boolean isPreview) {
		this.isRunning = true;
		this.lbCameraDisplay = cameraDisplay;
		this.camera = camera;
		this.isPreview = isPreview;
	}
	
	/*public void setIsPreview(Boolean isPreview) {
		this.isPreview = isPreview;
	}*/
	
	@Override
	public void run() {
		while (this.isRunning) {
			Mat matCam = camera.getImage();
			if(isPreview)
			{
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

	private boolean isRunning;
	private JLabel lbCameraDisplay;
	private ICamera camera;
	
	private Boolean isPreview;
	
}
