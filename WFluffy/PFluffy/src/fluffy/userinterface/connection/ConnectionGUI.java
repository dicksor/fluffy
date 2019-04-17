/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.connection;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import fluffy.tools.image.MagasinImage;

public class ConnectionGUI extends JFrame {

	public ConnectionGUI() {
		geometry();
		control();
		appearance();
	}

	private void geometry() {
		this.jPanelForm = new JPanelForm();
		this.jPanelButtons = new JPanelButtons(this);

		this.borderlayout = new BorderLayout();
		setLayout(borderlayout);

		this.add(jPanelForm, BorderLayout.NORTH);
		this.add(jPanelButtons, BorderLayout.SOUTH);
	}

	private void control() {

	}

	private void appearance() {
		this.setTitle("Fluffy: Connection");
		this.setIconImage(MagasinImage.logo.getImage());
		this.setSize(360, 180);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this.jPanelForm.setBorder(new EmptyBorder(7, 7, 7, 7));
	}

	// tools

	private BorderLayout borderlayout;

	// Panels
	private JPanelForm jPanelForm;
	private JPanelButtons jPanelButtons;
}
