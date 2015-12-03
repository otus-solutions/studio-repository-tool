package br.org.studio.tool.repository.postgres;

import br.org.studio.tool.RepositoryConfiguration;
import br.org.studio.tool.database.postgres.PostgresDatabase;
import br.org.studio.tool.persitence.PersistenceConfiguration;
import br.org.studio.tool.persitence.PersistenceConfigurationBuilder;
import br.org.studio.tool.persitence.PersistenceContext;
import br.org.studio.tool.repository.Repository;
import br.org.studio.tool.repository.RepositoryDatabase;
import br.org.studio.tool.repository.RepositoryUtils;

public class PostgresRepository implements Repository {

	private static final String CREATE = "create";
	private static final String VALIDATE = "validate";

	private PersistenceContext persistenceContext;
	private RepositoryConfiguration configuration;
	private PostgresDatabase postgresql;
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

		PersistenceConfiguration persistenceConfiguration = buildPersistenceConfiguration(getConfiguration(), CREATE);
		persistenceContext = PersistenceContext.load(persistenceConfiguration);
	}

	@Override
	public void load() {
		PersistenceConfiguration persistenceConfiguration = buildPersistenceConfiguration(getConfiguration(), VALIDATE);
		persistenceContext = PersistenceContext.load(persistenceConfiguration);
	}

	@Override
	public void close() {
		if (persistenceContext != null)
			persistenceContext.close();
	}

	@Override
	public void delete() throws Exception {
		close();
		postgresql.dropDatabase();
	}

	@Override
	public RepositoryUtils getUtils() {
		return new RepositoryUtils(this);
	}

	public RepositoryDatabase getDatabase() {
		return database;
	}

	private PersistenceConfiguration buildPersistenceConfiguration(RepositoryConfiguration repositoryConfig, String hbm2dllAuto) {
		PersistenceConfigurationBuilder builder = new PersistenceConfigurationBuilder(repositoryConfig.getUrl());
		builder.withDriver(repositoryConfig.getDriver());
		builder.withDialect(repositoryConfig.getDialect());
		builder.withUser(repositoryConfig.getUser());
		builder.withPassword(repositoryConfig.getPassword());
		builder.withHbm2dllAuto(hbm2dllAuto);
		return builder.build();
	}

}
