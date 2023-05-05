package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.manager.ManagerPayments;
import es.elorrieta.aam.model.bbdd.pojo.Payment;

class ManagerPaymentsTest {

	private Payment payment = null;
	private ManagerPayments managerPayments = null;
	
	public ManagerPaymentsTest() {
		payment = new Payment();
		managerPayments = new ManagerPayments();
	}
	
	@Test
	void testInsertSelectUpdateDelete() {
		// testInsert()
		payment.setId(1);
		payment.setIban("123456789012345");
		payment.setCvv("123");
		Date expirationDate = new Date();
		payment.setExpirationDate(expirationDate);
		
		// insert order in the payments table in the database
		try {
			managerPayments.insert(payment);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos: " + e);
		}
		
		// testSelect()
		Payment result = new Payment();
		try {
			result = managerPayments.select(payment);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// the attributes of the objects are compared to see if they are equal
		assertEquals(result.getIban(), payment.getIban());
		assertEquals(result.getCvv(), payment.getCvv());
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").format(result.getExpirationDate()), 
				new SimpleDateFormat("yyyy-MM-dd").format(expirationDate));
		
		// testUpdate()
		payment.setId(result.getId());
		payment.setIban("543210987654321");
		payment.setCvv("321");
		Date newExpirationDate = new Date();
		payment.setExpirationDate(newExpirationDate);
		
		try {
			managerPayments.update(payment);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos: " + e);
		}
		
		// search of update
		try {
			result = managerPayments.select(payment);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// the attributes of the objects are compared to see if they are updated
		assertEquals(result.getId(), 1);
		assertEquals(result.getIban(), payment.getIban());
		assertEquals(result.getCvv(), payment.getCvv());
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").format(result.getExpirationDate()), new SimpleDateFormat("yyyy-MM-dd").format(payment.getExpirationDate()));
		
		// testDelete()
		// payment is deleted by id
		// expected result --> null
		try {
			managerPayments.delete(payment);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println("NO se ha podido conectar ala base de datos: " + e);
		}
		
		// search of delete
		try {
			result = managerPayments.select(payment);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// the attribute value is null
		assertNull(result);
	}

}