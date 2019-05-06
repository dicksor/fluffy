/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.imageprocessing;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 * This class contains utilities methods to apply diverse transformations to a matrix
 */
public class OpenCvUtil {

	/**
	 * Convert an OpenCV matrix to a buffered image
	 * @param m The matrix to transform
	 * @return a buffered image
	 */
	public static BufferedImage matToBufferedImage(Mat m) {
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if (m.channels() > 1) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		int bufferSize = m.channels() * m.cols() * m.rows();
		byte[] b = new byte[bufferSize];
		m.get(0, 0, b);
		BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(b, 0, targetPixels, 0, b.length);
		return image;
	}

	public static Mat rotateImage(Mat m, double angle) {
		Point center = new Point(m.cols() / 2.0, m.rows() / 2.0);
		double scale = 1.0;
		Mat mRotation = Imgproc.getRotationMatrix2D(center, angle, scale);
		Mat mRotatedImage = new Mat();
		Imgproc.warpAffine(m, mRotatedImage, mRotation, new Size(m.cols(), m.rows()));
		return mRotatedImage;
	}

	public static Mat zoomImage(Mat m, int scale) {
		Mat mScaledImage = new Mat();
		Imgproc.resize(m, mScaledImage, new Size(m.cols() * scale, m.rows() * scale), scale, scale, Imgproc.INTER_NEAREST);
		int deltacx = (mScaledImage.width() / 2) - (m.width() / 2);
		int deltacy = (mScaledImage.height() / 2) - (m.height() / 2);
		Rect rectCrop = new Rect(deltacx, deltacy, m.width(), m.height());
		Mat croppedImage = new Mat(mScaledImage, rectCrop);
		return croppedImage;
	}

}
