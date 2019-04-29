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

	public JPanelCameraGUI(JFrame frameRoot, JPanelCameraPreview jPanelCameraPreview, String cameraName,
			String cameraDescription, Camera camera) {
		this.frameRoot = frameRoot;
		this.jPanelCameraPreview = jPanelCameraPreview;

		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
		this.camera = camera;

		this.cameraPipeline = new CameraPipeline();
		this.camera.addPropertyChangeListener(this.cameraPipeline);
		this.snapshotTaker = new DialogSnapshotTaker();
		this.camera.addPropertyChangeListener(this.snapshotTaker);

		this.geometry();
		this.control();
		this.appearance();

		this.cameraDisplay = new CameraDisplay(this.lbCameraDisplay, false);
		this.cameraPipeline.addPropertyChangeListener(this.cameraDisplay);
		this.cameraPipeline.addPropertyChangeListener(this.panelNorth);
	}

	private void appearance() {
		this.displayStatistic(false);
		this.panelEast.setVisible(false);
	}

	private void control() {

	}

	public int getZoom() {
		return panelWest.getZoom();
	}

	public double getRotationAngle() {
		return panelWest.getRotationAngle();
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
		this.panelEast = new JPanelEast();
		this.panelWest = new JPanelWest(this, cameraName, cameraDescription);
		this.panelEast.setPreferredSize(
				new Dimension(panelWest.getPreferredSize().width, panelWest.getPreferredSize().height));
		this.panelSouth = new JPanelSouth(this.frameRoot, this, this.jPanelCameraPreview, cameraName);
		this.panelNorth = new JPanelNorth();
		this.lbCameraDisplay = new JLabel();

		Box boxCameraPreview = centerCamera(lbCameraDisplay);

		this.borderMainLayout = new BorderLayout();
		this.setLayout(this.borderMainLayout);

		this.add(this.panelWest, BorderLayout.WEST);
		this.add(this.panelSouth, BorderLayout.SOUTH);
		this.add(this.panelNorth, BorderLayout.NORTH);
		this.add(this.panelEast, BorderLayout.EAST);
		this.add(boxCameraPreview, BorderLayout.CENTER);
	}

	public void setFaceDetection(boolean hasFaceDetection) {
		if(!hasFaceDetection)
			this.panelNorth.resetFaceDetectedCount();
		this.cameraPipeline.setIsActive(Operators.FACEDETECTION, hasFaceDetection);
	}

	public void setYoloDetection(boolean hasYoloDetection) {
		this.cameraPipeline.setIsActive(Operators.YOLO, hasYoloDetection);
	}
	
	public void setTinyYoloDetection(boolean hasTinyYoloDetection) {
		this.cameraPipeline.setIsActive(Operators.TINY_YOLO, hasTinyYoloDetection);
	}

	public void rotateCamera(double angle) {
		this.cameraPipeline.setRotationAngle(angle);
	}

	public void zoomCamera(int zoomFactor) {
		this.cameraPipeline.setZoomFactor(zoomFactor);
	}

	public void takeSnapShot() {
		this.snapshotTaker.getSnapShot();
	}

	public void stopStream() {
		this.cameraPipeline.removePropertyChangeListener(this.cameraDisplay);
	}
	
	public void stopStatStream() {
		this.panelEast.setVisible(false);
		this.cameraPipeline.removePropertyChangeListener(this.panelEast);
		this.panelEast.clearList();
	}
	
	public void startStatStream() {
		this.panelEast.setVisible(true);
		this.cameraPipeline.addPropertyChangeListener(this.panelEast);
	}
	
	public void displayStatistic(boolean isStatOn) {
		this.panelNorth.setVisible(isStatOn);
	}

	private JPanelCameraPreview jPanelCameraPreview;
	private JLabel lbCameraDisplay;
	private JPanelWest panelWest;
	private JPanelSouth panelSouth;
	private JPanelNorth panelNorth;
	private JPanelEast panelEast;
	private BorderLayout borderMainLayout;
	private CameraPipeline cameraPipeline;
	private JFrame frameRoot;
	private CameraDisplay cameraDisplay;
	private String cameraName;
	private String cameraDescription;
	private DialogSnapshotTaker snapshotTaker;
	private Camera camera;
}
