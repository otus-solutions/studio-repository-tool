package br.org.studio.tool;

import br.org.studio.tool.base.repository.Repository;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.repository.MongoRepository;

public class RepositoryManagerFacade {

    private Repository getRepository(RepositoryConfiguration configuration) {
        return new MongoRepository(configuration);
    }

    public Repository createRepository(RepositoryConfiguration configuration) {
        Repository repository = getRepository(configuration);

        if (repository.isAccessible()) {
            repository.initialize();
            return repository;
        } else {
            return null;
        }
    }

    public void deleteRepository(RepositoryConfiguration configuration) {
        Repository repository = getRepository(configuration);

        if (repository.isAccessible()) {
            repository.delete();
        }
    }

    public Repository connectRepository(RepositoryConfiguration configuration) {
        Repository repository = getRepository(configuration);

        if (repository.isAccessible()) {
            repository.load();
            return repository;
        } else {
            return null;
        }
    }

    public Boolean isRepositoryAccessible(RepositoryConfiguration configuration) {
        Repository repository = getRepository(configuration);
        return repository.isAccessible();
    }

}
