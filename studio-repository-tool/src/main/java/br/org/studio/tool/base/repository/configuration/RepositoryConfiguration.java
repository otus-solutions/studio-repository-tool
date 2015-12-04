package br.org.studio.tool.base.repository.configuration;

import br.org.studio.tool.base.database.HibernateDatabase;
import br.org.studio.tool.base.repository.RepositoryDatabase;
import br.org.studio.tool.base.repository.RepositoryType;
import br.org.studio.tool.postgres.database.PostgresDatabase;

public abstract class RepositoryConfiguration {

	private String name;
	private String host;
	private String port;
	private String user;
	private String password;
	private RepositoryType repositoryType;

	protected RepositoryConfiguration(RepositoryType repositoryType) {
		this.repositoryType = repositoryType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriver() {
		return PostgresDatabase.DRIVER;
	}

	public String getDialect() {
		return PostgresDatabase.DIALECT;
	}

	public RepositoryType getRepositoryType() {
		return repositoryType;
	}

	// TODO: limpar isso
	public HibernateDatabase buildMetaDatabase() {
		RepositoryDatabase repository = new RepositoryDatabase(getName());
		repository.setHost(getHost());
		repository.setPort(getPort());
		repository.setUser(getUser());
		repository.setPassword(getPassword());
		return repository;
	}

	public abstract String getUrl();

}
