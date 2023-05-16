package es.elorrieta.aam.model.bbdd.pojo;

import java.io.Serializable;

/**
 * represents a customer , extends the Person class and implements the
 * Serializable interface. It inherits the properties and methods of the Person
 * class
 * 
 * @author Admin
 *
 */
public class Customer extends Person implements Serializable {

	private static final long serialVersionUID = -3269494051008982311L;

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [Id()=" + getId() + ",Name()=" + getName() + ",LastName()=" + getLastName()
				+ ", NumberPhone()=" + getNumberPhone() + ", Email()=" + getEmail() + ",Address()=" + getAddress()
				+ ", Password()=" + getPassword() + ", isStatus()=" + isStatus() + ",Image()=" + getImage()
				+ ",Profile()=" + getProfile() + "]";
	}

}
