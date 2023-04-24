package es.elorrieta.aam.model.bbdd.pojo.junitSprint1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.Address.Country;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Payment;

class PaymentTest {
	private Payment payment = null;

	public PaymentTest() {
		payment = new Payment();
	}

	@Test
	void constructortest() {
		assertEquals(payment.getId(), 0);
		assertEquals(payment.getIban(), null);
		assertEquals(payment.getCvv(), null);
		assertEquals(payment.getExpirationDate(), null);
		assertEquals(payment.getOrder(), null);
	}

	@Test
	void idGetterSetterTest() {
		payment.setId(122);
		assertEquals(payment.getId(), 122);
	}

	@Test
	void ibanGetterSetterTest() {
		payment.setIban("123456789087654");
		assertNotNull(payment.getIban());
		assertEquals(payment.getIban(), "123456789087654");
	}

	@Test
	void cvvGetterSetterTest() {
		payment.setCvv("123456");
		assertNotNull(payment.getCvv());
		assertEquals(payment.getCvv(), "123456");
	}

	@Test
	void expirationDateGetterSetterTest() {
		try {
			payment.setExpirationDate(new SimpleDateFormat("dd/MM/yyyy").parse("00/12/2024"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
		assertNotNull(payment.getExpirationDate());
		try {
			assertEquals(payment.getExpirationDate(), new SimpleDateFormat("dd/MM/yyyy").parse("00/12/2024"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
	}

	@Test
	void odrerTest() {
		Order order = new Order();
		order.setId(344);
		Address address = new Address();
		address.setId(11);
		address.setStreet("calle san ignacio 12");
		address.setCodPostal("48004");
		address.setCity("Bilbao");
		address.setProvince("Bizkaia");
		address.setCountry(Country.SPAIN);
		order.setAddress(address);
		payment.setOrder(order);
		assertNotNull(payment.getOrder());
		assertEquals(payment.getOrder().getId(), 344);
		assertEquals(payment.getOrder().getAddress(), address);

	}

	@Test
	void paymentToStringTest() {
		payment.setId(122);
		payment.setIban("123456789087654");
		payment.setCvv("123456");
		try {
			payment.setExpirationDate(new SimpleDateFormat("dd/MM/yyyy").parse("00/12/2024"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
		Order order = new Order();
		order.setId(344);
		Address address = new Address();
		address.setId(11);
		address.setStreet("calle san ignacio 12");
		address.setCodPostal("48004");
		address.setCity("Bilbao");
		address.setProvince("Bizkaia");
		address.setCountry(Country.SPAIN);
		order.setAddress(address);
		payment.setOrder(order);
		String expected = "Payment [id=122, iban=123456789087654, cvv=123456, expirationDate=Sat Nov 30 00:00:00 CET 2024, order=Order [id=344, deliveryDate=null, orderDate=null, totalPrice=0.0, status=null, payment=null, shoppingCart=null, customer=null, address=Address [id=11, street=calle san ignacio 12, codPostal=48004, city=Bilbao, province=Bizkaia, country=SPAIN], EmployeeManagedOrders=null]]";
		assertEquals(payment.toString(), expected);

	}
}
