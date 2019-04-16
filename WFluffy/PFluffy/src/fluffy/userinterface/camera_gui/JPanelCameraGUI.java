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
import fluffy.network.camera.decorator.CameraFaceDetection;
import fluffy.network.camera.decorator.CameraRotation;
import fluffy.network.camera.decorator.ICamera;
import fluffy.userinterface.cameradisplay.CameraDisplay;
import fluffy.userinterface.main.JPanelCameraPreview;

public class JPanelCameraGUI extends JPanel
	{

	public JPanelCameraGUI(JFrame frameRoot, String cameraName, String cameraDescription, JPanelCameraGUI panelCamera, JPanelCameraPreview panelCameraPreview)
		{
		this.panelCameraPreview = panelCameraPreview;
		this.panelCamera = panelCamera;
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
		this.geometry();
		this.control();
		this.appearance();
		this.camera = null;
		this.frameRoot = frameRoot;
		}

	private void appearance()
		{

		}

	private void control()
		{

		}

	private Box centerCamera(JLabel label)
		{
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

	private void geometry()
		{
		System.out.println(cameraName);
		this.panelWest = new JPanelWest(this, cameraName, cameraDescription);
		this.panelEast = new JPanel();
		this.panelEast.setPreferredSize(new Dimension(panelWest.getPreferredSize().width, panelWest.getPreferredSize().height));
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

	public void takeSnapShot()
	{
	Thread snapThread = new Thread(new DialogSnapshotTaker(this.camera));
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

	public void stopStream()
		{
		this.cameraDisplay.setIsRunning(false);
		}

	private JPanelCameraPreview panelCameraPreview;
	private JPanelCameraGUI panelCamera;

	private JLabel lbCameraDisplay;
	private JPanelWest panelWest;
	private JPanelSouth panelSouth;
	private JPanel panelEast;
	private BorderLayout borderMainLayout;
	private ICamera camera;
	private JFrame frameRoot;
	private CameraDisplay cameraDisplay;
	private Thread threadDisplayImage;
	private double cameraRotationAngle;
	private ICamera cameraWithFaceDetection;
	private ICamera cameraWithoutFaceDetection;

	private String cameraName;
	private String cameraDescription;
	}
