package br.org.studio.tool.repository;

import br.org.studio.tool.RepositoryConfiguration;
import br.org.studio.tool.RepositoryType;

public class RepositoryConfigurationBuilder {

	private static final String PORT = "5432";
	private static final String LOCALHOST = "localhost";
	private static final String POSTGRES = "postgres";

	private String dbname;
	private String host;
	private String port;
	private String user;
	private String password;

	public RepositoryConfiguration buildPostgresConfiguration() {
		RepositoryConfiguration configuration = new RepositoryConfiguration(RepositoryType.POSTGRESQL);

		configuration.setName(dbname);
		configuration.setHost(getHost());
		configuration.setPort(getPort());
		configuration.setUser(getUser());
		configuration.setPassword(getPassword());

		return configuration;
	}

	public RepositoryConfigurationBuilder withName(String dbname) {
		this.dbname = dbname;
		return this;
	}

	public RepositoryConfigurationBuilder withHost(String host) {
		this.host = host;
		return this;
	}

	public RepositoryConfigurationBuilder withPort(String port) {
		this.port = port;
		return this;
	}

	public RepositoryConfigurationBuilder withUser(String user) {
		this.user = user;
		return this;
	}

	public RepositoryConfigurationBuilder withPassword(String password) {
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
