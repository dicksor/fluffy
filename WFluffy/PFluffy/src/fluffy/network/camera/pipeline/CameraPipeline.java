/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.network.camera.pipeline;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.opencv.core.Mat;

public class CameraPipeline implements PropertyChangeListener {

	public CameraPipeline() {
		this.support = new PropertyChangeSupport(this);

		this.image = new Mat();
		this.faceDetectedCount = 0;
		
		this.detectionStat = new ConcurrentHashMap<String, AtomicInteger>();

		this.operators = new HashMap<Operators, AbstractOperator>();
		this.operators.put(Operators.YOLO, new OperatorYoloDetection(false));
		this.operators.put(Operators.TINY_YOLO, new OperatorTinyYoloDetection(false));
		this.operators.put(Operators.FACEDETECTION, new OperatorFaceDetection(false));
		this.operators.put(Operators.ROTATION, new OperatorRotation(true, 0));
		this.operators.put(Operators.ZOOM, new OperatorZoom(true, 1));

		((OperatorFaceDetection) this.operators.get(Operators.FACEDETECTION)).addPropertyChangeListener(this);
		((OperatorTinyYoloDetection) this.operators.get(Operators.TINY_YOLO)).addPropertyChangeListener(this);
		((OperatorYoloDetection) this.operators.get(Operators.YOLO)).addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("faceDetected")) {
			int faceDetected = (int) evt.getNewValue();
			this.support.firePropertyChange("faceDetected", this.faceDetectedCount, faceDetected);
			this.faceDetectedCount = faceDetected;
		} else if (evt.getPropertyName().equals("detectionStatistic")) {
			ConcurrentMap<String, AtomicInteger> detectionStats = (ConcurrentHashMap<String, AtomicInteger>) evt.getNewValue();
			support.firePropertyChange("detectionStatistic", this.detectionStat, detectionStats);
			this.detectionStat = detectionStats;
		}
		else {
			receivedImage(evt);
		}
		
	}

	public Mat getImage() {
		return this.image;
	}

	public void setIsActive(Operators operator, boolean isActive) {
		AbstractOperator op = this.operators.get(operator);
		if (op != null)
			op.setIsActive(isActive);
	}

	public void setRotationAngle(double angle) {
		OperatorRotation rotationOperator = (OperatorRotation) this.operators.get(Operators.ROTATION);
		if (rotationOperator != null)
			rotationOperator.setAngle(angle);
	}

	public void setZoomFactor(int zoomFactor) {
		OperatorZoom zoomOperator = (OperatorZoom) this.operators.get(Operators.ZOOM);
		if (zoomOperator != null)
			zoomOperator.setScale(zoomFactor);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	private void receivedImage(PropertyChangeEvent evt) {
		Mat img = (Mat) evt.getNewValue();
		img = this.applyOperationPipeline(img);
		this.support.firePropertyChange("img", this.image, img);
		this.image = img;
	}

	private Mat applyOperationPipeline(Mat img) {
		for (AbstractOperator operator : this.operators.values()) {
			if (operator.isActive())
				img = operator.operate(img);
		}
		return img;
	}

	private Mat image;
	private Map<Operators, AbstractOperator> operators;
	private PropertyChangeSupport support;
	private int faceDetectedCount;
	private ConcurrentMap<String, AtomicInteger> detectionStat;
}
