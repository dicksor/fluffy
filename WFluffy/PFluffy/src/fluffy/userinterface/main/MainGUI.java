package fluffy.userinterface.main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainGUI extends JFrame {

	public MainGUI() {
		this.geometry();
		this.control();
		this.appearance();
	}

	private void appearance() {
		this.setTitle("Fluffy : Main");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	private void control() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(700, 400));
	}

	private void geometry() {
		this.jPannelButtons = new JPannelButtons();
		this.jPannelLabel = new JPannelLabel();
		this.jPannelCameraPreview = new JPannelCameraPreview("", "test", "test");

		this.setLayout(new BorderLayout());

		this.add(this.jPannelLabel, BorderLayout.NORTH);
		this.add(this.jPannelCameraPreview, BorderLayout.CENTER);
		this.add(this.jPannelButtons, BorderLayout.SOUTH);
	}

	public void streamCamera() {
		this.jPannelCameraPreview.streamCamera();
	}

	private JPannelButtons jPannelButtons;
	private JPannelLabel jPannelLabel;
	private JPannelCameraPreview jPannelCameraPreview;
}
