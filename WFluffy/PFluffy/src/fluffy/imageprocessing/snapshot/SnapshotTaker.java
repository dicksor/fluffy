
package fluffy.imageprocessing.snapshot;

import java.awt.image.BufferedImage;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import fluffy.imageprocessing.OpenCvUtil;
import fluffy.network.camera.ICamera;

public abstract class SnapshotTaker implements Runnable
	{

	public SnapshotTaker(ICamera camera)
		{
		this.camera = camera;
		this.lock = new ReentrantLock();
		}

	protected BufferedImage getBuffuredImage()
		{
		this.lock.lock();
		BufferedImage snapShot = OpenCvUtil.matToBufferedImage(this.camera.getImage());
		this.lock.unlock();
		return snapShot;
		}

	protected ICamera camera;
	private Lock lock;
	}
