package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.manager.ManagerCustomers;
import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.view.windows.UserManagerWindowComponents.CustomersTab;

class CustomersTabTest extends JFrame {

	private static final long serialVersionUID = 7642722694408607711L;
	private ManagerCustomers managerCustomers = null;
	private CustomersTab customersTab = null;

	public CustomersTabTest() {
		managerCustomers = new ManagerCustomers();
		customersTab = new CustomersTab();
	}

	@Test
	void ArrayListAVentanaTest() {
		// hacemos un select de todos los clientes que se van a mostrar en la tabla.

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

		// llamamos al metodo de la clase CustomersTab que se encarga de insertar los
		// clientes y devuelve una Jtable asi podemos comprobar que los datos se
		// muestran en la tabla.

		JTable table = customersTab.insertIntoTable(customers);

		// comprobamos que el tamaño de la lista customers es 3, es decir , se van a
		// mostrar 3 empleados en la tabla.

		assertEquals(customers.size(), 3);
// ahora comprobamos  que el numero de filas es  igual al tamaño de la lista de clientes que es 3.
		int rows = table.getModel().getRowCount();
		int columns = table.getModel().getColumnCount();

		assertEquals(rows, 3);
		assertEquals(columns, 12);

		// en la primera celda de cada fila va el id del cliente , comprobamos si el
		// valor
		// de la primera celda es igual al id del cliente.

		int idFirstRow = Integer.parseInt(table.getModel().getValueAt(0, 0).toString());
		int idSecondRow = Integer.parseInt(table.getModel().getValueAt(1, 0).toString());
		int idThirdRow = Integer.parseInt(table.getModel().getValueAt(2, 0).toString());
		assertEquals(customers.get(0).getId(), idFirstRow);
		assertEquals(customers.get(1).getId(), idSecondRow);
		assertEquals(customers.get(2).getId(), idThirdRow);

	}

}
