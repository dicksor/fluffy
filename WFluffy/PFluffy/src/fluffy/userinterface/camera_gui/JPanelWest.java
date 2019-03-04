package fluffy.userinterface.camera_gui;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

<<<<<<< HEAD:WFluffy/PFluffy/src/fluffy/userinterface/camera_gui/JPanelWest.java
public class JPanelWest extends JPanel {
	public JPanelWest() {
=======
public class CameraGUI extends JFrame{
	
	public CameraGUI() {
>>>>>>> 02205d66bf849f3ce94739745809cc10efb81934:WFluffy/PFluffy/src/fluffy/userinterface/CameraGUI.java
		geometry();
		control();
		appearance();
	}

	private void geometry() {
		this.lblCameraName = new JLabel("Camera Name");
		this.btnSnapshot = new JButton("Take Snapshot");
		this.btnRotateLeft = new JButton("Rotate left");
		this.btnRotateRight = new JButton("Rotate right");
		this.panelZoom = new JPanelZoom();
		
		
		this.boxMainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxMainLayout);
		
		this.add(lblCameraName);
		this.add(btnSnapshot);
		this.add(btnSnapshot);
		this.add(btnRotateLeft);
		this.add(btnRotateRight);
		this.add(panelZoom);
	}

	private void control() {
		// rien
	}

	private void appearance() {
		// rien
	}

	private JLabel lblCameraName;
	private JButton btnSnapshot;
	private JButton btnRotateLeft;
	private JButton btnRotateRight;
	private JPanelZoom panelZoom;
	
	private BoxLayout boxMainLayout;
}
