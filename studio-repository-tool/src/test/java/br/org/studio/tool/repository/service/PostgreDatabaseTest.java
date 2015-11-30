package br.org.studio.tool.repository.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class PostgreDatabaseTest {

	private static final String LOCALHOST = "localhost";
	private static final String HOST = "myhost";
	private static final String DEFAULT_PORT = "5432";
	private static final String PORT = "1123";
	private static final String USER = "user";
	private static final String PASSWORD = "password";
	private static final String POSTGRES = "postgres";
	private static final String NAME = "db_test";
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	private static final String JDBC_POSTGRESQL = "jdbc:postgresql://";
	private static final String CONNECTION_URL = JDBC_POSTGRESQL + LOCALHOST + ":" + DEFAULT_PORT + "/" + NAME;

	private PostgreDatabase newCustomizedDatabaseObject() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();
		builder.withHost(HOST).withName(NAME).withPort(PORT).withUser(USER).withPassword(PASSWORD);
		return builder.build();
	}

	private PostgreDatabase newDefaultDatabaseObject() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();
		builder.withName(NAME);
		return builder.build();
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_a_host() {
		Database database = newCustomizedDatabaseObject();

		assertThat(database.getHost(), equalTo(HOST));
	}

	@Test
	public void if_host_is_not_specified_on_constructor_then_host_should_be_equal_to_LOCALHOST() {
		Database database = newDefaultDatabaseObject();

		assertThat(database.getHost(), equalTo(LOCALHOST));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_a_host_port() {
		Database database = newCustomizedDatabaseObject();

		assertThat(database.getPort(), equalTo(PORT));
	}

	@Test
	public void if_host_port_is_not_specified_on_constructor_then_host_port_should_be_equal_to_5432() {
		Database database = newDefaultDatabaseObject();

		assertThat(database.getPort(), equalTo(DEFAULT_PORT));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_name() {
		Database database = newCustomizedDatabaseObject();

		assertThat(database.getName(), equalTo(NAME));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_user() {
		Database database = newCustomizedDatabaseObject();

		assertThat(database.getUser(), equalTo(USER));
	}

	@Test
	public void if_user_is_not_specified_on_constructor_then_user_should_be_equal_to_POSTGRES() {
		Database database = newDefaultDatabaseObject();

		assertThat(database.getUser(), equalTo(POSTGRES));
	}

	@Test
	public void an_instance_of_PostgreDatabase_should_has_an_password() {
		Database database = newCustomizedDatabaseObject();

		assertThat(database.getPassword(), equalTo(PASSWORD));
	}

	@Test
	public void if_password_is_not_specified_on_constructor_then_password_should_be_equal_to_POSTGRES() {
		Database database = newDefaultDatabaseObject();

		assertThat(database.getPassword(), equalTo(POSTGRES));
	}

	@Test
	public void getConnection_method_should_return_an_instance_of_Connection_when_database_exist() throws Exception {
		Database database = newDefaultDatabaseObject();

		Connection connection = database.getConnection();

		assertThat(connection, instanceOf(Connection.class));
		connection.close();
	}

	@Test
	public void hasError_method_should_return_false_when_database_is_created_successfully() throws SQLException {
		Database database = newDefaultDatabaseObject();
		database.createDatabase();

		assertThat(database.hasError(), equalTo(false));
		database.dropDatabase(NAME);
	}

	@Test
	public void hasError_method_should_return_false_when_database_is_dropped_successfully() throws SQLException {
		Database database = newDefaultDatabaseObject();
		database.createDatabase();

		database.dropDatabase(NAME);

		assertThat(database.hasError(), equalTo(false));

	}

	@Test
	public void getDriver_should_return_driver_for_postgres() {
		Database database = newDefaultDatabaseObject();

		assertThat(database.getDriver(), equalTo(DRIVER));
	}

	@Test
	public void getDialect_should_return_dialect_for_postgres() {
		Database database = newDefaultDatabaseObject();

		assertThat(database.getDialect(), equalTo(DIALECT));
	}

	@Test
	public void getUrl_should_return_url_connection() {
		Database database = newDefaultDatabaseObject();

		assertThat(database.getUrl(), equalTo(CONNECTION_URL));
	}

}
