package br.org.studio.tool.base.repository.data;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.org.studio.tool.base.persitence.PersistenceContext;

public abstract class GenericDaoBean<T> implements GenericDao<T> {

	protected Class<?> entityClass;
	protected EntityManager entityManager;

	public GenericDaoBean(PersistenceContext persistenceContext) {
		entityManager = persistenceContext.getEntityManager();

		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<?>) genericSuperclass.getActualTypeArguments()[1];
	}

	@Override
	public void create(Object entity) {
		entityManager.persist(entity);
	}

	@Override
	public T retrieve(Object id) {
		return (T) entityManager.find(entityClass, id);
	}

	@Override
	public void update(Object entity) {
		entityManager.persist(entityManager.merge(entity));
	}

	@Override
	public void delete(Object entity) {
		entityManager.remove(entityManager.merge(entity));
	}

}
