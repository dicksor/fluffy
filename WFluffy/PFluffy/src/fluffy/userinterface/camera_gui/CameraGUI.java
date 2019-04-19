/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.userinterface.camera_gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import fluffy.network.camera.Camera;
import fluffy.network.camera.model.CameraXml;
import fluffy.userinterface.main.JPanelCameraPreview;

public class CameraGUI extends JFrame
	{

	public CameraGUI(Camera camera, JPanelCameraPreview jPanelCameraPreview, String cameraName, String cameraDescription)
		{
		this.camera = camera;
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
		this.geometry();
		this.control();
		this.appearance();
		}

	private void appearance()
		{
		this.setTitle("Fluffy : Camera");
		//this.setIconImage(MagasinImage.logo.getImage());
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setVisible(true);
		}

	private void control()
		{
		this.addWindowListener(new WindowAdapter()
			{

			@Override
			public void windowClosing(WindowEvent e)
				{
				CameraXml cameraXml = CameraXml.getInstance();
				cameraXml.setCameraZoom(cameraName, String.valueOf(CameraGUI.this.panelCamera.getZoom()));
				cameraXml.setCameraAngle(cameraName, String.valueOf(CameraGUI.this.panelCamera.getRotationAngle()));
				}
			});
		}

	private void geometry()
		{
		this.panelCamera = new JPanelCameraGUI(this, this.cameraName, this.cameraDescription, this.camera);
		this.add(this.panelCamera);
		}

	private JPanelCameraGUI panelCamera;
	private String cameraName;
	private String cameraDescription;
	private Camera camera;
	}
