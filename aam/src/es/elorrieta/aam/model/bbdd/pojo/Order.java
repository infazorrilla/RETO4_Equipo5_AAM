package es.elorrieta.aam.model.bbdd.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import es.elorrieta.aam.model.bbdd.pojo.manager.ManagerOrders;

public class Order  implements Serializable {

	private static final long serialVersionUID = 7011816090907660930L;

	// PK
	private int id = 0;

	// FK: the relationship between Order and payment is 1 to 1.
	private Payment payment = null;

	// FK: the relationship between Order and ShoppingCart is 1 to 1.
	private ShoppingCart shoppingCart = null;

	// FK: the relationship between Order and Customer is 1 to 1.
	private Customer customer = null;

	// FK: the relationship between Order and Address is 1 to 1.
	private Address address = null;

	// FK: the relationship between Order and EmployeeManagedOrders is 1 to 1.
	private EmployeeManagedOrders EmployeeManagedOrders = null;

	// ATTRIBUTES
	private Date deliveryDate = null;
	private Date orderDate = null;
	private double totalPrice = 0;
	private Status status = null;

	public enum Status {
		Pending, AwaitingShipment, Shipped, Cancelled

	}


	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public EmployeeManagedOrders getEmployeeManagedOrders() {
		return EmployeeManagedOrders;
	}

	public void setEmployeeManagedOrders(EmployeeManagedOrders employeeManagedOrders) {
		EmployeeManagedOrders = employeeManagedOrders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(EmployeeManagedOrders, address, customer, deliveryDate, id, orderDate, payment,
				shoppingCart, status, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(EmployeeManagedOrders, other.EmployeeManagedOrders)
				&& Objects.equals(address, other.address) && Objects.equals(customer, other.customer)
				&& Objects.equals(deliveryDate, other.deliveryDate) && id == other.id
				&& Objects.equals(orderDate, other.orderDate) && Objects.equals(payment, other.payment)
				&& Objects.equals(shoppingCart, other.shoppingCart) && status == other.status
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", deliveryDate=" + deliveryDate + ", orderDate=" + orderDate + ", totalPrice="
				+ totalPrice + ", status=" + status + ", payment=" + payment + ", shoppingCart=" + shoppingCart
				+ ", customer=" + customer + ", address=" + address + ", EmployeeManagedOrders=" + EmployeeManagedOrders
				+ "]";
	}

}
