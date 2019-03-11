package fluffy.userinterface.connection;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class ConnectionGUI extends JFrame {

	public ConnectionGUI() {
		geometry();
		control();
		appearance();
	}

	private void geometry() {
		this.jPanelForm = new JPanelForm();
		this.jPanelButtons = new JPanelButtons();

		this.borderlayout = new BorderLayout();
		setLayout(borderlayout);

		this.add(jPanelForm, BorderLayout.NORTH);
		this.add(jPanelButtons, BorderLayout.SOUTH);
	}

	private void control() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void appearance() {
		this.setTitle("Fluffy: Connection");
		this.setSize(300, 180);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this.jPanelForm.setBorder(new EmptyBorder(7, 7, 7, 7));
	}

	// tools

	private BorderLayout borderlayout;

	// Panels
	private JPanelForm jPanelForm;
	private JPanelButtons jPanelButtons;
}
