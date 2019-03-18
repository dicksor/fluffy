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
		this.lbLinkPreview = new JLabel("Link of web preview : ");
		this.lbCameraDescription = new JLabel("Camera description : ");

		this.fldCameraName = new JTextField();
		this.fldLinkPreview = new JTextField();
		this.fldCameraDescription = new JTextField();

		this.gridlayout = new GridLayout(3, 2);
		setLayout(gridlayout);

		this.add(lbCameraName);
		this.add(fldCameraName);

		this.add(lbLinkPreview);
		this.add(fldLinkPreview);

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

	public String getCameraName() {
		return this.fldCameraName.getText();
	}

	public String getCameraDescription() {
		return this.fldCameraDescription.getText();
	}

	public String getLinkPreview() {
		return this.fldLinkPreview.getText();
	}

	// tools

	private GridLayout gridlayout;

	// Labels
	private JLabel lbCameraName;
	private JLabel lbLinkPreview;
	private JLabel lbCameraDescription;

	// TextFields
	private JTextField fldCameraName;
	private JTextField fldLinkPreview;
	private JTextField fldCameraDescription;
}
