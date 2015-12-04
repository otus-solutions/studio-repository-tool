package br.org.studio.tool.mongodb.repository;

import org.bson.Document;

import br.org.studio.tool.base.repository.Repository;
import br.org.studio.tool.base.repository.RepositoryUtils;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.database.MongoDatabase;

import com.mongodb.client.MongoCollection;

public class MongoRepository implements Repository {

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
		database = new MongoDatabase(configuration);
		insertMetaInformation();
	}

	private void insertMetaInformation() {
		MongoCollection<Document> info = database.get().getCollection("info");

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
		database.close();
	}

	@Override
	public RepositoryUtils getUtils() {
		return null;
	}

	public MongoDatabase getDatabase() {
		return database;
	}

}
