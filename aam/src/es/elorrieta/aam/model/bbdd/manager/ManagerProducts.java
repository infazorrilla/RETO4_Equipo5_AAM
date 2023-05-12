package es.elorrieta.aam.model.bbdd.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
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
import es.elorrieta.aam.model.bbdd.pojo.Product.Genders;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerProducts extends ManagerAbstract<Product> {

	public ManagerProducts() {
		super(new DBUtils());
	}

	@Override
	public void insert(Product product) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (!dbUtils.isConnected()) {
			dbUtils.connect();
		}
		PreparedStatement preparedStatement = null;
		try {
			String query = "INSERT INTO products " + "(`id_subCategory`, `id_brand`, `gender`) " + "VALUES ('" + "','"
					+ product.getCategory() + product.getBrand() + "','" + product.getGender() + "')";
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
	public Product select(Product product)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
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

	public List<Product> doSelectAllByGenderSubCategoryBrand(String gender, int brand, int subCategory)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {

		if (!dbUtils.isConnected())
			dbUtils.connect();
		if (dbUtils.connection == null) {
			throw new AccessToDataBaseException("No Se ha podido acceder a la base de datos");
		}
		List<Product> ret = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			statement = dbUtils.connection.createStatement();
			String query = "SELECT `id_product`, `id_subCategory`, `id_brand`, `gender`, name, price FROM products  WHERE `id_brand` = '"
					+ brand + "' AND `gender` = '" + gender + "' AND `id_subCategory` = '" + subCategory + "'";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				if (ret == null) {
					ret = new ArrayList<Product>();
				}
				Product myProduct = new Product();
				myProduct.setId(resultSet.getInt("id_product"));
				myProduct.setCategory(resultSet.getInt("id_subCategory"));
				Brand brand1 = new Brand();
				brand1.setId(resultSet.getInt("id_brand"));
				myProduct.setBrand(brand1);
				myProduct.setName(resultSet.getString("name"));
				myProduct.setPrice(resultSet.getDouble("price"));
				myProduct.setGender(Genders.valueOf(resultSet.getString("gender")));

				myProduct.setProductItems(new ManagerProductItems().selectAllByIdProduct(myProduct.getId()));
				List<File> images = getImages(myProduct.getId(), myProduct.getName());
				myProduct.setImages(images);
				ret.add(myProduct);
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

	private List<File> getImages(int id, String name) throws SQLException {
		List<File> ret = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int num = 0;

		try {

			statement = dbUtils.connection.createStatement();
			String query = "SELECT `image` FROM `images` WHERE `id_product` ='" + id + "' ";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				if (ret == null) {
					ret = new ArrayList<File>();
				}
				num++;
				ret.add(productImage(name + num + "", resultSet.getBlob("image")));
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

	private File productImage(String name, Blob blob) {
		File file = null;
		if (null != blob) {
			byte bytes[] = null;
			FileOutputStream fos = null;

			try {
				file = new File(name + ".png");

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
		filename = datetime + rndChar();
		return filename;
	}

	private static char rndChar() {
		int rnd = (int) (Math.random() * 52);
		char base = (rnd < 26) ? 'A' : 'a';
		return (char) (base + rnd % 26);

	}
}