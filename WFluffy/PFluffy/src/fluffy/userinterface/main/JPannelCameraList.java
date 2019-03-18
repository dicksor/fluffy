package fluffy.userinterface.main;

import java.awt.FlowLayout;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JPanel;

import fluffy.userinterface.connection.CameraList;

public class JPannelCameraList extends JPanel {

	public JPannelCameraList() {
		this.geometry();
		this.control();
		this.appearance();
	}

	private void appearance() {
		// TODO Auto-generated method stub

	}

	private void control() {
		// TODO Auto-generated method stub

	}

	private void geometry() {
		this.flowLayout = new FlowLayout(FlowLayout.CENTER);

		//this.setJPannelCamPrev.add(new JPannelCameraPreview("", "test", "test"));

		this.setLayout(this.flowLayout);

		CameraList cameraList = CameraList.getInstance();
		Set<JPannelCameraPreview> setFor = cameraList.getSetCam();
		for (JPannelCameraPreview jPannelCameraPreview : setFor) {
			this.add(jPannelCameraPreview);
		}

	}

	private FlowLayout flowLayout;

}
