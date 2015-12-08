package br.org.studio.tool.mongodb.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoClientFactory {

    public static MongoClient createClient(String host, String port) {
        MongoConnector connector = MongoConnector.getConnector(host, port);
        return new MongoClient(new MongoClientURI(connector.getUri()));
    }

}
