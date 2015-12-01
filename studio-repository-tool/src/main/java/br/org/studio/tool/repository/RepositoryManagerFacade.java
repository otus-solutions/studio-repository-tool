package br.org.studio.tool.repository;

import java.sql.SQLException;

import br.org.studio.tool.repository.service.PostgresDatabase;
import br.org.studio.tool.repository.service.RepositoryFactory;

public class RepositoryManagerFacade {

	private RepositoryFactory repositoryFactory;

	public RepositoryManagerFacade() {
		repositoryFactory = new RepositoryFactory();
	}

	public void createRepository(RepositoryConfiguration configuration) throws SQLException {
		PostgresDatabase postgresql = new PostgresDatabase(configuration);
		postgresql.createDatabase();
		repositoryFactory.initialize(configuration);
	}

	public void deleteRepository(RepositoryConfiguration configuration) throws SQLException {
		PostgresDatabase postgresql = new PostgresDatabase(configuration);
		postgresql.dropDatabase();
	}

}
