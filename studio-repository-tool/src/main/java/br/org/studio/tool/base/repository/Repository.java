package br.org.studio.tool.base.repository;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

public interface Repository {

    RepositoryConfiguration getConfiguration();

    void initialize() throws Exception;

    void load();

    void close();

    void delete() throws Exception;

}
