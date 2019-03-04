package fluffy.userinterface.camera_gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class CameraGUI extends JFrame{
	public CameraGUI() {
		geometry();
		control();
		appearance();
	}

	private void appearance() {
		this.setVisible(true);
		this.setSize(new Dimension(600, 600));
	}

	private void control() {
	}

	private void geometry() {
		panelCamera = new JPanelCameraGUI();
		this.add(panelCamera);
	}
	
	
	private JPanelCameraGUI panelCamera;
}
