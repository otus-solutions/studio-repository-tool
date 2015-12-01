package br.org.studio.tool.repository.database;

import br.org.studio.tool.repository.RepositoryConfiguration;
import br.org.studio.tool.repository.persitence.PersistenceConfiguration;
import br.org.studio.tool.repository.persitence.PersistenceConfigurationBuilder;
import br.org.studio.tool.repository.persitence.PersistenceContext;

public class Repository {

	private static final String CREATE = "create";
	private static final String VALIDATE = "validate";

	private PersistenceContext persistenceContext;
	private RepositoryConfiguration configuration;

	public Repository(RepositoryConfiguration configuration) {
		this.configuration = configuration;
	}

	public RepositoryConfiguration getConfiguration() {
		return configuration;
	}

	public void initialize() {
		PersistenceConfiguration persistenceConfiguration = buildPersistenceConfiguration(getConfiguration(), CREATE);
		persistenceContext = PersistenceContext.load(persistenceConfiguration);
	}

	public void load() {
		PersistenceConfiguration persistenceConfiguration = buildPersistenceConfiguration(getConfiguration(), VALIDATE);
		persistenceContext = PersistenceContext.load(persistenceConfiguration);
	}

	public void close() {
		if (persistenceContext != null)
			persistenceContext.close();
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

	public RepositoryUtils getUtils() {
		return new RepositoryUtils(this);
	}

}
