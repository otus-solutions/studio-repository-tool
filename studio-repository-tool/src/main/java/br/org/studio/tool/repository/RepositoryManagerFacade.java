package br.org.studio.tool.repository;

import java.sql.SQLException;

import br.org.studio.tool.repository.service.Database;
import br.org.studio.tool.repository.service.PostgreDatabase;
import br.org.studio.tool.repository.service.RepositoryFactory;

public class RepositoryManagerFacade {

	private Database postgresql;
	private RepositoryFactory repositoryFactory;

	public RepositoryManagerFacade() {
		repositoryFactory = new RepositoryFactory();
	}

	//TODO: deixar generico a instancia do banco
	public void createRepository(RepositoryConfiguration configuration) throws SQLException {
		postgresql = new PostgreDatabase(configuration.getName());

		postgresql.createDatabase(configuration.getName());
		repositoryFactory.initializeRepository(configuration);
	}

	public void deleteRepository(RepositoryConfiguration configuration) throws SQLException {
		postgresql = new PostgreDatabase(configuration.getName());
		
		postgresql.dropDatabase(configuration.getName());
	}

}
