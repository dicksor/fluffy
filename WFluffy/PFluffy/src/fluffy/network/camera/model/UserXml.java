
package fluffy.network.camera.model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class UserXml
	{

	private UserXml()
		{
		this.FILENAME = "user.xml";
		this.load();
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

	private void save() {
	try {
		this.xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILENAME)));
		this.xmlEncoder.writeObject(this.model);
		this.xmlEncoder.flush();
		this.xmlEncoder.close();
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	}
}

private void load() {
	try {
		this.xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(FILENAME)));
		// FIXME Cast exception
		this.model = (UserModel) this.xmlDecoder.readObject();
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch (ClassCastException e) {
		e.printStackTrace();
	}
}

	private static UserXml INSTANCE = null;
	private UserModel model;
	private final String FILENAME;

	private XMLEncoder xmlEncoder;
	private XMLDecoder xmlDecoder;
	}
