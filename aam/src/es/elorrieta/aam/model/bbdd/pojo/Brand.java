package es.elorrieta.aam.model.bbdd.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Brand implements Serializable {

	private static final long serialVersionUID = -2589051523281319846L;

	// PK
	private int id = 0;

	// FK: the relationship between Brand and Product is 1 to 1 .
	private List<Product> products = null;

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeesManagedStore, id, products, value);
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
				&& Objects.equals(products, other.products) && value == other.value;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", products=" + products + ", employeesManagedStore=" + employeesManagedStore
				+ ", value=" + value + "]";
	}

}
