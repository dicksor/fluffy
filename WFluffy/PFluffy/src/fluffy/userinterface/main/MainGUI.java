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
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fluffy.network.camera.Camera;
import fluffy.network.camera.model.CameraModel;
import fluffy.network.camera.model.CameraXml;

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
		Camera camera = new Camera(cameraModel.getLink(), cameraModel.getLink());
		if (!camera.open()) {
			JOptionPane.showMessageDialog(null,
					"Could not find a camera with the provided link : " + cameraModel.getLink(), "ErrBox: fluffy",
					JOptionPane.ERROR_MESSAGE);
			CameraXml cameraXml = CameraXml.getInstance();
			cameraXml.remove(cameraModel.getName());
		} else {
			this.jPanelCameraList.addCameraPreview(
					new JPanelCameraPreview(camera, cameraModel.getName(), cameraModel.getDescription(),jPanelCameraList, this));
		}
	}

	private void appearance() {
		this.setTitle("Fluffy : Main");
		// this.setIconImage(MagasinImage.logo.getImage());
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
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

		Map<String, CameraModel> cameraList = cameraXml.getCameras();
		for (Map.Entry<String, CameraModel> pair : cameraList.entrySet()) {
			Camera camera = new Camera(pair.getValue().getLink(), pair.getValue().getName());
			if (!camera.open()) {
				JOptionPane.showMessageDialog(null,
						"Could not find a camera with the provided link : " + pair.getValue().getLink(),
						"ErrBox: fluffy", JOptionPane.ERROR_MESSAGE);
			} else {
				this.jPanelCameraList.addCameraPreview(
						new JPanelCameraPreview(camera, pair.getValue().getName(), pair.getValue().getDescription(), jPanelCameraList, this));
			}
		}
	}

	private JPanelButtons jPanelButtons;
	private JPanelLabel jPanelLabel;
	private JPanelCameraList jPanelCameraList;

}
