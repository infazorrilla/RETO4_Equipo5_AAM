package es.elorrieta.aam.model.bbdd.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerAddress extends ManagerAbstract<Address> {

	public ManagerAddress() {
		super(new DBUtils());

	}

	@Override
	public List<Address> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception {

		return null;
	}

	@Override
	public void insert(Address address) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "INSERT INTO `address`(`country`, `street`, `cod_postal`, `city`, `province`, `created_at`) VALUES ('"
					+ address.getCountry() + "','" + address.getStreet() + "','" + address.getCodPostal() + "','    "
					+ address.getCity() + "','" + address.getProvince() + "','"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(address.getCreatedAt()) + "')";
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
	public Address select(Address address)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		Address ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			statement = dbUtils.connection.createStatement();
			String query = "SELECT `id_address`, `country`, `street`, `cod_postal`, `city`, `province`, `created_at` FROM `address` WHERE `created_at` = '"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(address.getCreatedAt()) + "'";
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				if (ret == null) {
					ret = new Address();
				}
				ret.setId(resultSet.getInt("id_address"));
				ret.setCountry(resultSet.getString("country"));
				ret.setCodPostal(resultSet.getString("cod_postal"));
				ret.setStreet(resultSet.getString("street"));
				ret.setCity(resultSet.getString("city"));
				ret.setProvince(resultSet.getString("province"));
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

				dbUtils.disconnect();
			}
		}
		return ret;
	}

	public Address selectById(int id) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		Address ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			statement = dbUtils.connection.createStatement();
			String query = "SELECT `id_address`, `country`, `street`, `cod_postal`, `city`, `province`, `created_at` FROM `address` WHERE `id_address` = '"
					+ id + "'";
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				if (ret == null) {
					ret = new Address();
				}
				ret.setId(resultSet.getInt("id_address"));
				ret.setCountry(resultSet.getString("country"));
				ret.setCodPostal(resultSet.getString("cod_postal"));
				ret.setStreet(resultSet.getString("street"));
				ret.setCity(resultSet.getString("city"));
				ret.setProvince(resultSet.getString("province"));
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

				dbUtils.disconnect();
			}
		}
		return ret;
	}

	@Override
	public void update(Address address) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		Statement statement = null;
		try {
			statement = dbUtils.connection.createStatement();

			String query = "UPDATE `address` SET `country`='" + address.getCountry() + "',`street`='"
					+ address.getStreet() + "',`cod_postal`='" + address.getCodPostal() + "',`city`= '"
					+ address.getCity() + "',`province`='" + address.getProvince() + "' WHERE `id_address` = '"
					+ address.getId() + "' ";
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
	public void delete(Address t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {

	}

}
