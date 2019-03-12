package fluffy.userinterface.camera_gui;

import javax.swing.JFrame;

import fluffy.network.camera.CameraFaceDetection;
import fluffy.network.camera.CameraRotation;
import fluffy.network.camera.ICamera;

public class CameraGUI extends JFrame {

	public CameraGUI() {
		this.geometry();
		this.control();
		this.appearance();
	}
	
	public CameraGUI(ICamera camera) {
		this();
		camera = new CameraRotation(new CameraFaceDetection(camera), 90);
		this.panelCamera.setCamera(camera);
		this.panelCamera.streamCamera();
	}

	private void appearance() {
		this.setTitle("Fluffy : Camera");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	private void control() {
		// TODO
	}

	private void geometry() {
		this.panelCamera = new JPanelCameraGUI();
		this.add(this.panelCamera);
	}

	private JPanelCameraGUI panelCamera;
}
