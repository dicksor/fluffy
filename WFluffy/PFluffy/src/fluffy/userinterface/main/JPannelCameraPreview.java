package fluffy.userinterface.main;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fluffy.userinterface.camera_gui.CameraGUI;

public class JPannelCameraPreview extends JPanel {

	public JPannelCameraPreview() {
		geometry();
		control();
		appearance();
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
