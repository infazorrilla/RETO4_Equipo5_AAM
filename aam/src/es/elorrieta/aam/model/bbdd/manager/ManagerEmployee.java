package es.elorrieta.aam.model.bbdd.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.EmployeeManagedOrders;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerEmployee extends ManagerAbstract<EmployeeManagedOrders> {

	public ManagerEmployee() {
		super(new DBUtils());

	}

	@Override
	public List<EmployeeManagedOrders> selectAll()
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		ArrayList<EmployeeManagedOrders> ret = (ArrayList<EmployeeManagedOrders>) doSelectAll();
		if (ret == null) {
			throw new NotFoundException("there are no employees");
		}
		return ret;
	}

	private List<EmployeeManagedOrders> doSelectAll()
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		List<EmployeeManagedOrders> ret = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			statement = dbUtils.connection.createStatement();
			String query = "SELECT * FROM " + ManagerAbstract.TABLE_EMPLOYEES + " WHERE id_employee_type = 2";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				if (ret == null) {
					ret = new ArrayList<EmployeeManagedOrders>();
				}

				EmployeeManagedOrders employee = new EmployeeManagedOrders();

				employee.setId(resultSet.getInt("id_employee"));
				employee.setName(resultSet.getString("name"));
				employee.setLastName(resultSet.getString("lastname"));
				employee.setEmail(resultSet.getString("email"));
				if (null != resultSet.getDate("birthDate")) {
					Date date = resultSet.getDate("birthDate");
					employee.setBirthDate(new Date(date.getTime()));
				}
				employee.setPassword(resultSet.getString("password"));
				employee.setImage(userFoto(resultSet.getBlob("image")));
				employee.setStatus(resultSet.getBoolean("status"));

				if (0 != resultSet.getInt("id_address")) {
					ManagerAddress managerAddress = new ManagerAddress();
					Address address = managerAddress.selectById(resultSet.getInt("id_address"));
					if (address != null) {
						employee.setAddress(address);
					}

				}
				ret.add(employee);
			}
		} finally {

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}

			}
			dbUtils.disconnect();
		}
		return ret;

	}

	@Override
	public void insert(EmployeeManagedOrders t)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public EmployeeManagedOrders select(EmployeeManagedOrders employeeManagedOrders)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {

		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		EmployeeManagedOrders ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		try {

			statement = dbUtils.connection.createStatement();
			String query = "SELECT `id_employee`, `id_address` , `id_employee_type`, `name`, `lastname`, `email`, `password` , `birthDate` , `image`, `status` FROM "
					+ ManagerAbstract.TABLE_EMPLOYEES + "  WHERE email = '" + employeeManagedOrders.getEmail()
					+ "' AND password =  '" + employeeManagedOrders.getPassword() + "'";
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				if (ret == null) {
					ret = new EmployeeManagedOrders();
					if (0 == resultSet.getInt("id_address")) {
						ret.setId(resultSet.getInt("id_employee"));
						if (null != resultSet.getDate("birthDate")) {
							Date date = resultSet.getDate("birthDate");
							ret.setBirthDate(new Date(date.getTime()));
						}
						ret.setEmployeeType(resultSet.getInt("id_employee_type"));
						ret.setName(resultSet.getString("name"));
						ret.setLastName(resultSet.getString("lastname"));
						ret.setEmail(resultSet.getString("email"));
						ret.setPassword(resultSet.getString("password"));
						ret.setImage(userFoto(resultSet.getBlob("image")));
						ret.setStatus(resultSet.getBoolean("status"));

					} else {
						String query2 = "SELECT e.id_employee, e.id_address, e.id_employee_type ,e.name, e.lastname, e.email, e.password, e.birthDate, e.image, e.status , a.country , a.street , a.cod_postal , a.city , a.province FROM "
								+ ManagerAbstract.TABLE_EMPLOYEES + " AS e JOIN " + ManagerAbstract.TABLE_ADDRESS
								+ " AS a ON e.id_address = a.id_address WHERE e.email = '"
								+ employeeManagedOrders.getEmail() + "' AND e.password = '"
								+ employeeManagedOrders.getPassword() + "'";
						resultSet2 = statement.executeQuery(query2);

						if (resultSet2.next()) {
							ret.setId(resultSet2.getInt("id_employee"));
							ret.setEmployeeType(resultSet2.getInt("id_employee_type"));
							ret.setName(resultSet2.getString("name"));
							ret.setLastName(resultSet2.getString("lastname"));
							ret.setEmail(resultSet2.getString("email"));
							if (null != resultSet2.getDate("birthDate")) {
								Date date = resultSet2.getDate("birthDate");
								ret.setBirthDate(new Date(date.getTime()));
							}
							ret.setPassword(resultSet2.getString("password"));
							ret.setImage(userFoto(resultSet2.getBlob("image")));
							ret.setStatus(resultSet2.getBoolean("status"));
							Address address = new Address();
							address.setId(resultSet2.getInt("id_address"));
							address.setCity(resultSet2.getString("city"));
							address.setCountry(resultSet2.getString("country"));
							address.setStreet(resultSet2.getString("street"));
							address.setCodPostal(resultSet2.getString("cod_postal"));
							address.setProvince(resultSet2.getString("province"));
							ret.setAddress(address);
						}

					}
				}
			}
		} finally {
			if (resultSet2 != null) {
				try {
					resultSet2.close();
				} catch (SQLException e) {
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}

				dbUtils.disconnect();
			}
		}
		return ret;
	}

	private File userFoto(Blob blob) {
		File file = null;
		if (null != blob) {
			byte bytes[] = null;
			FileOutputStream fos = null;

			try {
				file = new File(".png");

				fos = new FileOutputStream(file);

				bytes = blob.getBytes(1, (int) blob.length());
				fos.write(bytes);
			} catch (SQLException e) {

			}

			catch (

			FileNotFoundException e) {

			} catch (IOException e) {

				e.printStackTrace();

			}

		}
		return file;
	}

	@Override
	public void update(EmployeeManagedOrders employee)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		PreparedStatement preparedStatement = null;
		try {

			Address address = checkAddress(employee.getAddress());

			String query = "UPDATE " + ManagerAbstract.TABLE_EMPLOYEES
					+ " SET `id_address`= ? ,`name`= ?,`lastname`= ? ,`email`= ? , `password`= ? , `birthDate`= ?  WHERE `id_employee` = ?";

			preparedStatement = dbUtils.connection.prepareStatement(query);

			preparedStatement.setInt(1, address.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setString(5, employee.getPassword());

			preparedStatement.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(employee.getBirthDate()));

			File file = employee.getImage();

			preparedStatement.setInt(7, employee.getId());

			preparedStatement.executeUpdate();
			if (file != null) {
				updateImage(preparedStatement, file, employee.getId());
			}
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
				}
			}
			dbUtils.disconnect();
		}
	}

	private Address checkAddress(Address address)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		Address ret = new Address();
		if (address.getId() != 0) {
			doUpdateAdress(address);
			ret = address;
		} else {
			doInsertAddress(address);
			ret = doSelectAdress(address);
		}

		return ret;
	}

	private void doInsertAddress(Address address)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		ManagerAddress managerAddress = new ManagerAddress();
		managerAddress.insert(address);
	}

	private Address doSelectAdress(Address address)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		ManagerAddress managerAddress = new ManagerAddress();
		return managerAddress.select(address);
	}

	private void doUpdateAdress(Address address)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		ManagerAddress managerAddress = new ManagerAddress();
		managerAddress.update(address);
	}

	private void updateImage(PreparedStatement preparedStatement, File file, int id)
			throws SQLException, FileNotFoundException, NotFoundException, AccessToDataBaseException, Exception {
		String query = "UPDATE " + ManagerAbstract.TABLE_EMPLOYEES + " SET `image` = ?   WHERE `id_employee` = ?";
		preparedStatement = dbUtils.connection.prepareStatement(query);
		FileInputStream fileInputStream = new FileInputStream(file);
		preparedStatement.setBinaryStream(1, fileInputStream, (int) file.length());
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();
	}

	public void updateEmployeeStatus(EmployeeManagedOrders employee)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		Statement statement = null;
		try {
			statement = dbUtils.connection.createStatement();
			int value = employee.isStatus() == false ? 0 : 1;
			String query = "UPDATE " + ManagerAbstract.TABLE_EMPLOYEES + " SET `status`= '" + value
					+ "' WHERE `id_employee` = '" + employee.getId() + "'";
			statement.executeUpdate(query);

		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
			dbUtils.disconnect();
		}
	}

	@Override
	public void delete(EmployeeManagedOrders emoloyee)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		PreparedStatement preparedStatement = null;
		try {

			String query = "DELETE FROM " + ManagerAbstract.TABLE_EMPLOYEES + " WHERE `id_employee` =  '"
					+ emoloyee.getId() + "'";
			preparedStatement = dbUtils.connection.prepareStatement(query);
			preparedStatement.execute();

		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
				}
			}
			dbUtils.disconnect();
		}

	}

}
