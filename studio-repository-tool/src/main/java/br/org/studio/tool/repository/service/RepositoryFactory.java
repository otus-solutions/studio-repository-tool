package br.org.studio.tool.repository.service;

import br.org.studio.tool.repository.RepositoryConfiguration;
import br.org.studio.tool.repository.persitence.PersistenceConfiguration;
import br.org.studio.tool.repository.persitence.PersistenceConfigurationBuilder;
import br.org.studio.tool.repository.persitence.PersistenceContext;

public class RepositoryFactory {

	public static final String UNIT_NAME = "RepositoryPool";

	protected static final String CREATE = "create";
	protected static final String VALIDATE = "validate";

	private PersistenceContext persistenceContext;

	public RepositoryFactory() {
		persistenceContext = new PersistenceContext();
	}

	public void initialize(RepositoryConfiguration repositoryConfig) {
		PersistenceConfiguration configuration = buildPersistenceConfiguration(repositoryConfig, CREATE);
		persistenceContext.load(configuration);
		persistenceContext.close();
	}

	public void load(RepositoryConfiguration repositoryConfig) {
		PersistenceConfiguration configuration = buildPersistenceConfiguration(repositoryConfig, VALIDATE);
		persistenceContext.load(configuration);
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
}
