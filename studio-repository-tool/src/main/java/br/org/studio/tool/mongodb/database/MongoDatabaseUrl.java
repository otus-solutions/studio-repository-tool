package br.org.studio.tool.mongodb.database;

import br.org.studio.tool.base.database.DatabaseUrl;

public class MongoDatabaseUrl extends DatabaseUrl {

	@Override
	public String getProtocol() {
		return StudioMongoDatabase.PROTOCOL;
	}

}
