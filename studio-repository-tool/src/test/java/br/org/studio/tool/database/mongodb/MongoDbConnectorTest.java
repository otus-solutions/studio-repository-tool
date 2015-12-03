package br.org.studio.tool.database.mongodb;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class MongoDbConnectorTest {

	private static final String DEFAULT_HOST = "127.0.0.1";
	private static final String DEFAULT_PORT = "27017";
	private static final String EXTERNAL_HOST = "192.168.0.1";
	private static final String EXTERNAL_PORT = "27017";
	private static final String DRIVER = "mongodb";
	private static final String URI = DRIVER + "://" + EXTERNAL_HOST + ":" + EXTERNAL_PORT;

	@Test
	public void localHostConnector_should_an_instance_with_host_info_equal_to_localhost() {
		MongoDbConnector connector = MongoDbConnector.localhostConnector();

		assertThat(connector.getHost(), equalTo(DEFAULT_HOST));
	}

	@Test
	public void localHostConnector_should_an_instance_with_host_port_info() {
		MongoDbConnector connector = MongoDbConnector.localhostConnector();

		assertThat(connector.getPort(), equalTo(DEFAULT_PORT));
	}

	@Test
	public void externalHostConnector_should_an_instance_with_host_info_equal_to_host_parameter() {
		MongoDbConnector connector = MongoDbConnector.externalHostConnector(EXTERNAL_HOST, EXTERNAL_PORT);

		assertThat(connector.getHost(), equalTo(EXTERNAL_HOST));
	}

	@Test
	public void externalHostConnector_should_an_instance_with_host_port_info_equal_to_port_parameter() {
		MongoDbConnector connector = MongoDbConnector.externalHostConnector(EXTERNAL_HOST, EXTERNAL_PORT);

		assertThat(connector.getPort(), equalTo(EXTERNAL_PORT));
	}

	@Test
	public void getUri_should_an_String_with_connection_uri_info() {
		MongoDbConnector connector = MongoDbConnector.externalHostConnector(EXTERNAL_HOST, EXTERNAL_PORT);

		assertThat(connector.getUri(), equalTo(URI));
	}

	@Test
	public void getUri_should_an_String_that_contains_the_host_info() {
		MongoDbConnector connector = MongoDbConnector.externalHostConnector(EXTERNAL_HOST, EXTERNAL_PORT);

		assertThat(connector.getUri(), containsString(EXTERNAL_HOST));
	}

	@Test
	public void getUri_should_an_String_that_contains_the_port_info() {
		MongoDbConnector connector = MongoDbConnector.externalHostConnector(EXTERNAL_HOST, EXTERNAL_PORT);

		assertThat(connector.getUri(), containsString(EXTERNAL_PORT));
	}

}
