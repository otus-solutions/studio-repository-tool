package br.org.studio.tool.postgres.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import br.org.studio.tool.base.database.HibernateDatabase;
import br.org.studio.tool.base.database.MetaDatabase;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

public class PostgresDatabase extends MetaDatabase implements HibernateDatabase {

	public static final String DRIVER = "org.postgresql.Driver";
	public static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	public static final String PROTOCOL = "jdbc:postgresql://";

	public PostgresDatabase(RepositoryConfiguration configuration) {
		super(configuration);
	}

	@Override
	public String getDriver() {
		return DRIVER;
	}

	@Override
	public String getUrl() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(PROTOCOL);
		stringBuilder.append(getHost());
		stringBuilder.append(":");
		stringBuilder.append(getPort());
		stringBuilder.append("/postgres");
		return stringBuilder.toString();
	}

	@Override
	public Connection getConnection() throws Exception {
		Class.forName(DRIVER);
		connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
		Connection sqlConnection = (Connection) connection;

		if (sqlConnection.isClosed()) {
			throw new Exception();
		}

		return sqlConnection;
	}

	@Override
	public String getDialect() {
		return DIALECT;
	}

	public void createDatabase() throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("CREATE DATABASE ");
		stringBuilder.append(getName());
		stringBuilder.append(" WITH OWNER = postgres");
		stringBuilder.append(" ENCODING = 'UTF8' ");
		stringBuilder.append(" TABLESPACE = pg_default ");
		stringBuilder.append(" LC_COLLATE = 'pt_BR.UTF-8' ");
		stringBuilder.append(" LC_CTYPE = 'pt_BR.UTF-8' ");
		stringBuilder.append(" CONNECTION LIMIT = -1;");
		String sql = stringBuilder.toString();
		executeStatement(sql);
	}

	public void dropDatabase() throws Exception {
		executeStatement("DROP DATABASE " + getName());
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

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
