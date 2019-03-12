package fluffy.userinterface.camera_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fluffy.network.camera.Camera;
import fluffy.network.camera.CameraRotation;

public class JPanelWest extends JPanel {

	public JPanelWest(JFrame jFrame) {
		this.jFrame = jFrame;
		geometry();
		control();
		appearance();
	}

	private void geometry() {
		this.lblCameraName = new JLabel("Camera Name");
		this.btnSnapshot = new JButton("Take Snapshot");
		this.btnRotateLeft = new JButton("Rotate left");
		this.btnRotateRight = new JButton("Rotate right");
		this.panelZoom = new JPanelZoom();

		this.boxMainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxMainLayout);

		this.add(lblCameraName);
		this.add(btnSnapshot);
		this.add(btnSnapshot);
		this.add(btnRotateLeft);
		this.add(btnRotateRight);
		this.add(panelZoom);
	}

	private void control() {
		this.btnRotateLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rotAngle += 90;
				System.out.println(rotAngle);
				// FIXME : excessivement laborieux
				((CameraGUI) JPanelWest.this.jFrame).setCamera(new CameraRotation(((CameraGUI) JPanelWest.this.jFrame).getCamera(), rotAngle));
			}
			
		});
	}

	private void appearance() {
		// rien
	}

	private JLabel lblCameraName;
	private JButton btnSnapshot;
	private JButton btnRotateLeft;
	private JButton btnRotateRight;
	private JPanelZoom panelZoom;
	private BoxLayout boxMainLayout;
	private JFrame jFrame;
	private double rotAngle;
}
