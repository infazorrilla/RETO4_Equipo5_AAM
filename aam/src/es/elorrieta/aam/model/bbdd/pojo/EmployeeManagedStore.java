package es.elorrieta.aam.model.bbdd.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class EmployeeManagedStore extends Employee   implements Serializable{

	
	private static final long serialVersionUID = 5838275838591637199L;
	private List<Brand> brands = null;

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(brands);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeManagedStore other = (EmployeeManagedStore) obj;
		return Objects.equals(brands, other.brands);
	}

	@Override
	public String toString() {
		return "EmployeeManagedStore [brands=" + brands + ", getEmployeeType()=" + getEmployeeType() + " getId()="
				+ getId() + ", getName()=" + getName() + ", getLastName()=" + getLastName() + ", getNumberPhone()="
				+ getNumberPhone() + ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress()
				+ ", getPassword()=" + getPassword() + ", isStatus()=" + isStatus() + ", getImage()=" + getImage()
				+ ", getProfile()=" + getProfile() + "]";
	}

}
