package br.org.studio.tool.repository;

import java.sql.SQLException;

public class Studio {

	public static void main(String[] args) throws SQLException {
		RepositoryConfiguration configuration = RepositoryConfiguration.forPostgre("meu_banco", "localhost", "5432", "postgres", "postgres");
		RepositoryManagerFacade managerFacade = new RepositoryManagerFacade();

		managerFacade.createRepository(configuration);
		managerFacade.deleteRepository(configuration);
	}

}
