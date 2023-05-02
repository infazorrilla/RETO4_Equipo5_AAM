package es.elorrieta.aam.view.windows.UserManagerWindowComponents;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.manager.ManagerCustomers;
import es.elorrieta.aam.model.bbdd.pojo.Customer;

public class CustomersTab {
	private JTable customersTable;
	private JButton btnBlocCustomer;
	private JButton btnDesblockUser;

	public JPanel panelCustomers() {

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1207, 661);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 5, 1207, 427);
		panel.add(scrollPane);
		customersTable = new JTable();
		customersTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "ID", "nombre", "Apellidos", "Email", "Contrase\u00F1a", "Fecha De Necimiento",
						"Direccion", "CodPostal", "Ciudad", "Provincia", "Pais", "\u00BFEsta Bloqueado?" }));

		scrollPane.setViewportView(customersTable);

		btnBlocCustomer = new JButton("Bloquear Cliente ");
		btnBlocCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (customersTable.getSelectedRow() != -1) {
					if (isBlockedUser()) {
						JOptionPane.showMessageDialog(null, "este Usuario ya esta bloqueado ");
					} else {
						try {
							blockCustomer(true);
							doInsertInfoCustIntoTable();
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(panel, "Data Base Error. Contents cannot be displayed",
									"ERROR!!", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (AccessToDataBaseException e1) {
							JOptionPane.showMessageDialog(panel, "Data Base Access. Coundn't connect to data base  ",
									"ERROR!!", JOptionPane.ERROR_MESSAGE);
						} catch (NotFoundException e1) {
							JOptionPane.showMessageDialog(panel, "Data Base is empty", "ERROR!!",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(panel, "Generic error...", "ERROR!!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ningun Cliente seleccionado");
				}

			}
		});
		btnBlocCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBlocCustomer.setBounds(273, 482, 183, 41);
		panel.add(btnBlocCustomer);

		btnDesblockUser = new JButton("Desbloquear Cliente");
		btnDesblockUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (customersTable.getSelectedRow() != -1) {
					if (!isBlockedUser()) {
						JOptionPane.showMessageDialog(null, "este Usuario ya esta desbloqueado ");
					} else {
						try {
							blockCustomer(false);
							doInsertInfoCustIntoTable();
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(panel, "Data Base Error. Contents cannot be displayed",
									"ERROR!!", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (AccessToDataBaseException e1) {
							JOptionPane.showMessageDialog(panel, "Data Base Access. Coundn't connect to data base  ",
									"ERROR!!", JOptionPane.ERROR_MESSAGE);
						} catch (NotFoundException e1) {
							JOptionPane.showMessageDialog(panel, "Data Base is empty", "ERROR!!",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(panel, "Generic error...", "ERROR!!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ningun Cliente seleccionado");
				}

			}
		});
		btnDesblockUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDesblockUser.setBounds(705, 482, 200, 41);
		panel.add(btnDesblockUser);

		try {
			doInsertInfoCustIntoTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return panel;
	}

	private void doInsertInfoCustIntoTable()
			throws SQLException, AccessToDataBaseException, NotFoundException, Exception {

		List<Customer> customers = null;
		ManagerCustomers managerCustomers = new ManagerCustomers();
		customers = managerCustomers.selectAll();

		insertInfoCustIntoTable(customers);
	}

	private void insertInfoCustIntoTable(List<Customer> customers) {

		DefaultTableModel model = (DefaultTableModel) customersTable.getModel();
		customersTable.removeAll();
		model.setRowCount(0);
		for (Customer customer : customers) {
			model.addRow(new String[] { customer.getId() + "", customer.getName() == null ? "" : customer.getName(),
					customer.getLastName() == null ? "" : customer.getLastName(),
					customer.getEmail() == null ? "" : customer.getEmail(),
					customer.getPassword() == null ? "" : customer.getPassword(),
					customer.getBirthDate() == null ? ""
							: new SimpleDateFormat("dd-MM-yyyy").format(customer.getBirthDate()),
					customer.getAddress() == null ? "" : customer.getAddress().getStreet(),
					customer.getAddress() == null ? "" : customer.getAddress().getCodPostal(),
					customer.getAddress() == null ? "" : customer.getAddress().getCity(),
					customer.getAddress() == null ? "" : customer.getAddress().getProvince(),
					customer.getAddress() == null ? "" : customer.getAddress().getCountry(),
					customer.isStatus() == false ? "NO" : "SI" });
		}
	}

	private boolean isBlockedUser() {
		return customersTable.getModel().getValueAt(customersTable.getSelectedRow(), 11).toString()
				.equalsIgnoreCase("SI");

	}

	private void blockCustomer(Boolean status)
			throws SQLException, AccessToDataBaseException, NotFoundException, Exception {

		Customer customer = new Customer();
		customer.setId(
				Integer.parseInt(customersTable.getModel().getValueAt(customersTable.getSelectedRow(), 0).toString()));
		customer.setStatus(status);
		ManagerCustomers managerCustomers = new ManagerCustomers();
		managerCustomers.updateCustomerStatus(customer);
	}
}
