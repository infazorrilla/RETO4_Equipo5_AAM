package es.elorrieta.aam.model.bbdd.pojo;

import java.util.Objects;

public abstract class Employee extends Person {

	private int employeeType = 0;

	@Override
	public abstract void insert(Person person);

	@Override
	public abstract Person select(Person person);

	@Override
	public abstract void update(Person person);

	@Override
	public abstract void delete(Person person);

	public int getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(employeeType);
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
		Employee other = (Employee) obj;
		return employeeType == other.employeeType;
	}

	@Override
	public String toString() {
		return "Employee [employeeType=" + employeeType + "]";
	}

}
