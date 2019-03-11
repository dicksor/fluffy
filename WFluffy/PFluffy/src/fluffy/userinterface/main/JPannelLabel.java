package fluffy.userinterface.main;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPannelLabel extends JPanel {

	public JPannelLabel() {
		this.geometry();
		this.control();
		this.appearance();
	}

	private void appearance() {
		// TODO Auto-generated method stub

	}

	private void control() {
		// TODO Auto-generated method stub

	}

	private void geometry() {
		// TODO Auto-generated method stub
		this.lbTitle = new JLabel("Gestionaire de caméra IP");
		this.setLayout(new FlowLayout());
		this.add(this.lbTitle);
	}

	private JLabel lbTitle;
}
