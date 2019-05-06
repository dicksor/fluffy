/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

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
import java.util.HashMap;
import java.util.Map;

public class CameraXml
	{

	private CameraXml()
		{
		this.support = new PropertyChangeSupport(this);
		this.mapCamera = new HashMap<String, CameraModel>();
		this.FILENAME = "config.xml";
		this.file = new File(this.FILENAME);
		try
			{
			this.file.createNewFile();
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		this.load();
		this.save();
		}

	public static CameraXml getInstance()
		{
		if (INSTANCE == null)
			{
			INSTANCE = new CameraXml();
			}
		return INSTANCE;
		}
	
	public void remove(String camerName) {
		this.mapCamera.remove(camerName);
		this.save();
	}

	public void add(CameraModel cam)
		{
		this.mapCamera.put(cam.getName(), cam);
		this.save();
		this.support.firePropertyChange("newcamera", null, cam);
		}

	public void setCameraAngle(String cameraName, String angle)
		{
		if (mapCamera.containsKey(cameraName))
			{
			CameraModel tmp = mapCamera.get(cameraName);
			tmp.setAngle(angle);
			mapCamera.put(cameraName, tmp);
			}
		save();
		}

	public void setCameraZoom(String cameraName, String zoom)
		{
		if (mapCamera.containsKey(cameraName))
			{
			CameraModel tmp = mapCamera.get(cameraName);
			tmp.setZoom(zoom);
			mapCamera.put(cameraName, tmp);
			}
		save();
		}

	public Map<String, CameraModel> getCameras()
		{
		return this.mapCamera;
		}

	public void addPropertyChangeListener(PropertyChangeListener pcl)
		{
		support.addPropertyChangeListener(pcl);
		}

	public void removePropertyChangeListener(PropertyChangeListener pcl)
		{
		support.removePropertyChangeListener(pcl);
		}

	@Override
	protected void finalize() throws Throwable
		{
		this.xmlEncoder.close();
		}

	private void save()
		{
		try
			{
			this.xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILENAME)));
			this.xmlEncoder.writeObject(this.mapCamera);
			this.xmlEncoder.flush();
			this.xmlEncoder.close();
			}
		catch (FileNotFoundException e)
			{
			e.printStackTrace();
			}
		}

	@SuppressWarnings("unchecked")
	private void load()
		{
		try
			{
			FileInputStream file = new FileInputStream(FILENAME);
			if (file.available() > 0)
				{
				this.xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(FILENAME)));

				Object o = this.xmlDecoder.readObject();
				if (o instanceof HashMap<?, ?>)
					{
					this.mapCamera = (HashMap<String, CameraModel>)o;
					}
				else
					{
					System.out.println("Wrong format.");
					}
				}
			file.close();
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		catch (ClassCastException e)
			{
			e.printStackTrace();
			}
		}

	private static CameraXml INSTANCE = null;
	private Map<String, CameraModel> mapCamera;
	private final String FILENAME;
	private XMLEncoder xmlEncoder;
	private XMLDecoder xmlDecoder;
	private File file;
	private PropertyChangeSupport support;
	}
