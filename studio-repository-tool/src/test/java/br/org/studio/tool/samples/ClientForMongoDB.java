package br.org.studio.tool.samples;

import br.org.studio.tool.RepositoryManagerFacade;
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
		builder.withHost("127.0.0.1").withPort("27017").withDatabaseName("meu_banco");
		return builder.buildForMongo();
	}

}
