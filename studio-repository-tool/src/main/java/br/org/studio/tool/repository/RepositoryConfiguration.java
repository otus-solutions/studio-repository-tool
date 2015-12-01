package br.org.studio.tool.repository;

import br.org.studio.tool.repository.service.Database;
import br.org.studio.tool.repository.service.RepositoryDatabaseBuilder;

public class RepositoryConfiguration {

	private Database database;

	protected RepositoryConfiguration(Database database) {
		this.database = database;
	}

	public String getName() {
		return database.getName();
	}

	public String getHost() {
		return database.getHost();
	}

	public String getPort() {
		return database.getPort();
	}

	public String getUser() {
		return database.getUser();
	}

	public String getPassword() {
		return database.getPassword();
	}

	public String getUrl() {
		return database.getUrl();
	}

	public String getDriver() {
		return database.getDriver();
	}

	public String getDialect() {
		return database.getDialect();
	}

	public Database getDatabase() {
		return database;
	}

	public static RepositoryConfiguration forPostgre(String name, String host, String port, String user, String password) {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();
		builder.withName(name).withHost(host).withPort(port).withUser(user).withPassword(password);
		return new RepositoryConfiguration(builder.build());
	}

}
