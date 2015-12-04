package br.org.studio.tool.base.repository;

import br.org.studio.tool.base.database.HibernateDatabase;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

public class RepositoryDatabase extends HibernateDatabase {

	public RepositoryDatabase(RepositoryConfiguration configuration) {
		super(configuration);
	}

}
