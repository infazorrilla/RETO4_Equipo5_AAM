package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.controller.ReadWriteFromFile;
import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.manager.ManagerCustomers;
import es.elorrieta.aam.model.bbdd.pojo.Customer;

class ManagerCustomersTest {

	private ManagerCustomers managerCustomers = null;
	private ReadWriteFromFile readWriteFromFile = null;

	public ManagerCustomersTest() {

		managerCustomers = new ManagerCustomers();
		readWriteFromFile = new ReadWriteFromFile();
	}

	@Test
	void AccesoAbaseDeDatosInclusiónArraylistYLOGTxtDesdeArraylist() {
//primero comprobamos el acceso a la base de datos haciedo un selectAll() de todos los clientes de nuestra aplicacion
		List<Customer> customers = null;
		try {
			customers = managerCustomers.selectAll();
		} catch (SQLException e) {
			System.out.println("SQLException Error: " + e);
		} catch (NotFoundException e) {
			System.out.println("NotFoundException: " + e);
		} catch (AccessToDataBaseException e) {
			System.out.println("AccessToDataBaseException: " + e);
		} catch (Exception e) {
			System.out.println("Generic Error : " + e);
		}

		// test acceso a base de datos comprobando que el resultado distinto que null

		assertNotNull(customers);

		// comprobamos que el array es de tamaño 3 . 3 clientes

		assertEquals(customers.size(), 3);

		// comprobamos los ides de los clientes ,
		// cliente 1 -> ID= 9 , email = user123@gmail.com , password = User1234/

		// cliente 2 -> ID = 10 ,email = user12@gmail.com , password = User12A/
		// cliente 3 -> ID= 11, email = susi123@gmail.com , password = Susi1234/

		// cliente 1
		assertEquals(customers.get(0).getId(), 9);
		assertEquals(customers.get(0).getEmail(), "user123@gmail.com");
		assertEquals(customers.get(0).getPassword(), "User1234/");

		// cliente 2
		assertEquals(customers.get(1).getId(), 10);
		assertEquals(customers.get(1).getEmail(), "user12@gmail.com");
		assertEquals(customers.get(1).getPassword(), "User12A/");
		// cliente 3
		assertEquals(customers.get(2).getId(), 11);
		assertEquals(customers.get(2).getEmail(), "susi123@gmail.com");
		assertEquals(customers.get(2).getPassword(), "Susi1234/");

		// guardamos el contenido del array en un fichero LOG.txt
		readWriteFromFile.writeToFile(customers);

		// leemos el fichero LOG.txt.

		List<Customer> customersFromFile = readWriteFromFile.readFromFile();

		// comprabomas si se ha creado LOG.txt y que el fichero no esta vacio.
		File file = new File("LOG.txt");

		// devuelve un true si existe el fichero
		assertTrue(file.exists());
		// devuelve un true si el fichero no esta vacio
		assertTrue(file.length() != 0);

		// comparamos el contenido del fichero con el
		// resultado de la base de datos.
		assertEquals(customersFromFile, customers);

	}

}
