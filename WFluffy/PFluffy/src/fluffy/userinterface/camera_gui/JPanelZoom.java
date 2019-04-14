/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.camera_gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class JPanelZoom extends JPanel {

	public JPanelZoom() {
		geometry();
		control();
		appearance();
	}

	private void geometry() {
		this.lblZoom = new JLabel("Zoom : ");
		this.spZoom = new JSpinner();

		this.add(lblZoom);
		this.add(spZoom);

	}

	private void control() {
		// TODO Auto-generated method stub

	}

	private void appearance() {
		// TODO Auto-generated method stub

	}

	private JLabel lblZoom;
	private JSpinner spZoom;
}
