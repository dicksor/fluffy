package fluffy.userinterface.camera_gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class JPanelCameraGUI extends JPanel{
	
	public JPanelCameraGUI()
	{
	geometry();
	control();
	appearance();
	}

	private void appearance() {
		
	}

	private void control() {
		// TODO Auto-generated method stub
		
	}

	private void geometry() {
			
		panelWest = new JPanelWest();
		panelSouth = new JPanelSouth();
		test = new JButton("test");
		
		borderMainLayout = new BorderLayout();
		setLayout(borderMainLayout);
			
		this.add(panelWest, BorderLayout.WEST);
		this.add(panelSouth, BorderLayout.SOUTH);
		this.add(test, BorderLayout.CENTER);
	}
	
	
	
	//private Player cameraPlayer;
	private JButton test;
	private JPanelWest panelWest;
	private JPanelSouth panelSouth;
	
	
	private BorderLayout borderMainLayout;
	
}
