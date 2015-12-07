package br.org.studio.tool.mongodb.database;

public class MongoConnector {

	public static final String LOCALHOST = "127.0.0.1";
	public static final String DEFAULT_PORT = "27017";

	private MongoDatabaseUrl databaseUrl;

	private MongoConnector(String host, String port) {
		databaseUrl = new MongoDatabaseUrl();
		databaseUrl.setHost(host);
		databaseUrl.setPort(port);
	}

	public String getHost() {
		return databaseUrl.getHost();
	}

	public String getPort() {
		return databaseUrl.getPort();
	}

	public static MongoConnector localhostConnector() {
		return new MongoConnector(LOCALHOST, DEFAULT_PORT);
	}

	public static MongoConnector externalHostConnector(String host, String port) {
		return new MongoConnector(host, port);
	}

	public String getUri() {
		int lastDash = databaseUrl.getUrl().lastIndexOf("/");
		return databaseUrl.getUrl().substring(0, lastDash);
	}

}
