package es.elorrieta.aam.model.bbdd.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.controller.ValidatePayment;
import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;

import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Payment;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerOrders extends ManagerAbstract<Order> {

	public ManagerOrders() {
		super(new DBUtils());
	}

	@Override
	public void insert(Order order) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "INSERT INTO orders "
					+ "(`id_customer`, `id_address`, `id_shoppingcart`, `id_payment`, `status`, `totalPrice`, `delivery_date`, `created_at`) "
					+ "VALUES ('" + order.getCustomer() + "','" + order.getAddress() + "','" + order.getShoppingCart()
					+ "','" + order.getPayment() + "','" + order.getStatus() + "','" + order.getTotalPrice() + "','"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getDeliveryDate()) + "','"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderDate()) + "')";
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
	public Order select(Order order) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		Order ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = dbUtils.connection.createStatement();
			String query = "SELECT * FROM orders WHERE `id_order`=" + order.getId() + "'";
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
				// ret.setStatus(resultSet.getString("status"));
				ret.setTotalPrice(resultSet.getDouble("totalPrice"));
				Timestamp deliveryDate = resultSet.getTimestamp("delivery_date");
				ret.setDeliveryDate(new Date(deliveryDate.getTime()));
				Timestamp orderDate = resultSet.getTimestamp("orderDate");
				ret.setOrderDate(new Date(orderDate.getTime()));
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
	}

	@Override
	public void update(Order order) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "UPDATE orders " + "SET `status`='" + order.getStatus() + "', `totalPrice`='"
					+ order.getTotalPrice() + "', `orderDate`='" + order.getOrderDate() + "WHERE `id_order` = '"
					+ order.getId() + "'";
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
	public void delete(Order order) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
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
	public List<Order> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		List<Order> ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = dbUtils.connection.createStatement();
			String query = "SELECT * FROM orders";
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				if (ret == null) {
					ret = new ArrayList<Order>();
				}
				Order order = new Order();

				order.setId(resultSet.getInt("id_order"));
				Customer customer = new Customer();
				customer.setId(resultSet.getInt("id_customer"));
				order.setCustomer(customer);
				Address address = new Address();
				address.setId(resultSet.getInt("id_address"));
				order.setAddress(address);
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setId(resultSet.getInt("id_shoppingcart"));
				order.setShoppingCart(shoppingCart);
				Payment payment = new Payment();
				payment.setId(resultSet.getInt("id_payment"));
				order.setPayment(payment);
				// order.setStatus(resultSet.getString("status"));
				order.setTotalPrice(resultSet.getDouble("totalPrice"));
				Timestamp deliveryDate = resultSet.getTimestamp("delivery_date");
				order.setDeliveryDate(new Date(deliveryDate.getTime()));
				Timestamp orderDate = resultSet.getTimestamp("orderDate");
				order.setOrderDate(new Date(orderDate.getTime()));

				ret.add(order);
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
	}

	public void insertOrder(Order order) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No se ha podido acceder a la base de datos");
		}
		PreparedStatement preparedStatement = null;

		try {

			Address address = new ManagerCustomers()
					.checkAddress(order.getCustomer().getProfile().getUser().getAddress());
			Payment payment = new ManagerPayments().PaymentInsertSelectPayment(order.getPayment());
			ShoppingCart shoppingCart = new ManagerShoppingCart()
					.insertShopCartAndShopCartItems(order.getShoppingCart());
			if (!dbUtils.isConnected())
				dbUtils.connect();

			String query = "INSERT INTO `orders`( `id_customer`, `id_address`, `id_shoppingcart`, `id_payment`, `status`, `totalPrice`, `delivery_date`) VALUES ('"
					+ order.getCustomer().getProfile().getUser().getId() + "','" + address.getId() + "','"
					+ shoppingCart.getId() + "','" + payment.getId() + "','" + order.getStatus() + "','"
					+ order.getTotalPrice() + "','" + new SimpleDateFormat("yyyy-MM-dd").format(getDeliveryDate())
					+ "')";
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

	public Date getDeliveryDate() {
		return new ValidatePayment().convertToDateViaInstant(LocalDate.now().plusDays(10));
	}

}