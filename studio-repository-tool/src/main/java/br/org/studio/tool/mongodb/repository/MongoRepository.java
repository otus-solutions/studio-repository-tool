package br.org.studio.tool.mongodb.repository;

import br.org.studio.tool.base.repository.Repository;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.database.StudioMongoDatabase;

import java.io.IOException;
import java.net.Socket;

public class MongoRepository implements Repository {

    private RepositoryConfiguration configuration;
    private StudioMongoDatabase database;

    public MongoRepository(RepositoryConfiguration configuration) {
        this.configuration = configuration;
        database = new StudioMongoDatabase(configuration);
    }

    @Override
    public RepositoryConfiguration getDescriptor() {
        return configuration;
    }

    @Override
    public void initialize() {
        database.create();
    }

    @Override
    public void load() {
        database.load();
    }

    @Override
    public void delete() {
        database.drop();
    }

    @Override
    public void close() {
        database.close();
    }

    @Override
    public Boolean isAccessible() {
        return database.isAccessible();
    }
}
