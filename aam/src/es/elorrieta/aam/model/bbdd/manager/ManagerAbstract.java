package es.elorrieta.aam.model.bbdd.manager;

import java.util.List;

public abstract class ManagerAbstract<T> implements ManagerInterface<T> {

	@Override
	public abstract void insert(T t);

	@Override
	public abstract List<T> select(T t);

	@Override
	public abstract void update(T t);

	@Override
	public abstract void delete(T t);

}
