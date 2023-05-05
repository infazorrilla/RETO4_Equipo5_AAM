package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.manager.ManagerOrders;
import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Payment;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;

class ManagerOrdersTest {

	private Order order = null;
	private ManagerOrders managerOrders = null;
	
	public ManagerOrdersTest() {
		order = new Order();
		managerOrders = new ManagerOrders();
	}
	
	@Test
	void testInsertSelectUpdateDelete() {
		// testInsert()
		// knowing that id_customer = 11, id_address = 10, id_shoppingcart = 1, id_payment = 25
		Customer customer = new Customer();
		customer.setId(11);
		order.setCustomer(customer);
		Address address = new Address();
		address.setId(10);
		order.setAddress(address);
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setId(1);
		order.setShoppingCart(shoppingCart);
		Payment payment = new Payment();
		payment.setId(25);
		order.setPayment(payment);
		order.setStatus("Pending");
		Date orderDate = new Date();
		order.setOrderDate(orderDate);
		Date deliveryDate = new Date();
		order.setDeliveryDate(deliveryDate);
		order.setTotalPrice(13.52);
		
		// insert order in the orders table in the database
		try {
			managerOrders.insert(order);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos: " + e);
		}
		
		// testSelect()
		Order result = new Order();
		try {
			result = managerOrders.select(order);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// the attributes of the objects are compared to see if they are equal
		assertEquals(result.getCustomer().getId(), order.getCustomer().getId());
		assertEquals(result.getAddress().getId(), 1, order.getAddress().getId());
		assertEquals(result.getShoppingCart().getId(), order.getShoppingCart().getId());
		assertEquals(result.getPayment().getId(), order.getPayment().getId());
		assertEquals(result.getStatus(), "Pending", order.getStatus());
		assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.getOrderDate()), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderDate));
		assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.getDeliveryDate()), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(deliveryDate));
		assertEquals(result.getTotalPrice(), 13.52, order.getTotalPrice());
		
		// testUpdate()
		order.setId(result.getId());
		order.setStatus("Shipped");
		Date newOrderDate = new Date();
		order.setOrderDate(newOrderDate);
		Date newDeliveryDate = new Date();
		order.setDeliveryDate(newDeliveryDate);
		order.setTotalPrice(25.56);
		
		try {
			managerOrders.update(order);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos: " + e);
		}
		
		// search of update
		try {
			result = managerOrders.select(order);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// the attributes of the objects are compared to see if they are updated
			assertEquals(result.getId(), 1, order.getId());
			assertEquals(result.getCustomer().getId(), 11, order.getCustomer().getId());
			assertEquals(result.getAddress().getId(), 10, order.getAddress().getId());
			assertEquals(result.getShoppingCart().getId(), 1, order.getShoppingCart().getId());
			assertEquals(result.getPayment().getId(), 25, order.getPayment().getId());
			assertEquals(result.getStatus(), "Shipped", order.getStatus());
			assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.getOrderDate()), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderDate));
			assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.getDeliveryDate()), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(deliveryDate));
			assertEquals(result.getTotalPrice(), 25.56, order.getTotalPrice());
		
		// testDelete()
		// order is deleted by id
		// expected result --> null
		try {
			managerOrders.delete(order);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos: " + e);
		}
		
		// search of delete
		try {
			result = managerOrders.select(order);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// the attribute value is null
		assertNull(result);
	}

}