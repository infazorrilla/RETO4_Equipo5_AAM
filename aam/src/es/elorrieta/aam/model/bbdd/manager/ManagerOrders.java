package es.elorrieta.aam.model.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerOrders extends ManagerAbstract<Order> {

	public ManagerOrders(){
		super(new DBUtils());
		
	}

	@Override
	public void insert(Order t) {

	}

	@Override
	public Order select(Order t) {

		return null;
	}

	@Override
	public void update(Order t) {

	}

	@Override
	public void delete(Order t) {

	}

	@Override
	public List<Order> selectAll(Order t) throws SQLException, Exception {
		
		return null;
	}

}
