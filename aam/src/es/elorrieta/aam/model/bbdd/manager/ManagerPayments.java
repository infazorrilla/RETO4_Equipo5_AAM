package es.elorrieta.aam.model.bbdd.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.pojo.Payment;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerPayments extends ManagerAbstract<Payment> {

	public ManagerPayments(){
		super(new DBUtils());
	}
	
	@Override
	public void insert(Payment payment) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "INSERT INTO payments " 
					+ "(`iban`, `cvv`, `expirationDate`) "
					+ "VALUES ('" + payment.getIban() + "','" + payment.getCvv() + "','" + new SimpleDateFormat("yyyy-MM-dd").format(payment.getExpirationDate()) + "')";
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
	public Payment select(Payment payment) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		Payment ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = dbUtils.connection.createStatement();
			String query = "SELECT `id_payment`, `iban`, `cvv`, `expirationDate` FROM payments WHERE `id_payment`='" + payment.getId() + "'";
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				if (ret == null) {
					ret = new Payment();
				}
				ret.setId(resultSet.getInt("id_payment"));
				ret.setIban(resultSet.getString("iban"));
				ret.setCvv(resultSet.getString("cvv"));
				Timestamp expirationDate = resultSet.getTimestamp("expirationDate");
				ret.setExpirationDate(new Date(expirationDate.getTime()));
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
	public void update(Payment payment) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "UPDATE payments "
					+ "SET `iban`='" + payment.getIban() + "', `cvv`='" + payment.getCvv() + "', `expirationDate`='" + new SimpleDateFormat("yyyy-MM-dd").format(payment.getExpirationDate()) + "' "
					+ "WHERE `id_payment` = '" + payment.getId() + "'";
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
	public void delete(Payment payment) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "DELETE FROM payments WHERE `id_payment` = '" + payment.getId() + "'";
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
	public List<Payment> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		List<Payment> ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = dbUtils.connection.createStatement();
			String query = "SELECT * FROM payments";
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				if (ret == null) {
					ret = new ArrayList<Payment>();
				}
				Payment payment = new Payment();
				
				payment.setId(resultSet.getInt("id_payment"));
				payment.setIban(resultSet.getString("iban"));
				payment.setCvv(resultSet.getString("cvv"));
				Timestamp expirationDate = resultSet.getTimestamp("expirationDate");
				payment.setExpirationDate(new Date(expirationDate.getTime()));
				
				ret.add(payment);
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

}