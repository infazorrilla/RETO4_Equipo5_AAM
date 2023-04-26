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

import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerShoppingCart extends ManagerAbstract<ShoppingCart> {

	public ManagerShoppingCart() {
		super(new DBUtils());
	}

	@Override
	public void insert(ShoppingCart shoppingCart) throws SQLException, Exception {

		if (!dbUtils.isConnected())
			dbUtils.connect();
		PreparedStatement preparedStatement = null;
		try {

			String query = "INSERT INTO " + ManagerAbstract.TABLE_SHOPPINGCART
					+ "( `totalPrice`, `descount` , `created_at`) VALUES ('" + shoppingCart.getTotalPrice() + "','"
					+ shoppingCart.getDescount() + "', '"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(shoppingCart.getCreatedAt()) + "' )";
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
	public List<ShoppingCart> select(ShoppingCart shoppingCart) throws SQLException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		List<ShoppingCart> ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			statement = dbUtils.connection.createStatement();
			String query = "SELECT `id_shoppingcart`, `totalPrice`, `descount` , `created_at` FROM "
					+ ManagerAbstract.TABLE_SHOPPINGCART + " WHERE `created_at` = '"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(shoppingCart.getCreatedAt()) + "''"
					+ shoppingCart.getId() + "' ";
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				if (ret == null) {
					ret = new ArrayList<ShoppingCart>();
				}
				ShoppingCart shopCart = new ShoppingCart();
				shopCart.setId(resultSet.getInt("id_shoppingcart"));
				shopCart.setTotalPrice(resultSet.getDouble("totalPrice"));
				shopCart.setDescount(resultSet.getDouble("descount"));
				Timestamp createdAt = resultSet.getTimestamp("created_at");
				shopCart.setCreatedAt(new Date(createdAt.getTime()));
				ret.add(shopCart);
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
	public void update(ShoppingCart shoppingCart) throws SQLException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		Statement statement = null;
		try {
			statement = dbUtils.connection.createStatement();
			String query = "UPDATE " + ManagerAbstract.TABLE_SHOPPINGCART + " SET `totalPrice`='"
					+ shoppingCart.getTotalPrice() + "',`descount`='" + shoppingCart.getDescount()
					+ "'WHERE `id_shoppingcart` = '" + shoppingCart.getId() + "'";

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
	public void delete(ShoppingCart shoppingCart) throws SQLException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		PreparedStatement preparedStatement = null;
		try {

			String query = "DELETE FROM " + ManagerAbstract.TABLE_SHOPPINGCART + " WHERE `id_shoppingcart`= '"
					+ shoppingCart.getId() + "'";
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
