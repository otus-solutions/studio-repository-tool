package br.org.studio.tool.base.repository;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

public interface Repository {

    RepositoryConfiguration getDescriptor();

    void initialize();

    void load();

    void close();

    void delete();

    Boolean isAccessible();

}
