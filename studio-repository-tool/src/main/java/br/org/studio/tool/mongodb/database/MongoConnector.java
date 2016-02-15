package br.org.studio.tool.mongodb.database;

import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.MongoTimeoutException;
import com.mongodb.ServerAddress;

public class MongoConnector {

	private MongoDatabaseUrl databaseUrl;
	private MongoClient client;
	private static final String DB_ADMIN = "admin";

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
    	return databaseUrl.getUrl();
    }

	public MongoClient createClient(MongoCredential credential) {
		MongoClientOptions clientOptions = MongoClientOptions.builder().serverSelectionTimeout(1000).build();
		return new MongoClient(createServerAddress(), Arrays.asList(credential), clientOptions);
	}

	private ServerAddress createServerAddress() {
		return new ServerAddress(getHost(), Integer.parseInt(getPort()));
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

	public Boolean isValidCredentials(String userName, String password) {
		try {
			client = createClient(MongoCredential.createCredential(userName, DB_ADMIN, password.toCharArray()));
			// Simple command that needs authentication
			client.listDatabaseNames().first();
			return Boolean.TRUE;
		} catch (MongoTimeoutException timeout) {
			if (MongoException.fromThrowable(timeout).toString().contains("Authentication failed.")) {
				System.out.println("ERROR: Authentication Failed.");
			}
			timeout.printStackTrace();
			return Boolean.FALSE;
		} finally {
			client.close();
		}
	}
}
