package br.org.studio.tool.repository;

import java.sql.SQLException;

import br.org.studio.tool.repository.service.RepositoryFactory;

public class RepositoryManagerFacade {

	private RepositoryFactory repositoryFactory;

	public RepositoryManagerFacade() {
		repositoryFactory = new RepositoryFactory();
	}

	public void createRepository(RepositoryConfiguration configuration) throws SQLException {
		configuration.getDatabase().createDatabase();
		repositoryFactory.initializeRepository(configuration);
	}

	public void deleteRepository(RepositoryConfiguration configuration) throws SQLException {
		configuration.getDatabase().dropDatabase(configuration.getName());
	}

}
