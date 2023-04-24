package es.elorrieta.aam.model.bbdd.pojo.junitSprint1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.pojo.Brand;
import es.elorrieta.aam.model.bbdd.pojo.Brand.Brands;
import es.elorrieta.aam.model.bbdd.pojo.Product;
import es.elorrieta.aam.model.bbdd.pojo.Product.Category;

class ProductTest {
	private Product product = null;

	public ProductTest() {
		product = new Product();
	}

	@Test
	void constructorTest() {
		assertEquals(product.getId(), 0);
		assertEquals(product.getCategory(), null);
		assertEquals(product.getDate(), null);
		assertEquals(product.getProductItems(), null);
		assertEquals(product.getBrand(), null);
	}

	@Test
	void idGetterSetterTest() {
		product.setId(1234);
		assertEquals(product.getId(), 1234);
	}

	@Test
	void categoryGetterSetterTest() {
		product.setCategory(Category.Tshirt);
		assertNotNull(product.getCategory());
		assertEquals(product.getCategory(), Category.Tshirt);

	}

	@Test
	void dateGetterSetterTest() {
		try {
			product.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}
		try {
			assertEquals(product.getDate(), new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}

	}

	@Test
	void brandGettersSettersTest() {
		Brand brand = new Brand();
		brand.setId(111);
		brand.setValue(Brands.NIKE);
		product.setBrand(brand);
		assertNotNull(product.getBrand());
		assertEquals(product.getBrand().getValue(), Brands.NIKE);
		assertEquals(product.getBrand().getId(), 111);
	}

	@Test
	void productToStringTest() {
		product.setId(1234);
		product.setCategory(Category.Tshirt);
		try {
			product.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");

		}
		Brand brand = new Brand();
		brand.setId(111);
		brand.setValue(Brands.NIKE);
		product.setBrand(brand);
		String expected = "Product [id=1234, category=Tshirt, date=Sat Apr 29 00:00:00 CEST 2023, productItems=null, brand=Brand [id=111, product=null, value=NIKE, employeesManagedStore=null]]";
		assertEquals(product.toString(), expected);
	}

}
