/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.network.mail.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Insipired by : https://stackoverflow.com/questions/15269507/how-to-validate-a-jtextfield-of-email-id-with-a-regex-in-swing-code
 * This class is used to check if the mail is in the correct format
 */
public class EmailValidator
	{

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public EmailValidator()
		{
		pattern = Pattern.compile(EMAIL_PATTERN);//set the pattern of regular expression
		}

	/**
	 * Validate email with regular expression
	 *
	 * @param hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validate(final String hex)
		{

		matcher = pattern.matcher(hex);
		return matcher.matches();

		}
	}
