package br.org.studio.tool.mongodb.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.org.studio.tool.base.repository.Repository;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.database.MongoClientFactory;
import br.org.studio.tool.mongodb.repository.MongoRepository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MongoRepository.class, MongoClientFactory.class })
public class MongoRepositoryTest {

	private static final String DBNAME = "dbname";
	private static final String INFO_COLLECTION_NAME = "info";

	@Mock
	private RepositoryConfiguration repositoryConfiguration;
	@Mock
	private MongoClient mongoClient;
	@Mock
	private MongoDatabase database;
	@Mock
	private MongoCollection<Document> collection;
	@Mock
	private Document document;

	private MongoRepository repository;

	@Before
	public void setup() throws Exception {
		whenNew(Document.class).withNoArguments().thenReturn(document);

		mockStatic(MongoClientFactory.class);
		when(MongoClientFactory.createClient()).thenReturn(mongoClient);
		when(repositoryConfiguration.getName()).thenReturn(DBNAME);
		when(mongoClient.getDatabase(DBNAME)).thenReturn(database);
		when(database.getCollection(INFO_COLLECTION_NAME)).thenReturn(collection);

		repository = new MongoRepository(repositoryConfiguration);
	}

	@Test
	public void a_MongoRepository_should_be_an_instance_of_Repository() {
		assertThat(repository, instanceOf(Repository.class));
	}

	@Test
	public void a_MongoRepository_instance_should_has_a_configuration() {
		assertThat(repository.getConfiguration(), instanceOf(RepositoryConfiguration.class));
	}

	@Test
	public void initialize_method_should_call_createClient_from_MongoClientFactory() {
		repository.initialize();

		verifyStatic();
		MongoClientFactory.createClient();
	}

	@Test
	public void initialize_method_should_cal_getCollection_from_MongoDatabase() {
		repository.initialize();

		verify(mongoClient).getDatabase(DBNAME);
	}

	@Test
	public void initialize_method_should_cal_insertOne_from_MongoCollection() {
		repository.initialize();

		verify(collection).insertOne(document);
	}

	@Test
	public void initialize_method_should_calls() {
		repository.initialize();

		verify(database).getCollection(INFO_COLLECTION_NAME);
	}

	@Test
	public void close_method_should_call_close_from_MongoClient() {
		repository.initialize();

		repository.close();

		verify(mongoClient).close();
	}

}
