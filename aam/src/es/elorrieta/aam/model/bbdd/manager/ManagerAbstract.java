package es.elorrieta.aam.model.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import es.elorrieta.aam.model.bbdd.utils.DBUtils;

public abstract class ManagerAbstract<T> implements ManagerInterface<T> {

	protected DBUtils dbUtils = null;
	protected static final String TABLE_SHOPPINGCARTITEMS = "shoppingcartitems";
	protected static final String TABLE_SHOPPINGCART = "shoppingcart";

	public ManagerAbstract(DBUtils dbUtils) {
		this.dbUtils = dbUtils;
	}

	@Override
	public abstract  List<T> selectAll(T t) throws SQLException, Exception;

	@Override
	public abstract  void insert(T t) throws SQLException, Exception;

	@Override
	public  abstract T select(T t) throws SQLException, Exception;

	@Override
	public abstract  void update(T t) throws SQLException, Exception;

	@Override
	public abstract void delete(T t) throws SQLException, Exception;

}
