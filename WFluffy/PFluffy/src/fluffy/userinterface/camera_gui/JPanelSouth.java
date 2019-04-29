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

	public JPanelSouth(JFrame frameRoot, JPanelCameraGUI jPanelCameraGUI, JPanelCameraPreview jPanelCameraPreview,
			String camerName) {
		this.frameRoot = frameRoot;
		this.jPanelCameraPreview = jPanelCameraPreview;
		this.jPanelCameraGUI = jPanelCameraGUI;
		this.cameraName = camerName;
		geometry();
		control();
		appearance();
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
				JPanelSouth.this.jPanelCameraPreview.streamCamera();
				CameraXml cameraXml = CameraXml.getInstance();
				cameraXml.setCameraAngle(cameraName,
						String.valueOf(JPanelSouth.this.jPanelCameraGUI.getRotationAngle()));
				cameraXml.setCameraZoom(cameraName, String.valueOf(JPanelSouth.this.jPanelCameraGUI.getZoom()));
				JPanelSouth.this.frameRoot.setVisible(false);
				JPanelSouth.this.frameRoot.dispose();
			}
		});
	}

	private void geometry() {
		this.btnReturn = new JButton("Return to main view");

		this.add(btnReturn);
	}

	private JPanelCameraPreview jPanelCameraPreview;
	private String cameraName;
	private JButton btnReturn;
	private JFrame frameRoot;
	private JPanelCameraGUI jPanelCameraGUI;
}
