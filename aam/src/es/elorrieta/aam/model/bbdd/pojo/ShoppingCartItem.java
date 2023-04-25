package es.elorrieta.aam.model.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

import es.elorrieta.aam.model.bbdd.pojo.manager.ManagerShoppingCartItems;

public class ShoppingCartItem  implements Serializable {

	private static final long serialVersionUID = 8903949143647177682L;

	// PK
	private int id = 0;

	// FK: the relationship between ShoppingCartItem and ShoppingCart is 1 to 1.

	private ShoppingCart shoppingCart = null;

	// FK: the relationship between ShoppingCartItem and ProductItem is 1 to 1.

	private ProductItem productItem = null;

	// ATTRIBUTES
	private double price = 0;
	private int quantity = 0;

	

	// Getters and setters

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, price, productItem, quantity, shoppingCart);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCartItem other = (ShoppingCartItem) obj;
		return id == other.id && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(productItem, other.productItem) && quantity == other.quantity
				&& Objects.equals(shoppingCart, other.shoppingCart);
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [id=" + id + ", price=" + price + ", quantity=" + quantity + ", shoppingCart="
				+ shoppingCart + ", productItem=" + productItem + "]";
	}

}
