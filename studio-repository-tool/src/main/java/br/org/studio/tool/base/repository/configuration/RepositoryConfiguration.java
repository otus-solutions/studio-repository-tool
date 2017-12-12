package br.org.studio.tool.base.repository.configuration;

import br.org.studio.tool.base.database.DatabaseUrl;
import br.org.studio.tool.base.repository.RepositoryConnectionDataDescriptor;
import br.org.studio.tool.base.repository.RepositoryDescriptor;
import br.org.studio.tool.base.repository.RepositoryType;

public abstract class RepositoryConfiguration implements RepositoryDescriptor {

    private String user;
    private String password;
    private RepositoryType repositoryType;
    private RepositoryConnectionDataDescriptor repositoryConnectionDataDescriptor;
    protected DatabaseUrl databaseUrl;

    protected RepositoryConfiguration(RepositoryType repositoryType, DatabaseUrl databaseUrl) {
        this.repositoryType = repositoryType;
        this.databaseUrl = databaseUrl;
    }

    public void setDatabaseUrl(DatabaseUrl databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    @Override
    public String getDatabaseName() {
        return databaseUrl.getDatabaseName();
    }

    public void setDatabaseName(String name) {
        databaseUrl.setDatabaseName(name);
    }

    public void setHostName(String host) {
        databaseUrl.setHost(host);
    }

    public void setPort(String port) {
        databaseUrl.setPort(port);
    }

    @Override
    public String getUserName() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public RepositoryConnectionDataDescriptor getRepositoryConnectionDataDescriptor() {
    	return repositoryConnectionDataDescriptor;
    }
    
    public void setRepositoryConnectionDataDescriptor(
			RepositoryConnectionDataDescriptor repositoryConnectionDataDescriptor) {
		this.repositoryConnectionDataDescriptor = repositoryConnectionDataDescriptor;
	}

	public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return databaseUrl.getUrl();
    }

    public RepositoryType getRepositoryType() {
        return repositoryType;
    }

}
