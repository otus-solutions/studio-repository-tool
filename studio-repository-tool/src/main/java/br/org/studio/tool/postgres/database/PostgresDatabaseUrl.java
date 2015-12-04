package br.org.studio.tool.postgres.database;

import br.org.studio.tool.base.database.DatabaseUrl;

public class PostgresDatabaseUrl extends DatabaseUrl {

	@Override
	public String getProtocol() {
		return PostgresDatabase.PROTOCOL;
	}

}
