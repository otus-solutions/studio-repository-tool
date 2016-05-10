package br.org.studio.tool.base.repository.configuration;

import br.org.studio.tool.base.repository.RepositoryConnectionDataDescriptor;
import br.org.studio.tool.mongodb.repository.MongoRepositoryConfiguration;

public class RepositoryConfigurationBuilder {

    private String dbname;
    private String user;
    private String password;
    private RepositoryConnectionDataDescriptor repositoryConnectionDataDescriptor;

    public RepositoryConfiguration buildForMongo() {
        return build(new MongoRepositoryConfiguration());
    }

    private RepositoryConfiguration build(RepositoryConfiguration configuration) {
        configuration.setDatabaseName(dbname);
        configuration.setRepositoryConnectionDataDescriptor(repositoryConnectionDataDescriptor);
        configuration.setUser(getUser());
        configuration.setPassword(getPassword());

        return configuration;
    }

    public RepositoryConfigurationBuilder withDatabaseName(String dbname) {
        this.dbname = dbname;
        return this;
    }

    public RepositoryConfigurationBuilder withUser(String user) {
        this.user = user;
        return this;
    }

    public RepositoryConfigurationBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    private String getUser() {
        if (user == null || user.isEmpty()) {
            return null;
        } else {
            return user;
        }
    }

    private String getPassword() {
        if (password == null || password.isEmpty()) {
            return null;
        } else {
            return password;
        }
    }

	public RepositoryConfigurationBuilder withRepositoryConnectionData(RepositoryConnectionDataDescriptor repositoryConnectionDataDescriptor) {
		this.repositoryConnectionDataDescriptor = repositoryConnectionDataDescriptor;
		return this;
	}

}
