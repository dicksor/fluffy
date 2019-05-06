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
		appearance();
	}

	private void geometry() {
		this.panelForm = new JPanelForm();
		this.panelButtons = new JPanelButtons(this, this.panelForm);

		this.borderlayout = new BorderLayout();
		setLayout(borderlayout);

		this.add(panelForm, BorderLayout.NORTH);
		this.add(panelButtons, BorderLayout.SOUTH);
	}

	private void appearance() {
		this.setTitle("Fluffy: Connection");
		this.setIconImage(MagasinImage.logo.getImage());
		this.setSize(360, 180);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this.panelForm.setBorder(new EmptyBorder(7, 7, 7, 7));
	}

	private BorderLayout borderlayout;
	private JPanelForm panelForm;
	private JPanelButtons panelButtons;
}
