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

import fluffy.network.camera.Camera;
import fluffy.network.camera.pipeline.CameraPipeline;
import fluffy.userinterface.camera_gui.CameraGUI;
import fluffy.userinterface.cameradisplay.CameraDisplay;

public class JPanelCameraPreview extends JPanel {

	public JPanelCameraPreview(String link, String cameraName, String cameraDescription) {
		this.geometry();
		this.control();
		this.appearance();
		
		// Pour streamer la vidéo surveillance remplacer "" par ->
		// http://192.168.1.200/axis-cgi/mjpg/video.cgi?resolution=480x360&clock=1&date=1
		this.camera = new Camera(link);
		this.camera.open();
		
		// Todo : fermer à un moment ou instancier ailleurs
		Thread cameraThread = new Thread(this.camera);
		cameraThread.start();
		
		this.cameraPipeline = new CameraPipeline();
		this.camera.addPropertyChangeListener(this.cameraPipeline);
		
		this.cameraDisplay = new CameraDisplay(this.lbCameraPreview, true);
		this.cameraPipeline.addPropertyChangeListener(this.cameraDisplay);
		
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
	}

	private void appearance() {
		this.flowLayout.setHgap(50);
	}

	private void control() {
		this.lbCameraPreview.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new CameraGUI(camera, JPanelCameraPreview.this, cameraName, cameraDescription);
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

	private FlowLayout flowLayout;
	private JLabel lbCameraData;
	private JLabel lbCameraPreview;
	private Camera camera;
	private CameraPipeline cameraPipeline;

	private String cameraName;
	private String cameraDescription;

	private CameraDisplay cameraDisplay;

}
