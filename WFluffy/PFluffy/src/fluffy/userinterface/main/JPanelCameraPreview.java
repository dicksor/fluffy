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

import fluffy.imageprocessing.snapshot.AutoSnapshotTaker;
import fluffy.network.camera.Camera;
import fluffy.userinterface.camera_gui.CameraGUI;
import fluffy.userinterface.cameradisplay.CameraDisplay;

public class JPanelCameraPreview extends JPanel {

	public JPanelCameraPreview(Camera camera, String cameraName, String cameraDescription) {
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
		
		this.geometry();
		this.control();
		this.appearance();
		
		this.camera = camera;
		
		Thread cameraThread = new Thread(this.camera);
		cameraThread.start();
		
		this.streamCamera();
		
		this.autoSnapShotTaker = new AutoSnapshotTaker();
		this.camera.addPropertyChangeListener(this.autoSnapShotTaker);
	}
	
	public void streamCamera() {
		this.cameraDisplay = new CameraDisplay(this.lbCameraPreview, true);
		this.camera.addPropertyChangeListener(this.cameraDisplay);
	}

	private void appearance() {
		this.flowLayout.setHgap(50);
	}

	private void control() {
		this.lbCameraPreview.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JPanelCameraPreview.this.camera.removePropertyChangeListener(JPanelCameraPreview.this.cameraDisplay);
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
	private String cameraName;
	private String cameraDescription;
	private CameraDisplay cameraDisplay;
	private AutoSnapshotTaker autoSnapShotTaker;

}
