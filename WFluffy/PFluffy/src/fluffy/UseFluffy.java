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

import org.opencv.core.Core;

import fluffy.network.mail.EmailSender;
import fluffy.userinterface.main.MainGUI;
import mdlaf.MaterialLookAndFeel;

public class UseFluffy {

	public static void main(String[] args) {
		if (lockInstance("fluffy.lock")) {
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			System.loadLibrary("opencv_ffmpeg401_64");
			try {
				UIManager.setLookAndFeel(new MaterialLookAndFeel());
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			// FIXME : remove when production mode
			/*CameraXml cameraList = CameraXml.getInstance();
			CameraModel cam = new CameraModel("webcam", "", "Webcam du staff...", "90", "1");
			cameraList.add(cam);*/

			EmailSender emailSender = new EmailSender();
			new MainGUI();
		
		} else {
			System.err.println("Only one instance of Fluffy can run!");
			System.exit(-1);
		}
	}

	private static boolean lockInstance(final String lockFile) {
		try {
			final File file = new File(lockFile);
			final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
			final FileLock fileLock = randomAccessFile.getChannel().tryLock();
			if (fileLock != null) {
				Runtime.getRuntime().addShutdownHook(new Thread() {

					@Override
					public void run() {
						try {
							fileLock.release();
							randomAccessFile.close();
							file.delete();
						} catch (Exception e) {
							System.err.println("Unable to remove lock file: " + lockFile);
						}
					}
				});
				return true;
			}
		} catch (Exception e) {
			System.err.println("Unable to remove lock file: " + lockFile);
		}
		return false;
	}
}
