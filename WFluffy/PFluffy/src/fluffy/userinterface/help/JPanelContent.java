
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
				+ "First, you need to fill the form with your perosnnal email, and choose an hour. "
				+ "You need to validate it by clicking \"Apply Changes\"<br>"
				+ "You will receive an email every day at the time you have configured. It will contains a folder with pictures.<br>"
				+ "Every time a personn is detected, the application gonna take a screenshot and added them inside the folder.<br>"
				+ "By clicking on \"Force Email\", an email will directly sent to you.<br><br>"
				+ "<strong>Webcam</strong><br><br>"
				+ "You have by default your laptop webcam configured. If you want to add one, you can just click on \"Add camera\".<br>"
				+ "You need to fill the form, by writing the name (What you want), the link to acces the preview video, and a desciption. "
				+ "Then, click on \"Connection\" to save the configuration.<br> When you leave the programm, all configurations are saved.<br><br>"
				+ "To get the camera preview in a single window, you can juste click on the small preview.<br>"
				+ "A bigger window will open. You have some tools, you can :<br>"
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
