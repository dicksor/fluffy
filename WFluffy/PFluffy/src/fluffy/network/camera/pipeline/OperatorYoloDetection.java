package fluffy.network.camera.pipeline;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.Set;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvYoloDetection;

public class OperatorYoloDetection extends AbstractOperator implements PropertyChangeListener {

	public OperatorYoloDetection(boolean isActive) {
		super(isActive);
		this.support = new PropertyChangeSupport(this);
		this.detectionStat = new HashSet<String>();
		this.yoloDetection = new OpenCvYoloDetection("yolov3\\yolov3.weights", "yolov3\\yolov3.cfg", 0.6f);
		this.yoloDetection.addPropertyChangeListener(this);
	}

	@Override
	public Mat operate(Mat image) {
		return this.yoloDetection.feedForward(image);
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
			Set<String> detectionStats = (HashSet<String>) evt.getNewValue();
			support.firePropertyChange("detectionStatistic", this.detectionStat, detectionStats);
			this.detectionStat = detectionStats;
		} 
	}

	private OpenCvYoloDetection yoloDetection;
	private PropertyChangeSupport support;
	private Set<String> detectionStat;
}
