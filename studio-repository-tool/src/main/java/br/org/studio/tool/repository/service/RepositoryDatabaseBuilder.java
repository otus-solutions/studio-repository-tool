package br.org.studio.tool.repository.service;

public class RepositoryDatabaseBuilder {

	private static final String PORT = "5432";
	private static final String LOCALHOST = "localhost";
	private static final String POSTGRES = "postgres";

	private String dbname;
	private String host;
	private String port;
	private String user;
	private String password;

	public RepositoryDatabase build() {
		RepositoryDatabase database = new RepositoryDatabase(dbname);

		database.setHost(getHost());
		database.setPort(getPort());
		database.setUser(getUser());
		database.setPassword(getPassword());

		return database;
	}

	public RepositoryDatabaseBuilder withName(String dbname) {
		this.dbname = dbname;
		return this;
	}

	public RepositoryDatabaseBuilder withHost(String host) {
		this.host = host;
		return this;
	}

	public RepositoryDatabaseBuilder withPort(String port) {
		this.port = port;
		return this;
	}

	public RepositoryDatabaseBuilder withUser(String user) {
		this.user = user;
		return this;
	}

	public RepositoryDatabaseBuilder withPassword(String password) {
		this.password = password;
		return this;
	}

	private String getHost() {
		if (host == null || host.isEmpty()) {
			return LOCALHOST;
		} else {
			return host;
		}
	}

	private String getPort() {
		if (port == null || port.isEmpty()) {
			return PORT;
		} else {
			return port;
		}
	}

	private String getUser() {
		if (user == null || user.isEmpty()) {
			return POSTGRES;
		} else {
			return user;
		}
	}

	private String getPassword() {
		if (password == null || password.isEmpty()) {
			return POSTGRES;
		} else {
			return password;
		}
	}

}
