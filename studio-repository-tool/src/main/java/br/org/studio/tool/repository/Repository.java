package br.org.studio.tool.repository;

import br.org.studio.tool.RepositoryConfiguration;

public interface Repository {

	RepositoryConfiguration getConfiguration();

	void initialize() throws Exception;

	void load();

	void close();

	void delete() throws Exception;

	RepositoryUtils getUtils();

}
