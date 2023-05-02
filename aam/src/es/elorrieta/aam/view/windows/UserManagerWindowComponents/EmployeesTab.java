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
import es.elorrieta.aam.model.bbdd.manager.ManagerEmployee;
import es.elorrieta.aam.model.bbdd.pojo.EmployeeManagedOrders;

public class EmployeesTab {
	private JTable employeesTable;
	private JButton btnBlocCustomer;
	private JButton btnDesblockUser;

	public JPanel panelEmployees() {

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1207, 661);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 5, 1207, 427);
		panel.add(scrollPane);
		employeesTable = new JTable();
		employeesTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "ID", "nombre", "Apellidos", "Email", "Contrase\u00F1a", "Fecha De Necimiento",
						"Direccion", "CodPostal", "Ciudad", "Provincia", "Pais", "\u00BFEsta Bloqueado?" }));

		scrollPane.setViewportView(employeesTable);

		btnBlocCustomer = new JButton("Bloquear Cliente ");
		btnBlocCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (employeesTable.getSelectedRow() != -1) {
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
					JOptionPane.showMessageDialog(null, "selecciona un cliente");
				}

			}
		});
		btnBlocCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBlocCustomer.setBounds(273, 482, 183, 41);
		panel.add(btnBlocCustomer);

		btnDesblockUser = new JButton("Desbloquear Cliente");
		btnDesblockUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (employeesTable.getSelectedRow() != -1) {
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
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(panel, "Data Base Error. Contents cannot be displayed", "ERROR!!",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		} catch (AccessToDataBaseException e1) {
			JOptionPane.showMessageDialog(panel, "Data Base Access. Coundn't connect to data base  ", "ERROR!!",
					JOptionPane.ERROR_MESSAGE);
		} catch (NotFoundException e1) {
			JOptionPane.showMessageDialog(panel, "Data Base is empty", "ERROR!!", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(panel, "Generic error...", "ERROR!!", JOptionPane.ERROR_MESSAGE);
		}

		return panel;
	}

	private void doInsertInfoCustIntoTable()
			throws SQLException, AccessToDataBaseException, NotFoundException, Exception {

		List<EmployeeManagedOrders> employees = null;
		ManagerEmployee managerEmployees = new ManagerEmployee();
		employees = managerEmployees.selectAll();

		insertInfoCustIntoTable(employees);
	}

	private void insertInfoCustIntoTable(List<EmployeeManagedOrders> employees) {

		DefaultTableModel model = (DefaultTableModel) employeesTable.getModel();
		employeesTable.removeAll();
		model.setRowCount(0);
		for (EmployeeManagedOrders employee : employees) {
			model.addRow(new String[] { employee.getId() + "", employee.getName() == null ? "" : employee.getName(),
					employee.getLastName() == null ? "" : employee.getLastName(),
					employee.getEmail() == null ? "" : employee.getEmail(),
					employee.getPassword() == null ? "" : employee.getPassword(),
					employee.getBirthDate() == null ? ""
							: new SimpleDateFormat("dd-MM-yyyy").format(employee.getBirthDate()),
					employee.getAddress() == null ? "" : employee.getAddress().getStreet(),
					employee.getAddress() == null ? "" : employee.getAddress().getCodPostal(),
					employee.getAddress() == null ? "" : employee.getAddress().getCity(),
					employee.getAddress() == null ? "" : employee.getAddress().getProvince(),
					employee.getAddress() == null ? "" : employee.getAddress().getCountry(),
					employee.isStatus() == false ? "NO" : "SI" });
		}
	}

	private boolean isBlockedUser() {
		return employeesTable.getModel().getValueAt(employeesTable.getSelectedRow(), 11).toString()
				.equalsIgnoreCase("SI");

	}

	private void blockCustomer(Boolean status)
			throws SQLException, AccessToDataBaseException, NotFoundException, Exception {

		EmployeeManagedOrders employee = new EmployeeManagedOrders();
		employee.setId(
				Integer.parseInt(employeesTable.getModel().getValueAt(employeesTable.getSelectedRow(), 0).toString()));
		employee.setStatus(status);
		ManagerEmployee managerEmployee = new ManagerEmployee();
		managerEmployee.updateEmployeeStatus(employee);
	}
}
