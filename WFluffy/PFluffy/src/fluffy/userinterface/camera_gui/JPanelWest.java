package fluffy.userinterface.camera_gui;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelWest extends JPanel {

	public JPanelWest() {
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
		
		Box boxV = Box.createVerticalBox();
		
		boxV.add(Box.createVerticalStrut(60));
		boxV.add(lblCameraName);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(btnSnapshot);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(btnRotateLeft);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(btnRotateRight);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(panelZoom);
		boxV.add(Box.createVerticalStrut(30));
		
		setLayout(new BorderLayout());
		this.add(boxV, BorderLayout.CENTER);
	}

	private void control() {
		// rien
	}

	private void appearance() {
		// rien
	}
	
	public JButton getBtnRotateLeft() {
		return btnRotateLeft;
	}
	

	private JLabel lblCameraName;
	private JButton btnSnapshot;
	private JButton btnRotateLeft;
	private JButton btnRotateRight;
	private JPanelZoom panelZoom;

}
