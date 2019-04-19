/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.network.camera.model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UserXml
	{

	private UserXml()
		{
		//this.support = new PropertyChangeSupport(this);
		this.model = new UserModel();
		this.FILENAME = "user.xml";
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

	public UserModel getUserModel()
		{
		return model;
		}

	@Override
	protected void finalize() throws Throwable
		{
		this.xmlEncoder.close();
		}

	public static UserXml getInstance()
		{
		if (INSTANCE == null)
			{
			INSTANCE = new UserXml();
			}
		return INSTANCE;
		}

	public void add(UserModel model)
		{
		this.model = model;
		save();
		}

	private void save()
		{
		try
			{
			this.xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILENAME)));
			this.xmlEncoder.writeObject(this.model);
			this.xmlEncoder.flush();
			this.xmlEncoder.close();
			}
		catch (FileNotFoundException e)
			{
			e.printStackTrace();
			}
		}

	private void load()
		{
		try
			{
			FileInputStream file = new FileInputStream(FILENAME);
			if (file.available() > 0)
				{
				this.xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(FILENAME)));

				Object o = this.xmlDecoder.readObject();
				if (o instanceof UserModel)
					{
					this.model = (UserModel)o;
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

	private static UserXml INSTANCE = null;
	private UserModel model;
	private final String FILENAME;

	private XMLEncoder xmlEncoder;
	private XMLDecoder xmlDecoder;
	private File file;
	}
