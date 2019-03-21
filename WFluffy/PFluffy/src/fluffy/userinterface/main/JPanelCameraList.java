package fluffy.userinterface.main;

import java.awt.FlowLayout;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JPanel;

public class JPanelCameraList extends JPanel {

	public JPanelCameraList() {
		this.setJPanelCamPrev = new LinkedList<JPanelCameraPreview>();
		
		this.geometry();
		this.control();
		this.appearance();
	}
	
	public void addCameraPreview(JPanelCameraPreview panelCameraPreview) {
		this.setJPanelCamPrev.add(panelCameraPreview);
		this.add(panelCameraPreview);
	}
	
	public void streamCameras() {
		for(JPanelCameraPreview jPannelCameraPreview : this.setJPanelCamPrev) {
			jPannelCameraPreview.streamCamera();
		}
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
		
		this.streamCameras();
	}

	private List<JPanelCameraPreview> setJPanelCamPrev;
	private FlowLayout flowLayout;

}
