package fluffy.userinterface.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class JPanelEmail extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelEmail()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/



	private void geometry()
		{
		jPanelEmailInfo = new JPanelEmailInfo();
		btnApply = new JButton("Apply Change");
		setLayout(new FlowLayout());
		add(jPanelEmailInfo);
		add(btnApply);
		}

	private void control()
		{
		btnApply.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				//mettre ces valeurs dans un fichier texte
				String email = JPanelEmail.this.jPanelEmailInfo.getFldEmail().getText();
				int hour = JPanelEmail.this.jPanelEmailInfo.getCbxHours().getSelectedIndex();
				JOptionPane.showMessageDialog(null, "Settings correctly applied", "InfoBox: fluffy", JOptionPane.INFORMATION_MESSAGE);

				}
			});
		}

	private void appearance()
		{
		this.btnApply.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnApply.setForeground(Color.WHITE);
		this.btnApply.setPreferredSize(new Dimension(150, 50));
		MaterialUIMovement.add(this.btnApply, MaterialColors.GRAY_200);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools

	private JButton btnApply;
	private JPanelEmailInfo jPanelEmailInfo;

	}
