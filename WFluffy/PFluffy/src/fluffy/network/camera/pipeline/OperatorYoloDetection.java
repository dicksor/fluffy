package fluffy.network.camera.pipeline;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.opencv.core.Mat;

import fluffy.imageprocessing.OpenCvYoloDetection;

public class OperatorYoloDetection extends AbstractOperator implements PropertyChangeListener {

	public OperatorYoloDetection(boolean isActive) {
		super(isActive);
		this.support = new PropertyChangeSupport(this);
		this.detectionStat = new ConcurrentHashMap<String, AtomicInteger>();

		final String DEV_WEI = "..\\PDeploy\\Deploy\\ext\\yolov\\yolov3.weights";
		final String DEP_WEI = "ext\\yolov\\yolov3.weights";

		final String DEV_CFG = "..\\PDeploy\\Deploy\\ext\\yolov\\yolov3.cfg";
		final String DEP_CFG = "ext\\yolov\\yolov3.cfg";

		this.yoloDetection = new OpenCvYoloDetection(DEP_WEI, DEP_CFG, 0.6f);
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
			ConcurrentMap<String, AtomicInteger> detectionStats = (ConcurrentHashMap<String, AtomicInteger>) evt.getNewValue();
			support.firePropertyChange("detectionStatistic", this.detectionStat, detectionStats);
			this.detectionStat = detectionStats;
		}
	}

	private OpenCvYoloDetection yoloDetection;
	private PropertyChangeSupport support;
	private ConcurrentMap<String, AtomicInteger> detectionStat;
}
