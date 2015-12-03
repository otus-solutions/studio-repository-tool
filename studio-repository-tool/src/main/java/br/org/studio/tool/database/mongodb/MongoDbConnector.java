package br.org.studio.tool.database.mongodb;

public class MongoDbConnector {

	private static final String LOCALHOST = "127.0.0.1";
	private static final String DEFAULT_PORT = "27017";
	private static final String PROTOCOL = "mongodb://";

	private String host;
	private String port;

	private MongoDbConnector(String host, String port) {
		this.host = host;
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public static MongoDbConnector localhostConnector() {
		return new MongoDbConnector(LOCALHOST, DEFAULT_PORT);
	}

	public static MongoDbConnector externalHostConnector(String host, String port) {
		return new MongoDbConnector(host, port);
	}

	public String getUri() {
		return PROTOCOL + getHost() + ":" + getPort();
	}

}
