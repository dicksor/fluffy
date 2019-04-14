package fluffy.imageprocessing.snapshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.camera.decorator.ICamera;
import fluffy.network.camera.exception.EmptyImageException;

public class SnapshotTaker implements Runnable {

	public SnapshotTaker(ICamera camera) {
		this.camera = camera;
	}
	
	@Override
	public void run() {
		BufferedImage snapShot;
		// FIXME : BUG avec caméra ip
		try {
			Mat image = this.camera.getImage();
			System.out.println(image.size());
			snapShot = OpenCvUtil.matToBufferedImage(image);
			JFileChooser fileChooser = new JFileChooser();
			int returnVal = fileChooser.showSaveDialog(null);
			if ( returnVal == JFileChooser.APPROVE_OPTION ){
				String filePath = fileChooser.getSelectedFile().toString() + ".jpg";
				File file = new File(filePath);
			    try {
					ImageIO.write(snapShot, "jpg", file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (EmptyImageException e) {
			e.printStackTrace();
		}
	}
	
	private ICamera camera;
}
