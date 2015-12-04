package br.org.studio.tool.base.persitence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import org.hamcrest.Matchers;
import org.junit.Test;

public class PersistenceConfigurationBuilderTest {

	private static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	private static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
	private static final String USER = "user";
	private static final String PASSWORD = "password";
	private static final String POSTGRES = "postgres";

	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

	@Test
	public void build_method_should_return_an_instance_of_PersistenceConfiguration() {
		PersistenceConfigurationBuilder builder = new PersistenceConfigurationBuilder();

		Object object = builder.build();

		assertThat(object, instanceOf(PersistenceConfiguration.class));
	}

	@Test
	public void build_method_should_return_an_instance_of_PersistenceConfiguration_with_driver() {
		PersistenceConfigurationBuilder builder = new PersistenceConfigurationBuilder();

		builder.withDriver(POSTGRESQL_DRIVER);
		PersistenceConfiguration database = builder.build();

		assertThat(database.getProperties(), Matchers.hasValue(POSTGRESQL_DRIVER));
	}

	@Test
	public void build_method_should_return_an_instance_of_PersistenceConfiguration_with_url() {
		PersistenceConfigurationBuilder builder = new PersistenceConfigurationBuilder();

		builder.withUrl(URL);
		PersistenceConfiguration database = builder.build();

		assertThat(database.getProperties(), Matchers.hasValue(URL));
	}

	@Test
	public void build_method_should_return_an_instance_of_PersistenceConfiguration_with_user() {
		PersistenceConfigurationBuilder builder = new PersistenceConfigurationBuilder();

		builder.withUser(USER);
		PersistenceConfiguration database = builder.build();

		assertThat(database.getProperties(), Matchers.hasValue(USER));
	}

	@Test
	public void build_method_should_return_an_instance_of_PersistenceConfiguration_with_default_user_when_user_is_not_defined() {
		PersistenceConfigurationBuilder builder = new PersistenceConfigurationBuilder();

		PersistenceConfiguration database = builder.build();

		assertThat(database.getProperties(), Matchers.hasValue(POSTGRES));
	}

	@Test
	public void build_method_should_return_an_instance_of_PersistenceConfiguration_with_password() {
		PersistenceConfigurationBuilder builder = new PersistenceConfigurationBuilder();

		builder.withPassword(PASSWORD);
		PersistenceConfiguration database = builder.build();

		assertThat(database.getProperties(), Matchers.hasValue(PASSWORD));
	}

	@Test
	public void build_method_should_return_an_instance_of_PersistenceConfiguration_with_default_password_when_password_is_not_defined() {
		PersistenceConfigurationBuilder builder = new PersistenceConfigurationBuilder();

		PersistenceConfiguration database = builder.build();

		assertThat(database.getProperties(), Matchers.hasValue(POSTGRES));
	}

	@Test
	public void build_method_should_return_an_instance_of_PersistenceConfiguration_with_dialect() {
		PersistenceConfigurationBuilder builder = new PersistenceConfigurationBuilder();

		builder.withDialect(DIALECT);
		PersistenceConfiguration database = builder.build();

		assertThat(database.getProperties(), Matchers.hasValue(DIALECT));
	}

}
