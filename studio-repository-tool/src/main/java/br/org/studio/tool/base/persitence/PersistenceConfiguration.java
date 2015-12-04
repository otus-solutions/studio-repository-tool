package br.org.studio.tool.base.persitence;

import java.util.HashMap;
import java.util.Map;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

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
		properties.put(PersistenceProperty.DRIVER.getValue(), value);
	}

	public void setUrl(String value) {
		properties.put(PersistenceProperty.URL.getValue(), value);
	}

	public void setUser(String value) {
		properties.put(PersistenceProperty.USER.getValue(), value);
	}

	public void setPassword(String value) {
		properties.put(PersistenceProperty.PASSWORD.getValue(), value);
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
		return getBuilder(repositoryConfig, CREATE).build();
	}

	public static PersistenceConfiguration forValidate(RepositoryConfiguration repositoryConfig) {
		return getBuilder(repositoryConfig, VALIDATE).build();
	}

	private static PersistenceConfigurationBuilder getBuilder(RepositoryConfiguration repositoryConfig, String hbm2dllAuto) {
		PersistenceConfigurationBuilder build = new PersistenceConfigurationBuilder();
		build.withUrl(repositoryConfig.getUrl());
		build.withDriver(repositoryConfig.getDriver());
		build.withDialect(repositoryConfig.getDialect());
		build.withUser(repositoryConfig.getUser());
		build.withPassword(repositoryConfig.getPassword());
		build.withHbm2dllAuto(hbm2dllAuto);
		return build;
	}

}
