package es.elorrieta.aam.model.bbdd.pojo;

public interface CustomerAccountOrderActions {

	public boolean addItemToTheShoppingCart(ShoppingCartItem shoppingCartItem);

	public boolean cancelOrder(Order order);

	public boolean removeItem(ShoppingCartItem shoppingCartItem);
}
