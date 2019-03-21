package fluffy.userinterface.main;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fluffy.network.camera.Camera;
import fluffy.network.camera.ICamera;
import fluffy.userinterface.camera_gui.CameraGUI;
import fluffy.userinterface.cameradisplay.CameraDisplay;

public class JPanelCameraPreview extends JPanel {

	public JPanelCameraPreview(JFrame mainView, Camera camera) {
		// Pour streamer la vid�o surveillance remplacer "" par ->
		// http://192.168.1.200/axis-cgi/mjpg/video.cgi?resolution=480x360&clock=1&date=1
		this.camera = camera;
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
		
		this.lbCameraData = new JLabel("Entrer les informations de la cam�ra ici");
		this.lbCameraPreview = new JLabel();

		this.flowLayout = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(this.flowLayout);

		this.add(this.lbCameraData);
		this.add(this.lbCameraPreview);
	}

	public void streamCamera() {
		this.camera.open();
		
		// Normalement par la suite on pourra faire cameraDisplay = new CameraDisplayVideo(...), pour d�sactiver l'option d�tection
		CameraDisplay cameraDisplay = new CameraDisplay(this.lbCameraPreview, this.camera, true);
		
		Thread threadDisplayImage = new Thread(cameraDisplay);
		threadDisplayImage.start();
	}

	private FlowLayout flowLayout;
	private JLabel lbCameraData;
	private JLabel lbCameraPreview;
	private ICamera camera;

}
