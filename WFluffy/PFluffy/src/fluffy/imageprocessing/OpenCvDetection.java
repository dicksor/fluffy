package fluffy.imageprocessing;

import org.opencv.objdetect.CascadeClassifier;

public abstract class OpenCvDetection {
	
	public OpenCvDetection(String xmlModelFile) {
		this.xmlModelFile = xmlModelFile;
		this.classifier = new CascadeClassifier(this.xmlModelFile);
	}

	private String xmlModelFile;
	protected CascadeClassifier classifier;
}
