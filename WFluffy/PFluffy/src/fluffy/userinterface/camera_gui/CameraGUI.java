package fluffy.userinterface.camera_gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import fluffy.network.camera.decorator.CameraFaceDetection;
import fluffy.network.camera.decorator.CameraRotation;
import fluffy.network.camera.decorator.ICamera;
import fluffy.userinterface.main.JPanelCameraPreview;

public class CameraGUI extends JFrame {

	public CameraGUI() {
		this.geometry();
		this.control();
		this.appearance();
	}
	
	public CameraGUI(JPanelCameraPreview jPanelCameraPreview, ICamera camera) {
		this();
		this.panelCameraPreview = jPanelCameraPreview;
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
				// FIXME : Find dynamic delay
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				CameraGUI.this.panelCameraPreview.streamCamera();
		    }
		});
	}

	private void geometry() {
		this.panelCamera = new JPanelCameraGUI(this);
		this.add(this.panelCamera);
	}

	private JPanelCameraPreview panelCameraPreview;
	private JPanelCameraGUI panelCamera;
}
