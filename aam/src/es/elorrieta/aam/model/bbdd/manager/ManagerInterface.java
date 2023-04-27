package es.elorrieta.aam.model.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

public interface ManagerInterface<T> {

	public void insert(T t) throws SQLException, Exception;

	public T select(T t) throws SQLException, Exception;
	
	public List<T> selectAll(T t) throws SQLException, Exception;

	public void update(T t) throws SQLException, Exception;

	public void delete(T t) throws SQLException, Exception;

}
