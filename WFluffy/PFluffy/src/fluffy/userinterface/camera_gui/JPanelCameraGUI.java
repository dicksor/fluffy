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
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fluffy.imageprocessing.snapshot.DialogSnapshotTaker;
import fluffy.network.camera.Camera;
import fluffy.network.camera.pipeline.CameraPipeline;
import fluffy.network.camera.pipeline.Operators;
import fluffy.userinterface.cameradisplay.CameraDisplay;
import fluffy.userinterface.main.JPanelCameraPreview;

public class JPanelCameraGUI extends JPanel {

	public JPanelCameraGUI(JFrame frameRoot, String cameraName, String cameraDescription, JPanelCameraGUI panelCamera,
			JPanelCameraPreview panelCameraPreview) {
		this.panelCameraPreview = panelCameraPreview;
		this.panelCamera = panelCamera;
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
		this.geometry();
		this.control();
		this.appearance();
		this.frameRoot = frameRoot;
	}

	private void appearance() {

	}

	private void control() {

	}

	private Box centerCamera(JLabel label) {
		Box boxV = Box.createHorizontalBox();
		Box boxH = Box.createVerticalBox();

		boxV.add(Box.createVerticalGlue());
		boxV.add(label);
		boxV.add(Box.createVerticalGlue());

		boxH.add(Box.createHorizontalGlue());
		boxH.add(boxV);
		boxH.add(Box.createHorizontalGlue());
		return boxH;
	}

	private void geometry() {
		System.out.println(cameraName);
		this.panelWest = new JPanelWest(this, cameraName, cameraDescription);
		this.panelEast = new JPanel();
		this.panelEast.setPreferredSize(
				new Dimension(panelWest.getPreferredSize().width, panelWest.getPreferredSize().height));
		this.panelSouth = new JPanelSouth(this.frameRoot, panelCamera, panelCameraPreview);
		this.lbCameraDisplay = new JLabel();

		Box boxCameraPreview = centerCamera(lbCameraDisplay);

		this.borderMainLayout = new BorderLayout();
		this.setLayout(this.borderMainLayout);

		this.add(this.panelWest, BorderLayout.WEST);
		this.add(this.panelSouth, BorderLayout.SOUTH);
		this.add(this.panelEast, BorderLayout.EAST);
		this.add(boxCameraPreview, BorderLayout.CENTER);
	}

	public void setFaceDetection(boolean hasFaceDetection) {
		this.cameraPipeline.setIsActive(Operators.FACEDETECTION, hasFaceDetection);
	}

	public void setCamera(Camera camera) {
		this.cameraPipeline = new CameraPipeline();
		camera.addPropertyChangeListener(this.cameraPipeline);	
	}

	public void rotateCamera(double angle) {
		this.cameraPipeline.setRotationAngle(angle);
	}

	public void zoomCamera(int zoomFactor) {
		this.cameraPipeline.setZoomFactor(zoomFactor);
	}

	public void takeSnapShot() {
		Thread snapThread = new Thread(new DialogSnapshotTaker(this.cameraPipeline));
		snapThread.start();
	}

	public void streamCamera() {
		this.cameraDisplay = new CameraDisplay(this.lbCameraDisplay, false);
		this.cameraPipeline.addPropertyChangeListener(this.cameraDisplay);
	}

	public void stopStream() {
		this.cameraPipeline.removePropertyChangeListener(this.cameraDisplay);
	}

	private JPanelCameraPreview panelCameraPreview;
	private JPanelCameraGUI panelCamera;

	private JLabel lbCameraDisplay;
	private JPanelWest panelWest;
	private JPanelSouth panelSouth;
	private JPanel panelEast;
	private BorderLayout borderMainLayout;
	private CameraPipeline cameraPipeline;
	private JFrame frameRoot;
	private CameraDisplay cameraDisplay;
	private String cameraName;
	private String cameraDescription;
}
