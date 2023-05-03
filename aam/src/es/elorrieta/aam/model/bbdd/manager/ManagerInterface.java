package es.elorrieta.aam.model.bbdd.manager;

import java.sql.SQLException;
import java.util.List;

import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;

public interface ManagerInterface<T> {

	public void insert(T t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception;

	public T select(T t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception;

	public List<T> selectAll() throws SQLException, NotFoundException, AccessToDataBaseException, Exception;

	public void update(T t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception;

	public void delete(T t) throws SQLException, NotFoundException, AccessToDataBaseException, Exception;

}
