/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.imageprocessing.snapshot;

import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import fluffy.imageprocessing.OpenCvFaceDetection;
import fluffy.imageprocessing.OpenCvUtil;

public class AutoSnapshotTaker extends SnapshotTaker{

	public AutoSnapshotTaker() {
		this.faceDetection = new OpenCvFaceDetection();
		try {
			this.format = new SimpleDateFormat("HH.mm.ss");
			this.dateCapture = this.format.parse(this.format.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String name = evt.getPropertyName();
		this.setImage((Mat) evt.getNewValue());
		this.detecte();
	}
	
	@Override
	public void getSnapShot() {
		String filePath = createFolderFromDate() + "\\" + this.filename + ".jpg";
		System.out.println(filePath);
		File file = new File(filePath);
		try {
			ImageIO.write(OpenCvUtil.matToBufferedImage(this.getImage()), "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void detecte() {
		MatOfRect faceDetections = this.faceDetection.detecte(this.getImage());

		// test if array > 1, because we would take only on snapshot
		if (faceDetections.toArray().length >= 1) {
			takeSnapshot();
		}
	}
	
	private void takeSnapshot() {
		try {
			dateActuelle = format.parse(format.format(new Date()));
			long difference = dateActuelle.getTime() - dateCapture.getTime();

			if (difference >= DELAY_BETWEEN_CAPTURE) {
				String strDateCapture = format.format(new Date());
				this.filename = strDateCapture;
				dateCapture = format.parse(strDateCapture);
				this.getSnapShot();
			}
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("Error with the snapshot");
		}
	}

	private String createFolderFromDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYY");

		File snapshotsDir = new File("snapshots\\" + format.format(new Date()));
		if (!snapshotsDir.exists())
			snapshotsDir.mkdirs();
		return snapshotsDir.toString();
	}

	private String filename;
	private static final long DELAY_BETWEEN_CAPTURE = 10000;// temps en milliseconde
	private SimpleDateFormat format;
	private Date dateCapture;
	private Date dateActuelle;
	private OpenCvFaceDetection faceDetection;
}
