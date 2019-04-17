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
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import fluffy.network.mail.zip.ZipCreator;

/**
* Inspired by : https://stackoverflow.com/questions/10748212/how-to-call-function-every-hour-also-how-can-i-loop-this
* This class is used to send the mail at a particular moment of the day
*/
public class EmailSender
	{

	public EmailSender()
		{
		Timer timer = new Timer();//timer object
		TimerTask hourTimerTask = new TimerTask()
			{

			@Override
			public void run()
				{
				//lecture de l'adresse mail et de l'heure dans le fichier xml
				String email = "romain.capocasale99@gmail.com";
				int hour = 9;
				//check if hour in xml file is current hour
				if (LocalDateTime.now().getHour() == hour)
					{
					String snapShotFileName = getSnapShotFileName();
					ZipCreator zipCreator = new ZipCreator(snapShotFileName);//zip the content of the snapshot folder of the day
					Email mail = new Email(email, snapShotFileName + ".zip");//create email object with zip file
					mail.sendEmail();
					ZipCreator.deleteZip(snapShotFileName + ".zip");//delete zip file
					}

				}
			};
		timer.schedule(hourTimerTask, 0l, 1000 * 60 * 60);//execute TimerTask function every hour
		}

	/**
	 * return date of the day at String format
	 * @return date of the day
	 */
	private String getSnapShotFileName()
		{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return dateFormat.format(date);
		}
	}
