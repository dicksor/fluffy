/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.userinterface.camera_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class JPanelWest extends JPanel {

	public JPanelWest(JPanelCameraGUI panelCamera, String cameraName, String cameraDescription) {
		this.panelCamera = panelCamera;
		this.cameraRotationAngle = 0;
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
		geometry();
		control();
		appearance();
	}

	private void geometry() {
		this.lblCameraName = new JLabel("<html><strong>Camera name : </strong>" + cameraName + "</html>");
		this.lblCameraDescription = new JLabel("<html><strong>Description : </strong>" + cameraDescription + "</html>");
		this.btnSnapshot = new JButton("Take Snapshot");
		this.btnRotateLeft = new JButton("Rotate left");
		this.btnRotateRight = new JButton("Rotate right");
		this.ckbFaceDetection = new JCheckBox("With face detection");
		this.ckbYoloDetection = new JCheckBox("With yolo detection");
		this.panelZoom = new JPanelZoom(this.panelCamera);

		Box boxV = Box.createVerticalBox();

		boxV.add(Box.createVerticalGlue());
		boxV.add(this.lblCameraName);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(this.lblCameraDescription);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(this.btnSnapshot);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(this.btnRotateLeft);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(this.btnRotateRight);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(this.ckbFaceDetection);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(this.ckbYoloDetection);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(this.panelZoom);
		boxV.add(Box.createVerticalGlue());

		setLayout(new BorderLayout());
		this.add(boxV, BorderLayout.CENTER);
	}

	private void control() {
		this.btnRotateLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cameraRotationAngle += 90;
				((JPanelCameraGUI) panelCamera).rotateCamera(cameraRotationAngle);
			}
		});

		this.btnRotateRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cameraRotationAngle -= 90;
				((JPanelCameraGUI) panelCamera).rotateCamera(cameraRotationAngle);
			}
		});

		this.btnSnapshot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((JPanelCameraGUI) panelCamera).takeSnapShot();
			}
		});

		this.ckbFaceDetection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JPanelWest.this.ckbFaceDetection.isSelected()) {
					JPanelWest.this.ckbYoloDetection.setSelected(false);
					JPanelWest.this.ckbYoloDetection.setEnabled(false);
					panelCamera.setFaceDetection(true);
				} else {
					panelCamera.setFaceDetection(false);
					JPanelWest.this.ckbYoloDetection.setEnabled(true);
				}
			}
		});
		
		this.ckbYoloDetection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JPanelWest.this.ckbYoloDetection.isSelected()) {
					JPanelWest.this.ckbFaceDetection.setSelected(false);
					JPanelWest.this.ckbFaceDetection.setEnabled(false);
					panelCamera.setYoloDetection(true);
				} else {
					panelCamera.setYoloDetection(false);
					JPanelWest.this.ckbFaceDetection.setEnabled(true);
				}
			}
		});

	}

	private void appearance() {
		this.btnSnapshot.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnSnapshot.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnSnapshot, MaterialColors.GRAY_200);

		this.btnRotateLeft.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnRotateLeft.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnRotateLeft, MaterialColors.GRAY_200);

		this.btnRotateRight.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnRotateRight.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnRotateRight, MaterialColors.GRAY_200);
	}

	public JButton getBtnRotateLeft() {
		return btnRotateLeft;
	}

	private JLabel lblCameraName;
	private JLabel lblCameraDescription;
	private JButton btnSnapshot;
	private JButton btnRotateLeft;
	private JButton btnRotateRight;
	private JCheckBox ckbFaceDetection;
	private JCheckBox ckbYoloDetection;
	private JPanelZoom panelZoom;
	private JPanelCameraGUI panelCamera;
	private double cameraRotationAngle;

	private String cameraName;
	private String cameraDescription;
}
