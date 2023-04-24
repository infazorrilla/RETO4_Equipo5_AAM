package es.elorrieta.aam.model.bbdd.pojo;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import es.elorrieta.aam.model.bbdd.pojo.manager.ManagerShoppingCart;

public class ShoppingCart extends ManagerShoppingCart<ShoppingCart> {
	
	
    //PK
	private int id = 0;
	
	//FK: the relationship between ShoppingCart and Order is 1 to 1.
	
	private Order order = null;
	
	//FK: the relationship between ShoppingCart and ShoppingCartItem is 1 to Many.
	
	private List<ShoppingCartItem> shoppingCartItems = null;
	
	
	
	
	@Override
	public void insert(ShoppingCart t) {

	}

	@Override
	public ShoppingCart select(ShoppingCart t) {

		return null;
	}

	@Override
	public void update(ShoppingCart t) {

	}

	@Override
	public void delete(ShoppingCart t) {

	}
 
	
	// ATTRIBUTES
	private double totalPrice = 0;
	private double descount = 0;
	private Date dateOfPurchase = null;

	

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

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
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
		return Objects.hash(dateOfPurchase, descount, id, order, shoppingCartItems, totalPrice);
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
		return Objects.equals(dateOfPurchase, other.dateOfPurchase)
				&& Double.doubleToLongBits(descount) == Double.doubleToLongBits(other.descount) && id == other.id
				&& Objects.equals(order, other.order) && Objects.equals(shoppingCartItems, other.shoppingCartItems)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", totalPrice=" + totalPrice + ", descount=" + descount + ", dateOfPurchase="
				+ dateOfPurchase + ", order=" + order + ", shoppingCartItems=" + shoppingCartItems + "]";
	}

}
