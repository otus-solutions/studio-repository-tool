package br.org.studio.tool.mongodb.database;

public class MongoConnector {

	private static final String LOCALHOST = "127.0.0.1";
	private static final String DEFAULT_PORT = "27017";
	private static final String PROTOCOL = "mongodb://";

	private String host;
	private String port;

	private MongoConnector(String host, String port) {
		this.host = host;
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public static MongoConnector localhostConnector() {
		return new MongoConnector(LOCALHOST, DEFAULT_PORT);
	}

	public static MongoConnector externalHostConnector(String host, String port) {
		return new MongoConnector(host, port);
	}

	public String getUri() {
		return PROTOCOL + getHost() + ":" + getPort();
	}

}
