/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.camera_gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import fluffy.network.camera.CameraFaceDetection;
import fluffy.network.camera.ICamera;

public class CameraGUI extends JFrame {

	public CameraGUI() {
		this.geometry();
		this.control();
		this.appearance();
	}
	
	public CameraGUI(ICamera camera) {
		this();
		camera = new CameraFaceDetection(camera);
		this.panelCamera.setCamera(camera);
		this.panelCamera.streamCamera();
	}

	private void appearance() {
		this.setTitle("Fluffy : Camera");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	private void control() {
		this.addWindowListener(new WindowAdapter() {
			
			@Override
		    public void windowClosing(WindowEvent e) {
				panelCamera.stopStream();
		    }
		});
	}

	private void geometry() {
		this.panelCamera = new JPanelCameraGUI(this);
		this.add(this.panelCamera);
	}

	private JPanelCameraGUI panelCamera;
}
