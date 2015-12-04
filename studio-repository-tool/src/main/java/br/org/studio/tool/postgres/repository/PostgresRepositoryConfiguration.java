package br.org.studio.tool.postgres.repository;

import br.org.studio.tool.base.repository.RepositoryType;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.base.repository.configuration.RepositoryConfigurationBuilder;
import br.org.studio.tool.postgres.database.PostgresDatabase;
import br.org.studio.tool.postgres.database.PostgresDatabaseUrl;

public class PostgresRepositoryConfiguration extends RepositoryConfiguration {

	public PostgresRepositoryConfiguration() {
		super(RepositoryType.POSTGRESQL, new PostgresDatabaseUrl());
	}

	public String getDriver() {
		return PostgresDatabase.DRIVER;
	}

	public String getDialect() {
		return PostgresDatabase.DIALECT;
	}

	public static RepositoryConfiguration create(String name, String host, String port, String user, String password) {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();
		builder.withDatabaseName(name).withHost(host).withPort(port).withUser(user).withPassword(password);
		return builder.buildForPostgres();
	}

}
