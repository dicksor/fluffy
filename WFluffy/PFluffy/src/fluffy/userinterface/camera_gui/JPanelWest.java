package fluffy.userinterface.camera_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelWest extends JPanel {

	public JPanelWest() {
		this.cameraRotationAngle = 0;
		geometry();
		control();
		appearance();
	}
	
	public JPanelWest(JPanelCameraGUI panelCamera) {
		this();
		this.panelCamera = panelCamera;
	}

	private void geometry() {
		this.lblCameraName = new JLabel("Camera Name");
		this.btnSnapshot = new JButton("Take Snapshot");
		this.btnRotateLeft = new JButton("Rotate left");
		this.btnRotateRight = new JButton("Rotate right");
		this.ckbFaceDetection = new JCheckBox("With face detection");
		this.panelZoom = new JPanelZoom();
		
		Box boxV = Box.createVerticalBox();
		
		boxV.add(Box.createVerticalStrut(60));
		boxV.add(lblCameraName);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(btnSnapshot);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(btnRotateLeft);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(btnRotateRight);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(ckbFaceDetection);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(panelZoom);
		boxV.add(Box.createVerticalStrut(30));
		
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
				panelCamera.stopStream();
				panelCamera.takeSnapShot();
				panelCamera.streamCamera();
			}
		});
		
		this.ckbFaceDetection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JPanelWest.this.ckbFaceDetection.isSelected()) {
					panelCamera.setFaceDetection(true);
				}	
				else {
					panelCamera.setFaceDetection(false);
				}
			}
		});
	}

	private void appearance() {
		// rien
	}
	
	public JButton getBtnRotateLeft() {
		return btnRotateLeft;
	}
	

	private JLabel lblCameraName;
	private JButton btnSnapshot;
	private JButton btnRotateLeft;
	private JButton btnRotateRight;
	private JCheckBox ckbFaceDetection;
	private JPanelZoom panelZoom;
	private JPanelCameraGUI panelCamera;
	private double cameraRotationAngle;

}
