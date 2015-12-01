package br.org.studio.tool;

import java.sql.SQLException;

import br.org.studio.tool.database.PostgresDatabase;
import br.org.studio.tool.repository.Repository;
import br.org.studio.tool.repository.RepositoryUtils;

public class RepositoryManagerFacade {

	private Repository repository;

	public void createRepository(RepositoryConfiguration configuration) throws SQLException {
		usePostgresDatabase(configuration).createDatabase();

		repository = new Repository(configuration);
		repository.initialize();
	}

	public void deleteRepository(RepositoryConfiguration configuration) throws SQLException {
		usePostgresDatabase(configuration).dropDatabase();
	}

	public RepositoryUtils connectRepository(RepositoryConfiguration configuration) {
		repository = new Repository(configuration);
		repository.load();
		return repository.getUtils();
	}

	private PostgresDatabase usePostgresDatabase(RepositoryConfiguration configuration) {
		return new PostgresDatabase(configuration);
	}

}
