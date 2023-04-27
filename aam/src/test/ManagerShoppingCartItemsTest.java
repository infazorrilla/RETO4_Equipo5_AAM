package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.manager.ManagerShoppingCartItems;
import es.elorrieta.aam.model.bbdd.pojo.ProductItem;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCartItem;

class ManagerShoppingCartItemsTest {

	private ShoppingCartItem shoppingCartItem = null;
	private ManagerShoppingCartItems managerShoppingCartItems = null;

	public ManagerShoppingCartItemsTest() {
		shoppingCartItem = new ShoppingCartItem();
		managerShoppingCartItems = new ManagerShoppingCartItems();
	}

	@Test
	void insertSelectUpdateDeleteTest() {

		// insertTest()
		// sabiendo que id_productItem = 1 y id_shoppingcart = 21

		ProductItem ProductItem = new ProductItem();
		ProductItem.setId(1);
		shoppingCartItem.setProductItem(ProductItem);
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setId(21);
		shoppingCartItem.setShoppingCart(shoppingCart);
		shoppingCartItem.setPrice(132);
		shoppingCartItem.setQuantity(12);

		// insertamos shoppingCartItem en la tabla shoppingCartItems en la base de datos

		try {
			managerShoppingCartItems.insert(shoppingCartItem);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos:  " + e);
		}

		// hacemos el select buscandolo por id_shoppingcart y id_product_item

		ShoppingCartItem result = new ShoppingCartItem();
		try {
			result = managerShoppingCartItems.select(shoppingCartItem);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos:  " + e);
		}
		// ahora comprobamos que se ha insertado correctamente

		assertEquals(result.getShoppingCart().getId(), shoppingCartItem.getShoppingCart().getId());
		assertEquals(result.getProductItem().getId(), shoppingCartItem.getProductItem().getId());
		assertEquals(result.getPrice(), 132, shoppingCartItem.getPrice());
		assertEquals(result.getQuantity(), shoppingCartItem.getQuantity());

		// updateTest()

		shoppingCartItem.setId(result.getId());

		// update

		shoppingCartItem.setPrice(250);

		shoppingCartItem.setQuantity(5);

		try {
			managerShoppingCartItems.update(shoppingCartItem);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos:  " + e);
		}

		// hacemos el select
		try {
			result = managerShoppingCartItems.select(shoppingCartItem);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos:  " + e);
		}

		// comprobamos si los 2 objetos son iguales

		assertEquals(result.toString(), shoppingCartItem.toString());
		assertEquals(result.getPrice(), 250, shoppingCartItem.getPrice());
		assertEquals(result.getQuantity(), shoppingCartItem.getQuantity());

		// DeleteTest()
		// se espera result --> null.

		// borramos shoppingCartItem de la base de datos

		try {
			managerShoppingCartItems.delete(shoppingCartItem);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos:  " + e);
		}

		// hacemos el select

		try {
			result = managerShoppingCartItems.select(shoppingCartItem);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos:  " + e);
		}

		// comprobamos que result = null
		assertNull(result);
	}

}