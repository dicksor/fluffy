package fluffy;

import org.opencv.core.Core;

import fluffy.userinterface.main.MainGUI;

public class UseFluffy {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.loadLibrary("opencv_ffmpeg401_64");
		new MainGUI();
	}

}
