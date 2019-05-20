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

public class UserModel implements Serializable {

	public UserModel() {
		this.email = "";
		this.hour = "";
	}

	public UserModel(String email, String hour) {
		this.email = email;
		this.hour = hour;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getEmail() {
		return this.email;
	}

	public String getHour() {
		return this.hour;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "UserModel [email=" + this.email + ", hour=" + this.hour + "]";
	}

	private String email;
	private String hour;
}
