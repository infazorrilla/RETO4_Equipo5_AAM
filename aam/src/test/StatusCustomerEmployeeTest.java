package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.manager.ManagerCustomers;
import es.elorrieta.aam.model.bbdd.manager.ManagerEmployee;
import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.model.bbdd.pojo.EmployeeManagedOrders;

class StatusCustomerEmployeeTest {

	private Customer customer = null;
	private ManagerCustomers managerCustomers = null;
	private EmployeeManagedOrders employeeManagedOrders = null;
	private ManagerEmployee managerEmployee = null;
	
	public StatusCustomerEmployeeTest() {
		customer = new Customer();
		managerCustomers = new ManagerCustomers();
		employeeManagedOrders = new EmployeeManagedOrders();
		managerEmployee = new ManagerEmployee();
	}
	
	@Test
	void testStatusCustomer() {
		customer.setEmail("customer2@gmail.com");
		customer.setPassword("Customer123/");
		
		Customer result = new Customer();
		try {
			result = managerCustomers.select(customer);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		assertNotNull(result);
		int value = result.isStatus() == false ? 0 : 1;
		assertEquals(value, 0);
		assertFalse(result.isStatus());
	}
	
	@Test
	void testStatusEmployee() {
		employeeManagedOrders.setEmail("admin123@gmail.com");
		employeeManagedOrders.setPassword("Admin123/");
		
		EmployeeManagedOrders result = new EmployeeManagedOrders();
		try {
			result = managerEmployee.select(employeeManagedOrders);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		assertNotNull(result);
		int value = result.isStatus() == false ? 0 : 1;
		assertEquals(value, 0);
	}

}