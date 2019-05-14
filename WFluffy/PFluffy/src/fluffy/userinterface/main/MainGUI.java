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
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ProgressMonitor;

import fluffy.network.camera.Camera;
import fluffy.network.camera.model.CameraModel;
import fluffy.network.camera.model.CameraXml;
import fluffy.tools.image.MagasinImage;

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
		CameraModel cameraModel = (CameraModel) evt.getNewValue();
		try {
			this.openCamera(cameraModel.getLink(), cameraModel.getName(), cameraModel.getDescription());
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			displayError(cameraModel.getLink());
		}
	}

	private void appearance() {
		this.setTitle("Fluffy : Main");
		this.setIconImage(MagasinImage.logo.getImage());
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	private void control() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void geometry() {
		this.panelButtons = new JPanelButtons();
		this.panelLabel = new JPanelLabel();
		this.panelLabel.repaint();
		this.panelCameraList = new JPanelCameraList();

		this.loadCameras();

		this.setLayout(new BorderLayout());

		this.add(this.panelLabel, BorderLayout.NORTH);
		this.add(this.panelCameraList, BorderLayout.CENTER);
		this.add(this.panelButtons, BorderLayout.SOUTH);
	}

	private void loadCameras() {
		CameraXml cameraXml = CameraXml.getInstance();
		cameraXml.addPropertyChangeListener(this);

		Map<String, CameraModel> cameraList = cameraXml.getCameras();
		for (Map.Entry<String, CameraModel> pair : cameraList.entrySet()) {
			CameraModel cameraModel = pair.getValue();
			try {
				this.openCamera(cameraModel.getLink(), cameraModel.getName(), cameraModel.getDescription());
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				displayError(cameraModel.getLink());
			}
		}
	}

	private void displayError(String cameraLink) {
		JOptionPane.showMessageDialog(this,
				"Could not find a camera with the provided link : " + cameraLink, "ErrBox: fluffy",
				JOptionPane.ERROR_MESSAGE);
	}

	private void openCamera(String cameraLink, String cameraName, String cameraDescription)
			throws InterruptedException, ExecutionException, TimeoutException {
		String message = "Trying to open camera : " + cameraName;
		String note = "Trying for maximum : " + Integer.toString(this.CAMERA_OPENING_DELAY) + " seconds";
		ProgressMonitor pm = new ProgressMonitor(this, message, note, 0, this.CAMERA_OPENING_DELAY);

		Camera camera = new Camera(cameraLink, cameraName);

		ExecutorService executor = Executors.newFixedThreadPool(1);
		ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
		
		Future<Boolean> isFutureCameraOpen = executor.submit(() -> {
			AtomicInteger prog = new AtomicInteger(0);
			scheduledExecutorService.scheduleAtFixedRate(() -> {
				pm.setProgress(prog.incrementAndGet());
			}, 0, 1, TimeUnit.SECONDS);
			return camera.open();
		});

		if (isFutureCameraOpen.get(this.CAMERA_OPENING_DELAY, TimeUnit.SECONDS)) {
			this.panelCameraList.addCameraPreview(
					new JPanelCameraPreview(camera, cameraName, cameraDescription, this.panelCameraList, this));
		}
		else {
			displayError(cameraLink);
		}

		pm.close();
		scheduledExecutorService.shutdown();
		executor.shutdown();
	}

	private JPanelButtons panelButtons;
	private JPanelLabel panelLabel;
	private JPanelCameraList panelCameraList;
	private final int CAMERA_OPENING_DELAY = 15;

}
