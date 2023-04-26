package es.elorrieta.aam.model.bbdd.pojo;

import java.util.List;
import java.util.Objects;

public class EmployeeManagedOrders extends Employee {

	private List<Order> orders = null;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(orders);
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
		EmployeeManagedOrders other = (EmployeeManagedOrders) obj;
		return Objects.equals(orders, other.orders);
	}

	@Override
	public String toString() {
		return "EmployeeManagedOrders [orders=" + orders + ", getEmployeeType()=" + getEmployeeType() + " getId()="
				+ getId() + ", getName()=" + getName() + ", getLastName()=" + getLastName() + ", getNumberPhone()="
				+ getNumberPhone() + ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress()
				+ ", getPassword()=" + getPassword() + ", isStatus()=" + isStatus() + ", getImage()=" + getImage()
				+ ", getProfile()=" + getProfile() + "]";
	}

	
	



}
