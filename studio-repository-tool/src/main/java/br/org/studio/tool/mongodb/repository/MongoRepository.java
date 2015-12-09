package br.org.studio.tool.mongodb.repository;

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
    public RepositoryConfiguration getConfiguration() {
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
    public void delete() throws Exception {
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
