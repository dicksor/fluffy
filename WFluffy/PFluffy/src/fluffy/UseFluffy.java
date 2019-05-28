/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fluffy.network.mail.EmailSender;
import fluffy.userinterface.main.MainGUI;
import mdlaf.MaterialLookAndFeel;


public class UseFluffy
	{

	public static void main(String[] args)
		{
		if (lockInstance("fluffy.lock"))
			{
			String libname = args[0];
			System.load(libname);
			//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			//System.loadLibrary("opencv_ffmpeg401_64");
			try
				{
				UIManager.setLookAndFeel(new MaterialLookAndFeel());
				}
			catch (UnsupportedLookAndFeelException e)
				{
				e.printStackTrace();
				}

			EmailSender emailSender = new EmailSender();
			new MainGUI();

			}
		else
			{
			System.err.println("Only one instance of Fluffy can run!");
			System.exit(-1);
			}
		}

	/**
	 * Indique si le programme est déjà ouvert ou non
	 * Méthode prise de https://stackoverflow.com/questions/177189/how-to-implement-a-single-instance-java-application
	 * @param lockFile chemin du fichier de lock
	 * @return indique si le programme est deja ouvert
	 */
	private static boolean lockInstance(final String lockFile)
		{
		try
			{
			final File file = new File(lockFile);
			final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
			final FileLock fileLock = randomAccessFile.getChannel().tryLock();
			if (fileLock != null)
				{
				Runtime.getRuntime().addShutdownHook(new Thread()
					{

					@Override
					public void run()
						{
						try
							{
							fileLock.release();
							randomAccessFile.close();
							file.delete();
							}
						catch (Exception e)
							{
							System.err.println("Unable to remove lock file: " + lockFile);
							}
						}
					});
				return true;
				}
			}
		catch (Exception e)
			{
			System.err.println("Unable to remove lock file: " + lockFile);
			}
		return false;
		}
}
