package br.org.studio.tool.mongodb.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.io.IOException;
import java.net.Socket;

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
        return new MongoClient(new MongoClientURI(getUri()));
    }

    public Boolean testConnection() {
        try {
            Socket socket = new Socket(databaseUrl.getHost(), Integer.valueOf(databaseUrl.getPort()));
            socket.close();

            return Boolean.TRUE;

        } catch (IOException e) {
            return Boolean.FALSE;
        }
    }
}
