
package fluffy.network.mail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import fluffy.network.mail.zip.ZipCreator;

public class EmailSender
	{

	public EmailSender()
		{
		Timer timer = new Timer();
		TimerTask hourTimerTask = new TimerTask()
			{

			@Override
			public void run()
				{
				//lecture de l'adresse mail et de l'heure dans le fichier xml
				String email = "romain.capocasale99@gmail.com";
				int hour = 9;
				if (LocalDateTime.now().getHour() == hour)
					{
					ZipCreator zipCreator = new ZipCreator(getSnapShotFileName());
					Mail mail = new Mail(email, getSnapShotFileName() + ".zip");
					mail.sendEmail();
					}

				}
			};
		timer.schedule(hourTimerTask, 0l, 1000 * 60*60);
		}

	private String getSnapShotFileName()
		{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return dateFormat.format(date);
		}
	}
