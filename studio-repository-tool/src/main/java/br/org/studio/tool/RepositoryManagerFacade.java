package br.org.studio.tool;

import java.util.HashMap;
import java.util.Map;

import br.org.studio.tool.base.repository.Repository;
import br.org.studio.tool.base.repository.RepositoryUtils;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.repository.MongoRepository;

public class RepositoryManagerFacade {

    private Map<String, Repository> repositories;

    public RepositoryManagerFacade() {
        repositories = new HashMap<>();
    }

    public void createRepository(RepositoryConfiguration configuration) throws Exception {
        Repository repository = getRepository(configuration);
        repository.initialize();

        repositories.put(configuration.getName(), repository);
    }

    public void deleteRepository(RepositoryConfiguration configuration) throws Exception {
        repositories.get(configuration.getName()).delete();
    }

    public RepositoryUtils connectRepository(RepositoryConfiguration configuration) {
        Repository repository = repositories.get(configuration.getName());
        repository.load();
        return repository.getUtils();
    }

    private Repository getRepository(RepositoryConfiguration configuration) {
        return new MongoRepository(configuration);
    }

}
