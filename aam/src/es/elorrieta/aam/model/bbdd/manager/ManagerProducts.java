package es.elorrieta.aam.model.bbdd.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.pojo.Product;
import es.elorrieta.aam.model.bbdd.pojo.Product.Category;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerProducts extends ManagerAbstract<Product> {

	public ManagerProducts(){
		super(new DBUtils());
	}
	
	@Override
	public void insert(Product product) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "INSERT INTO products "
					+ "(`id_subCategory`, `id_brand`, `gender`) " 
					+ "VALUES ('" + "','" + product.getCategory() + product.getBrand() + "','" + product.getGender() + "')";
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
	public Product select(Product product) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected()) 
			dbUtils.connect();
		Product ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = dbUtils.connection.createStatement();
			String query = "SELECT * FROM products";
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				if (ret == null) {
					ret = new Product();
				}
				ret.setId(resultSet.getInt("id_product"));
				
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
	public void update(Product product) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Product product) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Product> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}