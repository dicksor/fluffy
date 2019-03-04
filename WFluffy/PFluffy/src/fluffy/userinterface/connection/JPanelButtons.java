package fluffy.userinterface.connection;

import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JPanelButtons extends JPanel {

	public JPanelButtons() {
		geometry();
		control();
		appearance();
	}
	

	private void geometry() {
		this.btnCancel = new JButton("Cancel");
		this.btnConnectionCamera = new JButton("Connection");

		this.flowlayout = new FlowLayout();
		setLayout(flowlayout);

		this.add(btnCancel);
		this.add(btnConnectionCamera);
	}

	private void control() {
		this.btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Component root = SwingUtilities.getRoot((JButton)e.getSource());
				root.dispatchEvent(new WindowEvent((Window) root, WindowEvent.WINDOW_CLOSING));
			}
		});
	}

	private void appearance() {
		// TODO
	}

	// tools

	private FlowLayout flowlayout;

	// Buttons
	private JButton btnConnectionCamera;
	private JButton btnCancel;
}
