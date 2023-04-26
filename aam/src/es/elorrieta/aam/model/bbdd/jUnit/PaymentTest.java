package es.elorrieta.aam.model.bbdd.jUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Payment;
import es.elorrieta.aam.model.bbdd.pojo.Address.Country;

class PaymentTest {

	private Payment payment = null;
	
	public PaymentTest() {
		payment = new Payment();
	}
	
	@Test
	void testConstructor() {
		assertEquals(payment.getId(), 0);
		assertEquals(payment.getOrder(), null);
		assertEquals(payment.getIban(), null);
		assertEquals(payment.getCvv(), null);
		assertEquals(payment.getExpirationDate(), null);
	}
	
	@Test
	void testId() {
		int id = 1;
		payment.setId(id);
		
		assertEquals(payment.getId(), 1);
	}
	
	@Test
	void testOrder() {
		Order order = new Order();
		
		int id = 1;
		String street = "Calle San Ignacio 12";
		String codPostar = "48004";
		String city = "Bilbao";
		String province = "Bizkaia";
		int idAddress = 1;
		
		order.setId(id);
		Address address = new Address();
		address.setId(idAddress);
		address.setStreet(street);
		address.setCodPostal(codPostar);
		address.setCity(city);
		address.setProvince(province);
		address.setCountry(Country.SPAIN);
		order.setAddress(address);
		payment.setOrder(order);
		
		assertNotNull(payment.getOrder());
		assertEquals(payment.getOrder().getId(), 1);
		assertEquals(payment.getOrder().getAddress(), address);
	}
	
	@Test
	void testIban() {
		String iban = "123456789012345";
		
		payment.setIban(iban);
		
		assertNotNull(payment.getIban());
		assertEquals(payment.getIban(), "123456789012345");
	}
	
	@Test
	void testCvv() {
		String cvv = "123456";
		
		payment.setCvv(cvv);
		
		assertNotNull(payment.getCvv());
		assertEquals(payment.getCvv(), "123456");
	}
	
	@Test
	void testExpirationDate() {
		String expirationDate = "15/08/2026";
		
		try {
			payment.setExpirationDate(new SimpleDateFormat("dd/mm/yyyy").parse(expirationDate));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
		
		assertNotNull(payment.getExpirationDate());
		try {
			assertEquals(payment.getExpirationDate(), new SimpleDateFormat("dd/mm/yyyy").parse(expirationDate));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
	}
	
	@Test
	void testToString() {
		int id = 1;
		payment.setId(id);
		
		int idOrder = 1;
		int idAddress = 1;
		String street = "Calle San Ignacio 12";
		String codPostar = "48004";
		String city = "Bilbao";
		String province = "Bizkaia";
		Order order = new Order();
		order.setId(idOrder);
		Address address = new Address();
		address.setId(idAddress);
		address.setStreet(street);
		address.setCodPostal(codPostar);
		address.setCity(city);
		address.setProvince(province);
		address.setCountry(Country.SPAIN);
		order.setAddress(address);
		payment.setOrder(order);
		
		String iban = "123456789012345";
		payment.setIban(iban);
		
		String cvv = "123456";
		payment.setCvv(cvv);
		
		String expirationDate = "15/08/2026";
		try {
			payment.setExpirationDate(new SimpleDateFormat("dd/mm/yyyy").parse(expirationDate));
		} catch (ParseException e) {
			System.out.println("Format incorret");
		}
		
		String expected = "Payment [id=1, "
				+ "iban=123456789012345, "
				+ "cvv=123456, "
				+ "expirationDate=Thu Jan 15 00:08:00 CET 2026, "
				+ "order=Order [id=1, deliveryDate=null, orderDate=null, totalPrice=0.0, status=null, payment=null, shoppingCart=null, customer=null, address=Address [id=1, street=Calle San Ignacio 12, codPostal=48004, city=Bilbao, province=Bizkaia, country=SPAIN], EmployeeManagedOrders=null]]";
		assertEquals(payment.toString(), expected);
	}

}