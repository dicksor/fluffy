
package fluffy.network.camera.model;

import java.io.Serializable;

public class UserModel implements Serializable {

	public UserModel() {
		this.email = "";
		this.hour = 0;
	}

	public UserModel(String email, int hour) {
		this.email = email;
		this.hour = hour;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getEmail() {
		return this.email;
	}

	public int getHour() {
		return this.hour;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "UserModel [email=" + this.email + ", hour=" + this.hour + "]";
	}

	private String email;
	private int hour;
}
