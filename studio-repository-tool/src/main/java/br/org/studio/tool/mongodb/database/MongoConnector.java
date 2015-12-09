package br.org.studio.tool.mongodb.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoSocketOpenException;

public class MongoConnector {

    private MongoDatabaseUrl databaseUrl;

    private MongoConnector(String host, String port) {
        databaseUrl = new MongoDatabaseUrl();
        databaseUrl.setHost(host);
        databaseUrl.setPort(port);
    }

    public static MongoConnector getConnector(String host, String port) {
        return new MongoConnector(host, port);
    }

    public String getHost() {
        return databaseUrl.getHost();
    }

    public String getPort() {
        return databaseUrl.getPort();
    }

    public String getUri() {
        int lastDash = databaseUrl.getUrl().lastIndexOf("/");
        return databaseUrl.getUrl().substring(0, lastDash);
    }

    public MongoClient createClient() {
        try {
            return new MongoClient(new MongoClientURI(getUri()));
        } catch (MongoSocketOpenException exception) {
            return null;
        }
    }

    public Boolean testConnection() {
        MongoClient client = createClient();
        Boolean result = null;

        if (client != null) {
            client.close();
            result = true;
        } else {
            result = false;
        }

        return result;
    }

}
