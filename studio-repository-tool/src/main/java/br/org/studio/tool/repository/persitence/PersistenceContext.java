package br.org.studio.tool.repository.persitence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceContext {

	private static final String UNIT_NAME = "RepositoryPool";

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void load(PersistenceConfiguration configuration) {
		entityManagerFactory = Persistence.createEntityManagerFactory(UNIT_NAME, configuration.getProperties());
		producesEntityManager();
	}

	public EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			producesEntityManager();
		}
		return entityManager;
	}

	public void close() {
		entityManager.close();
		entityManager = null;
	}

	private void producesEntityManager() {
		entityManager = entityManagerFactory.createEntityManager();
	}

}
