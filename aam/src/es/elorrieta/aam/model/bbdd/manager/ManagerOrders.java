package es.elorrieta.aam.model.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerOrders extends ManagerAbstract<Order> {

	public ManagerOrders(){
		super(new DBUtils());
		
	}

	@Override
	public List<Order> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Order t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order select(Order t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Order t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Order t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}

	

}
