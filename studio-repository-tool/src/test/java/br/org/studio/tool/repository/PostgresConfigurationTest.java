package br.org.studio.tool.repository;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class PostgresConfigurationTest {

	private static final String JDBC_POSTGRESQL = "jdbc:postgresql://";
	private static final String USER = "postgres";
	private static final String PASSWORD = "postgres";
	private static final String PORT = "5432";
	private static final String HOST = "localhost";
	private static final String NAME = "repository_name";
	private static final String CONNECTION_URL = JDBC_POSTGRESQL + HOST + ":" + PORT + "/" + NAME;

	private RepositoryConfiguration repositoryConfiguration;

	@Before
	public void setup() {
		createRepositoryConfiguration();
	}

	@Test
	public void an_instance_of_PostgresConfiguration_should_has_a_name() {
		assertThat(repositoryConfiguration.getName(), equalTo(NAME));
	}

	@Test
	public void an_instance_of_PostgresConfiguration_should_has_a_host() {
		assertThat(repositoryConfiguration.getHost(), equalTo(HOST));
	}

	@Test
	public void an_instance_of_PostgresConfiguration_should_has_a_host_port() {
		assertThat(repositoryConfiguration.getPort(), equalTo(PORT));
	}

	@Test
	public void an_instance_of_PostgresConfiguration_should_has_a_db_user() {
		assertThat(repositoryConfiguration.getUser(), equalTo(USER));
	}

	@Test
	public void an_instance_of_PostgresConfiguration_should_has_a_user_password() {
		assertThat(repositoryConfiguration.getPassword(), equalTo(PASSWORD));
	}

	@Test
	public void getUrl_from_PostgresConfiguration_should_return_an_connection_url() {
		assertThat(repositoryConfiguration.getUrl(), equalTo(CONNECTION_URL));
	}

	private void createRepositoryConfiguration() {
		repositoryConfiguration = RepositoryConfiguration.forPostgre(NAME, HOST, PORT, USER, PASSWORD);
	}

}
