/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.tools.image;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

public class ImageLoader
	{
	/**
	* Non Bloquant
	* Depuis un .jar
	*/
	public static ImageIcon loadAsynchroneJar(String nameFile)//Non Bloquant
		{
		URL url = ClassLoader.getSystemResource(nameFile);
		Image image = Toolkit.getDefaultToolkit().getImage(url);
		return new ImageIcon(image);
		}
	}

