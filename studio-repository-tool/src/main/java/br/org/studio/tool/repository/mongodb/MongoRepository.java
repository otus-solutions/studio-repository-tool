package br.org.studio.tool.repository.mongodb;

import br.org.studio.tool.RepositoryConfiguration;
import br.org.studio.tool.database.mongodb.MongoClientFactory;
import br.org.studio.tool.repository.Repository;
import br.org.studio.tool.repository.RepositoryUtils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoRepository implements Repository {

	private RepositoryConfiguration configuration;
	private MongoClient client;
	private MongoDatabase database;

	public MongoRepository(RepositoryConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	public RepositoryConfiguration getConfiguration() {
		return configuration;
	}

	@Override
	public void initialize() {
		client = MongoClientFactory.createClient();
		database = client.getDatabase(configuration.getName());
	}

	@Override
	public void load() {
	}

	@Override
	public void delete() throws Exception {
	}

	@Override
	public void close() {
		if (client != null)
			client.close();
	}

	@Override
	public RepositoryUtils getUtils() {
		return null;
	}

	public MongoDatabase getDatabase() {
		return database;
	}

}
