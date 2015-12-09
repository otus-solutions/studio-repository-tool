package br.org.studio.tool.base.repository.configuration;

import br.org.studio.tool.base.database.DatabaseUrl;
import br.org.studio.tool.base.repository.RepositoryDescriptor;
import br.org.studio.tool.base.repository.RepositoryType;

public abstract class RepositoryConfiguration implements RepositoryDescriptor {

    private String repositoryName;
    private String user;
    private String password;
    private RepositoryType repositoryType;
    private String description;
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

    @Override
    public String getHostName() {
        return databaseUrl.getHost();
    }

    public void setHostName(String host) {
        databaseUrl.setHost(host);
    }

    @Override
    public String getPort() {
        return databaseUrl.getPort();
    }

    public void setPort(String port) {
        databaseUrl.setPort(port);
    }

    @Override
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String name) {
        repositoryName = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return databaseUrl.getUrl();
    }

    public RepositoryType getRepositoryType() {
        return repositoryType;
    }

}
