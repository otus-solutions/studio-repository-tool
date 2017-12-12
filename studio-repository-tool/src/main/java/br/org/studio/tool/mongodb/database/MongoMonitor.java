package br.org.studio.tool.mongodb.database;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoIterable;

public class MongoMonitor {

	private MongoClient mongoClient;

	public MongoMonitor(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public ListDatabasesIterable<Document> listDatabases() {
		return mongoClient.listDatabases();
	}

	public MongoIterable<String> listDatabaseNames() {
		return mongoClient.listDatabaseNames();
	}

}
