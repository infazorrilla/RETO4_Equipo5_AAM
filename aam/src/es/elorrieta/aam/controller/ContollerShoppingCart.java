package es.elorrieta.aam.controller;

public class ContollerShoppingCart {
	public int quantityNowPlus(int cantidad) {
		return cantidad + 1;
	}

	public int quantityNowMinus(int cantidad) {
		return cantidad - 1;
	}
}
