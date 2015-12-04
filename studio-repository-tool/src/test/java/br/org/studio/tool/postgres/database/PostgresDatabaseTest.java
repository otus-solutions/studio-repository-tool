package br.org.studio.tool.postgres.database;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.postgres.repository.PostgresRepositoryConfiguration;

public class PostgresDatabaseTest {

	private static final String LOCALHOST = "localhost";
	private static final String DEFAULT_PORT = "5432";
	private static final String POSTGRES = "postgres";
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	private static final String JDBC_POSTGRESQL = "jdbc:postgresql://";
	private static final String CONNECTION_URL = JDBC_POSTGRESQL + LOCALHOST + ":" + DEFAULT_PORT + "/" + POSTGRES;

	private PostgresDatabase database;
	private RepositoryConfiguration configuration;

	@Before
	public void setup() {
		configuration = createRepositoryConfiguration();
		database = new PostgresDatabase(configuration);
	}

	private RepositoryConfiguration createRepositoryConfiguration() {
		return PostgresRepositoryConfiguration.create(POSTGRES, LOCALHOST, DEFAULT_PORT, POSTGRES, POSTGRES);
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_a_host() {
		assertThat(database.getHost(), equalTo(LOCALHOST));
	}

	@Test
	public void if_host_is_not_specified_on_constructor_then_host_should_be_equal_to_LOCALHOST() {
		assertThat(database.getHost(), equalTo(LOCALHOST));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_a_host_port() {
		assertThat(database.getPort(), equalTo(DEFAULT_PORT));
	}

	@Test
	public void if_host_port_is_not_specified_on_constructor_then_host_port_should_be_equal_to_5432() {
		assertThat(database.getPort(), equalTo(DEFAULT_PORT));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_name() {
		assertThat(database.getName(), equalTo(POSTGRES));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_user() {
		assertThat(database.getUser(), equalTo(POSTGRES));
	}

	@Test
	public void if_user_is_not_specified_on_constructor_then_user_should_be_equal_to_POSTGRES() {
		assertThat(database.getUser(), equalTo(POSTGRES));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_password() {
		assertThat(database.getPassword(), equalTo(POSTGRES));
	}

	@Test
	public void if_password_is_not_specified_on_constructor_then_password_should_be_equal_to_POSTGRES() {
		assertThat(database.getPassword(), equalTo(POSTGRES));
	}

	@Test
	public void getConnection_method_should_return_an_instance_of_Connection_when_database_exist() throws Exception {
		Connection connection = database.getConnection();

		assertThat(connection, instanceOf(Connection.class));
		connection.close();
	}

	@Test
	public void hasError_method_should_return_false_when_database_is_created_successfully() throws Exception {
		database.createDatabase(configuration.getName());

		assertThat(database.hasError(), equalTo(false));
		database.dropDatabase();
	}

	@Test
	public void hasError_method_should_return_false_when_database_is_dropped_successfully() throws Exception {
		database.createDatabase(configuration.getName());

		database.dropDatabase();

		assertThat(database.hasError(), equalTo(false));

	}

	@Test
	public void getDriver_should_return_driver_for_postgres() {
		assertThat(database.getDriver(), equalTo(DRIVER));
	}

	@Test
	public void getDialect_should_return_dialect_for_postgres() {
		assertThat(database.getDialect(), equalTo(DIALECT));
	}

	@Test
	public void getUrl_should_return_url_connection() {
		assertThat(database.getUrl(), equalTo(CONNECTION_URL));
	}

}
