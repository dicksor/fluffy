package fluffy.userinterface.connection;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelForm extends JPanel {

	public JPanelForm() {
		geometry();
		control();
		appearance();
	}

	private void geometry() {
		this.lbCameraName = new JLabel("Camera name : ");
		this.lbAdressIP = new JLabel("IP adresse : ");
		this.lbCameraDescription = new JLabel("Camera description : ");

		this.fldCameraName = new JTextField();
		this.fldAdressIP = new JTextField();
		this.fldCameraDescription = new JTextField();

		this.gridlayout = new GridLayout(3, 2);
		setLayout(gridlayout);

		this.add(lbCameraName);
		this.add(fldCameraName);

		this.add(lbAdressIP);
		this.add(fldAdressIP);

		this.add(lbCameraDescription);
		this.add(fldCameraDescription);
	}

	private void control() {
		// TODO
	}

	private void appearance() {
		gridlayout.setVgap(10);
		gridlayout.setHgap(5);
	}

	// tools

	private GridLayout gridlayout;

	// Labels
	private JLabel lbCameraName;
	private JLabel lbAdressIP;
	private JLabel lbCameraDescription;

	// TextFields
	private JTextField fldCameraName;
	private JTextField fldAdressIP;
	private JTextField fldCameraDescription;
}