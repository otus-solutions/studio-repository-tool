package br.org.studio.tool;

import br.org.studio.tool.base.repository.DefaultRepositoryDescriptor;
import br.org.studio.tool.base.repository.Repository;
import br.org.studio.tool.base.repository.RepositoryDescriptor;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.repository.MongoRepository;
import br.org.studio.tool.mongodb.repository.MongoRepositoryConfiguration;

import java.util.List;

public class RepositoryManagerFacade {
	
	
	public static void main(String[] args) {
		
		DefaultRepositoryDescriptor repo = new DefaultRepositoryDescriptor();
		RepositoryDescriptor repository = MongoRepositoryConfiguration.create(repo);
		System.out.println(repository.getHostName());	
		System.out.println(repository.getPort());		
	}
	

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

        Boolean result = repository.isAccessible();

        return result;
    }

    public Boolean existRepository(RepositoryDescriptor configuration){
        Repository repository = connectRepository(configuration);

        List<String> databaseNames = repository.getDatabaseNames();
        Boolean result = databaseNames.stream().filter(databaseName -> databaseName.equals(configuration.getDatabaseName())).findFirst().isPresent();

        return result;
    }

}
