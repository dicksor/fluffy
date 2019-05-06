/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.userinterface.camera_gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fluffy.userinterface.main.JPanelCameraPreview;
import fluffy.network.camera.model.CameraXml;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class JPanelSouth extends JPanel {

	public JPanelSouth(JFrame frameRoot, JPanelCameraGUI panelCameraGUI, JPanelCameraPreview panelCameraPreview, String camerName) {
		this.frameRoot = frameRoot;
		this.panelCameraPreview = panelCameraPreview;
		this.panelCameraGUI = panelCameraGUI;
		this.cameraName = camerName;
		this.geometry();
		this.control();
		this.appearance();
	}

	private void appearance() {
		this.btnReturn.setBackground(MaterialColors.RED_400);
		this.btnReturn.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnReturn, MaterialColors.GRAY_200);
	}

	private void control() {
		this.btnReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CameraXml cameraXml = CameraXml.getInstance();
				cameraXml.setCameraAngle(cameraName, String.valueOf(JPanelSouth.this.panelCameraGUI.getRotationAngle()));
				cameraXml.setCameraZoom(cameraName, String.valueOf(JPanelSouth.this.panelCameraGUI.getZoom()));
				JPanelSouth.this.panelCameraGUI.stopStream();
				JPanelSouth.this.panelCameraGUI.setYoloDetection(false);
				JPanelSouth.this.panelCameraGUI.setTinyYoloDetection(false);
				JPanelSouth.this.panelCameraPreview.streamCamera();
				JPanelSouth.this.frameRoot.setVisible(false);
				JPanelSouth.this.frameRoot.dispose();
			}
		});
	}

	private void geometry() {
		this.btnReturn = new JButton("Return to main view");

		this.add(btnReturn);
	}

	private JPanelCameraPreview panelCameraPreview;
	private String cameraName;
	private JButton btnReturn;
	private JFrame frameRoot;
	private JPanelCameraGUI panelCameraGUI;
}
