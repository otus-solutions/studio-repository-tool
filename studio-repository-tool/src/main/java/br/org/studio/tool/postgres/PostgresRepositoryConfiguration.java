package br.org.studio.tool.postgres;

import br.org.studio.tool.base.repository.RepositoryType;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.base.repository.configuration.RepositoryConfigurationBuilder;
import br.org.studio.tool.postgres.database.PostgresDatabase;

public class PostgresRepositoryConfiguration extends RepositoryConfiguration {

	public PostgresRepositoryConfiguration() {
		super(RepositoryType.POSTGRESQL);
	}

	public String getDriver() {
		return PostgresDatabase.DRIVER;
	}

	public String getDialect() {
		return PostgresDatabase.DIALECT;
	}

	public String getUrl() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(PostgresDatabase.PROTOCOL);
		stringBuilder.append(getHost());
		stringBuilder.append(":");
		stringBuilder.append(getPort());
		stringBuilder.append("/");
		stringBuilder.append(getName());
		return stringBuilder.toString();
	}

	public static RepositoryConfiguration create(String name, String host, String port, String user, String password) {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();
		builder.withDatabaseName(name).withHost(host).withPort(port).withUser(user).withPassword(password);
		return builder.buildForPostgres();
	}

}
