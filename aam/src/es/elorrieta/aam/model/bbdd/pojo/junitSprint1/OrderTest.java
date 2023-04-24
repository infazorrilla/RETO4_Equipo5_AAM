package es.elorrieta.aam.model.bbdd.pojo.junitSprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.pojo.Address.Country;
import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.model.bbdd.pojo.Payment;
import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;
import es.elorrieta.aam.model.bbdd.pojo.EmployeeManagedOrders;
import es.elorrieta.aam.model.bbdd.pojo.Order.Status;

class OrderTest {
	private Order order = null;

	public OrderTest() {
		order = new Order();
	}

	@Test
	void Constructortest() {
		assertEquals(order.getId(), 0);
		assertEquals(order.getDeliveryDate(), null);
		assertEquals(order.getOrderDate(), null);
		assertEquals(order.getTotalPrice(), 0);
		assertEquals(order.getStatus(), null);
		assertEquals(order.getPayment(), null);
		assertEquals(order.getShoppingCart(), null);
		assertEquals(order.getCustomer(), null);
		assertEquals(order.getAddress(), null);
		assertEquals(order.getEmployeeManagedOrders(), null);

	}

	@Test
	void idGetterSettertest() {
		order.setId(14440);
		assertEquals(order.getId(), 14440);
	}

	@Test
	void deliveryDateGetterSettertest() {
		try {
			order.setDeliveryDate(new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
		assertNotNull(order.getDeliveryDate());
		try {
			assertEquals(order.getDeliveryDate(), new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}

	}

	@Test
	void orderDateGetterSettertest() {
		try {
			order.setOrderDate(new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
		assertNotNull(order.getOrderDate());
		try {
			assertEquals(order.getOrderDate(), new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}

	}

	@Test
	void totalPriceGetterSettertest() {
		order.setTotalPrice(129.123);
		assertEquals(order.getTotalPrice(), 129.123);
	}

	@Test
	void statusGetterSettertest() {
		order.setStatus(Status.Pending);
		assertNotNull(order.getStatus());
		assertEquals(order.getStatus(), Status.Pending);

	}

	@Test
	void PaymentTest() {
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
		assertNotNull(order.getPayment());
		assertEquals(order.getPayment(), payment);
	}

	@Test
	void customerTest() {
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
		assertNotNull(order.getCustomer());
		assertEquals(order.getCustomer(), customer);
		assertEquals(order.getCustomer().getId(), 122);

	}

	@Test
	void adressTest() {
		Address address = new Address();
		address.setId(11);
		address.setStreet("calle san ignacio 12");
		address.setCodPostal("48004");
		address.setCity("Bilbao");
		address.setProvince("Bizkaia");
		address.setCountry(Country.SPAIN);
		order.setAddress(address);
		assertNotNull(order.getAddress());
		assertEquals(order.getAddress(), address);
		assertEquals(order.getAddress().getCountry(), Country.SPAIN);
	}

	@Test
	void employeeManagedOrdersTest() {
		EmployeeManagedOrders employee = new EmployeeManagedOrders();
		employee.setId(12344);
		employee.setEmail("employee123@gmail.com");
		employee.setPassword("1234");
		order.setEmployeeManagedOrders(employee);
		assertNotNull(order.getEmployeeManagedOrders());
		assertEquals(order.getEmployeeManagedOrders(), employee);
		assertEquals(order.getEmployeeManagedOrders().getId(), 12344);

	}

	@Test
	void shoppingCartTest() {
		ShoppingCart cart = new ShoppingCart();
		cart.setId(3333);
		try {
			cart.setDateOfPurchase(new SimpleDateFormat("dd/MM/yyyy").parse("00/12/2024"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
		cart.setDescount(0.5);
		cart.setTotalPrice(120.99);
		order.setShoppingCart(cart);
		assertNotNull(order.getShoppingCart());
		assertEquals(order.getShoppingCart(), cart);
		assertEquals(order.getShoppingCart().getId(), 3333);
	}

	@Test
	void shoppingCartToStringTest() {
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
		ShoppingCart cart = new ShoppingCart();
		cart.setId(3333);
		try {
			cart.setDateOfPurchase(new SimpleDateFormat("dd/MM/yyyy").parse("00/12/2024"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
		cart.setDescount(0.5);
		cart.setTotalPrice(120.99);
		order.setShoppingCart(cart);
		String expected = "Order [id=14440, deliveryDate=Sat Apr 29 00:00:00 CEST 2023, orderDate=Sat Apr 29 00:00:00 CEST 2023, totalPrice=129.123, status=Pending, payment=Payment [id=122, iban=123456789087654, cvv=123456, expirationDate=Sat Nov 30 00:00:00 CET 2024, order=null], shoppingCart=ShoppingCart [id=3333, totalPrice=120.99, descount=0.5, dateOfPurchase=Sat Nov 30 00:00:00 CET 2024, order=null, shoppingCartItems=null], customer=Customer [Id()=122,Name()=alex,LastName()=robertson, NumberPhone()=123456789, Email()=alex@gmail.com,Address()=null, Password()=XXX, isStatus()=false,Image()=foto.txt,Profile()=null], address=Address [id=11, street=calle san ignacio 12, codPostal=48004, city=Bilbao, province=Bizkaia, country=SPAIN], EmployeeManagedOrders=Employee [employeeType=0]]";
		assertEquals(order.toString(), expected);
	}
}
