package br.org.studio.tool.base.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

public abstract class HibernateDatabase extends MetaDatabase implements Database {

	private Connection connection;

	protected HibernateDatabase(RepositoryConfiguration configuration) {
		super(configuration);
	}

	public Connection getConnection() throws Exception {
		Class.forName(getDriver());
		connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());

		if (connection.isClosed()) {
			throw new Exception();
		}

		return connection;
	}

	public void executeStatement(String sql) throws Exception {
		Statement statement = null;

		try {
			statement = getConnection().createStatement();
			statement.execute(sql);
		} catch (Exception exception) {
			setError(statement.getWarnings());
			getConnection().close();
		} finally {
			if (statement != null) {
				statement.close();
				getConnection().close();
			}
		}
	}

	public String getDialect() {
		return getConfiguration().getDialect();
	}

	public String getDriver() {
		return getConfiguration().getDriver();
	}

}
