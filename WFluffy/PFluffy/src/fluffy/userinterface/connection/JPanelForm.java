/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.connection;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fluffy.network.camera.model.CameraModel;
import fluffy.network.camera.model.CameraXml;

public class JPanelForm extends JPanel {

	public JPanelForm() {
		geometry();
		appearance();
	}

	public void save() {
		CameraXml cameraXml = CameraXml.getInstance();
		String link = "";
		if (!this.fldAdressIP.getText().isEmpty()) {
			link = this.fldAdressIP.getText();
		}
		CameraModel cameraModel = new CameraModel(this.fldCameraName.getText(), link,
				this.fldCameraDescription.getText());
		cameraXml.add(cameraModel);
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

	private void appearance() {
		gridlayout.setVgap(10);
		gridlayout.setHgap(10);
	}

	private GridLayout gridlayout;
	private JLabel lbCameraName;
	private JLabel lbAdressIP;
	private JLabel lbCameraDescription;
	private JTextField fldCameraName;
	private JTextField fldAdressIP;
	private JTextField fldCameraDescription;
}
