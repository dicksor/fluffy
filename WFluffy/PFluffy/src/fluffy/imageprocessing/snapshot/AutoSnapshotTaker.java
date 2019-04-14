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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import fluffy.network.camera.ICamera;

public class AutoSnapshotTaker extends SnapshotTaker
	{

	public AutoSnapshotTaker(ICamera camera, String filename)
		{
		super(camera);
		this.filename = filename;
		}

	@Override
	public void run()
		{
		String filePath = createFolderFromDate() + "\\" + this.filename + ".jpg";
		System.out.println(filePath);
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

	private String createFolderFromDate()
		{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYY");

		File snapshotsDir = new File("snapshots\\" + format.format(new Date()));
		if(!snapshotsDir.exists())
			{
			snapshotsDir.mkdir();
			}
		return snapshotsDir.toString();
		}

	private String filename;
	}
