package fluffy.userinterface.connection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class CameraList {

	private CameraList() {
	}

	public static void addCam(String cameraName, String link, String cameraDescription) {

		try {
			output = new FileOutputStream("config.xml");

			prop.setProperty("cameraName", cameraName);
			prop.setProperty("link", link);
			prop.setProperty("cameraDescription", cameraDescription);

			prop.storeToXML(output, null);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static Properties prop = new Properties();
	private static OutputStream output = null;
}
