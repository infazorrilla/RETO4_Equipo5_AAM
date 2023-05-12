package es.elorrieta.aam.model.bbdd.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.pojo.Brand;
import es.elorrieta.aam.model.bbdd.pojo.Product;
import es.elorrieta.aam.model.bbdd.pojo.ProductItem;
import es.elorrieta.aam.model.bbdd.pojo.Product.Genders;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerProductItems extends ManagerAbstract<ProductItem> {

	public ManagerProductItems() {
		super(new DBUtils());
	}

	@Override
	public void insert(ProductItem t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {

	}

	@Override
	public ProductItem select(ProductItem t)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ProductItem t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ProductItem t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductItem> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception {

		return null;
	}

	public List<ProductItem> selectAllByIdProduct(int productId)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		List<ProductItem> ret = doSelectAll(productId);

		if (ret == null) {
			throw new NotFoundException("there are no productItems");
		}
		return ret;
	}

	private List<ProductItem> doSelectAll(int productId)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {

		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		List<ProductItem> ret = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			statement = dbUtils.connection.createStatement();
			String query = "SELECT `id_product_item`, `id_product`, `price`, `stock`, `size` FROM `productitems` WHERE `id_product` = '"
					+ productId + "'";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				if (ret == null) {
					ret = new ArrayList<ProductItem>();
				}
				ProductItem productItem = new ProductItem();
				productItem.setId(resultSet.getInt("id_product_item"));
				productItem.setPrice(resultSet.getDouble("price"));
				productItem.setStock(resultSet.getInt("stock"));
				productItem.setSize(resultSet.getString("size"));

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

		}
		return ret;
	}

	public List<String> getAvaliableSizes(int id)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {

		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		List<String> ret = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			statement = dbUtils.connection.createStatement();
			String query = "SELECT `size` FROM `productitems` WHERE `id_product` = '" + id + "'" + "GROUP BY size ";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				if (ret == null) {
					ret = new ArrayList<String>();
				}

				ret.add(resultSet.getString("size"));

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
}