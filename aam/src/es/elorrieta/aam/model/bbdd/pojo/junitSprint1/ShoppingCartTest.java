package es.elorrieta.aam.model.bbdd.pojo.junitSprint1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.pojo.Address.Country;
import es.elorrieta.aam.model.bbdd.pojo.Order.Status;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.model.bbdd.pojo.Payment;
import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCartItem;
import es.elorrieta.aam.model.bbdd.pojo.EmployeeManagedOrders;
import java.util.ArrayList;

class ShoppingCartTest {
	private ShoppingCart shoppingCart = null;

	public ShoppingCartTest() {
		shoppingCart = new ShoppingCart();
	}

	@Test
	void constructortest() {
		assertEquals(shoppingCart.getId(), 0);
		assertEquals(shoppingCart.getTotalPrice(), 0, 0);
		assertEquals(shoppingCart.getDescount(), 0, 0);
		assertEquals(shoppingCart.getDateOfPurchase(), null);
		assertEquals(shoppingCart.getOrder(), null);
		assertEquals(shoppingCart.getShoppingCartItems(), null);

	}

	@Test
	void idGetterSetterTest() {
		shoppingCart.setId(11);
		assertEquals(shoppingCart.getId(), 11);

	}

	@Test
	void totalPriceGetterSetterTest() {
		shoppingCart.setTotalPrice(12.4);
		assertEquals(shoppingCart.getTotalPrice(), 0, 12.4);

	}

	@Test
	void descountGetterSetterTest() {
		shoppingCart.setDescount(0.5);
		assertEquals(shoppingCart.getDescount(), 0, 0.5);

	}

	@Test
	void dateOfParchaseGetterSetterTest() {
		try {
			shoppingCart.setDateOfPurchase(new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
		assertNotNull(shoppingCart.getDateOfPurchase());
		try {
			assertEquals(shoppingCart.getDateOfPurchase(), new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
	}

	@Test
	void orderGettersSettersTest() {

		Order order = new Order();
		order.setId(14440);
		try {
			order.setDeliveryDate(new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
		try {
			order.setOrderDate(new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
		order.setTotalPrice(129.123);
		order.setStatus(Status.Pending);
		Customer customer = new Customer();
		customer.setId(122);
		customer.setName("alex");
		customer.setLastName("robertson");
		customer.setNumberPhone("123456789");
		customer.setEmail("alex@gmail.com");
		customer.setPassword("XXX");
		customer.setImage(new File("foto.txt"));
		customer.setStatus(false);

		order.setCustomer(customer);
		Payment payment = new Payment();
		payment.setId(122);
		payment.setIban("123456789087654");
		payment.setCvv("123456");
		try {
			payment.setExpirationDate(new SimpleDateFormat("dd/MM/yyyy").parse("00/12/2024"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
		order.setPayment(payment);
		Address address = new Address();
		address.setId(11);
		address.setStreet("calle san ignacio 12");
		address.setCodPostal("48004");
		address.setCity("Bilbao");
		address.setProvince("Bizkaia");
		address.setCountry(Country.SPAIN);
		order.setAddress(address);
		EmployeeManagedOrders employee = new EmployeeManagedOrders();
		employee.setId(12344);
		employee.setEmail("employee123@gmail.com");
		employee.setPassword("1234");
		order.setEmployeeManagedOrders(employee);
		shoppingCart.setOrder(order);
		assertNotNull(shoppingCart.getOrder());
		assertEquals(shoppingCart.getOrder(), order);
		assertEquals(shoppingCart.getOrder().getId(), 14440);
		assertEquals(shoppingCart.getOrder().getCustomer().getId(), 122);
		assertEquals(shoppingCart.getOrder().getAddress().getCountry(), Country.SPAIN);
	}

	@Test
	void ShoppingCartItemGettersSettersTest() {
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
		shoppingCartItem.setId(1222);
		shoppingCartItem.setPrice(12);
		shoppingCartItem.setQuantity(2);
		List<ShoppingCartItem> shoppingCartItems = new ArrayList<ShoppingCartItem>();
		shoppingCartItems.add(shoppingCartItem);
		shoppingCart.setShoppingCartItems(shoppingCartItems);
		assertNotNull(shoppingCart.getShoppingCartItems());
		assertEquals(shoppingCart.getShoppingCartItems(), shoppingCartItems);
		assertEquals(shoppingCart.getShoppingCartItems().size(), 1);
		assertEquals(shoppingCart.getShoppingCartItems().get(0).getId(), 1222);

	}

	@Test
	void ShoppingCartToStringTest() {
		shoppingCart.setId(11);
		shoppingCart.setTotalPrice(12.4);
		shoppingCart.setDescount(0.5);
		try {
			shoppingCart.setDateOfPurchase(new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}

		Order order = new Order();
		order.setId(14440);
		shoppingCart.setOrder(order);
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
		shoppingCartItem.setId(1222);
		shoppingCartItem.setPrice(12);
		shoppingCartItem.setQuantity(2);
		List<ShoppingCartItem> shoppingCartItems = new ArrayList<ShoppingCartItem>();
		shoppingCartItems.add(shoppingCartItem);
		shoppingCart.setShoppingCartItems(shoppingCartItems);
		String expected = "ShoppingCart [id=11, totalPrice=12.4, descount=0.5, dateOfPurchase=Sat Apr 29 00:00:00 CEST 2023, order=Order [id=14440, deliveryDate=null, orderDate=null, totalPrice=0.0, status=null, payment=null, shoppingCart=null, customer=null, address=null, EmployeeManagedOrders=null], shoppingCartItems=[ShoppingCartItem [id=1222, price=12.0, quantity=2, shoppingCart=null, productItem=null]]]";
		assertEquals(shoppingCart.toString(), expected);

	}

}
