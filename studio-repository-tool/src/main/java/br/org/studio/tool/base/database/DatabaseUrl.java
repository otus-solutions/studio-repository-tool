package br.org.studio.tool.base.database;

public abstract class DatabaseUrl {

	private String host;
	private String port;
	private String name;

	public DatabaseUrl() {
		setDatabaseName("");
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host.trim();
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port.trim();
	}

	public String getDatabaseName() {
		return name;
	}

	public void setDatabaseName(String name) {
		if (name != null)
			this.name = name.trim();
	}

	public String getUrl() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getProtocol());
		stringBuilder.append(getHost());
		stringBuilder.append(":");
		stringBuilder.append(getPort());
		stringBuilder.append("/");
		stringBuilder.append(getDatabaseName());
		return stringBuilder.toString();
	}

	public abstract String getProtocol();

}
