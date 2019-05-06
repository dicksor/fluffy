/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.userinterface.camera_gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fluffy.network.camera.model.CameraXml;

public class JPanelZoom extends JPanel
	{

	public JPanelZoom(JPanelCameraGUI panelCamera, String cameraName)
		{
		this.panelCamera = panelCamera;
		this.geometry();
		this.control();

		CameraXml cameraXml = CameraXml.getInstance();
		if(!cameraXml.getCameras().get(cameraName).getZoom().equals(""))
			{
			zoom = Integer.valueOf(cameraXml.getCameras().get(cameraName).getZoom());
			panelCamera.rotateCamera(zoom);
			spZoom.setValue(zoom);
			}

		}

	private void geometry()
		{
		this.lblZoom = new JLabel("Zoom : ");
		this.spZoom = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

		this.add(lblZoom);
		this.add(spZoom);

		}

	private void control()
		{
		this.spZoom.addChangeListener(new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				zoom = (Integer)JPanelZoom.this.spZoom.getValue();
				panelCamera.zoomCamera(zoom);
				}
			});
		}

	public int getZoom()
		{
		return zoom;
		}

	private int zoom;
	private JLabel lblZoom;
	private JSpinner spZoom;
	private JPanelCameraGUI panelCamera;
	}
