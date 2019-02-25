package fluffy.userinterface;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConnectionGUI extends JFrame {

	public ConnectionGUI() {
		geometry();
		control();
		appearance();
	}

	private void appearance() {
		this.setTitle("Fluffy");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void control() {

	}

	private void geometry() {

		// Buttons
		this.btnCancel = new JButton("Cancel");
		this.btnConnectionCamera = new JButton("Connection");

		// Labels
		this.lbCameraName = new JLabel("Camera name : ");
		this.lbAdresseIP = new JLabel("Adresse IP : ");
		this.lbCameraDescription = new JLabel("Camera description : ");

		// Set Layout
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Add
		this.add(lbCameraName);

		this.add(btnConnectionCamera);
		this.add(btnCancel);

	}

	// tools

	// Labels
	private JLabel lbCameraName;
	private JLabel lbAdresseIP;
	private JLabel lbCameraDescription;

	// TextFields
	private JTextField fldCameraName;
	private JTextField fldAdresseIP;
	private JTextField fldCameraDescription;

	// Buttons
	private JButton btnConnectionCamera;
	private JButton btnCancel;

}
