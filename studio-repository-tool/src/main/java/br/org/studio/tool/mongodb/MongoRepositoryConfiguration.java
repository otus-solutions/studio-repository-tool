package br.org.studio.tool.mongodb;

import br.org.studio.tool.base.repository.RepositoryType;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.base.repository.configuration.RepositoryConfigurationBuilder;
import br.org.studio.tool.mongodb.database.MongoDatabase;

public class MongoRepositoryConfiguration extends RepositoryConfiguration {

	public MongoRepositoryConfiguration() {
		super(RepositoryType.MONGODB);
	}

	@Override
	public String getUrl() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(MongoDatabase.PROTOCOL);
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
		return builder.buildForMongo();
	}

}
