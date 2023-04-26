package es.elorrieta.aam.model.bbdd.manager;

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
	public List<Product> select(Product t) {

		return null;
	}

	@Override
	public void update(Product t) {

	}

	@Override
	public void delete(Product t) {

	}

}
