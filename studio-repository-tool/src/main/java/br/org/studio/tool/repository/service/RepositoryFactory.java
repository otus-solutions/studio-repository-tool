package br.org.studio.tool.repository.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.org.studio.tool.repository.RepositoryConfiguration;
import br.org.studio.tool.repository.datasource.Configuration;

public class RepositoryFactory {

	public static final String UNIT_NAME = "RepositoryPool";

	// 1. cria entity manager
	// 2. executa tarefa no banco
	// 3. fecha entity manager
	public void initializeRepository(RepositoryConfiguration repositoryConfig) {
		Configuration configuration = buildPostgreConfiguration(repositoryConfig);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME, configuration.getProperties());
		emf.createEntityManager();
		emf.close();
	}

	private Configuration buildPostgreConfiguration(RepositoryConfiguration repositoryConfig) {
		Configuration configuration = new Configuration();

		configuration.setDriver(repositoryConfig.getDriver());
		configuration.setUrl(repositoryConfig.getUrl());
		configuration.setUser(repositoryConfig.getUser());
		configuration.setPassword(repositoryConfig.getPassword());

		configuration.setDialect(repositoryConfig.getDialect());
		configuration.setDefaultSchema("public");
		configuration.setShowSql("false");
		configuration.setAutoCommit("true");
		configuration.setHbm2DllAuto("create");

		return configuration;
	}
}
