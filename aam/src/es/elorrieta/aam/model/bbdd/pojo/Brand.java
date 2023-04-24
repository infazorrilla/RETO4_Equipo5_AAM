package es.elorrieta.aam.model.bbdd.pojo;

import java.util.List;
import java.util.Objects;

public class Brand {
	// PK
	private int id = 0;

	// FK: the relationship between Brand and Product is 1 to 1 .
	private Product product = null;

	// FK: the relationship between Brand and EmployeeManagedStore is 1 to many .
	private List<EmployeeManagedStore> employeesManagedStore = null;

	// ATTRIBUTES
	private Brands value = null;

	public enum Brands {
		ADIDAS, NIKE, ZARA, BERSHKA, MANGO
	}

//GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Brands getValue() {
		return value;
	}

	public void setValue(Brands value) {
		this.value = value;
	}

	public List<EmployeeManagedStore> getEmployeesManagedStore() {
		return employeesManagedStore;
	}

	public void setEmployeesManagedStore(List<EmployeeManagedStore> employeesManagedStore) {
		this.employeesManagedStore = employeesManagedStore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeesManagedStore, id, product, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		return Objects.equals(employeesManagedStore, other.employeesManagedStore) && id == other.id
				&& Objects.equals(product, other.product) && value == other.value;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", product=" + product + ", value=" + value + ", employeesManagedStore="
				+ employeesManagedStore + "]";
	}

}
