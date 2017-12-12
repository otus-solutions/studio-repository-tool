package br.org.studio.tool.base.repository;

public class RepositoryConnectionData implements RepositoryConnectionDataDescriptor {
	
	private String database;
	private String port;
	private String host;
	private String password;
	private String username;
	
	public RepositoryConnectionData() {
		super();
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getDatabase() {
		return this.database;
	}

	@Override
	public String getPort() {
		return this.port;
	}

	@Override
	public String getHost() {
		return this.host;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

}
