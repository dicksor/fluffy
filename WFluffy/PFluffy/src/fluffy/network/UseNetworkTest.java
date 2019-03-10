package fluffy.network;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import fluffy.userinterface.main.MainGUI;

public class UseNetworkTest {
	public static void main(String[] args) {
		System.out.println("Welcome to OpenCV " + Core.VERSION);
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		VideoCapture ip_cam = new VideoCapture();

		ip_cam.open("http://192.168.0.218:554");

		if (!ip_cam.isOpened()) {
			System.out.print("Error while trying to open the webcam");
			return;
		}

		System.out.println("Success!");

		ip_cam.release();
	}
}
