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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import fluffy.imageprocessing.OpenCvUtil;

public class CameraDisplay implements PropertyChangeListener {

	public CameraDisplay(JLabel cameraDisplay, Boolean isPreview) {
		this.lbCameraDisplay = cameraDisplay;
		this.isPreview = isPreview;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Mat matCam = (Mat) evt.getNewValue();
		if (isPreview)
			Imgproc.resize(matCam, matCam, new Size(150, 150));
		BufferedImage imgCam = OpenCvUtil.matToBufferedImage(matCam);
		ImageIcon imgIcn = new ImageIcon(imgCam);
		this.lbCameraDisplay.setIcon(imgIcn);
	}

	private JLabel lbCameraDisplay;
	private Boolean isPreview;
}
