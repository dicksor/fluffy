/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.main;

import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JPanel;

public class JPanelCameraList extends JPanel {

	public JPanelCameraList() {	
		this.geometry();
		this.control();
		this.appearance();
	}

	public void addCameraPreview(JPanelCameraPreview panelCameraPreview) {
		this.add(panelCameraPreview);
		panelCameraPreview.streamCamera();
		this.boxV.add(panelCameraPreview);
		this.add(boxV);
	}

	private void appearance() {
		// TODO Auto-generated method stub

	}

	private void control() {
		// TODO Auto-generated method stub

	}

	private void geometry() {
		this.jPanelEmail = new JPanelEmail();
		this.boxV = Box.createVerticalBox();
		this.boxV.add(jPanelEmail);

		this.setLayout(new FlowLayout());
	}

	private JPanelEmail jPanelEmail;
	private Box boxV;
}
