package br.org.studio.tool.repository;

import java.sql.SQLException;

import br.org.studio.tool.repository.database.PostgresDatabase;
import br.org.studio.tool.repository.database.Repository;
import br.org.studio.tool.repository.database.RepositoryUtils;

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
