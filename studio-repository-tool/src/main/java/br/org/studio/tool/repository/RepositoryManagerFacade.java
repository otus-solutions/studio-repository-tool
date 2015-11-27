package br.org.studio.tool.repository;

import java.sql.SQLException;

import br.org.studio.tool.repository.service.Database;

public class RepositoryManagerFacade {

	private Database postgresql;

	public RepositoryManagerFacade() {
		postgresql = new Database();
	}

	public void createRepository(String repositoryName) throws SQLException {
		postgresql.createDatabase(repositoryName);
	}

	public void deleteRepository(String repositoryName) throws SQLException {
		postgresql.dropDatabase(repositoryName);
	}

}
