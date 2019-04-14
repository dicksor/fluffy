/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.main;

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

public class JPanelButtons extends JPanel {

	public JPanelButtons() {
		this.geometry();
		this.control();
		this.appearance();
	}
	
	private void appearance() {
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
		this.add(this.btnQuit);
		this.add(this.btnHelp);
	}
	
	private FlowLayout flowLayout;
	
	private JButton btnHelp;
	private JButton btnQuit;
	private JButton btnAdd;

}
