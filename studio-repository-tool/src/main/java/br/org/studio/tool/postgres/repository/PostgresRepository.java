package br.org.studio.tool.postgres.repository;

import br.org.studio.tool.base.persitence.PersistenceConfiguration;
import br.org.studio.tool.base.persitence.PersistenceContext;
import br.org.studio.tool.base.repository.Repository;
import br.org.studio.tool.base.repository.RepositoryDatabase;
import br.org.studio.tool.base.repository.RepositoryUtils;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.postgres.database.PostgresDatabase;

public class PostgresRepository implements Repository {

	private PersistenceContext persistenceContext;
	private PostgresDatabase postgresql;
	private RepositoryConfiguration configuration;
	private RepositoryDatabase database;

	public PostgresRepository(RepositoryConfiguration configuration) {
		this.configuration = configuration;
		postgresql = new PostgresDatabase(configuration);
	}

	@Override
	public RepositoryConfiguration getConfiguration() {
		return configuration;
	}

	@Override
	public void initialize() throws Exception {
		postgresql.createDatabase();

		PersistenceConfiguration persistenceConfiguration = PersistenceConfiguration.forCreate(configuration);
		persistenceContext = PersistenceContext.load(persistenceConfiguration);
	}

	@Override
	public void load() {
		PersistenceConfiguration persistenceConfiguration = PersistenceConfiguration.forValidate(configuration);
		persistenceContext = PersistenceContext.load(persistenceConfiguration);
	}

	@Override
	public void delete() throws Exception {
		close();
		postgresql.dropDatabase();
	}

	@Override
	public void close() {
		if (persistenceContext != null)
			persistenceContext.close();
	}

	@Override
	public RepositoryUtils getUtils() {
		return new RepositoryUtils(this);
	}

	public RepositoryDatabase getDatabase() {
		return database;
	}

}
