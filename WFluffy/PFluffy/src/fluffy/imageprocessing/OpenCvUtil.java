package fluffy.imageprocessing;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class OpenCvUtil {
	
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
		Point center = new Point(m.cols() / 2.0, m.cols() / 2.0);
		double scale = 1.0;
		Mat mRotation = Imgproc.getRotationMatrix2D(center, angle, scale);
		Mat mRotatedImage = new Mat();
		Imgproc.warpAffine(m, mRotatedImage, mRotation, new Size(m.rows(), m.cols()));
		return mRotatedImage;
	}

}
