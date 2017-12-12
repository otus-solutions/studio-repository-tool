package br.org.studio.tool.mongodb.database;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mongodb.MongoClient;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoIterable;

@RunWith(PowerMockRunner.class)
public class MongoMonitorTest {

    @Mock
    private MongoClient mongoClient;
    @Mock
    private ListDatabasesIterable<Document> databases;
    @Mock
    private MongoIterable<String> databaseNames;

    @Before
    public void setup() {
        when(mongoClient.listDatabases()).thenReturn(databases);
        when(mongoClient.listDatabaseNames()).thenReturn(databaseNames);
    }

    @Test
    public void listDatabases_method_should_return_a_not_null_list_of_existent_databases() {
        MongoMonitor mongoMonitor = new MongoMonitor(mongoClient);

        databases = mongoMonitor.listDatabases();

        assertThat(databases, notNullValue());
    }

    @Test
    public void listDatabases_method_should_call_listDatabases_from_MongoClient() {
        MongoMonitor mongoMonitor = new MongoMonitor(mongoClient);

        mongoMonitor.listDatabases();

        verify(mongoClient).listDatabases();
    }

    @Test
    public void listDatabaseNames_method_should_return_a_not_null_list_of_existent_database_names() {
        MongoMonitor mongoMonitor = new MongoMonitor(mongoClient);

        databaseNames = mongoMonitor.listDatabaseNames();

        assertThat(databaseNames, notNullValue());
    }

    @Test
    public void listDatabaseNames_method_should_call_listDatabases_from_MongoClient() {
        MongoMonitor mongoMonitor = new MongoMonitor(mongoClient);

        mongoMonitor.listDatabaseNames();

        verify(mongoClient).listDatabaseNames();
    }

}
