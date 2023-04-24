package es.elorrieta.aam.model.bbdd.pojo;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Product {

	// PK
	private int id = 0;

	// FK: the relationship between Product and ProductItem is 1 to many.
	private List<ProductItem> productItems = null;

	// FK: the relationship between Product and Brand is 1 to 1.
	private Brand brand = null;

	// ATTRIBUTES
	private Category category = null;
	private Date date = null;

	public enum Category {
		Dress, Jeans, Tshirt, Shoes
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItems(List<ProductItem> productItems) {
		this.productItems = productItems;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, category, date, id, productItems);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(brand, other.brand) && category == other.category && Objects.equals(date, other.date)
				&& id == other.id && Objects.equals(productItems, other.productItems);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", date=" + date + ", productItems=" + productItems
				+ ", brand=" + brand + "]";
	}

}
