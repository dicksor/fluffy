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
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Insipred by : https://www.journaldev.com/2532/javamail-example-send-mail-in-java-smtp
 * This class is used to send mail
 *
 */
public class Email
	{

	/**
	 *
	 * @param userEmail
	 * @param zipFilePath
	 */
	public Email(String userEmail, String zipFilePath)
		{
		this.userEmail = userEmail;
		this.zipFilePath = zipFilePath;

		Properties props = System.getProperties();
		props.put("mail.smtp.host", SMTP_SERVER);//set smtp server
		session = Session.getInstance(props, null);
		}

	/**
	 * Create the email header, message and add zip file
	 */
	public void sendEmail()
		{
		try
			{
			// set header
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			// set message header
			msg.setFrom(new InternetAddress("fluffy.corporation@fluffy.com", "Fluffy"));
			msg.setReplyTo(InternetAddress.parse("fluffy.corporation@fluffy.com", false));
			msg.setSubject(SUBJECT, "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail, false));

			// set message
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(MESSAGE);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// set attachment
			messageBodyPart = new MimeBodyPart();
			DataSource dataSource = new FileDataSource(zipFilePath);
			messageBodyPart.setDataHandler(new DataHandler(dataSource));
			messageBodyPart.setFileName(zipFilePath);
			multipart.addBodyPart(messageBodyPart);
			msg.setContent(multipart);

			// send mail
			Transport.send(msg);

			System.out.println("EMail Sent Successfully!!");
			}
		catch (Exception e)
			{
			e.printStackTrace();
			}
		}

	/**
	 * return date of the day at String format
	 * @return date of the day
	 */
	public static String getSnapShotFileName()
		{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return dateFormat.format(date);
		}

	private Session session;
	private String userEmail;
	private String zipFilePath;
	private static final String SUBJECT = "Daily Snapshot Review";
	private static final String MESSAGE = "Daily Snapshot Review";
	private static final String SMTP_SERVER = "smtprel.he-arc.ch";
	}
