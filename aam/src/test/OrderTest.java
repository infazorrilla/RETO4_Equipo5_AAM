package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.model.bbdd.pojo.EmployeeManagedOrders;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Order.Status;
import es.elorrieta.aam.model.bbdd.pojo.Payment;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;
import es.elorrieta.aam.model.bbdd.pojo.Address.Country;

class OrderTest {

	private Order order = null;
	
	public OrderTest() {
		order = new Order();
	}
	
	public void testConstructor() {
		assertEquals(order.getId(), 0);
		assertEquals(order.getPayment(), null);
		assertEquals(order.getShoppingCart(), null);
		assertEquals(order.getCustomer(), null);
		assertEquals(order.getAddress(), null);
		assertEquals(order.getEmployeeManagedOrders(), null);
		assertEquals(order.getDeliveryDate(), null);
		assertEquals(order.getOrderDate(), null);
		assertEquals(order.getTotalPrice(), 0);
		assertEquals(order.getStatus(), null);
	}
	
	@Test
	void testId() {
		int id = 1;
		order.setId(id);
		
		assertEquals(order.getId(), 1);
	}
	
	@Test
	void testPayment() {
		Payment payment = new Payment();
		
		int id = 1;
		String iban = "123456789012345";
		String cvv = "123456";
		String expirationDate = "15/08/2026";
		
		payment.setId(id);
		payment.setIban(iban);
		payment.setCvv(cvv);
		try {
			payment.setExpirationDate(new SimpleDateFormat("dd/mm/yyyy").parse(expirationDate));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
		order.setPayment(payment);
		
		assertNotNull(order.getPayment());
		assertEquals(order.getPayment(), payment);
		assertEquals(order.getPayment().getId(), 1);
	}
	
	@Test
	void testShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		
		int id = 1;
		double descount = 0.5;
		double totalPrice = 105.99;
		String dateOfPurchase = "08/10/2025";
		
		shoppingCart.setId(id);
		shoppingCart.setDescount(descount);
		shoppingCart.setTotalPrice(totalPrice);
		try {
			shoppingCart.setDateOfPurchase(new SimpleDateFormat("dd/mm/yyyy").parse(dateOfPurchase));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
		order.setShoppingCart(shoppingCart);
		
		assertNotNull(order.getShoppingCart());
		assertEquals(order.getShoppingCart(), shoppingCart);
		assertEquals(order.getShoppingCart().getId(), 1);
	}
	
	@Test
	void testCustomer() {
		Customer customer = new Customer();
		
		int id = 1;
		String name = "Carlos";
		String lastName = "Lopez Diaz";
		String numberPhone = "123456789";
		String email = "lodi@gmail.com";
		String password = "123456";
		boolean status = true;
		String image = "foto.txt";
		
		customer.setId(id);
		customer.setName(name);
		customer.setLastName(lastName);
		customer.setNumberPhone(numberPhone);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setStatus(status);
		customer.setImage(new File(image));
		order.setCustomer(customer);
		
		assertNotNull(order.getCustomer());
		assertEquals(order.getCustomer(), customer);
		assertEquals(order.getCustomer().getId(), 1);
	}
	
	@Test
	void testAddress() {
		Address address = new Address();
		
		int id = 1;
		String street = "Calle San Ignacio 12";
		String codPostar = "48004";
		String city = "Bilbao";
		String province = "Bizkaia";
		
		address.setId(id);
		address.setStreet(street);
		address.setCodPostal(codPostar);
		address.setCity(city);
		address.setProvince(province);
		address.setCountry(Country.SPAIN);
		order.setAddress(address);
		
		assertNotNull(order.getAddress());
		assertEquals(order.getAddress(), address);
		assertEquals(order.getAddress().getCountry(), Country.SPAIN);
	}
	
	@Test
	void testEmployeeManagedOrders() {
		EmployeeManagedOrders employeeManagedOrders = new EmployeeManagedOrders();
		
		int id = 1;
		String email = "employee@gmail.com";
		String password = "123456";
		
		employeeManagedOrders.setId(id);
		employeeManagedOrders.setEmail(email);
		employeeManagedOrders.setPassword(password);
		order.setEmployeeManagedOrders(employeeManagedOrders);
		
		assertNotNull(order.getEmployeeManagedOrders());
		assertEquals(order.getEmployeeManagedOrders(), employeeManagedOrders);
		assertEquals(order.getEmployeeManagedOrders().getId(), 1);
	}
	
	@Test
	void testDeliveryDate() {
		String deliveryDate = "24/04/2023";
		
		try {
			order.setDeliveryDate(new SimpleDateFormat("dd/mm/yyyy").parse(deliveryDate));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
		
		assertNotNull(order.getDeliveryDate());
		try {
			assertEquals(order.getDeliveryDate(), new SimpleDateFormat("dd/mm/yyyy").parse(deliveryDate));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
	}
	
	@Test
	void testOrderDate() {
		String orderDate = "24/04/2023";
		
		try {
			order.setOrderDate(new SimpleDateFormat("dd/mm/yyyy").parse(orderDate));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
		
		assertNotNull(order.getOrderDate());
		try {
			assertEquals(order.getOrderDate(), new SimpleDateFormat("dd/mm/yyyy").parse(orderDate));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
	}
	
	@Test
	void testTotalPrice() {
		double totalPrice = 138.12;
		
		order.setTotalPrice(totalPrice);
		
		assertEquals(order.getTotalPrice(), 138.12);
	}
	
	@Test
	void testStatus() {
		order.setStatus(Status.Pending);
		
		assertNotNull(order.getStatus());
		assertEquals(order.getStatus(), Status.Pending);
	}
	
	@Test
	void testToString() {
		int idOrder = 1;
		order.setId(idOrder);
		
		Payment payment = new Payment();
		int idPayment = 1;
		String iban = "123456789012345";
		String cvv = "123456";
		String expirationDate = "15/08/2026";
		payment.setId(idPayment);
		payment.setIban(iban);
		payment.setCvv(cvv);
		try {
			payment.setExpirationDate(new SimpleDateFormat("dd/mm/yyyy").parse(expirationDate));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
		order.setPayment(payment);
		
		ShoppingCart shoppingCart = new ShoppingCart();
		int idShoppingCart = 1;
		double descount = 0.5;
		double totalPrice = 105.99;
		String dateOfPurchase = "08/10/2025";
		shoppingCart.setId(idShoppingCart);
		shoppingCart.setDescount(descount);
		shoppingCart.setTotalPrice(totalPrice);
		try {
			shoppingCart.setDateOfPurchase(new SimpleDateFormat("dd/mm/yyyy").parse(dateOfPurchase));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
		order.setShoppingCart(shoppingCart);
		
		Customer customer = new Customer();
		int idCustomer = 1;
		String nameCustomer = "Carlos";
		String lastNameCustomer = "Lopez Diaz";
		String numberPhoneCustomer = "123456789";
		String emailCustomer = "lodi@gmail.com";
		String passwordCustomer = "123456";
		boolean statusCustomer = true;
		String imageCustomer = "foto.txt";
		customer.setId(idCustomer);
		customer.setName(nameCustomer);
		customer.setLastName(lastNameCustomer);
		customer.setNumberPhone(numberPhoneCustomer);
		customer.setEmail(emailCustomer);
		customer.setPassword(passwordCustomer);
		customer.setStatus(statusCustomer);
		customer.setImage(new File(imageCustomer));
		order.setCustomer(customer);
		
		Address address = new Address();
		int idAddress = 1;
		String streetAddress = "Calle San Ignacio 12";
		String codPostarAddress = "48004";
		String cityAddress = "Bilbao";
		String provinceAddress = "Bizkaia";
		address.setId(idAddress);
		address.setStreet(streetAddress);
		address.setCodPostal(codPostarAddress);
		address.setCity(cityAddress);
		address.setProvince(provinceAddress);
		address.setCountry(Country.SPAIN);
		order.setAddress(address);
		
		EmployeeManagedOrders employeeManagedOrders = new EmployeeManagedOrders();
		int idEmployeeManagedOrders = 1;
		String emailEmployeeManagedOrders = "employee@gmail.com";
		String passwordEmployeeManagedOrders = "123456";
		employeeManagedOrders.setId(idEmployeeManagedOrders);
		employeeManagedOrders.setEmail(emailEmployeeManagedOrders);
		employeeManagedOrders.setPassword(passwordEmployeeManagedOrders);
		order.setEmployeeManagedOrders(employeeManagedOrders);
		
		String deliveryDate = "24/04/2023";
		try {
			order.setDeliveryDate(new SimpleDateFormat("dd/mm/yyyy").parse(deliveryDate));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
		
		String orderDate = "24/04/2023";
		try {
			order.setOrderDate(new SimpleDateFormat("dd/mm/yyyy").parse(orderDate));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
		
		double totalPrice1 = 138.12;
		order.setTotalPrice(totalPrice1);
		
		order.setStatus(Status.Pending);
		
		String expected = "Order [id=1, "
				+ "deliveryDate=Tue Jan 24 00:04:00 CET 2023, "
				+ "orderDate=Tue Jan 24 00:04:00 CET 2023, "
				+ "totalPrice=138.12, "
				+ "status=Pending, "
				+ "payment=Payment [id=1, iban=123456789012345, cvv=123456, expirationDate=Thu Jan 15 00:08:00 CET 2026, order=null], "
				+ "shoppingCart=ShoppingCart [id=1, totalPrice=105.99, descount=0.5, dateOfPurchase=Wed Jan 08 00:10:00 CET 2025, order=null, shoppingCartItems=null], "
				+ "customer=Customer [Id()=1,Name()=Carlos,LastName()=Lopez Diaz, NumberPhone()=123456789, Email()=lodi@gmail.com,Address()=null, Password()=123456, isStatus()=true,Image()=foto.txt,Profile()=null], "
				+ "address=Address [id=1, street=Calle San Ignacio 12, codPostal=48004, city=Bilbao, province=Bizkaia, country=SPAIN], "
				+ "EmployeeManagedOrders=EmployeeManagedOrders [orders=null, getEmployeeType()=0 getId()=1, getName()=null, getLastName()=null, getNumberPhone()=null, getEmail()=employee@gmail.com, getAddress()=null, getPassword()=123456, isStatus()=true, getImage()=null, getProfile()=null]]";
		assertEquals(order.toString(), expected);
	}

}