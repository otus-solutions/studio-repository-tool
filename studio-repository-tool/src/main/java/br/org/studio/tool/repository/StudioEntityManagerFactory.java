package br.org.studio.tool.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class StudioEntityManagerFactory {

	@SuppressWarnings("unused")
	public void initializeRepositoryPool() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RepositoryPool",
				getConfiguration());
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Session session = entityManager.unwrap(Session.class);
	}

	private Map<String, String> getConfiguration() {
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

		return properties;
	}

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
			if (connection.isClosed()) {
				System.out.println("fechado");
			} else {
				System.out.println("aberto");
			}
			return connection;
		} catch (Exception ex) {
			System.out.println("ops");
			return null;
		}
	}

	public void createDatabase() throws SQLException {
		Statement stmt = null;
		String sql = "CREATE DATABASE novo_banco WITH OWNER = postgres ENCODING = 'UTF8' TABLESPACE = pg_default LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8' CONNECTION LIMIT = -1;";
		try {
			stmt = getConnection().createStatement();
			stmt.execute(sql);
			System.out.println(stmt.getWarnings());
			System.out.println("Banco criado");
		} catch (Exception e) {
			System.out.println("ops");
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

}
