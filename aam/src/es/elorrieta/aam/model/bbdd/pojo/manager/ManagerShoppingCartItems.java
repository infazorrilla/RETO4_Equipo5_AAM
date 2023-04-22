package es.elorrieta.aam.model.bbdd.pojo.manager;

public abstract class ManagerShoppingCartItems<T> extends ManagerAbstract<T>{

	@Override
	public abstract void insert(T t);

	@Override
	public abstract  T select(T t);

	@Override
	public   abstract void update(T t);

	@Override
	public  abstract void delete(T t);

}
