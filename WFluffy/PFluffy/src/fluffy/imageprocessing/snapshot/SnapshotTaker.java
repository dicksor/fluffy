package fluffy.imageprocessing.snapshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.camera.ICamera;

public class SnapshotTaker implements Runnable {

	public SnapshotTaker(ICamera camera) {
		this.camera = camera;
		this.lock = new ReentrantLock();
	}
	
	@Override
	public void run() {
		this.lock.lock();
		BufferedImage snapShot = OpenCvUtil.matToBufferedImage(this.camera.getImage());
		this.lock.unlock();
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
	}
	
	private ICamera camera;
	private Lock lock;
}
