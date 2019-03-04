package fluffy.userinterface.camera_gui;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fluffy.userinterface.main.MainGUI;

public class JPanelSouth extends JPanel {

	public JPanelSouth() {
		geometry();
		control();
		appearance();
	}

	private void appearance() {
		// TODO Auto-generated method stub

	}

	private void control() {
		this.btnReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Component root = SwingUtilities.getRoot((JButton) e.getSource());
				root.dispatchEvent(new WindowEvent((Window) root, WindowEvent.WINDOW_CLOSING));
			}
		});
	}

	private void geometry() {
		this.btnReturn = new JButton("Return to main view");

		this.add(btnReturn);
	}

	private JButton btnReturn;

}
