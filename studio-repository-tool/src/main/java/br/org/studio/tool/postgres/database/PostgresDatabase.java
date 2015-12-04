package br.org.studio.tool.postgres.database;

import br.org.studio.tool.base.database.HibernateDatabase;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

public class PostgresDatabase extends HibernateDatabase {

	public static final String DRIVER = "org.postgresql.Driver";
	public static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	public static final String PROTOCOL = "jdbc:postgresql://";

	public PostgresDatabase(RepositoryConfiguration configuration) {
		super(configuration);
	}

	public void createDatabase(String databaseName) throws Exception {
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

	public void dropDatabase() throws Exception {
		executeStatement("DROP DATABASE " + getName());
	}

}
