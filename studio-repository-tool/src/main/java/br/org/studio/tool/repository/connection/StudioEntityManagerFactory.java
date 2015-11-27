package br.org.studio.tool.repository.connection;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudioEntityManagerFactory {

	@SuppressWarnings("unused")
	public void initializeRepositoryPool() {
		Map<String, String> properties = new HashMap<>();

		/* JPA properties */
		properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
		properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/repository");
		properties.put("javax.persistence.jdbc.user", "postgres");
		properties.put("javax.persistence.jdbc.password", "postgres");
		
		/* Hibernate properties */
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.default_schema", "public");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.connection.autocommit", "true");
		properties.put("hibernate.hbm2ddl.auto", "create");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RepositoryPool", properties);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	}
}
