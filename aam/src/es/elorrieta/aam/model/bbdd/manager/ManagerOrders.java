package es.elorrieta.aam.model.bbdd.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

<<<<<<< HEAD
import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.Customer;
=======
import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
>>>>>>> branch 'sprint2' of https://github.com/infazorrilla/RETO4_Equipo5_AAM.git
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Order.Status;
import es.elorrieta.aam.model.bbdd.pojo.Payment;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerOrders extends ManagerAbstract<Order> {

	public ManagerOrders(){
		super(new DBUtils());
	}
	
	@Override
<<<<<<< HEAD
	public void insert(Order order) throws SQLException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "INSERT INTO orders " 
					+ "(`id_customer`, `id_address`, `id_shoppingcart`, `id_payment`, `status`, `totalPrice`, `delivery_date`, `created_at`) "
					+ "VALUES ('" + order.getCustomer() + "','" + order.getAddress() + "','" + order.getShoppingCart() + "','" + order.getPayment() + "','" 
					+ order.getStatus() + "','" + order.getTotalPrice() + "','" + order.getDeliveryDate() + "','" 
					+ new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(order.getOrderDate()) + "')";
			preparedStatement = dbUtils.connection.prepareStatement(query);
			preparedStatement.execute();
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
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
	public Order select(Order order) throws SQLException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		Order ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = dbUtils.connection.createStatement();
			String query = "SELECT `id_order`, `id_customer`, `id_address`, `id_shoppingcart`, `id_payment`, `status`, `totalPrice`, `delivery_date`, `created_at` "
					+ "FROM orders "
					+ "WHERE `created_at` = " + new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(order.getOrderDate()) + "'";
			/**
			 * OJO CON EL METODO DE SimpleDateFormat
			 */
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				if (ret == null) {
					ret = new Order();
				}
				ret.setId(resultSet.getInt("id_order"));
				Customer customer = new Customer();
				customer.setId(resultSet.getInt("id_customer"));
				ret.setCustomer(customer);
				Address address = new Address();
				address.setId(resultSet.getInt("id_address"));
				ret.setAddress(address);
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setId(resultSet.getInt("id_shoppingcart"));
				ret.setShoppingCart(shoppingCart);
				Payment payment = new Payment();
				payment.setId(resultSet.getInt("id_payment"));
				ret.setPayment(payment);
				
				ret.setStatus(resultSet.getString("status"));
				
				ret.setTotalPrice(resultSet.getDouble("totalPrice"));
				Timestamp deliveryDate = resultSet.getTimestamp("delivery_date");
				ret.setDeliveryDate(new Date(deliveryDate.getTime()));
				Timestamp createdAt = resultSet.getTimestamp("created_at");
				ret.setDeliveryDate(new Date(createdAt.getTime()));
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
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
=======
	public List<Order> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		return null;
>>>>>>> branch 'sprint2' of https://github.com/infazorrilla/RETO4_Equipo5_AAM.git
	}
	
	@Override
<<<<<<< HEAD
	public void update(Order order) throws SQLException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "UPDATE orders "
					+ "SET `status`='" + order.getStatus() + "', `totalPrice`='" + order.getTotalPrice()
					+ "WHERE `id_order` = '" + order.getId() + "'";
			preparedStatement = dbUtils.connection.prepareStatement(query);
			preparedStatement.execute();
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
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
	public void delete(Order order) throws SQLException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "DELETE FROM orders WHERE `id_order` = '" + order.getId() + "'";
			preparedStatement = dbUtils.connection.prepareStatement(query);
			preparedStatement.execute();
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
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
	public List<Order> selectAll(Order order) throws SQLException, Exception {
=======
	public void insert(Order t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
>>>>>>> branch 'sprint2' of https://github.com/infazorrilla/RETO4_Equipo5_AAM.git
		
	}

	@Override
	public Order select(Order t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
}
=======
	@Override
	public void update(Order t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Order t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}

	

}
>>>>>>> branch 'sprint2' of https://github.com/infazorrilla/RETO4_Equipo5_AAM.git
