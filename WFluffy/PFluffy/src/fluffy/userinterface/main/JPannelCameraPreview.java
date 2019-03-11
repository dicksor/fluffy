package fluffy.userinterface.main;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;

import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.Camera;
import fluffy.userinterface.camera_gui.CameraGUI;

public class JPannelCameraPreview extends JPanel {

	public JPannelCameraPreview() {

		geometry();
		showLive();
		control();
		appearance();
	}

	private void showLive() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.loadLibrary("opencv_ffmpeg401_64");

		Camera camera = new Camera("http://192.168.1.200/axis-cgi/mjpg/video.cgi?resolution=480x360&clock=1&date=1");

		/*
		 * Thread displayLive = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { ImageIcon image = new
		 * ImageIcon(OpenCvUtil.matToBufferedImage(camera.getImage()));
		 * lbCameraPreview.setIcon(image); lbCameraPreview.repaint(); } });
		 */

		if (camera.open()) {
			while (true) {

				if (!camera.getImage().empty()) {
					break;
				} else {
					break;
				}
			}
		}
	}

	private void appearance() {
		this.flowLayout.setHgap(50);
	}

	private void control() {
		this.lbCameraPreview.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new CameraGUI();
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

	private FlowLayout flowLayout;
	private JLabel lbCameraData;
	// TODO : change to media player
	private JLabel lbCameraPreview;

}
