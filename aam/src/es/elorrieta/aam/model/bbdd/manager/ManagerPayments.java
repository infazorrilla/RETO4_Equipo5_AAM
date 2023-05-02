package es.elorrieta.aam.model.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.pojo.Payment;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerPayments extends ManagerAbstract<Payment> {

	public ManagerPayments(){
		super(new DBUtils());
		
	}

	@Override
	public List<Payment> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Payment t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payment select(Payment t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Payment t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Payment t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		// TODO Auto-generated method stub
		
	}
	

}
