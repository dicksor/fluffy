
package fluffy.userinterface.help;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class JPanelControls extends JPanel {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelControls() {
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

	private void geometry() {
		btnBack = new JButton("Back");

		this.setLayout(new BorderLayout());

		this.add(this.btnBack, BorderLayout.CENTER);
	}

	private void control() {

		this.btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Component root = SwingUtilities.getRoot((JButton) e.getSource());
				root.dispatchEvent(new WindowEvent((Window) root, WindowEvent.WINDOW_CLOSING));
			}
		});
	}

	private void appearance() {
		this.btnBack.setBackground(MaterialColors.LIGHT_BLUE_400);
		this.btnBack.setForeground(Color.WHITE);
		this.btnBack.setPreferredSize(new Dimension(150, 50));
		MaterialUIMovement.add(this.btnBack, MaterialColors.GRAY_200);
	}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JButton btnBack;

}
