package fluffy.userinterface.camera_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


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
		// TODO Auto-generated method stub

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
