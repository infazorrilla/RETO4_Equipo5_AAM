package es.elorrieta.aam.model.bbdd.pojo;

public class Profile {

	private Person user = null;

	private boolean isOn = false;

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

}
