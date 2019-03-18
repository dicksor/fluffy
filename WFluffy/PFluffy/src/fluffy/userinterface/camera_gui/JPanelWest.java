package fluffy.userinterface.camera_gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelWest extends JPanel {

	public JPanelWest() {
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
		// rien
	}

	private void appearance() {
		// rien
	}

	public JButton getBtnRotateLeft() {
		return btnRotateLeft;
	}

	private JLabel lblCameraName;
	private JButton btnSnapshot;
	private JButton btnRotateLeft;
	private JButton btnRotateRight;
	private JPanelZoom panelZoom;

	private BoxLayout boxMainLayout;
}
