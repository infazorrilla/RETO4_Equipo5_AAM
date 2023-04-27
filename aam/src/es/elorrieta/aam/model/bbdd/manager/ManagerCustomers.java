package es.elorrieta.aam.model.bbdd.manager;


import java.sql.SQLException;
import java.util.List;

import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerCustomers extends ManagerAbstract<Customer> {

	public ManagerCustomers() {
		super(new DBUtils());
		
	}

	@Override
	public List<Customer> selectAll(Customer t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Customer t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer select(Customer t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Customer t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	
	
}
