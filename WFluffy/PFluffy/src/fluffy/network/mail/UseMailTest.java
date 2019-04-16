/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.network.mail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fluffy.network.mail.zip.ZipCreator;

public class UseMailTest
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		//a supprimer pour tester l'envoie de mail
		String email = "romain.capocasale@he-arc.ch";
		int hour = 9;
		ZipCreator zipCreator = new ZipCreator(getSnapShotFileName());
		Email mail = new Email(email, getSnapShotFileName() + ".zip");
		mail.sendEmail();
		ZipCreator.deleteZip(getSnapShotFileName() + ".zip");
		}

	private static String getSnapShotFileName()
		{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return dateFormat.format(date);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
