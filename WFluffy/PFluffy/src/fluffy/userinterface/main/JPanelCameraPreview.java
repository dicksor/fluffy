/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.main;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fluffy.network.camera.decorator.Camera;
import fluffy.network.camera.decorator.ICamera;
import fluffy.userinterface.camera_gui.CameraGUI;
import fluffy.userinterface.cameradisplay.CameraDisplay;

public class JPanelCameraPreview extends JPanel {

	public JPanelCameraPreview(String link, String cameraName, String cameraDescription) {
		// Pour streamer la vidéo surveillance remplacer "" par ->
		// http://192.168.1.200/axis-cgi/mjpg/video.cgi?resolution=480x360&clock=1&date=1
		this.camera = new Camera(link);
		this.camera.open();
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
		this.geometry();
		this.control();
		this.appearance();
	}

	private void appearance() {
		this.flowLayout.setHgap(50);
	}

	private void control() {
		this.lbCameraPreview.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JPanelCameraPreview.this.stopStream();
				// FIXME : Find dynamic delay
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				new CameraGUI(JPanelCameraPreview.this, camera);
			}

		});
	}

	private void geometry() {
		this.lbCameraData = new JLabel("<html><strong>Camera name : </strong>" + this.cameraName + "<br/><strong>Description : </strong>" + this.cameraDescription + "</html>");
		this.lbCameraPreview = new JLabel();

		this.flowLayout = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(this.flowLayout);

		this.add(this.lbCameraData);
		this.add(this.lbCameraPreview);
	}

	public void streamCamera() {
		this.cameraDisplay = new CameraDisplay(this.lbCameraPreview, this.camera, true);

		Thread threadDisplayImage = new Thread(cameraDisplay);
		threadDisplayImage.start();
	}
	
	private void stopStream() {
		this.cameraDisplay.setIsRunning(false);
	}

	private FlowLayout flowLayout;
	private JLabel lbCameraData;
	private JLabel lbCameraPreview;
	private ICamera camera;

	private String cameraName;
	private String cameraDescription;
	
	private CameraDisplay cameraDisplay;

}
