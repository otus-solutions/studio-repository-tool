package br.org.studio.tool.persitence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceContext {

	private static final String UNIT_NAME = "RepositoryPool";

	private static PersistenceContext instance;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public static PersistenceContext load(PersistenceConfiguration configuration) {
		if (instance == null) {
			synchronized (PersistenceContext.class) {
				instance = new PersistenceContext();
			}
		}

		instance.loadEntityManager(configuration);
		return instance;
	}

	private void loadEntityManager(PersistenceConfiguration configuration) {
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
	}

	private void producesEntityManager() {
		entityManager = entityManagerFactory.createEntityManager();
	}

}
