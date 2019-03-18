package fluffy.userinterface.main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fluffy.network.camera.Camera;
import fluffy.network.camera.ICamera;
import fluffy.userinterface.camera_gui.CameraGUI;
import fluffy.userinterface.cameradisplay.CameraDisplay;

public class JPannelCameraPreview extends JPanel {

	public JPannelCameraPreview(String link, String cameraName, String cameraDescription) {
		// Pour streamer la vidéo surveillance remplacer "" par ->
		// http://192.168.1.200/axis-cgi/mjpg/video.cgi?resolution=480x360&clock=1&date=1
		this.camera = new Camera(link);
		this.link = link;
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
				new CameraGUI(camera);
			}

		});
	}

	private void geometry() {
		this.lbCameraData = new JLabel(this.cameraName);
		this.lbCameraPreview = new JLabel("Prévisualisation de la caméra");

		this.flowLayout = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(this.flowLayout);

		this.add(this.lbCameraData);
		this.add(this.lbCameraPreview);
	}

	public void streamCamera() {
		this.camera.open();

		// Normalement par la suite on pourra faire cameraDisplay = new
		// CameraDisplayVideo(...), pour désactiver l'option détection
		CameraDisplay cameraDisplay = new CameraDisplay(this.lbCameraPreview, this.camera, true);
		Thread threadDisplayImage = new Thread(cameraDisplay);
		threadDisplayImage.start();
	}

	private FlowLayout flowLayout;
	private JLabel lbCameraData;
	private JLabel lbCameraPreview;
	private ICamera camera;

	private JFrame mainView;

	private String link;
	private String cameraName;
	private String cameraDescription;
}
