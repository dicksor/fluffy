package fluffy.userinterface.camera_gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class JPanelEast extends JPanel implements PropertyChangeListener {

	public JPanelEast() {
		this.stats = new ConcurrentHashMap<String, AtomicInteger>();
		this.model = new DefaultListModel<String>();
		this.geometry();
		this.control();
		this.appearance();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		 if (evt.getPropertyName().equals("detectionStatistic")) {
			 	this.clearList();
				this.stats = (ConcurrentHashMap<String, AtomicInteger>) evt.getNewValue();
				for(Entry<String, AtomicInteger> stat: this.stats.entrySet()) {
					this.model.addElement(stat.getKey() + " : " + stat.getValue());
				}
		 }
	}
	
	public void clearList() {
		this.model.clear();
	}

	private void appearance() {
		// TODO Auto-generated method stub

	}

	private void control() {
		// TODO Auto-generated method stub

	}

	private void geometry() {
		this.statList = new JList<String>(this.model);
		this.lblDetectionStatistic = new JLabel("Detection statistics");

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(this.lblDetectionStatistic);
		this.add(this.statList);
	}

	private JList<String> statList;
	private DefaultListModel<String> model;
	private ConcurrentMap<String, AtomicInteger> stats;
	private JLabel lblDetectionStatistic;
}
