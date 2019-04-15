package fluffy.userinterface.main;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelEmailInfo extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelEmailInfo()
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
	public JTextField getFldEmail()
		{
		return this.fldEmail;
		}


	public JComboBox<Integer> getCbxHours()
		{
		return this.cbxHours;
		}



	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void fillComboBox()
		{
		int n = 23;
		for(int i = 0; i <= n; i++)
			{
			cbxHours.addItem(i);
			}
		}

	private void geometry()
		{
		lbEmail = new JLabel("Email : ");
		lbHours = new JLabel("Hours : ");
		fldEmail = new JTextField();
		cbxHours = new JComboBox<Integer>();
		fillComboBox();
		GridLayout gridLayout = new GridLayout(2, 2);
		setLayout(gridLayout);
		add(lbEmail);
		add(fldEmail);
		add(lbHours);
		add(cbxHours);

		}



	private void control()
		{
		// rien
		}

	private void appearance()
		{
		fldEmail.setPreferredSize(new Dimension(100, fldEmail.getPreferredSize().height));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JLabel lbEmail;
	private JLabel lbHours;
	private JTextField fldEmail;
	private JComboBox<Integer> cbxHours;

	}
