package br.org.studio.tool.mongodb.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoClientFactory {

	public static MongoClient createClient() {
		MongoConnector connector = MongoConnector.localhostConnector();
		return new MongoClient(new MongoClientURI(connector.getUri()));
	}

}
