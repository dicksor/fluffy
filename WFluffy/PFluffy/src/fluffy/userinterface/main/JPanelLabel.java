/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.userinterface.main;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelLabel extends JPanel
	{

	public JPanelLabel()
		{
		this.geometry();
		this.control();
		this.appearance();
		}

	private void appearance()
		{
		// TODO Auto-generated method stub

		}

	private void control()
		{
		// TODO Auto-generated method stub

		}

	private void geometry()
		{
		// TODO Auto-generated method stub
		this.lbTitle = new JLabel("<html><h1>Gestionaire de caméra IP</h1></html>");
		this.setLayout(new FlowLayout());
		this.add(this.lbTitle);
		}

	private JLabel lbTitle;
	}
