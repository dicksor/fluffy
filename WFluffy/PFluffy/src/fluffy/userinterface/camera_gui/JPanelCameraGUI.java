package fluffy.userinterface.camera_gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fluffy.network.camera.ICamera;
import fluffy.userinterface.cameradisplay.CameraDisplay;

public class JPanelCameraGUI extends JPanel {

	public JPanelCameraGUI(JFrame jFrame) {
		this.jFrame = jFrame;
		this.camera = null;
		geometry();
		control();
		appearance();
	}

	private void appearance() {

	}

	private void control() {
		// TODO Auto-generated method stub

	}

	private void geometry() {

		this.panelWest = new JPanelWest(this.jFrame);
		this.panelSouth = new JPanelSouth();
		this.lbCameraDisplay = new JLabel();

		this.borderMainLayout = new BorderLayout();
		setLayout(this.borderMainLayout);

		this.add(this.panelWest, BorderLayout.WEST);
		this.add(this.panelSouth, BorderLayout.SOUTH);
		this.add(this.lbCameraDisplay, BorderLayout.CENTER);
	}
	
	public void setCamera(ICamera camera) {
		this.camera = camera;
	}
	
	// FIXME : Almost duplicate code from JPannelCameraPreview
	public void streamCamera() {
		if(this.camera != null) {
			CameraDisplay cameraDisplay = new CameraDisplay(this.lbCameraDisplay, this.camera);
			
			Thread threadDisplayImage = new Thread(cameraDisplay);
			threadDisplayImage.start();
		}
		// TODO : Faire qqch si null
	}

	private JLabel lbCameraDisplay;
	private JPanelWest panelWest;
	private JPanelSouth panelSouth;
	private BorderLayout borderMainLayout;
	private ICamera camera;
	private JFrame jFrame;

}
