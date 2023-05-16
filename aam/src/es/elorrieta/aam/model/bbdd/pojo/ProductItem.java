package es.elorrieta.aam.model.bbdd.pojo;

import java.util.Objects;

public class ProductItem {

	private int id = 0;
	private double price = 0;
	private int stock = 0;

	private Product product = null;
	private String size = null;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, price, product, size, stock);
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
		return id == other.id && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(product, other.product) && Objects.equals(size, other.size) && stock == other.stock;
	}

	@Override
	public String toString() {
		return "ProductItem [id=" + id + ", price=" + price + ", stock=" + stock + ", product=" + product + ", size="
				+ size + "]";
	}

}
