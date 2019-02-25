package fluffy.userinterface;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainGUI extends JFrame {

	public MainGUI() {
		geometry();
		control();
		appearance();
	}

	private void appearance() {
		this.setTitle("Fluffy");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	private void control() {
		
	}

	private void geometry() {
		this.btnAdd = new JButton("Add camera");
		this.btnQuit = new JButton("Quit");
		this.btnHelp = new JButton("Help");
		// TODO : set camera title
		this.lbTitle = new JLabel("Gestionaire caméra IP");
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(this.lbTitle);
		this.add(this.btnAdd);
		this.add(this.btnQuit);
		this.add(this.btnHelp);
	}
	
	private JButton btnHelp;
	private JButton btnQuit;
	private JButton btnAdd;
	private JLabel lbTitle;

}
