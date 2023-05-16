package es.elorrieta.aam.model.bbdd.pojo;

public class Profile {

	private Person user = null;

	private boolean isOn = false;
	
	private int userType = 0;

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

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}
