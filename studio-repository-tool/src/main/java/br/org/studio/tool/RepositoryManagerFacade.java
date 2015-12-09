package br.org.studio.tool;

import br.org.studio.tool.base.repository.Repository;
import br.org.studio.tool.base.repository.RepositoryDescriptor;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.repository.MongoRepository;

public class RepositoryManagerFacade {

    private Repository getRepository(RepositoryDescriptor configuration) {
        return new MongoRepository((RepositoryConfiguration) configuration);
    }

    public Repository createRepository(RepositoryDescriptor configuration) {
        Repository repository = getRepository(configuration);

        if (repository.isAccessible()) {
            repository.initialize();
            return repository;
        } else {
            return null;
        }
    }

    public void deleteRepository(RepositoryDescriptor configuration) {
        Repository repository = getRepository(configuration);

        if (repository.isAccessible()) {
            repository.delete();
        }
    }

    public Repository connectRepository(RepositoryDescriptor configuration) {
        Repository repository = getRepository(configuration);

        if (repository.isAccessible()) {
            repository.load();
            return repository;
        } else {
            return null;
        }
    }

    public Boolean isRepositoryAccessible(RepositoryDescriptor configuration) {
        Repository repository = getRepository(configuration);
        return repository.isAccessible();
    }

}
