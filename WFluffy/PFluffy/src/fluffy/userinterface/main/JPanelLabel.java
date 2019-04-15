/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */
package fluffy.userinterface.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fluffy.image.MagasinImage;

public class JPanelLabel extends JPanel {

	public JPanelLabel() {
		this.geometry();
		this.control();
		this.appearance();
	}

	private void appearance() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D)g;

		AffineTransform transform = g2D.getTransform(); //sauvegarde
		Color color = g2D.getColor(); //sauvegarde
		Font font = g2D.getFont(); //sauvegarde

		dessiner(g2D);

		g2D.setFont(font); //restore
		g2D.setColor(color); //restore
		g2D.setTransform(transform); //restore
		}

	private void dessiner(Graphics2D g2d)
		{
		g2d.drawImage(MagasinImage.logo.getImage(), 0, 0, this);
		}

	private void control() {
		// TODO Auto-generated method stub

	}

	private void geometry() {
		// TODO Auto-generated method stub
		//this.lbTitle = new JLabel("Gestionaire de caméra IP");
		this.setLayout(new FlowLayout());
		//this.add(this.lbTitle);
	}

	private JLabel lbTitle;
}
