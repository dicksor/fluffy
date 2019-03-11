package fluffy.userinterface.camera_gui;

import javax.swing.JFrame;
import fluffy.network.Camera;

public class CameraGUI extends JFrame {

	public CameraGUI() {
		geometry();
		control();
		appearance();
	}
	
	public CameraGUI(Camera camera) {
		this();
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
