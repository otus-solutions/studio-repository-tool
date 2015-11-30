package br.org.studio.tool.repository.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Test;

public class PostgresDatabaseBuilderTest {

	private static final String DBNAME = "dbname";
	private static final String HOST = "myHost";
	private static final String LOCALHOST = "localhost";
	private static final String PORT = "1123";
	private static final String DEFAULT_PORT = "5432";
	private static final String USER = "user";
	private static final String PASSWORD = "password";
	private static final String POSTGRES = "postgres";

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		Object object = builder.build();

		assertThat(object, instanceOf(PostgreDatabase.class));
	}

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase_with_name() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		builder.withName(DBNAME);
		PostgreDatabase database = builder.build();

		assertThat(database.getName(), equalTo(DBNAME));
	}

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase_with_host() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		builder.withHost(HOST);
		PostgreDatabase database = builder.build();

		assertThat(database.getHost(), equalTo(HOST));
	}

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase_with_default_host_when_host_is_not_defined() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		PostgreDatabase database = builder.build();

		assertThat(database.getHost(), equalTo(LOCALHOST));
	}

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase_with_port() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		builder.withPort(PORT);
		PostgreDatabase database = builder.build();

		assertThat(database.getPort(), equalTo(PORT));
	}

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase_with_default_port_when_port_is_not_defined() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		PostgreDatabase database = builder.build();

		assertThat(database.getPort(), equalTo(DEFAULT_PORT));
	}

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase_with_user() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		builder.withUser(USER);
		PostgreDatabase database = builder.build();

		assertThat(database.getUser(), equalTo(USER));
	}

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase_with_default_user_when_user_is_not_defined() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		PostgreDatabase database = builder.build();

		assertThat(database.getUser(), equalTo(POSTGRES));
	}

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase_with_password() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		builder.withPassword(PASSWORD);
		PostgreDatabase database = builder.build();

		assertThat(database.getPassword(), equalTo(PASSWORD));
	}

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase_with_default_password_when_password_is_not_defined() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		PostgreDatabase database = builder.build();

		assertThat(database.getPassword(), equalTo(POSTGRES));
	}

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase_with_all_user_paramenters() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		builder.withName(DBNAME).withHost(HOST).withPort(PORT).withUser(USER).withPassword(PASSWORD);
		PostgreDatabase database = builder.build();

		assertThat(database.getName(), equalTo(DBNAME));
		assertThat(database.getHost(), equalTo(HOST));
		assertThat(database.getPort(), equalTo(PORT));
		assertThat(database.getUser(), equalTo(USER));
		assertThat(database.getPassword(), equalTo(PASSWORD));
	}

	@Test
	public void build_method_should_return_an_instance_of_PostgreDatabase_with_all_default_paramenters() {
		PostgresDatabaseBuilder builder = new PostgresDatabaseBuilder();

		builder.withName(DBNAME);
		PostgreDatabase database = builder.build();

		assertThat(database.getName(), equalTo(DBNAME));
		assertThat(database.getHost(), equalTo(LOCALHOST));
		assertThat(database.getPort(), equalTo(DEFAULT_PORT));
		assertThat(database.getUser(), equalTo(POSTGRES));
		assertThat(database.getPassword(), equalTo(POSTGRES));
	}

}
