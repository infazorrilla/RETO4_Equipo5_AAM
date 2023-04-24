package es.elorrieta.aam.model.bbdd.pojo;

public interface OperationsUserProfile {

	public boolean isProfileOn();

	public int getLoggendInUser();

	public boolean login(Person t);

	public boolean logout(Person t);

}
