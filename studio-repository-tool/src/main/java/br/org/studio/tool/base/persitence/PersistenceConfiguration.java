package br.org.studio.tool.base.persitence;

import java.util.HashMap;
import java.util.Map;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.postgres.database.PostgresDatabase;

public class PersistenceConfiguration {

	private static final String CREATE = "create";
	private static final String VALIDATE = "validate";

	private Map<String, String> properties = new HashMap<>();

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public PersistenceConfiguration() {
		properties = new HashMap<>();
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setDriver(String value) {
		properties.put(JpaProperty.DRIVER.getValue(), value);
	}

	public void setUrl(String value) {
		properties.put(JpaProperty.URL.getValue(), value);
	}

	public void setUser(String value) {
		properties.put(JpaProperty.USER.getValue(), value);
	}

	public void setPassword(String value) {
		properties.put(JpaProperty.PASSWORD.getValue(), value);
	}

	public void setDialect(String value) {
		properties.put(HibernateProperty.DIALECT.getValue(), value);
	}

	public void setDefaultSchema(String value) {
		properties.put(HibernateProperty.DEFAULT_SCHEMA.getValue(), value);
	}

	public void setShowSql(String value) {
		properties.put(HibernateProperty.SHOW_SQL.getValue(), value);
	}

	public void setAutoCommit(String value) {
		properties.put(HibernateProperty.AUTOCOMMIT.getValue(), value);
	}

	public void setHbm2DllAuto(String value) {
		properties.put(HibernateProperty.HBM2DLL_AUTO.getValue(), value);
	}

	public static PersistenceConfiguration forCreate(RepositoryConfiguration repositoryConfig) {
		PersistenceConfigurationBuilder builder = new PersistenceConfigurationBuilder(repositoryConfig.getUrl());
		builder.withDriver(PostgresDatabase.DRIVER);
		builder.withDialect(PostgresDatabase.DIALECT);
		builder.withUser(repositoryConfig.getUser());
		builder.withPassword(repositoryConfig.getPassword());
		builder.withHbm2dllAuto(CREATE);
		return builder.build();
	}
	
	public static PersistenceConfiguration forValidate(RepositoryConfiguration repositoryConfig) {
		PersistenceConfigurationBuilder builder = new PersistenceConfigurationBuilder(repositoryConfig.getUrl());
		builder.withDriver(PostgresDatabase.DRIVER);
		builder.withDialect(PostgresDatabase.DIALECT);
		builder.withUser(repositoryConfig.getUser());
		builder.withPassword(repositoryConfig.getPassword());
		builder.withHbm2dllAuto(VALIDATE);
		return builder.build();
	}

}
