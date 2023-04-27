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
	public void insert(Payment t) {

	}

	@Override
	public Payment select(Payment t) {

		return null;
	}

	@Override
	public void update(Payment t) {

	}

	@Override
	public void delete(Payment t) {

	}
	@Override
	public List<Payment> selectAll(Payment t) throws SQLException, Exception {
	
		return null;
	}

}
