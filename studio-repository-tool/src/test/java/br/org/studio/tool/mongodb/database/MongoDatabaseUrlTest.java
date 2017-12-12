package br.org.studio.tool.mongodb.database;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import br.org.studio.tool.base.database.DatabaseUrl;

public class MongoDatabaseUrlTest {

	private static final String LOCALHOST = "localhost";
	private static final String DEFAULT_PORT = "27017";
	private static final String DBNAME = "postgres";
	private static final String CONNECTION_URL = StudioMongoDatabase.PROTOCOL + LOCALHOST + ":" + DEFAULT_PORT + "/" + DBNAME;

	private DatabaseUrl url;

	@Before
	public void setup() {
		url = new MongoDatabaseUrl();
		url.setHost(LOCALHOST);
		url.setPort(DEFAULT_PORT);
		url.setDatabaseName(DBNAME);
	}

	@Test
	public void getProtocol_method_should_return_a_value_equal_to_PostgresDatabase_PROTOCOL() {
		assertThat(url.getProtocol(), equalTo(StudioMongoDatabase.PROTOCOL));
	}

	@Test
	public void getUrl_method_should_return_an_url_well_formed_for_jdbc_connections_with_PostgreSQL() {
		assertThat(url.getUrl(), equalTo(CONNECTION_URL));
	}

}
