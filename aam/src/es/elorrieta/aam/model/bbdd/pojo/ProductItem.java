package es.elorrieta.aam.model.bbdd.pojo;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class ProductItem {
	
	private int id = 0;
	private double price = 0;
	private int stock = 0;
	
	private List<File> images = null;
	private Product product = null;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<File> getImages() {
		return images;
	}

	public void setImages(List<File> images) {
		this.images = images;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, images, price, product, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductItem other = (ProductItem) obj;
		return id == other.id && Objects.equals(images, other.images)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(product, other.product) && stock == other.stock;
	}

	@Override
	public String toString() {
		return "ProductItem [id=" + id + ", price=" + price + ", stock=" + stock + ", images=" + images + ", product="
				+ product + "]";
	}

}
