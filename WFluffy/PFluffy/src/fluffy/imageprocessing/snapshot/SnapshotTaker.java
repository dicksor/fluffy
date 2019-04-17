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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.camera.exception.EmptyImageException;
import fluffy.network.camera.pipeline.CameraPipeline;

public abstract class SnapshotTaker implements Runnable {

	public SnapshotTaker(CameraPipeline cameraPipeline) {
		this.cameraPipeline = cameraPipeline;
	}

	protected BufferedImage getBuffuredImage() throws EmptyImageException {
		BufferedImage snapShot = OpenCvUtil.matToBufferedImage(this.cameraPipeline.getImage());
		return snapShot;
	}

	@Override
	public void run() {
		BufferedImage snapShot;
		Mat image = this.cameraPipeline.getImage();
		snapShot = OpenCvUtil.matToBufferedImage(image);
		JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String filePath = fileChooser.getSelectedFile().toString() + ".jpg";
			File file = new File(filePath);
			try {
				ImageIO.write(snapShot, "jpg", file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private CameraPipeline cameraPipeline;
}
