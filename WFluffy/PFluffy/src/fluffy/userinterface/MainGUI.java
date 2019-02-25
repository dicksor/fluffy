package fluffy.userinterface;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainGUI extends JFrame {
	
	public MainGUI() {
		geometry();
		control();
		appearance();
	}

	private void geometry() {
		
	}
	
	private void appearance() {
		this.setVisible(true);
	}
	
	private void control() {
		this.btnAdd = new JButton("Add");
		this.add(this.btnAdd);
	}
	
	private JButton btnAdd;
	
}
