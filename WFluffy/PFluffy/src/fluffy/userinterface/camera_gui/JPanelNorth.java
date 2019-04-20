package fluffy.userinterface.camera_gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelNorth extends JPanel implements PropertyChangeListener {

	public JPanelNorth() {
		this.faceDetected = "Face detected : ";
		this.faceDetectedCount = "0";
		geometry();
		control();
		appearance();
	}
	
	public void resetFaceDetectedCount() {
		this.faceDetectedCount = "0";
		this.lblFaceDetected.setText(this.faceDetected + this.faceDetectedCount);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName() == "faceDetected") {
			this.faceDetectedCount = Integer.toString((int)evt.getNewValue());
			this.lblFaceDetected.setText(this.faceDetected + this.faceDetectedCount);
		}
	}

	private void appearance() {
		// TODO Auto-generated method stub

	}

	private void control() {
		// TODO Auto-generated method stub

	}

	private void geometry() {
		this.lblFaceDetected = new JLabel(this.faceDetected + this.faceDetectedCount);

		this.add(this.lblFaceDetected);
	}

	private JLabel lblFaceDetected;
	private final String faceDetected;
	private String faceDetectedCount;

}
