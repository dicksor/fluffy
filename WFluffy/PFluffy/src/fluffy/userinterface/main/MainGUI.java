/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

import fluffy.userinterface.connection.CameraList;

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
		this.jPanelCameraList.addCameraPreview(new JPanelCameraPreview("", "test", "test"));

		CameraList.addCam("test", "link_test", "description...");

		this.setLayout(new BorderLayout());

		this.add(this.jPanelLabel, BorderLayout.NORTH);
		this.add(this.jPanelCameraList, BorderLayout.CENTER);
		this.add(this.jPanelButtons, BorderLayout.SOUTH);
	}

	private JPanelButtons jPanelButtons;
	private JPanelLabel jPanelLabel;
	private JPanelCameraList jPanelCameraList;

}
