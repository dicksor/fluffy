package fluffy.userinterface.connection;

import java.util.Set;

import fluffy.userinterface.main.JPannelCameraPreview;

/* Singleton Class for Webcams List */
public class CameraList {

	private CameraList() {
	}

	private static CameraList INSTANCE = null;

	public static CameraList getInstance() {
		if (INSTANCE == null)
			INSTANCE = new CameraList();
		return INSTANCE;
	}

	public void addCam(String cameraName, String link, String cameraDescription) {
		this.setJPannelCamPrev.add(new JPannelCameraPreview(link, cameraName, cameraDescription));
	}

	public Set<JPannelCameraPreview> getSetCam() {
		return this.setJPannelCamPrev;
	}

	// Attributes
	private Set<JPannelCameraPreview> setJPannelCamPrev;
}
