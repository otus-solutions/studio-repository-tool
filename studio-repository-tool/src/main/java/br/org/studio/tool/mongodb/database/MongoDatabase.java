package br.org.studio.tool.mongodb.database;

import br.org.studio.tool.base.database.MetaDatabase;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

import com.mongodb.MongoClient;

public class MongoDatabase extends MetaDatabase {

	public static final String PROTOCOL = "mongodb://";

	private MongoClient client;
	private com.mongodb.client.MongoDatabase database;

	public MongoDatabase(RepositoryConfiguration configuration) {
		super(configuration);
		client = MongoClientFactory.createClient();
		database = client.getDatabase(configuration.getName());
	}

	@Override
	public Boolean hasError() {
		return null;
	}

	@Override
	public String getDriver() {
		return null;
	}

	public void close() {
		if (client != null)
			client.close();
	}

	public com.mongodb.client.MongoDatabase get() {
		return database;
	}

}
