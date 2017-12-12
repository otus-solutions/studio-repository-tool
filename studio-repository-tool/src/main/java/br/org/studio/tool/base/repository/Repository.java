package br.org.studio.tool.base.repository;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import java.util.List;

public interface Repository {

    RepositoryConfiguration getDescriptor();

    void create();

    void load();

    void close();

    void delete();

    Boolean isAccessible();

    List<String> getDatabaseNames();
}
