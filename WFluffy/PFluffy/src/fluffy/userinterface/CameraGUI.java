package fluffy.userinterface;

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
		
	}

	private void control() {
	}

	private void geometry() {
		this.lblCameraName = new JLabel("Camera Name");
		this.lblZoom = new JLabel("Zoom : ");
		this.btnSnapshot = new JButton("Take Snapshot");
		this.btnRotateLeft = new JButton("Rotate left");
		this.btnRotateRight = new JButton("Rotate right");
		this.btnReturn = new JButton("Return to main view");
		this.btnQuit = new JButton("Quitter");
		this.spZoom = new JSpinner();
		
		this.add(lblCameraName);
		this.add(lblZoom);
		this.add(btnSnapshot);
		this.add(btnSnapshot);
		this.add(btnRotateLeft);
		this.add(btnRotateRight);
		this.add(btnReturn);
		this.add(btnQuit);
		this.add(spZoom);
	}
	
	private JLabel lblCameraName;
	private JLabel lblZoom;
	private JButton btnSnapshot;
	private JButton btnRotateLeft;
	private JButton btnRotateRight;
	private JButton btnReturn;
	private JButton btnQuit;
	//private Player cameraPlayer;
	private JSpinner spZoom;
	
}
