package es.elorrieta.aam.model.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public abstract class ManagerAbstract<T> implements ManagerInterface<T> {

	protected DBUtils dbUtils = null;
	protected static final String TABLE_SHOPPINGCARTITEMS = "shoppingcartitems";
	protected static final String TABLE_SHOPPINGCART = "shoppingcart";
	protected static final String TABLE_CUSTOMERS = "customers";
	protected static final String TABLE_EMPLOYEES = "employees";
	protected static final String TABLE_ADDRESS = "address";
	protected static final String TABLE_PRODUCT = "products";

	public ManagerAbstract(DBUtils dbUtils) {
		this.dbUtils = dbUtils;
	}

	@Override
	public abstract List<T> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception;

	@Override
	public abstract void insert(T t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception;

	@Override
	public abstract T select(T t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception;

	@Override
	public abstract void update(T t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception;

	@Override
	public abstract void delete(T t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception;

}
