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

import fluffy.network.camera.decorator.ICamera;
import fluffy.tools.image.MagasinImage;
import fluffy.userinterface.main.JPanelCameraPreview;

public class CameraGUI extends JFrame
	{

	public CameraGUI(ICamera camera, JPanelCameraPreview jPanelCameraPreview, String cameraName, String cameraDescription)
		{
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
		this.geometry();
		this.control();
		this.appearance();
		this.panelCameraPreview = jPanelCameraPreview;
		this.panelCamera.setCamera(camera);
		this.panelCamera.streamCamera();
		}

	private void appearance()
		{
		this.setTitle("Fluffy : Camera");
		this.setIconImage(MagasinImage.logo.getImage());
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
				panelCamera.stopStream();
				// FIXME : Find dynamic delay
				try
					{
					Thread.sleep(2000);
					}
				catch (InterruptedException e1)
					{
					e1.printStackTrace();
					}
				CameraGUI.this.panelCameraPreview.streamCamera();
				}
			});
		}

	private void geometry()
		{
		this.panelCamera = new JPanelCameraGUI(this, cameraName, cameraDescription, panelCamera, panelCameraPreview);
		this.add(this.panelCamera);
		}

	private JPanelCameraPreview panelCameraPreview;
	private JPanelCameraGUI panelCamera;
	private String cameraName;
	private String cameraDescription;
	}
