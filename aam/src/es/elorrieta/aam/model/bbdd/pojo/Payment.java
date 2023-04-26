package es.elorrieta.aam.model.bbdd.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Payment  implements Serializable {

	private static final long serialVersionUID = -6152476064974115544L;
	
	// PK
	private int id = 0;
	
	// FK: the relationship between payment and order is 1 to 1.
	private Order order = null;
	
	// ATTRIBUTES
	private String iban = null;
	private String cvv = null;
	private Date expirationDate = null;
	
	// GETTERS AND SETTERES
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIban() {
		return iban;
	}
	
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public String getCvv() {
		return cvv;
	}
	
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cvv, expirationDate, iban, id, order);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(cvv, other.cvv) && Objects.equals(expirationDate, other.expirationDate)
				&& Objects.equals(iban, other.iban) && id == other.id && Objects.equals(order, other.order);
	}
	
	@Override
	public String toString() {
		return "Payment [id=" + id + ", iban=" + iban + ", cvv=" + cvv + ", expirationDate=" + expirationDate
				+ ", order=" + order + "]";
	}

}