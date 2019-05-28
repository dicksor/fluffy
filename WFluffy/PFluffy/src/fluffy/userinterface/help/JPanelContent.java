/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.help;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelContent extends JPanel {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelContent() {
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
		lbHeader = new JLabel("Fluffy project : Camera IP controller");

		lbContent = new JLabel("<html><body>"
				+ "<strong>Email</strong><br><br>"
				+ "First, you need to fill the form with your personal email, and choose an hour. "
				+ "You need to validate it by clicking \"Apply Changes\"<br>"
				+ "You will receive an email every day at the configured time. It will contain a folder with pictures.<br>"
				+ "Every time a personn is detected, the application is going to take a screenshot and add them inside the folder.<br>"
				+ "By clicking on \"Force Email\", an email will directly be sent to you.<br><br>"
				+ "<strong>Webcam</strong><br><br>"
				+ "Your laptop webcam is configured by default. If you want to add another camera, you can click on \"Add camera\".<br>"
				+ "You have to fill the form, by writing a name, the link to acces the preview video, and a desrciption. "
				+ "Then, click on \"Connection\" to save the configuration.<br> When you leave the programm, all the configurations will be saved.<br><br>"
				+ "To get the camera preview in a single window, you can juste click on the small video preview.<br>"
				+ "A new window will pop up. This window provides a variety of tools such as :<br>"
				+ "<ul>"
				+ "<li>Rotate left</li>"
				+ "<li>Rotate right</li>"
				+ "<li>Take a screenshot and save it</li>"
				+ "<li>Added frame detection (You have the choice between three differents detections)</li>"
				+ "<li>Go back to the main menu</li>"
				+ "</ul>"
				+ "</body></html>");

		lbFooter = new JLabel("<html><body>" + "Projet P2 Java<br>" + "HE-Arc Ingénierie | Année 2018-109<br>"
				+ "Professeurs : Rizzotti Aïcha et Punceva Magdalena<br>"
				+ "Etudiants : Romain Capocasale, Jonas Freiburghaus et Vincent Moulin" + "</body></html>");

		this.setLayout(new BorderLayout());

		this.add(lbHeader, BorderLayout.NORTH);
		this.add(this.lbContent, BorderLayout.CENTER);
		this.add(lbFooter, BorderLayout.SOUTH);
	}

	private void control() {
		// rien
	}

	private void appearance() {
		Font fontHeader = new Font("Arial", Font.BOLD, 40);
		this.lbHeader.setFont(fontHeader);
		
		Font fontContent = new Font("Arial", Font.PLAIN, 14);
		this.lbFooter.setFont(fontContent);

		Font fontFooter = new Font("Arial", Font.ITALIC, 15);
		this.lbFooter.setFont(fontFooter);
	}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel lbContent;
	private JLabel lbHeader;
	private JLabel lbFooter;

}
