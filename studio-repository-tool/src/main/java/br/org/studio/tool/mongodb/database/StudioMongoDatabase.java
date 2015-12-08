package br.org.studio.tool.mongodb.database;

import java.util.Map;

import org.bson.Document;

import br.org.studio.tool.base.database.MetaDatabase;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class StudioMongoDatabase extends MetaDatabase {

    public static final String PROTOCOL = "mongodb://";

    private MongoClient client;
    private MongoDatabase database;
    private RepositoryConfiguration configuration;

    public StudioMongoDatabase(RepositoryConfiguration configuration) {
        super(configuration);
        this.configuration = configuration;
    }

    @Override
    public Boolean hasError() {
        return false;
    }

    @Override
    public String getDriver() {
        return "mongodb";
    }

    public void create() {
        load();
        createMetaInformation();
        createAdminUser();
    }

    public void load() {
        client = MongoClientFactory.createClient(configuration.getHost(), configuration.getPort());
        database = client.getDatabase(configuration.getName());
    }

    public void drop() {
        client.dropDatabase(configuration.getName());
    }

    public void close() {
        if (client != null)
            client.close();
    }

    public MongoDatabase getConnection() {
        return database;
    }

    private void createMetaInformation() {
        MongoCollection<Document> info = database.getCollection(MetaInformation.COLLECTION.getValue());

        Document document = new Document();
        document.append(MetaInformation.DBNAME.getValue(), getName());
        document.append(MetaInformation.HOST.getValue(), getHost());
        document.append(MetaInformation.PORT.getValue(), getPort());

        info.insertOne(document);
    }

    private void createAdminUser() {
        Map<String, Object> commandArguments = new BasicDBObject();
        commandArguments.put("createUser", "admin");
        commandArguments.put("pwd", "admin");
        String[] roles = { "dbOwner" };
        commandArguments.put("roles", roles);
        BasicDBObject command = new BasicDBObject(commandArguments);
        database.runCommand(command);
    }

}
