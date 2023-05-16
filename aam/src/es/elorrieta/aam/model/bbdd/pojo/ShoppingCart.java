package es.elorrieta.aam.model.bbdd.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;



public class ShoppingCart  implements Serializable {

	private static final long serialVersionUID = 364133639081960563L;

	// PK
	private int id = 0;

	// FK: the relationship between ShoppingCart and Order is 1 to 1.

	private Order order = null;

	// FK: the relationship between ShoppingCart and ShoppingCartItem is 1 to Many.

	private List<ShoppingCartItem> shoppingCartItems = null;

	

	// ATTRIBUTES
	private double totalPrice = 0;
	private double descount = 0;
	private Date createdAt = null;
	

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getDescount() {
		return descount;
	}

	public void setDescount(double descount) {
		this.descount = descount;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, descount, id, order, shoppingCartItems, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		return Objects.equals(createdAt, other.createdAt)
				&& Double.doubleToLongBits(descount) == Double.doubleToLongBits(other.descount) && id == other.id
				&& Objects.equals(order, other.order) && Objects.equals(shoppingCartItems, other.shoppingCartItems)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", order=" + order + ", shoppingCartItems=" + shoppingCartItems
				+ ", totalPrice=" + totalPrice + ", descount=" + descount + ", createdAt=" + createdAt + "]";
	}



}
