package es.elorrieta.aam.model.bbdd.pojo;

public class Profile implements OperationsUserProfile {

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

	@Override
	public boolean isProfileOn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLoggendInUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean login(Person t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout(Person t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
}
