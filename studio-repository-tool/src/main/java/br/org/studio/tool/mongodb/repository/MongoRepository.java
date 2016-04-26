package br.org.studio.tool.mongodb.repository;

import java.util.List;

import br.org.studio.tool.base.repository.Repository;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.database.StudioMongoDatabase;

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

    @Override
    public List<String> getDatabaseNames() {
        return database.getDatabaseNames();
    }
}
