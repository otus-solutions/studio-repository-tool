package br.org.studio.tool.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Test;

import br.org.studio.tool.RepositoryConfiguration;

public class RepositoryConfigurationBuilderTest {

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
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		Object object = builder.buildPostgresConfiguration();

		assertThat(object, instanceOf(RepositoryConfiguration.class));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_name() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		builder.withName(DBNAME);
		RepositoryConfiguration configuration = builder.buildPostgresConfiguration();

		assertThat(configuration.getName(), equalTo(DBNAME));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_host() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		builder.withHost(HOST);
		RepositoryConfiguration configuration = builder.buildPostgresConfiguration();

		assertThat(configuration.getHost(), equalTo(HOST));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_default_host_when_host_is_not_defined() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		RepositoryConfiguration configuration = builder.buildPostgresConfiguration();

		assertThat(configuration.getHost(), equalTo(LOCALHOST));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_port() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		builder.withPort(PORT);
		RepositoryConfiguration configuration = builder.buildPostgresConfiguration();

		assertThat(configuration.getPort(), equalTo(PORT));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_default_port_when_port_is_not_defined() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		RepositoryConfiguration configuration = builder.buildPostgresConfiguration();

		assertThat(configuration.getPort(), equalTo(DEFAULT_PORT));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_user() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		builder.withUser(USER);
		RepositoryConfiguration configuration = builder.buildPostgresConfiguration();

		assertThat(configuration.getUser(), equalTo(USER));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_default_user_when_user_is_not_defined() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		RepositoryConfiguration configuration = builder.buildPostgresConfiguration();

		assertThat(configuration.getUser(), equalTo(POSTGRES));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_password() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		builder.withPassword(PASSWORD);
		RepositoryConfiguration configuration = builder.buildPostgresConfiguration();

		assertThat(configuration.getPassword(), equalTo(PASSWORD));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_default_password_when_password_is_not_defined() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		RepositoryConfiguration configuration = builder.buildPostgresConfiguration();

		assertThat(configuration.getPassword(), equalTo(POSTGRES));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_all_user_paramenters() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		builder.withName(DBNAME).withHost(HOST).withPort(PORT).withUser(USER).withPassword(PASSWORD);
		RepositoryConfiguration configuration = builder.buildPostgresConfiguration();

		assertThat(configuration.getName(), equalTo(DBNAME));
		assertThat(configuration.getHost(), equalTo(HOST));
		assertThat(configuration.getPort(), equalTo(PORT));
		assertThat(configuration.getUser(), equalTo(USER));
		assertThat(configuration.getPassword(), equalTo(PASSWORD));
	}

	@Test
	public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_all_default_paramenters() {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

		builder.withName(DBNAME);
		RepositoryConfiguration configuration = builder.buildPostgresConfiguration();

		assertThat(configuration.getName(), equalTo(DBNAME));
		assertThat(configuration.getHost(), equalTo(LOCALHOST));
		assertThat(configuration.getPort(), equalTo(DEFAULT_PORT));
		assertThat(configuration.getUser(), equalTo(POSTGRES));
		assertThat(configuration.getPassword(), equalTo(POSTGRES));
	}

}
