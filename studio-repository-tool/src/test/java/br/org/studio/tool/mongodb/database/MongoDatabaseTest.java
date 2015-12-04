package br.org.studio.tool.mongodb.database;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Before;
import org.junit.Test;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.repository.MongoRepositoryConfiguration;

public class MongoDatabaseTest {

	private static final String MONGO_PROTOCOL = "mongodb://";
	private static final String HOST = "localhost";
	private static final String PORT = "27017";
	private static final String NAME = "repository_name";
	private static final String CONNECTION_URL = MONGO_PROTOCOL + HOST + ":" + PORT + "/" + NAME;

	private MongoDatabase database;

	@Before
	public void setup() {
		RepositoryConfiguration configuration = createRepositoryConfiguration();
		database = new MongoDatabase(configuration);
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

}
