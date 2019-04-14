package fluffy.userinterface.help;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class HelpGUI extends JFrame {

	public HelpGUI() {
		geometry();
		control();
		appearance();
	}
	
	private void appearance() {
		this.setTitle("Fluffy : Aide");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.fldHelp.setEditable(false);
		this.setVisible(true);
	}

	private void control() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.btnQuit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Component root = SwingUtilities.getRoot((JButton)e.getSource());
				root.dispatchEvent(new WindowEvent((Window) root, WindowEvent.WINDOW_CLOSING));
			}
		});
	}

	private void geometry() {
		this.fldHelp = new JTextField("Ici s'affichera l'aide et à propos");
		this.btnQuit = new JButton("Quitter");
		
		this.setLayout(new BorderLayout());

		this.add(this.fldHelp, BorderLayout.CENTER);
		this.add(this.btnQuit, BorderLayout.SOUTH);
	}

	private JTextField fldHelp;
	private JButton btnQuit;
	
}
