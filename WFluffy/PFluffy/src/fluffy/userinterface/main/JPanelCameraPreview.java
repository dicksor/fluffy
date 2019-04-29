/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fluffy.imageprocessing.snapshot.AutoSnapshotTaker;
import fluffy.network.camera.Camera;
import fluffy.userinterface.camera_gui.CameraGUI;
import fluffy.userinterface.cameradisplay.CameraDisplay;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

public class JPanelCameraPreview extends JPanel {

	public JPanelCameraPreview(Camera camera, String cameraName, String cameraDescription) {
		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;

		this.geometry();
		this.control();
		this.appearance();
<<<<<<< HEAD
		// Pour streamer la vidéo surveillance remplacer "" par ->
		// http://192.168.1.200/axis-cgi/mjpg/video.cgi?resolution=480x360&clock=1&date=1
		this.camera = new Camera(link, cameraName);
		this.camera.open();

=======
		
		this.camera = camera;
		
>>>>>>> 141bbd96de29a76f329f3691a72ce3fd75f43bce
		// Todo : fermer à un moment ou instancier ailleurs
		Thread cameraThread = new Thread(this.camera);
		cameraThread.start();

		this.streamCamera();

		this.autoSnapShotTaker = new AutoSnapshotTaker();
		this.camera.addPropertyChangeListener(this.autoSnapShotTaker);
<<<<<<< HEAD

		this.cameraName = cameraName;
		this.cameraDescription = cameraDescription;
=======
>>>>>>> 141bbd96de29a76f329f3691a72ce3fd75f43bce
	}

	public void streamCamera() {
		this.cameraDisplay = new CameraDisplay(this.lbCameraPreview, true);
		this.camera.addPropertyChangeListener(this.cameraDisplay);
	}

	private void appearance() {
		this.flowLayout.setHgap(50);

		this.btnDelete.setBackground(MaterialColors.RED_400);
		this.btnDelete.setForeground(Color.WHITE);
		this.btnDelete.setPreferredSize(new Dimension(180, 50));
		MaterialUIMovement.add(this.btnDelete, MaterialColors.GRAY_200);
	}

	private void control() {
		this.lbCameraPreview.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JPanelCameraPreview.this.camera.removePropertyChangeListener(JPanelCameraPreview.this.cameraDisplay);
				new CameraGUI(camera, JPanelCameraPreview.this, cameraName, cameraDescription);
			}

		});

		this.btnDelete.addActionListener(new ActionListener()
			{
			@Override
			public void actionPerformed(ActionEvent e)
				{
			//
				}
			});
	}

	private void geometry() {
		this.lbCameraData = new JLabel("<html><strong>Camera name : </strong>" + this.cameraName + "<br/><strong>Description : </strong>" + this.cameraDescription + "</html>");
		this.lbCameraPreview = new JLabel();

		this.btnDelete = new JButton("Delete Camera");

		this.flowLayout = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(this.flowLayout);

		this.add(this.lbCameraData);
		this.add(this.lbCameraPreview);
		this.add(this.btnDelete);
	}

	private FlowLayout flowLayout;
	private JLabel lbCameraData;
	private JLabel lbCameraPreview;
	private Camera camera;
	private String cameraName;
	private String cameraDescription;

	private JButton btnDelete;

	private CameraDisplay cameraDisplay;

	// FIXME : Mettre ailleurs
	private AutoSnapshotTaker autoSnapShotTaker;

}
