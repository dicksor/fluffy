package fluffy.network.camera.model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CameraList {

	private CameraList() {
		this.listCamera = new ArrayList<CameraModel>();
		this.FILENAME = "config.xml";
		this.load();
	}

	@Override
	protected void finalize() throws Throwable {
		this.xmlEncoder.close();
	}

	public static CameraList getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CameraList();
		}
		return INSTANCE;
	}

	public void add(CameraModel cam) {
		this.listCamera.add(cam);
		save();
	}

	private void save() {
		try {
			this.xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILENAME)));
			this.xmlEncoder.writeObject(this.listCamera);
			this.xmlEncoder.flush();
			this.xmlEncoder.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void load() {
		try {
			this.xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(FILENAME)));
			this.listCamera = (ArrayList<CameraModel>) this.xmlDecoder.readObject();
		} 
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (ClassCastException e) {
			e.printStackTrace();
		}
	}

	// Attributes
	private static CameraList INSTANCE = null;
	private List<CameraModel> listCamera;
	private final String FILENAME;

	// Tools
	private XMLEncoder xmlEncoder;
	private XMLDecoder xmlDecoder;
}
