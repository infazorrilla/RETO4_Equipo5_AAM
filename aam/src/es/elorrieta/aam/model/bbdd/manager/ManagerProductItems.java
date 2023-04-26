package es.elorrieta.aam.model.bbdd.manager;

import java.util.List;

import es.elorrieta.aam.model.bbdd.pojo.ProductItem;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public class ManagerProductItems extends ManagerAbstract<ProductItem> {

	public ManagerProductItems(){
		super(new DBUtils());
		
	}

	@Override
	public void insert(ProductItem t) {

	}

	@Override
	public List<ProductItem> select(ProductItem t) {

		return null;
	}

	@Override
	public void update(ProductItem t) {

	}

	@Override
	public void delete(ProductItem t) {

	}

}
