package br.org.studio.tool.repository.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLWarning;

public class RepositoryDatabase implements Database {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	private static final String JDBC_POSTGRES = "jdbc:postgresql://";

	private String name;
	private String host;
	private String port;
	private String user;
	private String password;

	private SQLWarning warnings;
	private Connection connection;

	public RepositoryDatabase(String dbname) {
		this.name = dbname;
	}

	@Override
	public Boolean hasError() {
		return (warnings == null) ? false : true;
	}

	@Override
	public Connection getConnection() throws Exception {
		Class.forName(DRIVER);
		connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());

		if (connection.isClosed()) {
			throw new Exception();
		}

		return connection;
	}

	private String getUrlConnection() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(JDBC_POSTGRES);
		stringBuilder.append(getHost());
		stringBuilder.append(":");
		stringBuilder.append(getPort());
		stringBuilder.append("/");
		stringBuilder.append(getName());
		return stringBuilder.toString();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getDriver() {
		return DRIVER;
	}

	@Override
	public String getDialect() {
		return DIALECT;
	}

	@Override
	public String getUrl() {
		return getUrlConnection();
	}

}