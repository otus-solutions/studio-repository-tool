package br.org.studio.tool.repository.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class PostgreDatabase implements Database {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	private static final String JDBC_POSTGRES = "jdbc:postgresql://";

	private String name;
	private String host;
	private String port;
	private String user;
	private String password;

	private SQLWarning warnings;

	public PostgreDatabase(String dbname) {
		this.name = dbname;
		this.host = "localhost";
		this.port = "5432";
		this.user = "postgres";
		this.password = "postgres";
	}

	public PostgreDatabase(String dbname, String host, String port, String user, String password) {
		this.name = dbname;
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
	}

	@Override
	public Boolean hasError() {
		return (warnings == null) ? false : true;
	}

	@Override
	public Connection getConnection() throws Exception {
		Class.forName(DRIVER);
		Connection connection = null;
		connection = DriverManager.getConnection(JDBC_POSTGRES + getHost() + ":" + getPort() + "/postgres", getUser(), getPassword());

		if (connection.isClosed()) {
			throw new Exception();
		}

		return connection;
	}

	@Override
	public void createDatabase(String databaseName) throws SQLException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("CREATE DATABASE ");
		stringBuilder.append(databaseName);
		stringBuilder.append(" WITH OWNER = postgres");
		stringBuilder.append(" ENCODING = 'UTF8' ");
		stringBuilder.append(" TABLESPACE = pg_default ");
		stringBuilder.append(" LC_COLLATE = 'pt_BR.UTF-8' ");
		stringBuilder.append(" LC_CTYPE = 'pt_BR.UTF-8' ");
		stringBuilder.append(" CONNECTION LIMIT = -1;");
		String sql = stringBuilder.toString();
		executeStatement(sql);
	}

	@Override
	public void dropDatabase(String databaseName) throws SQLException {
		executeStatement("DROP DATABASE " + databaseName);
	}

	private void executeStatement(String sql) throws SQLException {
		Statement statement = null;

		try {
			statement = getConnection().createStatement();
			statement.execute(sql);
		} catch (Exception exception) {
			warnings = statement.getWarnings();
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public String getPort() {
		return port;
	}

	@Override
	public String getUser() {
		return user;
	}

	@Override
	public String getPassword() {
		return password;
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
		return JDBC_POSTGRES + getHost() + ":" + getPort() + "/" + getName();
	}

}
