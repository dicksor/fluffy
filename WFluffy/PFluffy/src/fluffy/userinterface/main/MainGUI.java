/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;

import javax.swing.JFrame;

import fluffy.network.camera.model.CameraXml;
import fluffy.network.camera.model.CameraModel;

/**
 * Main JFrame of the program
 *
 */
public class MainGUI extends JFrame implements PropertyChangeListener {

	public MainGUI() {
		this.geometry();
		this.control();
		this.appearance();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO : check camera open correctly
		CameraModel cameraModel = (CameraModel) evt.getNewValue();
		this.jPanelCameraList.addCameraPreview(new JPanelCameraPreview(cameraModel.getLink(), cameraModel.getName(),
				cameraModel.getDescription()));
	}

	private void appearance() {
		this.setTitle("Fluffy : Main");
		// this.setIconImage(MagasinImage.logo.getImage());
		this.setMinimumSize(new Dimension(700, 400));
		this.setVisible(true);
	}

	private void control() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void geometry() {
		this.jPanelButtons = new JPanelButtons();
		this.jPanelLabel = new JPanelLabel();
		this.jPanelLabel.repaint();
		this.jPanelCameraList = new JPanelCameraList();

		this.loadCameras();

		this.setLayout(new BorderLayout());

		this.add(this.jPanelLabel, BorderLayout.NORTH);
		this.add(this.jPanelCameraList, BorderLayout.CENTER);
		this.add(this.jPanelButtons, BorderLayout.SOUTH);
	}

	private void loadCameras() {
		CameraXml cameraXml = CameraXml.getInstance();
		cameraXml.addPropertyChangeListener(this);
		
		// TODO : check camera open correctly
		Set<CameraModel> cameraList = cameraXml.getCameras();
		for (CameraModel cameraModel : cameraList)
			this.jPanelCameraList.addCameraPreview(new JPanelCameraPreview(cameraModel.getLink(), cameraModel.getName(),
					cameraModel.getDescription()));
	}

	private JPanelButtons jPanelButtons;
	private JPanelLabel jPanelLabel;
	private JPanelCameraList jPanelCameraList;

}
