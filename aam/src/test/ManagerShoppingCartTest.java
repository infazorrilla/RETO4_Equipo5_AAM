package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		ShoppingCart result = new ShoppingCart();

		try {
			result = managerShoppingCart.select(shoppingCart);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println(" " + e);
		}

		// comprobamos comparando los atributos de los objetos son iguales

		assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.getCreatedAt()),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createdAt));
		assertEquals(result.getTotalPrice(), 125.68, shoppingCart.getTotalPrice());
		assertEquals(result.getDescount(), 0.3, shoppingCart.getDescount());

		// updateTest()

		shoppingCart.setId(result.getId());

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
			result = managerShoppingCart.select(shoppingCart);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("  " + e);
		}
//comprobamos que los datos se han modificado correctamente 
		assertEquals(result.toString(), shoppingCart.toString());
		assertEquals(result.getTotalPrice(), 50, shoppingCart.getTotalPrice());
		assertEquals(result.getDescount(), 0.1, shoppingCart.getDescount());
		assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.getCreatedAt()),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(shoppingCart.getCreatedAt()));
//deleteTest()
		// borramos shoppingcart por id
		// se espera result --> null
		try {
			managerShoppingCart.delete(shoppingCart);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println("  " + e);
		}

		try {
			result = managerShoppingCart.select(shoppingCart);
		} catch (SQLException e) {
			System.out.println("SQLException:  " + e);
		} catch (Exception e) {
			System.out.println(" " + e);
		}
// comprobamos que result = null
		assertNull(result);

	}

}
