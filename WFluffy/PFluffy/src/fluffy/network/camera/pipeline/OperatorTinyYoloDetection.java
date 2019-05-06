package fluffy.network.camera.pipeline;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvYoloDetection;

public class OperatorTinyYoloDetection extends AbstractOperator implements PropertyChangeListener {

	public OperatorTinyYoloDetection(boolean isActive) {
		super(isActive);
		this.support = new PropertyChangeSupport(this);
		this.detectionStat = new ConcurrentHashMap<String, AtomicInteger>();
		this.tinyYoloDetection = new OpenCvYoloDetection("yolov3\\yolov3tiny.weights", "yolov3\\yolov3tiny.cfg", 0.30f);
		this.tinyYoloDetection.addPropertyChangeListener(this);
	}

	@Override
	public Mat operate(Mat image) {
		return this.tinyYoloDetection.feedForward(image);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("detectionStatistic")) {
			ConcurrentMap<String, AtomicInteger> detectionStats = (ConcurrentHashMap<String, AtomicInteger>) evt.getNewValue();
			support.firePropertyChange("detectionStatistic", this.detectionStat, detectionStats);
			this.detectionStat = detectionStats;
		} 
	}

	private OpenCvYoloDetection tinyYoloDetection;
	private PropertyChangeSupport support;
	private ConcurrentMap<String, AtomicInteger> detectionStat;

}
