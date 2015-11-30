package br.org.studio.tool.repository.service;

public class PostgresDatabaseBuilder {

	private static final String PORT = "5432";
	private static final String LOCALHOST = "localhost";
	private static final String POSTGRES = "postgres";

	private String dbname;
	private String host;
	private String port;
	private String user;
	private String password;
	
	public PostgreDatabase build() {
		PostgreDatabase database = new PostgreDatabase(dbname);

		database.setHost(getHost());
		database.setPort(getPort());
		database.setUser(getUser());
		database.setPassword(getPassword());

		return database;
	}

	public PostgresDatabaseBuilder withName(String dbname) {
		this.dbname = dbname;
		return this;
	}

	public PostgresDatabaseBuilder withHost(String host) {
		this.host = host;
		return this;
	}

	public PostgresDatabaseBuilder withPort(String port) {
		this.port = port;
		return this;
	}

	public PostgresDatabaseBuilder withUser(String user) {
		this.user = user;
		return this;
	}

	public PostgresDatabaseBuilder withPassword(String password) {
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
