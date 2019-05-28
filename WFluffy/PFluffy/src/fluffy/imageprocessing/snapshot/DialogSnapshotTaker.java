/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.imageprocessing.snapshot;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvUtil;

public class DialogSnapshotTaker extends SnapshotTaker
	{

	/**
	 * Get the new image
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt)
		{
		this.setImage((Mat)evt.getNewValue());
		}

	/**
	 * Open a dialog to save the capture
	 */
	public void getSnapShot()
		{
		BufferedImage snapShot;
		snapShot = OpenCvUtil.matToBufferedImage(this.getImage());
		JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION)
			{
			String filePath = fileChooser.getSelectedFile().toString() + ".jpg";
			File file = new File(filePath);
			try
				{
				ImageIO.write(snapShot, "jpg", file);
				}
			catch (IOException e)
				{
				e.printStackTrace();
				}
			}
		}

	}
