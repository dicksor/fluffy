package fluffy.userinterface.main;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPannelCameraPreview extends JPanel {

	public JPannelCameraPreview() {
		geometry();
		control();
		appearance();
	}

	private void appearance() {
		// TODO Auto-generated method stub
		
	}

	private void control() {
		// TODO Auto-generated method stub
		
	}

	private void geometry() {
		// TODO Auto-generated method stub
		this.lbCameraData = new JLabel("Entrer les informations de la caméra ici");
		this.lbCameraPreview = new JLabel("Prévisualisation de la caméra");
		
		this.flowLayout = new FlowLayout(FlowLayout.CENTER);
		this.flowLayout.setHgap(50);
		this.setLayout(this.flowLayout);
		
		this.add(lbCameraData);
		this.add(this.lbCameraPreview);
	}

	private FlowLayout flowLayout;
	private JLabel lbCameraData;
	// TODO : change to media player
	private JLabel lbCameraPreview;

}
