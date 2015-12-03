package br.org.studio.tool.database.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoClientFactory {

	public static MongoClient createClient() {
		MongoDbConnector connector = MongoDbConnector.localhostConnector();
		return new MongoClient(new MongoClientURI(connector.getUri()));
	}

}
