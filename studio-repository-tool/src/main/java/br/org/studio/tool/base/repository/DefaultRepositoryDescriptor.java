package br.org.studio.tool.base.repository;

public class DefaultRepositoryDescriptor implements RepositoryDescriptor {

    private String repositoryName;
    private String databasName;
    private String hostName;
    private String port;
    private String user;
    private String password;
    private String description;

    @Override
    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    @Override
    public String getDatabaseName() {
        return databasName;
    }

    public void setDatabaseName(String databasName) {
        this.databasName = databasName;
    }

    @Override
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Override
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String getUserEmail() {
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
