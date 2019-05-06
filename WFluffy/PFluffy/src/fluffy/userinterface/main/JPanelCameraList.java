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
	}

	public void addCameraPreview(JPanelCameraPreview panelCameraPreview) {
		this.add(panelCameraPreview);
		this.boxV.add(panelCameraPreview);
		this.add(boxV);
	}

	private void geometry() {
		this.panelEmail = new JPanelEmail();
		this.boxV = Box.createVerticalBox();
		this.boxV.add(panelEmail);

		this.setLayout(new FlowLayout());
	}

	private JPanelEmail panelEmail;
	private Box boxV;
}
