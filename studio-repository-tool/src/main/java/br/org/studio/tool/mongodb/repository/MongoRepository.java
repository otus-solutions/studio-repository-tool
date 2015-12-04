package br.org.studio.tool.mongodb.repository;

import org.bson.Document;

import br.org.studio.tool.base.repository.Repository;
import br.org.studio.tool.base.repository.RepositoryUtils;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.database.MongoClientFactory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoRepository implements Repository {
	
	private MongoClient client;
	private RepositoryConfiguration configuration;
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
		insertMetaInformation();
	}

	private void insertMetaInformation() {
		MongoCollection<Document> info = database.getCollection("info");

		Document document = new Document();
		document.append("name", configuration.getName());
		document.append("host", configuration.getHost());
		document.append("port", configuration.getPort());

		info.insertOne(document);
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
