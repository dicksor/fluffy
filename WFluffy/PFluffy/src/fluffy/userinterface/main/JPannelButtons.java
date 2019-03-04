package fluffy.userinterface.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPannelButtons extends JPanel {

	public JPannelButtons() {
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
	}

	private void geometry() {
		this.btnAdd = new JButton("Add camera");
		this.btnQuit = new JButton("Quit");
		this.btnHelp = new JButton("Help");
		
		this.flowLayout = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(this.flowLayout);
		this.flowLayout.setVgap(20);
		
		
		this.add(this.btnAdd);
		this.add(this.btnQuit);
		this.add(this.btnHelp);
	}
	
	private FlowLayout flowLayout;
	
	private JButton btnHelp;
	private JButton btnQuit;
	private JButton btnAdd;

}
