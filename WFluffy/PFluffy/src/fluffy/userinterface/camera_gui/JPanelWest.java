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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class JPanelWest extends JPanel
	{

	public JPanelWest()
		{
		this.cameraRotationAngle = 0;
		geometry();
		control();
		appearance();
		}

	public JPanelWest(JPanel panelCamera)
		{
		this();
		this.panelCamera = panelCamera;
		}

	private void geometry()
		{
		this.lblCameraName = new JLabel("Camera Name");
		this.btnSnapshot = new JButton("Take Snapshot");
		this.btnRotateLeft = new JButton("Rotate left");
		this.btnRotateRight = new JButton("Rotate right");
		this.panelZoom = new JPanelZoom();

		Box boxV = Box.createVerticalBox();

		boxV.add(Box.createVerticalGlue());
		boxV.add(lblCameraName);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(btnSnapshot);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(btnRotateLeft);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(btnRotateRight);
		boxV.add(Box.createVerticalStrut(30));
		boxV.add(panelZoom);
		boxV.add(Box.createVerticalGlue());

		setLayout(new BorderLayout());
		this.add(boxV, BorderLayout.CENTER);
		}

	private void control()
		{
		this.btnRotateLeft.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				cameraRotationAngle += 90;
				((JPanelCameraGUI)panelCamera).rotateCamera(cameraRotationAngle);
				}
			});

		this.btnRotateRight.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				cameraRotationAngle -= 90;
				((JPanelCameraGUI)panelCamera).rotateCamera(cameraRotationAngle);
				}
			});

		this.btnSnapshot.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				((JPanelCameraGUI)panelCamera).takeSnapShot();
				}
			});
		}

	private void appearance()
		{
		this.btnSnapshot.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnSnapshot.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnSnapshot, MaterialColors.GRAY_200);

		this.btnRotateLeft.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnRotateLeft.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnRotateLeft, MaterialColors.GRAY_200);

		this.btnRotateRight.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnRotateRight.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnRotateRight, MaterialColors.GRAY_200);
		}

	public JButton getBtnRotateLeft()
		{
		return btnRotateLeft;
		}

	private JLabel lblCameraName;
	private JButton btnSnapshot;
	private JButton btnRotateLeft;
	private JButton btnRotateRight;
	private JPanelZoom panelZoom;
	private JPanel panelCamera;
	private double cameraRotationAngle;

	}
