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
import fluffy.network.camera.CameraRotation;
import fluffy.network.camera.ICamera;
import fluffy.userinterface.cameradisplay.CameraDisplay;

public class JPanelCameraGUI extends JPanel
	{

	public JPanelCameraGUI(JFrame frameRoot, String cameraName, String cameraDescription)
		{
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
		this.geometry();
		this.control();
		this.appearance();
		this.camera = null;
		this.frameRoot = frameRoot;
		this.geometry();
		this.control();
		this.appearance();
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

		this.panelWest = new JPanelWest(this, cameraName, cameraDescription);
		this.panelEast = new JPanel();
		this.panelEast.setPreferredSize(new Dimension(panelWest.getPreferredSize().width, panelWest.getPreferredSize().height));
		this.panelSouth = new JPanelSouth(this.frameRoot);
		this.lbCameraDisplay = new JLabel();

		Box boxCameraPreview = centerCamera(lbCameraDisplay);

		this.borderMainLayout = new BorderLayout();
		this.setLayout(this.borderMainLayout);

		this.add(this.panelWest, BorderLayout.WEST);
		this.add(this.panelSouth, BorderLayout.SOUTH);
		this.add(this.panelEast, BorderLayout.EAST);
		this.add(boxCameraPreview, BorderLayout.CENTER);
		}

	public void setCamera(ICamera camera)
		{
		this.camera = new CameraRotation(camera, 0);
		}

	public void rotateCamera(double angle)
		{
		// FIXME : Pas très DRY
		((CameraRotation)this.camera).setAngle(angle);
		this.cameraDisplay.setIsRunning(false);
		this.cameraDisplay = new CameraDisplay(this.lbCameraDisplay, this.camera, false);
		this.threadDisplayImage = new Thread(this.cameraDisplay);
		this.threadDisplayImage.start();
		}

	public void takeSnapShot()
		{
		Thread snapThread = new Thread(new DialogSnapshotTaker(this.camera));
		snapThread.start();
		}

	// FIXME : Almost duplicate code from JPannelCameraPreview
	public void streamCamera()
		{
		if (this.camera != null)
			{
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

	private JLabel lbCameraDisplay;
	private JPanelWest panelWest;
	private JPanelSouth panelSouth;
	private JPanel panelEast;
	private BorderLayout borderMainLayout;
	private ICamera camera;
	private JFrame frameRoot;
	private CameraDisplay cameraDisplay;
	private Thread threadDisplayImage;

	private String cameraName;
	private String cameraDescription;
	}
