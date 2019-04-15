/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fluffy.userinterface.connection.ConnectionGUI;
import fluffy.userinterface.help.HelpGUI;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class JPanelButtons extends JPanel {

	public JPanelButtons() {
		this.geometry();
		this.control();
		this.appearance();
	}

	private void appearance() {
		this.btnAdd.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnAdd.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnAdd, MaterialColors.GRAY_200);

		this.btnHelp.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnHelp.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnHelp, MaterialColors.GRAY_200);

		this.btnQuit.setBackground(MaterialColors.RED_400);
		this.btnQuit.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnQuit, MaterialColors.GRAY_200);

		this.flowLayout.setVgap(20);
	}

	private void control() {
		this.btnQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Component root = SwingUtilities.getRoot((JButton)e.getSource());
				root.dispatchEvent(new WindowEvent((Window) root, WindowEvent.WINDOW_CLOSING));
			}
		});

		this.btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ConnectionGUI();
			}
		});

		this.btnHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new HelpGUI();
			}
		});
	}

	private void geometry() {
		this.btnAdd = new JButton("Add camera");
		this.btnQuit = new JButton("Quit");
		this.btnHelp = new JButton("Help");

		this.flowLayout = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(this.flowLayout);

		this.add(this.btnAdd);
		this.add(this.btnHelp);
		this.add(this.btnQuit);

	}

	private FlowLayout flowLayout;

	private JButton btnHelp;
	private JButton btnQuit;
	private JButton btnAdd;

}
