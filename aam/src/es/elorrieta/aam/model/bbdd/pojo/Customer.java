package es.elorrieta.aam.model.bbdd.pojo;

import java.io.Serializable;

public class Customer extends Person  implements Serializable{


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
