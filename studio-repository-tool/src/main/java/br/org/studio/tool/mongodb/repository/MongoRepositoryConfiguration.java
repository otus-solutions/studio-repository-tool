package br.org.studio.tool.mongodb.repository;

import br.org.studio.tool.base.repository.RepositoryType;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.base.repository.configuration.RepositoryConfigurationBuilder;
import br.org.studio.tool.mongodb.database.MongoDatabaseUrl;

public class MongoRepositoryConfiguration extends RepositoryConfiguration {

	public MongoRepositoryConfiguration() {
		super(RepositoryType.MONGODB, new MongoDatabaseUrl());
	}

	public static RepositoryConfiguration create(String name, String host, String port, String user, String password) {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();
		builder.withDatabaseName(name).withHost(host).withPort(port).withUser(user).withPassword(password);
		return builder.buildForMongo();
	}

}
