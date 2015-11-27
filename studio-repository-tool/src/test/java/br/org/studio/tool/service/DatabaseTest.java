package br.org.studio.tool.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import java.sql.Connection;
import java.sql.SQLException;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DatabaseTest {

	private static final String DB_TEST = "db_test";

	@Test
	public void getConnection_method_should_return_an_instance_of_Connection_when_database_exist() throws Exception {
		Database database = new Database();

		Connection connection = database.getConnection();

		assertThat(connection, instanceOf(Connection.class));
		connection.close();
	}

	@Test
	public void hasError_method_should_return_false_when_database_is_created_successfully() throws SQLException {
		Database database = new Database();

		database.createDatabase(DB_TEST);

		assertThat(database.hasError(), Matchers.equalTo(false));
		database.dropDatabase(DB_TEST);
	}

	@Test
	public void hasError_method_should_return_false_when_database_is_dropped_successfully() throws SQLException {
		Database database = new Database();
		database.createDatabase(DB_TEST);

		database.dropDatabase(DB_TEST);

		assertThat(database.hasError(), Matchers.equalTo(false));

	}

}
