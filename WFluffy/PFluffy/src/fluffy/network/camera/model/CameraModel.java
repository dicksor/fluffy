/**
 * @author romain.capocasa
 * @author jonas.freiburghaus
 * @author vincent.moulin1
 * Projet P2
 * Printemps 2019
 * He-arc
 */

package fluffy.network.camera.model;

import java.io.Serializable;

public class CameraModel implements Serializable {

	public CameraModel() {
		this.name = "";
		this.link = "";
		this.description = "";
		this.angle = "";
		this.zoom = "";
	}

	public CameraModel(String name, String link, String description) {
		this.name = name;
		this.link = link;
		this.description = description;
		this.angle = "";
		this.zoom = "";
	}

	public CameraModel(String name, String link, String description, String angle, String zoom) {
		this.name = name;
		this.link = link;
		this.description = description;
		this.angle = angle;
		this.zoom = zoom;
	}

	public String getAngle() {
		return this.angle;
	}

	public void setAngle(String angle) {
		this.angle = angle;
	}

	public String getZoom() {
		return this.zoom;
	}

	public void setZoom(String zoom) {
		this.zoom = zoom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CameraModel [name=" + this.name + ", link=" + this.link + ", description=" + this.description
				+ ", angle=" + this.angle + ", zoom=" + this.zoom + "]";
	}

	private static final long serialVersionUID = 1L;

	// Attributes
	private String name;
	private String link;
	private String description;
	private String angle;
	private String zoom;
}
