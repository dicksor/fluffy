package fluffy.userinterface.main;

import java.awt.FlowLayout;
import javax.swing.JPanel;

public class JPanelCameraList extends JPanel {

	public JPanelCameraList() {	
		this.geometry();
		this.control();
		this.appearance();
	}
	
	public void addCameraPreview(JPanelCameraPreview panelCameraPreview) {
		this.add(panelCameraPreview);
		panelCameraPreview.streamCamera();
	}
	
	private void appearance() {
		// TODO Auto-generated method stub
		
	}

	private void control() {
		// TODO Auto-generated method stub
		
	}

	private void geometry() {
		this.flowLayout = new FlowLayout(FlowLayout.CENTER);
		
		this.setLayout(this.flowLayout);
	}

	private FlowLayout flowLayout;

}
