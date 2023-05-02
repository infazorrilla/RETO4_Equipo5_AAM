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
import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerCustomers extends ManagerAbstract<Customer> {

	public ManagerCustomers() {
		super(new DBUtils());

	}

	@Override
	public List<Customer> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		ArrayList<Customer> ret = (ArrayList<Customer>) doSelectAll();
		if (ret == null) {
			throw new NotFoundException("there are no customers");
		}
		return ret;
	}

	private List<Customer> doSelectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		List<Customer> ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		try {

			statement = dbUtils.connection.createStatement();
			String query = "SELECT * FROM `customers`";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				if (ret == null) {
					ret = new ArrayList<Customer>();
				}

				Customer customer = new Customer();

				customer.setId(resultSet.getInt("id_customer"));
				customer.setName(resultSet.getString("name"));
				customer.setLastName(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				if (null != resultSet.getDate("birthDate")) {
					Date date = resultSet.getDate("birthDate");
					customer.setBirthDate(new Date(date.getTime()));
				}
				customer.setPassword(resultSet.getString("password"));
				customer.setImage(userFoto(resultSet.getBlob("image")));
				customer.setStatus(resultSet.getBoolean("status"));

				if (0 != resultSet.getInt("id_address")) {
					ManagerAddress managerAddress = new ManagerAddress();
					Address address = managerAddress.selectById(resultSet.getInt("id_address"));
					if (address != null) {
						customer.setAddress(address);
					}

				}
				ret.add(customer);
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

			}
			dbUtils.disconnect();
		}
		return ret;
	}

	@Override
	public void insert(Customer customer) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {

		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "INSERT INTO " + ManagerAbstract.TABLE_CUSTOMERS
					+ "( `email`, `password`, `birthDate`) VALUES ('" + customer.getEmail() + "' , '"
					+ customer.getPassword() + "' , '"
					+ new SimpleDateFormat("yyyy-MM-dd").format(customer.getBirthDate()) + "')";
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

	@Override
	public Customer select(Customer customer)
			throws SQLException, NotFoundException, AccessToDataBaseException, NotFoundException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		Customer ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		try {
			if (dbUtils.connection == null) {
				throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
			} else {
				statement = dbUtils.connection.createStatement();
				String query = "SELECT `id_customer`, `id_address`, `name`, `lastname`, `email`, `password`, `birthDate`, `image`, `status` FROM `customers`  WHERE email = '"
						+ customer.getEmail() + "' AND password =  '" + customer.getPassword() + "'";
				resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					if (ret == null) {
						ret = new Customer();
					}
					if (0 == resultSet.getInt("id_address")) {
						ret.setId(resultSet.getInt("id_customer"));
						ret.setName(resultSet.getString("name"));
						ret.setLastName(resultSet.getString("lastname"));
						ret.setEmail(resultSet.getString("email"));
						if (null != resultSet.getDate("birthDate")) {
							Date date = resultSet.getDate("birthDate");
							ret.setBirthDate(new Date(date.getTime()));
						}
						ret.setPassword(resultSet.getString("password"));
						ret.setImage(userFoto(resultSet.getBlob("image")));
						ret.setStatus(resultSet.getBoolean("status"));

					} else {
						String query2 = "SELECT c.id_customer, c.id_address, c.name, c.lastname, c.email, c.password, c.birthDate, c.image, c.status , a.country , a.street , a.cod_postal , a.city , a.province FROM `customers` AS c JOIN address AS a ON c.id_address = a.id_address WHERE c.email = '"
								+ customer.getEmail() + "' AND c.password = '" + customer.getPassword() + "'";
						resultSet2 = statement.executeQuery(query2);

						if (resultSet2.next()) {
							ret.setId(resultSet2.getInt("id_customer"));
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
				file = new File(generateUniqueFileName() + ".png");

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

	private String generateUniqueFileName() {
		String filename = "";
		String datetime = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").format(new java.util.Date());
		datetime = datetime.replace("-", "");
		datetime = datetime.replace(":", "");
		filename = datetime;
		return filename;
	}

	@Override
	public void update(Customer customer)
			throws SQLException, IOException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		PreparedStatement preparedStatement = null;
		try {

			Address address = checkAddress(customer.getAddress());

			String query = "UPDATE `customers` SET `id_address`= ? ,`name`= ?,`lastname`= ? ,`email`= ? , `password`= ? , `birthDate`= ?  WHERE `id_customer` = ?";

			preparedStatement = dbUtils.connection.prepareStatement(query);

			preparedStatement.setInt(1, address.getId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, customer.getPassword());

			preparedStatement.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(customer.getBirthDate()));

			File file = customer.getImage();

			preparedStatement.setInt(7, customer.getId());

			preparedStatement.executeUpdate();
			if (file != null) {
				updateImage(file, customer.getId());
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

	private void updateImage(File file, int id) throws SQLException, FileNotFoundException {
		String query = "UPDATE `customers` SET `image` = ?   WHERE `id_customer` = ?";
		PreparedStatement preparedStatement = dbUtils.connection.prepareStatement(query);
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			preparedStatement.setBinaryStream(1, fileInputStream, (int) file.length());
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	private Address checkAddress(Address address)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		Address ret = new Address();
		if (address != null && address.getId() != 0) {
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

	private Address doSelectAdress(Address address) throws SQLException, Exception {
		ManagerAddress managerAddress = new ManagerAddress();
		return managerAddress.select(address);
	}

	private void doUpdateAdress(Address address) throws SQLException, Exception {
		ManagerAddress managerAddress = new ManagerAddress();
		managerAddress.update(address);
	}

	public void updateCustomerStatus(Customer customer) throws SQLException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		Statement statement = null;
		try {
			statement = dbUtils.connection.createStatement();
			int value = customer.isStatus() == false ? 0 : 1;
			String query = "UPDATE `customers` SET `status`= '" + value + "' WHERE `id_customer` = '" + customer.getId()
					+ "'";
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
	public void delete(Customer customer) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		PreparedStatement preparedStatement = null;
		try {

			String query = "DELETE FROM `customers` WHERE `id_customer` =  '" + customer.getId() + "'";
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
