/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.camera_gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;


public class JPanelSouth extends JPanel {

	public JPanelSouth() {
		geometry();
		control();
		appearance();
	}

	public JPanelSouth(JFrame frameRoot) {
		this();
		this.frameRoot = frameRoot;
	}

	private void appearance() {
		this.btnReturn.setBackground(MaterialColors.RED_400);
		this.btnReturn.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnReturn, MaterialColors.GRAY_200);
	}

	private void control() {
		this.btnReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frameRoot = JPanelSouth.this.frameRoot;
				frameRoot.dispatchEvent(new WindowEvent(frameRoot, WindowEvent.WINDOW_CLOSING));
			}
		});
	}

	private void geometry() {
		this.btnReturn = new JButton("Return to main view");

		this.add(btnReturn);
	}

	private JButton btnReturn;
	private JFrame frameRoot;

}
