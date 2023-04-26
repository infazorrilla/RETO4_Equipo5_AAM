package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.manager.ManagerShoppingCart;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;

class ManagerShoppingCartTest {
	private ManagerShoppingCart managerShoppingCart = null;
	private ShoppingCart shoppingCart = null;

	public ManagerShoppingCartTest() {
		shoppingCart = new ShoppingCart();
		managerShoppingCart = new ManagerShoppingCart();
	}

	@Test
	void insertSelectUpdateDelteTest() {
		// insertTest()

		shoppingCart.setTotalPrice(125.68);
		shoppingCart.setDescount(0.3);
		Date createdAt = new Date();
		shoppingCart.setCreatedAt(createdAt);
// insertamos shoppingcart en la base de datos.
		try {
			managerShoppingCart.insert(shoppingCart);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos:  " + e);
		}
//hacer el select buscandolo por fecha de creacion
		List<ShoppingCart> shoppingcart = new ArrayList<ShoppingCart>();

		try {
			shoppingcart = managerShoppingCart.select(shoppingCart);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println(" " + e);
		}

		// comprobamos comparando los atributos de los objetos son iguales

		assertEquals(shoppingcart.size(), 1);

		assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(shoppingcart.get(0).getCreatedAt()),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createdAt));
		assertEquals(shoppingcart.get(0).getTotalPrice(), 125.68, shoppingCart.getTotalPrice());
		assertEquals(shoppingcart.get(0).getDescount(), 0.3, shoppingCart.getDescount());

		// updateTest()

		shoppingCart.setId(shoppingcart.get(0).getId());

		shoppingCart.setTotalPrice(50);
		shoppingCart.setDescount(0.2);

		// update

		try {
			managerShoppingCart.update(shoppingCart);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos:  " + e);
		}
		// hacer el select

		try {
			shoppingcart = managerShoppingCart.select(shoppingCart);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("  " + e);
		}
//comprobamos que los datos se han modificado correctamente 
		assertEquals(shoppingcart.get(0).toString(), shoppingCart.toString());
		assertEquals(shoppingcart.get(0).getTotalPrice(), 50, shoppingCart.getTotalPrice());
		assertEquals(shoppingcart.get(0).getDescount(), 0.1, shoppingCart.getDescount());
		assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(shoppingcart.get(0).getCreatedAt()),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(shoppingCart.getCreatedAt()));
//deleteTest()
		// borramos shoppingcart por id
		// se espera shoppingcart --> null
		try {
			managerShoppingCart.delete(shoppingCart);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("  " + e);
		}

		try {
			shoppingcart = managerShoppingCart.select(shoppingCart);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println(" " + e);
		}
// comprobamos que shoppingcart = null
		assertNull(shoppingcart);

	}

}
