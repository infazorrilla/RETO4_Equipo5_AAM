package es.elorrieta.aam.model.bbdd.pojo.junitSprint1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.Address.Country;

class AddressTest {
	private Address address = null;

	public AddressTest() {
		address = new Address();
	}

	@Test
	void constructorTest() {
		assertEquals(address.getId(), 0);
		assertEquals(address.getStreet(), null);
		assertEquals(address.getCodPostal(), null);
		assertEquals(address.getCity(), null);
		assertEquals(address.getProvince(), null);
		assertEquals(address.getCountry(), null);
	}

	@Test
	void idGetterSetterTest() {
		address.setId(11);
		assertEquals(address.getId(), 11);
	}

	@Test
	void streetGetterSetterTest() {
		address.setStreet("calle san ignacio 12");
		assertNotNull(address.getStreet());
		assertEquals(address.getStreet(), "calle san ignacio 12");
	}

	@Test
	void codPostalGetterSetterTest() {
		address.setCodPostal("48004");
		assertNotNull(address.getCodPostal());
		assertEquals(address.getCodPostal(), "48004");
	}

	@Test
	void cityGetterSetterTest() {
		address.setCity("Bilbao");
		assertNotNull(address.getCity());
		assertEquals(address.getCity(), "Bilbao");
	}

	@Test
	void provinceGetterSetterTest() {
		address.setProvince("Bizkaia");
		assertNotNull(address.getProvince());
		assertEquals(address.getProvince(), "Bizkaia");
	}

	@Test
	void countryGetterSetterTest() {
		address.setCountry(Country.SPAIN);
		assertNotNull(address.getCountry());
		assertEquals(address.getCountry(), Country.SPAIN);
	}

	@Test
	void adressToStringTest() {
		address.setId(11);
		address.setStreet("calle san ignacio 12");
		address.setCodPostal("48004");
		address.setCity("Bilbao");
		address.setProvince("Bizkaia");
		address.setCountry(Country.SPAIN);
		String expected = "Address [id=11, street=calle san ignacio 12, codPostal=48004, city=Bilbao, province=Bizkaia, country=SPAIN]";
		assertEquals(address.toString(), expected);

	}

}