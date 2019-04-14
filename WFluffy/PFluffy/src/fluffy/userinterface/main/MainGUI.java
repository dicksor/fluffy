package fluffy.userinterface.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

import fluffy.network.camera.model.CameraList;
import fluffy.network.camera.model.CameraModel;

public class MainGUI extends JFrame {

	public MainGUI() {
		this.geometry();
		this.control();
		this.appearance();
	}

	private void appearance() {
		this.setTitle("Fluffy : Main");
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
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
		// http://192.168.1.200/axis-cgi/mjpg/video.cgi
		this.jPanelCameraList.addCameraPreview(new JPanelCameraPreview("", "test", "test"));

		CameraList cameraList = CameraList.getInstance();
		CameraModel cam = new CameraModel("test", "link_test", "description...");
		cameraList.add(cam);

		this.setLayout(new BorderLayout());

		this.add(this.jPanelLabel, BorderLayout.NORTH);
		this.add(this.jPanelCameraList, BorderLayout.CENTER);
		this.add(this.jPanelButtons, BorderLayout.SOUTH);
	}

	private JPanelButtons jPanelButtons;
	private JPanelLabel jPanelLabel;
	private JPanelCameraList jPanelCameraList;

}
