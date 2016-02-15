package br.org.studio.tool.base.repository.configuration;

import br.org.studio.tool.mongodb.repository.MongoRepositoryConfiguration;

public class RepositoryConfigurationBuilder {

    private static final String PORT = "27017";
    private static final String LOCALHOST = "localhost";

    private String dbname;
    private String host;
    private String port;
    private String user;
    private String password;
    private String repositoryName;
    private String description;

    public RepositoryConfiguration buildForMongo() {
        return build(new MongoRepositoryConfiguration());
    }

    private RepositoryConfiguration build(RepositoryConfiguration configuration) {
        configuration.setDatabaseName(dbname);
        configuration.setHostName(getHost());
        configuration.setPort(getPort());
        configuration.setUser(getUser());
        configuration.setPassword(getPassword());
        configuration.setRepositoryName(getRepositoryName());
        configuration.setDescription(getDescription());

        return configuration;
    }

    public RepositoryConfigurationBuilder withDatabaseName(String dbname) {
        this.dbname = dbname;
        return this;
    }

    public RepositoryConfigurationBuilder withHost(String host) {
        this.host = host;
        return this;
    }

    public RepositoryConfigurationBuilder withPort(String port) {
        this.port = port;
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

    public RepositoryConfigurationBuilder withRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
        return this;
    }

    public RepositoryConfigurationBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    private String getHost() {
        if (host == null || host.isEmpty()) {
            return LOCALHOST;
        } else {
            return host;
        }
    }

    private String getPort() {
        if (port == null || port.isEmpty()) {
            return PORT;
        } else {
            return port;
        }
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

    private String getRepositoryName() {
        if (repositoryName == null || repositoryName.isEmpty()) {
            return null;
        } else {
            return repositoryName;
        }
    }

    private String getDescription() {
        if (description == null || description.isEmpty()) {
            return null;
        } else {
            return description;
        }
    }

}
