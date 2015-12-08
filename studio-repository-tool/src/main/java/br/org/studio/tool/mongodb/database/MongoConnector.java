package br.org.studio.tool.mongodb.database;

public class MongoConnector {

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

	public static MongoConnector getConnector(String host, String port) {
		return new MongoConnector(host, port);
	}

	public String getUri() {
		int lastDash = databaseUrl.getUrl().lastIndexOf("/");
		return databaseUrl.getUrl().substring(0, lastDash);
	}

}
