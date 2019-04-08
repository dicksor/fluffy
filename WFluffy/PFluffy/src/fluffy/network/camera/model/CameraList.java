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

		try {
			this.xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILENAME)));
			// this.xmlDecoder = new XMLDecoder(new BufferedInputStream(new
			// FileInputStream(FILENAME)));
			// load();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
		System.out.println(cam);
		save();
	}

	private void save() {
<<<<<<< HEAD
		try {
			this.xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILENAME)));
			this.xmlEncoder.writeObject(this.listCamera);
			this.xmlEncoder.flush();
			this.xmlEncoder.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
=======
		System.out.println(this.listCamera);
		this.xmlEncoder.writeObject(this.listCamera);
>>>>>>> parent of d29861c... fixed xmldecoder error
	}

	private void load() {
		try {
			this.listCamera = (List<CameraModel>) this.xmlDecoder.readObject();
		} catch (ClassCastException e) {
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
