/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.main;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel that contains the email field with his label and the combox box hours with his label
 *
 *
 */
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

	/**
	 * fill the combobox with hours
	 */
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
