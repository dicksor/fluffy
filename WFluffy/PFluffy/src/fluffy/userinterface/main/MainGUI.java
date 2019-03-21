package fluffy.userinterface.main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import fluffy.network.camera.Camera;

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
		this.jPanelButtons = new JPanelButtons();
		this.jPanelLabel = new JPanelLabel();
		this.jPanelCameraList = new JPanelCameraList();
		this.jPanelCameraList.addCameraPreview(new JPanelCameraPreview(this, new Camera("")));
		// this.jPannelCameraList.addCameraPreview(new JPannelCameraPreview(this));

		this.setLayout(new BorderLayout());

		this.add(this.jPanelLabel, BorderLayout.NORTH);
		this.add(this.jPanelCameraList, BorderLayout.CENTER);
		this.add(this.jPanelButtons, BorderLayout.SOUTH);
	}

	private JPanelButtons jPanelButtons;
	private JPanelLabel jPanelLabel;
	private JPanelCameraList jPanelCameraList;

}
