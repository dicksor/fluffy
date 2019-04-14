/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.imageprocessing.snapshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import fluffy.network.camera.ICamera;

public class DialogSnapshotTaker extends SnapshotTaker
	{

	public DialogSnapshotTaker(ICamera camera)
		{
		super(camera);
		this.lock = new ReentrantLock();
		}

	@Override
	public void run()
		{
		JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION)
			{
			String filePath = fileChooser.getSelectedFile().toString() + ".jpg";
			File file = new File(filePath);
			try
				{
				ImageIO.write(getBuffuredImage(), "jpg", file);
				}
			catch (IOException e)
				{
				e.printStackTrace();
				}
			}
		}

	private Lock lock;
	}
