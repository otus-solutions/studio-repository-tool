package br.org.studio.tool;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import br.org.studio.tool.database.mongodb.MongoClientFactory;

public class MongoRunner {

	public static void main(String[] args) {
		MongoClient client = MongoClientFactory.createClient();
		MongoDatabase database = client.getDatabase("mydb");
		System.out.println(database.getName());
	}

}
