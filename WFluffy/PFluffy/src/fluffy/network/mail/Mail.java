
package fluffy.network.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail
	{

	public static void main(String[] args)
		{
		String to = "vincent.moulin@he-arc.ch";//change accordingly
		String from = "romain.capocasale@he-arc.ch";//change accordingly
		String host = "";//or IP address

		//Get the session object
		Properties properties = System.getProperties();
		properties.setProperty("smtprel.he-arc.ch", host);
		Session session = Session.getDefaultInstance(properties);

		//compose the message
		try
			{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Ping");
			message.setText("Hello, this is example of sending email  ");

			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");

			}
		catch (MessagingException mex)
			{
			mex.printStackTrace();
			}
		}
	}
