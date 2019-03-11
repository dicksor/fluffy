package fluffy.userinterface.cameradisplay;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvFaceDetection;
import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.Camera;

public class CameraDisplayVideoDetection extends CameraDisplay {

	public CameraDisplayVideoDetection(JLabel lbCameraDisplay, Camera camera) {
		super(lbCameraDisplay, camera);
		this.faceDetection = new OpenCvFaceDetection("C:\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml");
	}

	@Override
	public void run() {
		while (this.isRunning) {
			Mat matCam = camera.getImage();
			Mat matCamFaceDetected = faceDetection.detecte(matCam);
			BufferedImage imgCam = OpenCvUtil.matToBufferedImage(matCamFaceDetected);
			ImageIcon imgIcn = new ImageIcon(imgCam);
			this.lbCameraDisplay.setIcon(imgIcn);
		}
	}

	private OpenCvFaceDetection faceDetection;
}
