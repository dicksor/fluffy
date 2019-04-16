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

import javax.swing.JFrame;

import fluffy.network.camera.model.CameraList;
import fluffy.network.camera.model.CameraModel;

/**
 * Main JFrame of the program
 *
 */
public class MainGUI extends JFrame {

	public MainGUI() {
		this.geometry();
		this.control();
		this.appearance();
	}

	private void appearance() {
		this.setTitle("Fluffy : Main");
		this.setMinimumSize(new Dimension(700, 400));
		this.setVisible(true);
	}

	private void control() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void geometry() {
		this.jPanelButtons = new JPanelButtons();
		this.jPanelLabel = new JPanelLabel();
		this.jPanelLabel.repaint();
		this.jPanelCameraList = new JPanelCameraList();

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
