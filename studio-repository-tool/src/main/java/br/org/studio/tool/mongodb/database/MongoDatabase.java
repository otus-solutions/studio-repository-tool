package br.org.studio.tool.mongodb.database;

import java.sql.Connection;

import br.org.studio.tool.base.database.MetaDatabase;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

public class MongoDatabase extends MetaDatabase {

	public static final String PROTOCOL = "mongodb://";

	public MongoDatabase(RepositoryConfiguration configuration) {
		super(configuration);
	}

	@Override
	public Boolean hasError() {
		return null;
	}

	@Override
	public String getUrl() {
		StringBuilder builder = new StringBuilder();
		builder.append(PROTOCOL);
		builder.append(getHost());
		builder.append(":");
		builder.append(getPort());
		builder.append("/");
		builder.append(getName());
		return builder.toString();
	}

	@Override
	public String getDriver() {
		return null;
	}

	@Override
	public Connection getConnection() throws Exception {
		return null;
	}

}
