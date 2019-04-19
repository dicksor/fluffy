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

import fluffy.network.camera.model.CameraXml;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class JPanelSouth extends JPanel {

	public JPanelSouth(JFrame frameRoot, JPanelCameraGUI panelRoot, String cameraName) {
		this.frameRoot = frameRoot;
		this.panelRoot = panelRoot;
		this.cameraName = cameraName;
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
				CameraXml cameraXml = CameraXml.getInstance();
				cameraXml.setCameraAngle(cameraName, String.valueOf(panelRoot.getRotationAngle()));
				cameraXml.setCameraZoom(cameraName, String.valueOf(panelRoot.getZoom()));

				JPanelSouth.this.frameRoot.setVisible(false);
				JPanelSouth.this.frameRoot.dispose();
			}
		});
	}

	private void geometry() {
		this.btnReturn = new JButton("Return to main view");

		this.add(btnReturn);
	}

	private String cameraName;
	private JButton btnReturn;
	private JFrame frameRoot;
	private JPanelCameraGUI panelRoot;
}
