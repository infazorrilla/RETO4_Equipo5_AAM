package es.elorrieta.aam.model.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.pojo.ProductItem;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerProductItems extends ManagerAbstract<ProductItem> {

	public ManagerProductItems(){
		super(new DBUtils());
	}
	
	@Override
	public void insert(ProductItem t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

}