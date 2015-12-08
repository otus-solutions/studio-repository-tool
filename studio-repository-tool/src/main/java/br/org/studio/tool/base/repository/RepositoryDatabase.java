package br.org.studio.tool.base.repository;

import br.org.studio.tool.base.database.MetaDatabase;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

public class RepositoryDatabase extends MetaDatabase {

	public RepositoryDatabase(RepositoryConfiguration configuration) {
		super(configuration);
	}

	@Override
	public String getDriver() {
		return null;
	}

}
