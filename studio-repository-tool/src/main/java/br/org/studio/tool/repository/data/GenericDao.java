package br.org.studio.tool.repository.data;

public interface GenericDao<T> {

	void create(Object entity);

	T retrieve(Object entity);

	void update(Object entity);

	void delete(Object entity);

}
