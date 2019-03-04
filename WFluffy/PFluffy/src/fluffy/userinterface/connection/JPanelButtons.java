package fluffy.userinterface.connection;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

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
				System.exit(0);
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
