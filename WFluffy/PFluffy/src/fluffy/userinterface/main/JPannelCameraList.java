package fluffy.userinterface.main;

import java.awt.FlowLayout;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JPanel;

public class JPannelCameraList extends JPanel {

	public JPannelCameraList() {
		this.setJPannelCamPrev = new TreeSet<JPannelCameraPreview>();
		
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
		this.flowLayout = new FlowLayout(FlowLayout.CENTER);
		this.setJPannelCamPrev.add(new JPannelCameraPreview());
		
		this.setLayout(this.flowLayout);
		
		for(JPannelCameraPreview jPannelCameraPreview : this.setJPannelCamPrev) {
			this.add(jPannelCameraPreview);
		}

	}

	private Set<JPannelCameraPreview> setJPannelCamPrev;
	private FlowLayout flowLayout;

}
