package es.elorrieta.aam.model.bbdd.manager;

import java.util.List;

import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerCustomers extends ManagerAbstract<Customer> {

	public ManagerCustomers() {
		super(new DBUtils());
		
	}

	@Override
	public void insert(Customer t) {

	}

	@Override
	public List<Customer> select(Customer t) {

		return null;
	}

	@Override
	public void update(Customer t) {

	}

	@Override
	public void delete(Customer t) {

	}

}
