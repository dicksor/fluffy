package fluffy.userinterface.main;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fluffy.network.camera.Camera;
import fluffy.network.camera.ICamera;
import fluffy.userinterface.camera_gui.CameraGUI;
import fluffy.userinterface.cameradisplay.CameraDisplay;

public class JPannelCameraPreview extends JPanel {

	public JPannelCameraPreview() {
		// Pour streamer la vidéo surveillance remplacer "" par ->
		// http://192.168.1.200/axis-cgi/mjpg/video.cgi?resolution=480x360&clock=1&date=1
		this.camera = new Camera("");
		this.geometry();
		this.control();
		this.appearance();
	}

	private void appearance() {
		this.flowLayout.setHgap(50);
	}

	private void control() {
		this.lbCameraPreview.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new CameraGUI(camera);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}

	private void geometry() {
		// TODO Auto-generated method stub
		this.lbCameraData = new JLabel("Entrer les informations de la caméra ici");
		this.lbCameraPreview = new JLabel("Prévisualisation de la caméra");

		this.flowLayout = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(this.flowLayout);

		this.add(lbCameraData);
		this.add(this.lbCameraPreview);
	}

	public void streamCamera() {
		this.camera.open();
		
		// Normalement par la suite on pourra faire cameraDisplay = new CameraDisplayVideo(...), pour désactiver l'option détection
		CameraDisplay cameraDisplay = new CameraDisplay(this.lbCameraPreview, this.camera);
		
		Thread threadDisplayImage = new Thread(cameraDisplay);
		threadDisplayImage.start();
	}

	private FlowLayout flowLayout;
	private JLabel lbCameraData;
	private JLabel lbCameraPreview;
	private ICamera camera;

}
