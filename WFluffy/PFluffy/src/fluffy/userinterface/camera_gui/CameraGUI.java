/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.userinterface.camera_gui;

import java.awt.Frame;
import javax.swing.JFrame;

import fluffy.network.camera.Camera;
import fluffy.userinterface.main.JPanelCameraPreview;

public class CameraGUI extends JFrame {

	public CameraGUI(Camera camera, JPanelCameraPreview jPanelCameraPreview, String cameraName,
			String cameraDescription) {
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
		this.geometry();
		this.control();
		this.appearance();
		this.panelCameraPreview = jPanelCameraPreview;
		this.panelCamera.setCamera(camera);
		this.panelCamera.streamCamera();
	}

	private void appearance() {
		this.setTitle("Fluffy : Camera");
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	private void control() {
	}

	private void geometry() {
		this.panelCamera = new JPanelCameraGUI(this, cameraName, cameraDescription, panelCamera, panelCameraPreview);
		this.add(this.panelCamera);
	}

	private JPanelCameraPreview panelCameraPreview;
	private JPanelCameraGUI panelCamera;
	private String cameraName;
	private String cameraDescription;
}
