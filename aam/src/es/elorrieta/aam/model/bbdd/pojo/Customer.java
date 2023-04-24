package es.elorrieta.aam.model.bbdd.pojo;

public class Customer extends Person implements CustomerAccountOrderActions {

	@Override
	public void insert(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person select(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addItemToTheShoppingCart(ShoppingCartItem shoppingCartItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeItem(ShoppingCartItem shoppingCartItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [Id()=" + getId() + ",Name()=" + getName() + ",LastName()=" + getLastName()
				+ ", NumberPhone()=" + getNumberPhone() + ", Email()=" + getEmail() + ",Address()=" + getAddress()
				+ ", Password()=" + getPassword() + ", isStatus()=" + isStatus() + ",Image()=" + getImage()
				+ ",Profile()=" + getProfile() + "]";
	}


}
