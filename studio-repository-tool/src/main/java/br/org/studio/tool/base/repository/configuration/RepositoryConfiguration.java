package br.org.studio.tool.base.repository.configuration;

import br.org.studio.tool.base.database.DatabaseUrl;
import br.org.studio.tool.base.repository.RepositoryType;
import br.org.studio.tool.postgres.database.PostgresDatabase;

public abstract class RepositoryConfiguration {

	private String user;
	private String password;
	private RepositoryType repositoryType;
	protected DatabaseUrl databaseUrl;

	protected RepositoryConfiguration(RepositoryType repositoryType, DatabaseUrl databaseUrl) {
		this.repositoryType = repositoryType;
		this.databaseUrl = databaseUrl;
	}

	public void setDatabaseUrl(DatabaseUrl databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

	public String getName() {
		return databaseUrl.getDbName();
	}

	public void setName(String name) {
		databaseUrl.setDbName(name);
	}

	public String getHost() {
		return databaseUrl.getHost();
	}

	public void setHost(String host) {
		databaseUrl.setHost(host);
	}

	public String getPort() {
		return databaseUrl.getPort();
	}

	public void setPort(String port) {
		databaseUrl.setPort(port);
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

	public String getUrl() {
		return databaseUrl.getUrl();
	}

}
