package fluffy.userinterface.camera_gui;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class JPanelSouth extends JPanel{
	public JPanelSouth()
	{
	geometry();
	control();
	appearance();
	}

	private void appearance() {
		// TODO Auto-generated method stub
		
	}

	private void control() {
		this.btnQuit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		this.btnReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Component root = SwingUtilities.getRoot((JButton)e.getSource());
				root.dispatchEvent(new WindowEvent((Window) root, WindowEvent.WINDOW_CLOSING));
			}});
	}

	private void geometry() {
		this.btnReturn = new JButton("Return to main view");
		this.btnQuit = new JButton("Quitter");
		
		this.add(btnReturn);
		this.add(btnQuit);
	}
	
	private JButton btnReturn;
	private JButton btnQuit;

}
