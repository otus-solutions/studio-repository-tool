package br.org.studio.tool.repository.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import br.org.studio.tool.repository.service.Database;
import br.org.studio.tool.repository.service.PostgreDatabase;

public class PostgreDatabaseTest {

	private static final String LOCALHOST = "localhost";
	private static final String HOST = "myhost";
	private static final String P5432 = "5432";
	private static final String PORT = "1123";
	private static final String USER = "user";
	private static final String PASSWORD = "password";
	private static final String POSTGRES = "postgres";
	private static final String NAME = "db_test";
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	private static final String JDBC_POSTGRESQL = "jdbc:postgresql://";
	private static final String CONNECTION_URL = JDBC_POSTGRESQL + HOST + ":" + PORT + "/" + NAME;

	private Database database;

	@Before
	public void setup() {
		newPostgreDatabaseObject();
	}

	private void newPostgreDatabaseObject() {
		database = new PostgreDatabase(NAME, HOST, PORT, USER, PASSWORD);
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_a_host() {
		assertThat(database.getHost(), equalTo(HOST));
	}

	@Test
	public void if_host_is_not_specified_on_constructor_then_host_should_be_equal_to_LOCALHOST() {
		Database database = new PostgreDatabase(POSTGRES);

		assertThat(database.getHost(), equalTo(LOCALHOST));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_a_host_port() {
		assertThat(database.getPort(), equalTo(PORT));
	}

	@Test
	public void if_host_port_is_not_specified_on_constructor_then_host_port_should_be_equal_to_5432() {
		Database database = new PostgreDatabase(POSTGRES);

		assertThat(database.getPort(), equalTo(P5432));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_name() {
		assertThat(database.getName(), equalTo(NAME));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_user() {
		assertThat(database.getUser(), equalTo(USER));
	}

	@Test
	public void if_user_is_not_specified_on_constructor_then_user_should_be_equal_to_POSTGRES() {
		Database database = new PostgreDatabase(POSTGRES);

		assertThat(database.getUser(), equalTo(POSTGRES));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_password() {
		assertThat(database.getPassword(), equalTo(PASSWORD));
	}

	@Test
	public void if_password_is_not_specified_on_constructor_then_password_should_be_equal_to_POSTGRES() {
		Database database = new PostgreDatabase(POSTGRES);

		assertThat(database.getPassword(), equalTo(POSTGRES));
	}

	@Test
	public void getConnection_method_should_return_an_instance_of_Connection_when_database_exist() throws Exception {
		Database database = new PostgreDatabase(POSTGRES);

		Connection connection = database.getConnection();

		assertThat(connection, instanceOf(Connection.class));
		connection.close();
	}

	@Test
	public void hasError_method_should_return_false_when_database_is_created_successfully() throws SQLException {
		Database database = new PostgreDatabase(POSTGRES);
		database.createDatabase(NAME);

		assertThat(database.hasError(), equalTo(false));
		database.dropDatabase(NAME);
	}

	@Test
	public void hasError_method_should_return_false_when_database_is_dropped_successfully() throws SQLException {
		Database database = new PostgreDatabase(POSTGRES);
		database.createDatabase(NAME);

		database.dropDatabase(NAME);

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
