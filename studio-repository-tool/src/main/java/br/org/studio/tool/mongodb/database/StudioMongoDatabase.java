package br.org.studio.tool.mongodb.database;

import org.bson.Document;

import br.org.studio.tool.base.database.MetaDatabase;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class StudioMongoDatabase extends MetaDatabase {

	public static final String PROTOCOL = "mongodb://";

	private MongoClient client;
	private MongoDatabase database;

	public StudioMongoDatabase(RepositoryConfiguration configuration) {
		super(configuration);
		client = MongoClientFactory.createClient();
		database = client.getDatabase(configuration.getName());
		createMetaInformation();
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

	public MongoDatabase get() {
		return database;
	}

	private void createMetaInformation() {
		MongoCollection<Document> info = database.getCollection(MetaInformation.COLLECTION.getValue());

		Document document = new Document();
		document.append(MetaInformation.DBNAME.getValue(), getName());
		document.append(MetaInformation.HOST.getValue(), getHost());
		document.append(MetaInformation.PORT.getValue(), getPort());

		info.insertOne(document);
	}

}
