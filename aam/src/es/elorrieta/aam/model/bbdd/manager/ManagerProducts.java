package es.elorrieta.aam.model.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.pojo.Product;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerProducts extends ManagerAbstract<Product> {

	public ManagerProducts(){
		super(new DBUtils());
		
	}

	@Override
	public List<Product> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Product t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product select(Product t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}



}
