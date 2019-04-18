package fluffy.network.camera.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CameraXml {

	private CameraXml() {
		this.support = new PropertyChangeSupport(this);
		this.listCamera = new ArrayList<CameraModel>();
		this.FILENAME = "config.xml";
		this.file = new File(this.FILENAME);
		try {
			this.file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.load();
		this.save();
	}

	public static CameraXml getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CameraXml();
		}
		return INSTANCE;
	}

	public void add(CameraModel cam) {
		this.xmlEncoder.remove(this.listCamera);
		this.listCamera.add(cam);
		this.save();
		this.support.firePropertyChange("newcamera", null, cam);
	}

	public List<CameraModel> getCameras() {
		return this.listCamera;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	@Override
	protected void finalize() throws Throwable {
		this.xmlEncoder.close();
	}

	private void save() {
		try {
			this.xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILENAME)));
			this.xmlEncoder.writeObject(this.listCamera);
			this.xmlEncoder.flush();
			this.xmlEncoder.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void load() {
		try {
			FileInputStream file = new FileInputStream(FILENAME);
			if (file.available() > 0) {
				this.xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(FILENAME)));

				Object o = this.xmlDecoder.readObject();
				if (o instanceof List<?>) {
					this.listCamera = (ArrayList<CameraModel>) o;
				} else {
					System.out.println("Wrong format.");
				}
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}

	// Attributes
	private static CameraXml INSTANCE = null;
	private List<CameraModel> listCamera;
	private final String FILENAME;

	// Tools
	private XMLEncoder xmlEncoder;
	private XMLDecoder xmlDecoder;
	private File file;
	private PropertyChangeSupport support;
}
