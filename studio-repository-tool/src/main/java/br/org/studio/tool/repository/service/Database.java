package br.org.studio.tool.repository.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class Database {

	private SQLWarning warnings;

	public Boolean hasError() {
		return (warnings == null) ? false : true;
	}

	public Connection getConnection() throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

		if (connection.isClosed()) {
			throw new Exception();
		}

		return connection;
	}

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

}
