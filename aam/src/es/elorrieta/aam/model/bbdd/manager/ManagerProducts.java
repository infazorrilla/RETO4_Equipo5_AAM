package es.elorrieta.aam.model.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import es.elorrieta.aam.model.bbdd.pojo.Product;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerProducts extends ManagerAbstract<Product> {

	public ManagerProducts(){
		super(new DBUtils());
		
	}

	@Override
	public void insert(Product t) {

	}

	@Override
	public Product select(Product t) {

		return null;
	}

	@Override
	public void update(Product t) {

	}

	@Override
	public void delete(Product t) {

	}

	@Override
	public List<Product> selectAll(Product t) throws SQLException, Exception {
		
		return null;
	}

}
