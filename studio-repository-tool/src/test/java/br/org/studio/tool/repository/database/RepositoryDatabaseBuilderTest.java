package br.org.studio.tool.repository.database;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Test;

import br.org.studio.tool.repository.database.RepositoryDatabase;
import br.org.studio.tool.repository.database.RepositoryDatabaseBuilder;

public class RepositoryDatabaseBuilderTest {

	private static final String DBNAME = "dbname";
	private static final String HOST = "myHost";
	private static final String LOCALHOST = "localhost";
	private static final String PORT = "1123";
	private static final String DEFAULT_PORT = "5432";
	private static final String USER = "user";
	private static final String PASSWORD = "password";
	private static final String POSTGRES = "postgres";

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		Object object = builder.build();

		assertThat(object, instanceOf(RepositoryDatabase.class));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase_with_name() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		builder.withName(DBNAME);
		RepositoryDatabase database = builder.build();

		assertThat(database.getName(), equalTo(DBNAME));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase_with_host() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		builder.withHost(HOST);
		RepositoryDatabase database = builder.build();

		assertThat(database.getHost(), equalTo(HOST));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase_with_default_host_when_host_is_not_defined() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		RepositoryDatabase database = builder.build();

		assertThat(database.getHost(), equalTo(LOCALHOST));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase_with_port() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		builder.withPort(PORT);
		RepositoryDatabase database = builder.build();

		assertThat(database.getPort(), equalTo(PORT));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase_with_default_port_when_port_is_not_defined() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		RepositoryDatabase database = builder.build();

		assertThat(database.getPort(), equalTo(DEFAULT_PORT));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase_with_user() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		builder.withUser(USER);
		RepositoryDatabase database = builder.build();

		assertThat(database.getUser(), equalTo(USER));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase_with_default_user_when_user_is_not_defined() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		RepositoryDatabase database = builder.build();

		assertThat(database.getUser(), equalTo(POSTGRES));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase_with_password() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		builder.withPassword(PASSWORD);
		RepositoryDatabase database = builder.build();

		assertThat(database.getPassword(), equalTo(PASSWORD));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase_with_default_password_when_password_is_not_defined() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		RepositoryDatabase database = builder.build();

		assertThat(database.getPassword(), equalTo(POSTGRES));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase_with_all_user_paramenters() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		builder.withName(DBNAME).withHost(HOST).withPort(PORT).withUser(USER).withPassword(PASSWORD);
		RepositoryDatabase database = builder.build();

		assertThat(database.getName(), equalTo(DBNAME));
		assertThat(database.getHost(), equalTo(HOST));
		assertThat(database.getPort(), equalTo(PORT));
		assertThat(database.getUser(), equalTo(USER));
		assertThat(database.getPassword(), equalTo(PASSWORD));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryDatabase_with_all_default_paramenters() {
		RepositoryDatabaseBuilder builder = new RepositoryDatabaseBuilder();

		builder.withName(DBNAME);
		RepositoryDatabase database = builder.build();

		assertThat(database.getName(), equalTo(DBNAME));
		assertThat(database.getHost(), equalTo(LOCALHOST));
		assertThat(database.getPort(), equalTo(DEFAULT_PORT));
		assertThat(database.getUser(), equalTo(POSTGRES));
		assertThat(database.getPassword(), equalTo(POSTGRES));
	}

}
