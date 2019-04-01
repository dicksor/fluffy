package fluffy.network.camera.model;

import java.io.Serializable;

public class CameraModel implements Serializable {

	public CameraModel() {
		this.name = "";
		this.link = "";
		this.description = "";
	}

	public CameraModel(String name, String link, String description) {
		this.name = name;
		this.link = link;
		this.description = description;
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
		return "CameraModel [name=" + name + ", link=" + link + ", description=" + description + "]";
	}

	private static final long serialVersionUID = 1L;

	// Attributes
	private String name;
	private String link;
	private String description;
}
