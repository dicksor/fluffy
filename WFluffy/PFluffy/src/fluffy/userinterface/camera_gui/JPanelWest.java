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

import fluffy.network.camera.model.CameraXml;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class JPanelWest extends JPanel {

	public JPanelWest(JPanelCameraGUI panelCamera, String cameraName, String cameraDescription) {
		this.panelCamera = panelCamera;
		this.cameraRotationAngle = 0;
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
		this.geometry();
		this.control();
		this.appearance();

		CameraXml cameraXml = CameraXml.getInstance();
		if (!cameraXml.getCameras().get(cameraName).getAngle().equals("")) {
			cameraRotationAngle = Double.valueOf(cameraXml.getCameras().get(cameraName).getAngle());
			panelCamera.rotateCamera(cameraRotationAngle);
		}
	}

	private void geometry() {
		this.lblCameraName = new JLabel("<html><strong>Camera name : </strong>" + cameraName + "</html>");
		this.lblCameraDescription = new JLabel("<html><strong>Description : </strong>" + cameraDescription + "</html>");
		this.btnSnapshot = new JButton("Take Snapshot");
		this.btnRotateLeft = new JButton("Rotate left");
		this.btnRotateRight = new JButton("Rotate right");
		this.ckbFaceDetection = new JCheckBox("With face detection");
		this.ckbYoloDetection = new JCheckBox("With yolo detection");
		this.ckbTinyYoloDetection = new JCheckBox("With tiny yolo detection");
		this.panelZoom = new JPanelZoom(this.panelCamera, cameraName);

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
		boxV.add(this.ckbTinyYoloDetection);
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
				panelCamera.rotateCamera(cameraRotationAngle);
			}
		});

		this.btnRotateRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cameraRotationAngle -= 90;
				panelCamera.rotateCamera(cameraRotationAngle);
			}
		});

		this.btnSnapshot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCamera.takeSnapShot();
			}
		});

		this.ckbFaceDetection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JPanelWest.this.ckbFaceDetection.isSelected()) {
					JPanelWest.this.panelCamera.displayStatistic(true);
					JPanelWest.this.ckbYoloDetection.setSelected(false);
					JPanelWest.this.ckbYoloDetection.setEnabled(false);
					JPanelWest.this.ckbTinyYoloDetection.setSelected(false);
					JPanelWest.this.ckbTinyYoloDetection.setEnabled(false);
					JPanelWest.this.panelCamera.setFaceDetection(true);
				} else {
					JPanelWest.this.panelCamera.displayStatistic(false);
					JPanelWest.this.panelCamera.setFaceDetection(false);
					JPanelWest.this.ckbYoloDetection.setEnabled(true);
					JPanelWest.this.ckbTinyYoloDetection.setEnabled(true);
				}
			}
		});

		this.ckbYoloDetection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JPanelWest.this.ckbYoloDetection.isSelected()) {
					JPanelWest.this.panelCamera.startStatStream();
					JPanelWest.this.ckbFaceDetection.setSelected(false);
					JPanelWest.this.ckbFaceDetection.setEnabled(false);
					JPanelWest.this.ckbTinyYoloDetection.setSelected(false);
					JPanelWest.this.ckbTinyYoloDetection.setEnabled(false);
					JPanelWest.this.panelCamera.setYoloDetection(true);
				} else {
					JPanelWest.this.panelCamera.stopStatStream();
					JPanelWest.this.panelCamera.setYoloDetection(false);
					JPanelWest.this.ckbFaceDetection.setEnabled(true);
					JPanelWest.this.ckbTinyYoloDetection.setEnabled(true);
				}
			}
		});
		
		this.ckbTinyYoloDetection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JPanelWest.this.ckbTinyYoloDetection.isSelected()) {
					JPanelWest.this.panelCamera.startStatStream();
					JPanelWest.this.ckbYoloDetection.setSelected(false);
					JPanelWest.this.ckbYoloDetection.setEnabled(false);
					JPanelWest.this.ckbFaceDetection.setSelected(false);
					JPanelWest.this.ckbFaceDetection.setEnabled(false);
					JPanelWest.this.panelCamera.setTinyYoloDetection(true);
				} else {
					JPanelWest.this.panelCamera.stopStatStream();
					JPanelWest.this.panelCamera.setTinyYoloDetection(false);
					JPanelWest.this.ckbYoloDetection.setEnabled(true);
					JPanelWest.this.ckbFaceDetection.setEnabled(true);
				}
			}
		});

	}

	public double getRotationAngle() {
		return cameraRotationAngle;
	}

	public int getZoom() {
		return panelZoom.getZoom();
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
	private JCheckBox ckbTinyYoloDetection;
	private JPanelZoom panelZoom;
	private JPanelCameraGUI panelCamera;
	private double cameraRotationAngle;

	private String cameraName;
	private String cameraDescription;
}
