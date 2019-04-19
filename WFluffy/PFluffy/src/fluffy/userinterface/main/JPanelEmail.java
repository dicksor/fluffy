/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.userinterface.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fluffy.network.camera.model.UserModel;
import fluffy.network.camera.model.UserXml;
import fluffy.network.mail.EmailSender;
import fluffy.tools.mail.EmailValidator;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

/**
 * Panel that contains EmailInfo items and button to apply the change
 *
 */
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
		btnForceEmail = new JButton("Force Email");
		btnApply = new JButton("Apply Change");

		setLayout(new FlowLayout());

		add(jPanelEmailInfo);
		add(btnApply);
		add(btnForceEmail);
		}

	private void control()
		{
		btnForceEmail.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				String email = JPanelEmail.this.jPanelEmailInfo.getFldEmail().getText();
				if (!email.equals(""))
					{
					if ((new EmailValidator()).validate(email.trim()))
						{
						EmailSender.sendSnapShot(email);
						int hour = JPanelEmail.this.jPanelEmailInfo.getCbxHours().getSelectedIndex();

						UserXml userXml = UserXml.getInstance();
						UserModel userModel = new UserModel(email, String.valueOf(hour));
						userXml.add(userModel);
						JOptionPane.showMessageDialog(null, "Email was sent and settings are correctly applied", "InfoBox: fluffy", JOptionPane.INFORMATION_MESSAGE);
						}
					else
						{
						JOptionPane.showMessageDialog(null, "Error please enter a correct email", "ErrBox: fluffy", JOptionPane.ERROR_MESSAGE);
						}
					}
				else
					{
					UserXml userXml = UserXml.getInstance();
					UserModel userModel = userXml.getUserModel();
					String emailXML = userModel.getEmail();
					if (!emailXML.equals(""))
						{
						EmailSender.sendSnapShot(emailXML);
						JOptionPane.showMessageDialog(null, "Email was sent", "InfoBox: fluffy", JOptionPane.INFORMATION_MESSAGE);
						}
					else
						{
						JOptionPane.showMessageDialog(null, "Error please enter a email", "ErrBox: fluffy", JOptionPane.ERROR_MESSAGE);
						}
					}

				}
			});

		btnApply.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				//check if the email is in the correct format
				if ((new EmailValidator()).validate(JPanelEmail.this.jPanelEmailInfo.getFldEmail().getText().trim()))
					{
					String email = JPanelEmail.this.jPanelEmailInfo.getFldEmail().getText();
					int hour = JPanelEmail.this.jPanelEmailInfo.getCbxHours().getSelectedIndex();

					UserXml userXml = UserXml.getInstance();
					UserModel userModel = new UserModel(email, String.valueOf(hour));
					userXml.add(userModel);
					JOptionPane.showMessageDialog(null, "Settings correctly applied", "InfoBox: fluffy", JOptionPane.INFORMATION_MESSAGE);
					}
				else
					{
					JOptionPane.showMessageDialog(null, "Error please enter a correct email", "ErrBox: fluffy", JOptionPane.ERROR_MESSAGE);
					}
				}

			});
		}

	private void appearance()
		{
		this.btnApply.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnApply.setForeground(Color.WHITE);
		this.btnApply.setPreferredSize(new Dimension(150, 50));
		MaterialUIMovement.add(this.btnApply, MaterialColors.GRAY_200);

		this.btnForceEmail.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnForceEmail.setForeground(Color.WHITE);
		this.btnForceEmail.setPreferredSize(new Dimension(150, 50));
		MaterialUIMovement.add(this.btnForceEmail, MaterialColors.GRAY_200);

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools

	private JButton btnApply;
	private JPanelEmailInfo jPanelEmailInfo;
	private JButton btnForceEmail;
	}
