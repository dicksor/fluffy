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

public class JPanelZoom extends JPanel
	{

	public JPanelZoom(JPanelCameraGUI panelCamera)
		{
		this.panelCamera = panelCamera;
		geometry();
		control();
		appearance();
		}

	private void geometry()
		{
		this.lblZoom = new JLabel("Zoom : ");
		this.spZoom = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

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

	private void appearance()
		{
		// TODO Auto-generated method stub

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
