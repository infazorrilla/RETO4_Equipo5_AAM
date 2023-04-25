package es.elorrieta.aam.model.bbdd.pojo.manager;

import java.util.List;

public interface ManagerInterface<T> {

	public void insert(T t);

	public List<T> select(T t);

	public void update(T t);

	public void delete(T t);

}
