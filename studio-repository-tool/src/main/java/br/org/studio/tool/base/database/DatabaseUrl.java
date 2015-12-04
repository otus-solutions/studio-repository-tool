package br.org.studio.tool.base.database;

public abstract class DatabaseUrl {

	private String host;
	private String port;
	private String name;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDbName() {
		return name;
	}

	public void setDbName(String name) {
		this.name = name;
	}

	public String getUrl() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getProtocol());
		stringBuilder.append(getHost());
		stringBuilder.append(":");
		stringBuilder.append(getPort());
		stringBuilder.append("/");
		stringBuilder.append(getDbName());
		return stringBuilder.toString();
	}

	public abstract String getProtocol();

}
