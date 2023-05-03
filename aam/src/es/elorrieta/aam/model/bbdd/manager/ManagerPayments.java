package es.elorrieta.aam.model.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import es.elorrieta.aam.model.bbdd.pojo.Payment;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerPayments extends ManagerAbstract<Payment> {

	public ManagerPayments(){
		super(new DBUtils());
	}
	
	@Override
	public void insert(Payment payment) throws SQLException, Exception {
		
	}
	
	@Override
	public Payment select(Payment payment) throws SQLException, Exception {
		
		return null;
	}
	
	@Override
	public void update(Payment payment) throws SQLException, Exception {
		
	}
	
	@Override
	public void delete(Payment payment) throws SQLException, Exception {
		
	}
	@Override
	public List<Payment> selectAll(Payment payment) throws SQLException, Exception {
		
		return null;
	}

}