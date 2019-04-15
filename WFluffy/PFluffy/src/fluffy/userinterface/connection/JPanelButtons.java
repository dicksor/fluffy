/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.userinterface.connection;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class JPanelButtons extends JPanel
	{

	public JPanelButtons(JFrame parent)
		{
		this.parent = parent;
		geometry();
		control();
		appearance();
		}

	private void geometry()
		{
		this.btnCancel = new JButton("Cancel");
		this.btnConnectionCamera = new JButton("Connection");

		this.flowlayout = new FlowLayout();
		setLayout(flowlayout);

		this.add(btnCancel);
		this.add(btnConnectionCamera);

		}

	private void control()
		{
		this.btnCancel.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				JPanelButtons.this.parent.setVisible(false);
				JPanelButtons.this.parent.dispose();
				}

			});
		}

	private void appearance()
		{
		this.btnCancel.setBackground(MaterialColors.RED_400);
		this.btnCancel.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnCancel, MaterialColors.GRAY_200);

		this.btnConnectionCamera.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnConnectionCamera.setForeground(Color.WHITE);
		MaterialUIMovement.add(this.btnConnectionCamera, MaterialColors.GRAY_200);
		}

	//input
	private JFrame parent;

	// tools

	private FlowLayout flowlayout;

	// Buttons
	private JButton btnConnectionCamera;
	private JButton btnCancel;
	}
