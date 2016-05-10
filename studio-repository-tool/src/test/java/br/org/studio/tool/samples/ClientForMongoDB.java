package br.org.studio.tool.samples;

import br.org.studio.tool.RepositoryManagerFacade;
import br.org.studio.tool.base.repository.RepositoryConnectionData;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.base.repository.configuration.RepositoryConfigurationBuilder;

public class ClientForMongoDB {

	public static void main(String[] args) throws Exception {
		ClientForMongoDB program = new ClientForMongoDB();
		program.run();
	}

	public void run() throws Exception {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();
		rmf.createRepository(getConfiguration());
	}

	private RepositoryConfiguration getConfiguration() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();
		builder.withRepositoryConnectionData(createRepositoryConnectionData());
		return builder.buildForMongo();
	}
	
    
    private RepositoryConnectionData createRepositoryConnectionData() {
    	RepositoryConnectionData repositoryConnectionData = new RepositoryConnectionData();
    	repositoryConnectionData.setHost("127.0.0.1");
    	repositoryConnectionData.setPort("27017");
    	repositoryConnectionData.setDatabase("admin");
    	repositoryConnectionData.setPassword("12345");
    	repositoryConnectionData.setUsername("superRoot");
    	return repositoryConnectionData;
    }

}
