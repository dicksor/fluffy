/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.userinterface.camera_gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fluffy.userinterface.main.JPanelCameraPreview;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class JPanelSouth extends JPanel
	{

	public JPanelSouth(JFrame frameRoot, JPanelCameraGUI panelCamera, JPanelCameraPreview panelCameraPreview)
		{
		this.panelCameraPreview = panelCameraPreview;
		this.panelCamera = panelCamera;
		geometry();
		control();
		appearance();
		this.frameRoot = frameRoot;
		}

	private void appearance()
		{
		this.btnReturn.setBackground(MaterialColors.RED_400);
		this.btnReturn.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnReturn, MaterialColors.GRAY_200);
		}

	private void control()
		{
		this.btnReturn.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				//FIXME: le bouton ne fonctionne plus genere une erreur
				System.exit(-1);
				/*JPanelSouth.this.panelCamera.stopStream();

				try
					{
					Thread.sleep(2000);
					System.out.println("test");
					}
				catch (InterruptedException e1)
					{
					e1.printStackTrace();
					}
					JPanelSouth.this.panelCameraPreview.streamCamera();*/
				}
			});
		}

	private void geometry()
		{
		this.btnReturn = new JButton("Return to main view");

		this.add(btnReturn);
		}

	private JPanelCameraPreview panelCameraPreview;
	private JPanelCameraGUI panelCamera;

	private JButton btnReturn;
	private JFrame frameRoot;

	}
