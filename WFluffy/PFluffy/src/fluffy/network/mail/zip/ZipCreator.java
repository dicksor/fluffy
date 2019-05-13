/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.network.mail.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Insipred by : //http://www.java67.com/2016/12/how-to-create-zip-file-in-java-zipentry-example.html
 * This class is used for create zip file with the program snapshot
 *
 */

public class ZipCreator
	{

	public ZipCreator(String snapshotPath)
		{
		this.snapshotPath = snapshotPath;
		}

	/**
	 * create the zip archive
	 */
	public void create()
		{
		snapshotNames = getAllfilename();
		System.out.println(Arrays.toString(snapshotNames));
		try
			{
			FileOutputStream fos = new FileOutputStream(snapshotPath + ".zip");
			ZipOutputStream zipOS = new ZipOutputStream(fos);

			//add all file to the zip archive
			for(String fileName:snapshotNames)
				{
				writeToZipFile(SNAPSHOT_FOLDER + snapshotPath + "\\" + fileName, zipOS);
				}

			zipOS.close();
			fos.close();
			}
		catch (FileNotFoundException e)
			{
			e.printStackTrace();
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		}

	/**
	 * create zip archive with file in the snapshot folder
	 * @param path of the snapshot file
	 * @param zipStream
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void writeToZipFile(String path, ZipOutputStream zipStream) throws FileNotFoundException, IOException
		{

		System.out.println("Writing file : '" + path + "' to zip file");

		File aFile = new File(path);
		FileInputStream fis = new FileInputStream(aFile);
		ZipEntry zipEntry = new ZipEntry(path);
		zipStream.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while((length = fis.read(bytes)) >= 0)
			{
			zipStream.write(bytes, 0, length);
			}

		zipStream.closeEntry();
		fis.close();
		}

	/**
	 *
	 * @return return all filename in the snapshot folder
	 */
	private String[] getAllfilename()
		{
		File folder = new File(SNAPSHOT_FOLDER + snapshotPath);
		File[] listOfFiles = folder.listFiles();
		String[] fileName = new String[listOfFiles.length];

		for(int i = 0; i < listOfFiles.length; i++)
			{
			if (listOfFiles[i].isFile())
				{
				fileName[i] = listOfFiles[i].getName();
				}
			}
		return fileName;
		}

	/**
	 * delete zip file
	 * @param zipFile
	 */
	public static void deleteZip(String zipFile)
		{
		File file = new File(zipFile);
		if (!file.delete())
			{
			System.err.println("Error was occured!");
			}
		}

	/**
	 * path of the daily snapshot
	 */
	private String snapshotPath;
	private String[] snapshotNames;
	private static final String SNAPSHOT_FOLDER = "snapshots\\";
	}
