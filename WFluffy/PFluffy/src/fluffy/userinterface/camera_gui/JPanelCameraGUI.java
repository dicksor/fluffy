package fluffy.userinterface.camera_gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fluffy.imageprocessing.snapshot.SnapshotTaker;
import fluffy.network.camera.decorator.Camera;
import fluffy.network.camera.decorator.CameraDecorator;
import fluffy.network.camera.decorator.CameraFaceDetection;
import fluffy.network.camera.decorator.CameraRotation;
import fluffy.network.camera.decorator.ICamera;
import fluffy.userinterface.cameradisplay.CameraDisplay;

public class JPanelCameraGUI extends JPanel {

	public JPanelCameraGUI() {
		this.geometry();
		this.control();
		this.appearance();
	}
	
	public JPanelCameraGUI(JFrame frameRoot) {
		this.camera = null;
		this.frameRoot = frameRoot;
		this.geometry();
		this.control();
		this.appearance();
	}

	private void appearance() {

	}

	private void control() {

	}

	private void geometry() {

		this.panelWest = new JPanelWest(this);
		this.panelSouth = new JPanelSouth(this.frameRoot);
		this.lbCameraDisplay = new JLabel();

		this.borderMainLayout = new BorderLayout();
		this.setLayout(this.borderMainLayout);

		this.add(this.panelWest, BorderLayout.WEST);
		this.add(this.panelSouth, BorderLayout.SOUTH);
		this.add(this.lbCameraDisplay, BorderLayout.CENTER);
	}
	
	public void setFaceDetection(boolean hasFaceDetection) {
		this.stopStream();
		if(hasFaceDetection) {
			this.camera = this.cameraWithFaceDetection;
		} else {
			this.camera = this.cameraWithoutFaceDetection;
		}
		this.streamCamera();
		this.rotateCamera(this.cameraRotationAngle);
	}
	
	public void setCamera(ICamera camera) {
		this.cameraWithoutFaceDetection = new CameraRotation(camera, 0);
		this.camera = this.cameraWithoutFaceDetection;
		this.cameraWithFaceDetection = new CameraRotation(new CameraFaceDetection(camera), 0);
	}
	
	public void rotateCamera(double angle) {
		this.stopStream();
		this.cameraRotationAngle = angle;
		((CameraRotation) this.camera).setAngle(this.cameraRotationAngle);
		this.streamCamera();
	}
	
	public void takeSnapShot() {
		Thread snapThread = new Thread(new SnapshotTaker(this.camera));
		snapThread.start();
	}
	
	public void streamCamera() {
		if(this.camera != null) {
			this.cameraDisplay = new CameraDisplay(this.lbCameraDisplay, this.camera, false);
			this.threadDisplayImage = new Thread(this.cameraDisplay);
			this.threadDisplayImage.start();
		}
		// TODO : Faire qqch si null
	}
	
	public void stopStream() {
		this.cameraDisplay.setIsRunning(false);
	}

	private JLabel lbCameraDisplay;
	private JPanelWest panelWest;
	private JPanelSouth panelSouth;
	private BorderLayout borderMainLayout;
	private ICamera camera;
	private JFrame frameRoot;
	private CameraDisplay cameraDisplay;
	private Thread threadDisplayImage;
	private double cameraRotationAngle;
	private ICamera cameraWithFaceDetection;
	private ICamera cameraWithoutFaceDetection;

}