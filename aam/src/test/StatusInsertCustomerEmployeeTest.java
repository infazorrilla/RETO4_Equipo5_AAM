package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.manager.ManagerCustomers;
import es.elorrieta.aam.model.bbdd.manager.ManagerEmployee;
import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.model.bbdd.pojo.EmployeeManagedOrders;

public class StatusInsertCustomerEmployeeTest {

	private Customer customer = null;
	private ManagerCustomers managerCustomers = null;
	private EmployeeManagedOrders employeeManagedOrders = null;
	private ManagerEmployee managerEmployee = null;
	
	public StatusInsertCustomerEmployeeTest() {
		customer = new Customer();
		managerCustomers = new ManagerCustomers();
		employeeManagedOrders = new EmployeeManagedOrders();
		managerEmployee = new ManagerEmployee();
	}

	@Test
	void testStatusCustomer() throws ParseException {
		customer.setLastName("patata");
		customer.setName("tomate");
		customer.setEmail("exampleCustomer@gmail.com");
		customer.setPassword("ExampleCustomer123/");
		
		String cumple = "2001-11-23";
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormateada = (Date) formato.parse(cumple);
		
		customer.setBirthDate(dataFormateada);
		
		try {
			managerCustomers.insert(customer);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos: " + e);
		}
		
		Customer result = new Customer();
		try {
			result = managerCustomers.select(customer);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		int value = result.isStatus() == false ? 0 : 1;
		assertEquals(value, 0);
		assertFalse(result.isStatus());
		assertEquals(result.getLastName(), customer.getLastName());
	}
	
	@Test
	void testStatusEmployee() throws ParseException {
		employeeManagedOrders.setEmail("exampleEmployee@gmail.com");
		employeeManagedOrders.setPassword("ExampleEmployee123/");
		employeeManagedOrders.setEmployeeType(2);
		
		String cumple = "2001-11-23";
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormateada = (Date) formato.parse(cumple);
		
		employeeManagedOrders.setBirthDate(dataFormateada);
		
		try {
			managerEmployee.insert(employeeManagedOrders);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos: " + e);
		}
		
		EmployeeManagedOrders result = new EmployeeManagedOrders();
		try {
			result = managerEmployee.select(employeeManagedOrders);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		int value = result.isStatus() == false ? 0 : 1;
		assertEquals(value, 0);
	}

}