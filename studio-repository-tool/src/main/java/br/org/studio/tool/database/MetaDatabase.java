package br.org.studio.tool.database;

import java.sql.Connection;

import br.org.studio.tool.RepositoryConfiguration;

public abstract class MetaDatabase implements Database {

	protected String name;
	protected String host;
	protected String port;
	protected String user;
	protected String password;

	protected Object connection;

	private Object warnings;

	public MetaDatabase(RepositoryConfiguration configuration) {
		this.name = configuration.getName();
		this.host = configuration.getHost();
		this.port = configuration.getPort();
		this.user = configuration.getUser();
		this.password = configuration.getPassword();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public String getPort() {
		return port;
	}

	@Override
	public String getUser() {
		return user;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Boolean hasError() {
		return (warnings == null) ? false : true;
	}

	protected void setError(Object error) {
		warnings = error;
	}

	@Override
	public abstract String getDriver();

	@Override
	public abstract String getUrl();

	@Override
	public abstract Connection getConnection() throws Exception;

}
