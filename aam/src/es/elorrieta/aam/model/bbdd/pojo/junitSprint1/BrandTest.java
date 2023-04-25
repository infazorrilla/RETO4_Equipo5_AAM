package es.elorrieta.aam.model.bbdd.pojo.junitSprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.pojo.Brand;
import es.elorrieta.aam.model.bbdd.pojo.Brand.Brands;
import es.elorrieta.aam.model.bbdd.pojo.Product;
import es.elorrieta.aam.model.bbdd.pojo.EmployeeManagedStore;

import es.elorrieta.aam.model.bbdd.pojo.Product.Category;

class BrandTest {
	private Brand brand = null;

	public BrandTest() {
		brand = new Brand();
	}

	@Test
	void contructorTest() {
		assertEquals(brand.getId(), 0);
		assertEquals(brand.getEmployeesManagedStore(), null);
		assertEquals(brand.getProduct(), null);
		assertEquals(brand.getValue(), null);
	}

	@Test
	void idGetterSettertest() {
		brand.setId(1234);
		assertEquals(brand.getId(), 1234);
	}

	@Test
	void EmployeesManagedStoreGettersSetterstest() {
		EmployeeManagedStore employee = new EmployeeManagedStore();
		employee.setId(12344);
		employee.setEmail("employee123@gmail.com");
		employee.setPassword("1234");
		EmployeeManagedStore employee2 = new EmployeeManagedStore();
		employee2.setId(123333);
		employee2.setEmail("employee23@gmail.com");
		employee2.setPassword("DD123");
		List<EmployeeManagedStore> employees = new ArrayList<EmployeeManagedStore>();
		employees.add(employee);
		employees.add(employee2);
		brand.setEmployeesManagedStore(employees);
		assertNotNull(brand.getEmployeesManagedStore());
		assertEquals(brand.getEmployeesManagedStore().size(), 2);
		assertEquals(brand.getEmployeesManagedStore().get(1).getId(), 123333);

	}

	@Test
	void productGettersSetterstest() {
		Product product = new Product();
		product.setId(1234);
		product.setCategory(Category.Tshirt);
		try {
			product.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");

		}
		brand.setProduct(product);
		assertNotNull(brand.getProduct());
		assertEquals(brand.getProduct().getId(), 1234);
		assertEquals(brand.getProduct().getCategory(), Category.Tshirt);
	}

	@Test
	void valueGettersSetterstest() {
		brand.setValue(Brands.NIKE);
		assertNotNull(brand.getValue());
		assertEquals(brand.getValue(), Brands.NIKE);
	}

	@Test
	void brandToStringTest() {
		brand.setId(1234);
		EmployeeManagedStore employee = new EmployeeManagedStore();
		employee.setId(12344);
		employee.setEmail("employee123@gmail.com");
		employee.setPassword("1234");
		EmployeeManagedStore employee2 = new EmployeeManagedStore();
		employee2.setId(123333);
		employee2.setEmail("employee23@gmail.com");
		employee2.setPassword("DD123");
		List<EmployeeManagedStore> employees = new ArrayList<EmployeeManagedStore>();
		employees.add(employee);
		employees.add(employee2);
		brand.setEmployeesManagedStore(employees);
		brand.setValue(Brands.NIKE);
		String expected = "Brand [id=1234, product=null, value=NIKE, employeesManagedStore=[EmployeeManagedStore [brands=null, getEmployeeType()=0 getId()=12344, getName()=null, getLastName()=null, getNumberPhone()=null, getEmail()=employee123@gmail.com, getAddress()=null, getPassword()=1234, isStatus()=true, getImage()=null, getProfile()=null], EmployeeManagedStore [brands=null, getEmployeeType()=0 getId()=123333, getName()=null, getLastName()=null, getNumberPhone()=null, getEmail()=employee23@gmail.com, getAddress()=null, getPassword()=DD123, isStatus()=true, getImage()=null, getProfile()=null]]]";
		assertEquals(brand.toString(), expected);
	}
}
