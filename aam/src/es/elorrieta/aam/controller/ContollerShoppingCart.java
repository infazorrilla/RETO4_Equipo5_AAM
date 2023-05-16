package es.elorrieta.aam.controller;

import java.text.DecimalFormat;

import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCartItem;

public class ContollerShoppingCart {
	/**
	 * Increases the given quantity by 1.
	 * 
	 * @param quantity the quantity to be incremented
	 * @return the updated quantity after incrementing by 1
	 */
	public int quantityNowPlus(int quantity) {
		return quantity + 1;
	}

	/**
	 * Decreases the given quantity by 1.
	 * 
	 * @param quantity the quantity to be decremented
	 * @return the updated quantity after decrementing by 1
	 */
	public int quantityNowMinus(int quantity) {
		return quantity - 1;
	}

	/**
	 * Calculates the base price of a shopping cart.
	 *
	 * @param shopCart the shopping cart containing the items
	 * @return the total base price of the items in the shopping cart formatted as a
	 *         string
	 */
	public String calculatPriceBase(ShoppingCart shopCart) {
		double ret = 0.0;
		DecimalFormat decfor = new DecimalFormat("0.00");
		for (ShoppingCartItem shopCartItem : shopCart.getShoppingCartItems()) {

			if (null != shopCartItem) {
				ret += (shopCartItem.getPrice());
			}

		}
		return (decfor.format(ret));
	}
	/**
	 * Calculates the total price by multiplying the given price with the specified quantity.
	 *
	 * @param price The price of a single item.
	 * @param quantity The quantity of items.
	 * @return The total price calculated by multiplying the price with the quantity.
	 */
	public double calculateTotalPrice(double price, int quantiy) {
		return price * quantiy;
	}
}
