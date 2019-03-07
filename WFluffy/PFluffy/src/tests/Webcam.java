package tests;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class Webcam {

	public static void main(String args[]) {

		System.out.println("Hello, OpenCV");
		// Load the native library.
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		VideoCapture camera = new VideoCapture(0);
		camera.open(0); // Useless
		if (!camera.isOpened()) {
			System.out.println("Camera Error");
		} else {
			System.out.println("Camera OK?");
		}

		Mat frame = new Mat();

		camera.grab();
		System.out.println("Frame Grabbed");
		camera.retrieve(frame);
		System.out.println("Frame Decoded");

		camera.read(frame);
		System.out.println("Frame Obtained");

		/*
		 * No difference camera.release();
		 */

		System.out.println("Captured Frame Width " + frame.width());

		// HighGui.imshow("camera.jpg", frame);
		faceDetection(frame);

		BufferedImage img = Mat2BufferedImage(frame);
		displayImage(img);
		rotateImage(frame, 90);
		zoomImage(frame, 0.1);
	}

	public static void displayImage(Image img2) {

		// BufferedImage img=ImageIO.read(new File("/HelloOpenCV/lena.png"));
		ImageIcon icon = new ImageIcon(img2);
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(img2.getWidth(null) + 50, img2.getHeight(null) + 50);
		JLabel lbl = new JLabel();
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static BufferedImage Mat2BufferedImage(Mat m) {
		// Fastest code
		// output can be assigned either to a BufferedImage or to an Image

		int type = BufferedImage.TYPE_BYTE_GRAY;
		if (m.channels() > 1) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		int bufferSize = m.channels() * m.cols() * m.rows();
		byte[] b = new byte[bufferSize];
		m.get(0, 0, b); // get all the pixels
		BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(b, 0, targetPixels, 0, b.length);
		return image;
	}

	public static void faceDetection(Mat m) {
		String xmlFile = "C:\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml";
		CascadeClassifier classifier = new CascadeClassifier(xmlFile);

		MatOfRect faceDetections = new MatOfRect();
		classifier.detectMultiScale(m, faceDetections);
		System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

		for (Rect rect : faceDetections.toArray()) {
			Imgproc.rectangle(m, // where to draw the box
					new Point(rect.x, rect.y), // bottom left
					new Point(rect.x + rect.width, rect.y + rect.height), // top right
					new Scalar(0, 0, 255), 3 // RGB colour
			);
		}

		Imgcodecs.imwrite("C:\\Users\\jonas.freiburg\\Documents\\faceDetec.jpg", m);

		System.out.println("Image Processed");
	}

	public static void rotateImage(Mat m, double angle) {
		// get rotation matrix for rotating the image around its center in pixel
		// coordinates
		System.out.println("Starting rotation");
		Point center = new Point(m.cols() / 2.0, m.cols() / 2.0);
		double scale = 1.0;
		Mat mRotation = Imgproc.getRotationMatrix2D(center, angle, scale);
		Mat mRotatedImage = new Mat();
		Imgproc.warpAffine(m, mRotatedImage, mRotation, new Size(m.rows(), m.cols()));
		System.out.println("Rotation done");
		Imgcodecs.imwrite("C:\\Users\\jonas.freiburg\\Documents\\rotatedImg.jpg", mRotatedImage);
	}

	public static void zoomImage(Mat m, double scale) {
		System.out.println("Starting zoom");
		Mat mScaledImage = new Mat();
		Imgproc.resize(m, mScaledImage, new Size(m.rows(), m.cols()), scale, scale);
		System.out.println("Zoom done");
		Imgcodecs.imwrite("C:\\Users\\jonas.freiburg\\Documents\\zoomImg.jpg", mScaledImage);
	}

}