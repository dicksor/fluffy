/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy;

import org.opencv.core.Core;

import fluffy.userinterface.main.MainGUI;

public class UseFluffy
	{

	public static void main(String[] args)
		{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.loadLibrary("opencv_ffmpeg401_64");
		new MainGUI();
		}
	}
