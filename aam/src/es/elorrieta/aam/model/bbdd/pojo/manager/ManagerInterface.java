package es.elorrieta.aam.model.bbdd.pojo.manager;

public interface ManagerInterface<T> {

	public void insert(T t);

	public T select(T t);

	public void update(T t);

	public void delete(T t);

}
