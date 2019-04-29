/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.help;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class HelpGUI extends JFrame {

	public HelpGUI() {
		geometry();
		control();
		appearance();
	}

	private void appearance() {
		this.setTitle("Fluffy : Aide");
		// this.setIconImage(MagasinImage.logo.getImage());
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setVisible(true);

		this.jPanelContent.setBorder(new EmptyBorder(50, 50, 50, 50));
		this.jPanelControls.setBorder(new EmptyBorder(40, 250, 40, 250));
	}

	private void control() {

	}

	private void geometry() {
		this.jPanelContent = new JPanelContent();
		this.jPanelControls = new JPanelControls();

		this.setLayout(new BorderLayout());

		this.add(this.jPanelContent, BorderLayout.CENTER);
		this.add(this.jPanelControls, BorderLayout.SOUTH);
	}

	// Tools
	private JPanelControls jPanelControls;
	private JPanelContent jPanelContent;

}
