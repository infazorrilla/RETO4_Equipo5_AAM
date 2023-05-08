package es.elorrieta.aam.model.bbdd.pojo;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Product implements Serializable {

	private static final long serialVersionUID = -4377536014361082572L;

	// PK
	private int id = 0;

	// FK: the relationship between Product and ProductItem is 1 to many.
	private List<ProductItem> productItems = null;

	// FK: the relationship between Product and Brand is 1 to 1.
	private Brand brand = null;

	// ATTRIBUTES

	private Date date = null;
	private Genders gender = null;
	private int category = 0;
	private File image = null;

	public enum Genders {
		M, H
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Genders getGender() {
		return gender;
	}

	public int getCategory() {
		return category;
	}

	public void setGender(Genders gender) {
		this.gender = gender;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, category, date, gender, id, image, productItems);
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
				&& gender == other.gender && id == other.id && Objects.equals(image, other.image)
				&& Objects.equals(productItems, other.productItems);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productItems=" + productItems + ", brand=" + brand + ", date=" + date
				+ ", gender=" + gender + ", category=" + category + ", image=" + image + "]";
	}

	
}
