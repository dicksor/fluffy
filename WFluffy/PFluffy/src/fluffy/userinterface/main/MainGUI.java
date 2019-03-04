package fluffy.userinterface.main;

import java.awt.BorderLayout;
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
		this.setTitle("Fluffy : Main");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	private void control() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void geometry() {
		this.jPannelButtons = new JPannelButtons();
		this.jPannelLabel = new JPannelLabel();
		this.jPannelCameraPreview = new JPannelCameraPreview();

		this.setLayout(new BorderLayout());

		this.add(this.jPannelLabel, BorderLayout.NORTH);
		this.add(this.jPannelCameraPreview, BorderLayout.CENTER);
		this.add(this.jPannelButtons, BorderLayout.SOUTH);
	}

	private JPannelButtons jPannelButtons;
	private JPannelLabel jPannelLabel;
	private JPannelCameraPreview jPannelCameraPreview;

}
