package br.org.studio.tool.mongodb.database;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.bson.Document;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.repository.MongoRepositoryConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Ignore
@RunWith(PowerMockRunner.class)
@PrepareForTest({ MongoClientFactory.class })
public class MongoDatabaseTest {

	private static final String INFO_COLLECTION_NAME = "info";
	private static final String MONGO_PROTOCOL = "mongodb://";
	private static final String HOST = "localhost";
	private static final String PORT = "27017";
	private static final String NAME = "repository_name";
	private static final String CONNECTION_URL = MONGO_PROTOCOL + HOST + ":" + PORT + "/" + NAME;

	private StudioMongoDatabase database;
	private RepositoryConfiguration configuration;

	@Mock
	private MongoClient mongoClient;
	@Mock
	private MongoDatabase mongoDatabase;
	@Mock
	private MongoCollection<Document> collection;
	@Mock
	private FindIterable<Document> iterable;
	@Mock
	private Document document;

	@Before
	public void setup() {
		mockStatic(MongoClientFactory.class);
		when(MongoClientFactory.createClient()).thenReturn(mongoClient);
		when(mongoClient.getDatabase(NAME)).thenReturn(mongoDatabase);
		when(mongoDatabase.getCollection(MetaInformation.COLLECTION.getValue())).thenReturn(collection);
		when(database.get().getCollection(MetaInformation.COLLECTION.getValue()).find()).thenReturn(iterable);

		configuration = createRepositoryConfiguration();
		database = new StudioMongoDatabase(configuration);
	}

	private RepositoryConfiguration createRepositoryConfiguration() {
		return MongoRepositoryConfiguration.create(NAME, HOST, PORT, NAME, NAME);
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_a_host() {
		assertThat(database.getHost(), equalTo(HOST));
	}

	@Test
	public void if_host_is_not_specified_on_constructor_then_host_should_be_equal_to_LOCALHOST() {
		assertThat(database.getHost(), equalTo(HOST));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_a_host_port() {
		assertThat(database.getPort(), equalTo(PORT));
	}

	@Test
	public void if_host_port_is_not_specified_on_constructor_then_host_port_should_be_equal_to_5432() {
		assertThat(database.getPort(), equalTo(PORT));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_name() {
		assertThat(database.getName(), equalTo(NAME));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_user() {
		assertThat(database.getUser(), equalTo(NAME));
	}

	@Test
	public void if_user_is_not_specified_on_constructor_then_user_should_be_equal_to_POSTGRES() {
		assertThat(database.getUser(), equalTo(NAME));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_password() {
		assertThat(database.getPassword(), equalTo(NAME));
	}

	@Test
	public void if_password_is_not_specified_on_constructor_then_password_should_be_equal_to_POSTGRES() {
		assertThat(database.getPassword(), equalTo(NAME));
	}

	@Test
	public void getUrl_method_should_return_an_url_connection() {
		assertThat(database.getUrl(), equalTo(CONNECTION_URL));
	}

	@Test
	public void getConnection_method_should_return_an_instance_of_MongoDatabase_when_database_exist() throws Exception {
		com.mongodb.client.MongoDatabase mongo = database.get();

		assertThat(mongo, instanceOf(com.mongodb.client.MongoDatabase.class));
	}

	@Test
	public void a_new_MongoDatabase_instance_should_has_a_collection_info_with_the_name_of_database() {
		FindIterable<Document> info = database.get().getCollection(MetaInformation.COLLECTION.getValue()).find().limit(1);
		assertThat(info.first().get("name"), equalTo(NAME));
	}

	@Test
	public void a_new_MongoDatabase_instance_should_has_a_collection_info_with_the_host_of_database() {
		FindIterable<Document> info = database.get().getCollection(MetaInformation.COLLECTION.getValue()).find().limit(1);
		assertThat(info.first().get("host"), equalTo(HOST));
	}

	@Test
	public void a_new_MongoDatabase_instance_should_has_a_collection_info_with_the_port_of_database() {
		FindIterable<Document> info = database.get().getCollection(MetaInformation.COLLECTION.getValue()).find().limit(1);
		assertThat(info.first().get("port"), equalTo(PORT));
	}

	@Test
	public void new_instances_of_MongoDatabase_should_call_createClient_from_MongoClientFactory() {
		configuration = createRepositoryConfiguration();
		database = new StudioMongoDatabase(configuration);

		verifyStatic();
		MongoClientFactory.createClient();
	}

	@Test
	public void new_instances_of_MongoDatabase_should_should_cal_getDatabase_from_MongoClient() {
		configuration = createRepositoryConfiguration();
		database = new StudioMongoDatabase(configuration);

		verify(mongoClient).getDatabase(NAME);
	}

	@Test
	public void new_instances_of_MongoDatabase_should_should_call_getCollection_from_MongoDatabase() {
		configuration = createRepositoryConfiguration();
		database = new StudioMongoDatabase(configuration);

		verify(mongoDatabase).getCollection(INFO_COLLECTION_NAME);
	}

	@Test
	public void close_method_should_call_close_from_MongoClient() {
		database.close();

		verify(mongoClient).close();
	}

}
