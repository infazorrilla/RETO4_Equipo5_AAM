package es.elorrieta.aam.model.bbdd.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.elorrieta.aam.model.bbdd.pojo.ProductItem;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCartItem;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerShoppingCartItems extends ManagerAbstract<ShoppingCartItem> {

	public ManagerShoppingCartItems() {
		super(new DBUtils());

	}

	@Override
	public void insert(ShoppingCartItem shoppingCartItem) throws SQLException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		PreparedStatement preparedStatement = null;
		try {

			String query = "INSERT INTO " + ManagerAbstract.TABLE_SHOPPINGCARTITEMS
					+ "(`id_shoppingcart`, `id_product_item`, `price`, `quantity`) VALUES ('"
					+ shoppingCartItem.getShoppingCart().getId() + "','" + shoppingCartItem.getProductItem().getId()
					+ "','" + shoppingCartItem.getPrice() + "','" + shoppingCartItem.getQuantity() + "')";
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
	public ShoppingCartItem select(ShoppingCartItem shoppingCartItem) throws SQLException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		ShoppingCartItem ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			statement = dbUtils.connection.createStatement();
			String query = "SELECT * FROM " + ManagerAbstract.TABLE_SHOPPINGCARTITEMS + "";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				if (ret == null) {
					ret = new ShoppingCartItem();
				}
				ret.setId(resultSet.getInt("id_shoppingCartItem"));
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setId(resultSet.getInt("id_shoppingcart"));
				ret.setShoppingCart(shoppingCart);
				ProductItem productItem = new ProductItem();
				productItem.setId(resultSet.getInt("id_product_item"));
				ret.setProductItem(productItem);
				ret.setPrice(resultSet.getDouble("price"));
				ret.setQuantity(resultSet.getInt("quantity"));
				
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
	public void update(ShoppingCartItem shoppingCartItem) throws SQLException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		Statement statement = null;
		try {
			statement = dbUtils.connection.createStatement();
			String query = "UPDATE " + ManagerAbstract.TABLE_SHOPPINGCARTITEMS + " SET `price`='"
					+ shoppingCartItem.getPrice() + "',`quantity`='" + shoppingCartItem.getQuantity()
					+ "' WHERE `id_shoppingCartItem` = '" + shoppingCartItem.getId() + "' ";

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
	public void delete(ShoppingCartItem shoppingCartItem) throws SQLException, Exception {
		if (!dbUtils.isConnected())
			dbUtils.connect();
		PreparedStatement preparedStatement = null;
		try {

			String query = "DELETE FROM " + ManagerAbstract.TABLE_SHOPPINGCARTITEMS + " WHERE `id_shoppingCartItem`= '"
					+ shoppingCartItem.getId() + "'";
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
	public List<ShoppingCartItem> selectAll(ShoppingCartItem t) throws SQLException, Exception {
		
		return null;
	}

}
