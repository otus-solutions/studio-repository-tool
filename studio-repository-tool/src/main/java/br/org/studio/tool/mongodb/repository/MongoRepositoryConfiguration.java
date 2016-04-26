package br.org.studio.tool.mongodb.repository;

import br.org.studio.tool.base.repository.RepositoryDescriptor;
import br.org.studio.tool.base.repository.RepositoryType;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.base.repository.configuration.RepositoryConfigurationBuilder;
import br.org.studio.tool.mongodb.database.MongoDatabaseUrl;

public class MongoRepositoryConfiguration extends RepositoryConfiguration {

    public MongoRepositoryConfiguration() {
        super(RepositoryType.MONGODB, new MongoDatabaseUrl());
    }

    public static RepositoryConfiguration create(RepositoryDescriptor descriptor) {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();
        builder.withRepositoryName(descriptor.getRepositoryName());
        builder.withDatabaseName(descriptor.getDatabaseName());
        builder.withHost(descriptor.getHostName());
        builder.withPort(descriptor.getPort());
        builder.withUser(descriptor.getUserEmail());
        builder.withPassword(descriptor.getPassword());
        builder.withDescription(descriptor.getDescription());
        return builder.buildForMongo();
    }

}
