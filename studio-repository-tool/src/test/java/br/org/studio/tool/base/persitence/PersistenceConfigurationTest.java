package br.org.studio.tool.base.persitence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;

import org.junit.Before;
import org.junit.Test;

import br.org.studio.tool.base.persitence.PersistenceConfiguration;

public class PersistenceConfigurationTest {

	private static final String DRIVER_KEY = "javax.persistence.jdbc.driver";
	private static final String URL_KEY = "javax.persistence.jdbc.url";
	private static final String USER_KEY = "javax.persistence.jdbc.user";
	private static final String PASSWORD_KEY = "javax.persistence.jdbc.password";
	private static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
	private static final String POSTGRESQL_URL = "jdbc:postgresql://localhost:5432/repository";
	private static final String POSTGRESQL_USER = "postgres";
	private static final String POSTGRESQL_PASSWORD = "postgres";

	private static final String DIALECT_KEY = "hibernate.dialect";
	private static final String DEFAULT_SCHEMA_KEY = "hibernate.default_schema";
	private static final String SHOW_SQL_KEY = "hibernate.show_sql";
	private static final String CONNECTION_AUTOCOMMIT_KEY = "hibernate.connection.autocommit";
	private static final String HBM2DLL_AUTO_KEY = "hibernate.hbm2ddl.auto";
	private static final String HIBERNATE_DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	private static final String DEFAULT_SCHEMA = "public";
	private static final String SHOW_SQL = "true";
	private static final String CONNECTION_AUTOCOMMIT = "true";
	private static final String HBM2DLL_AUTO = "create";

	private PersistenceConfiguration configuration;

	@Before
	public void setup() {
		configuration = new PersistenceConfiguration();
	}

	@Test
	public void get_method_should_return_a_map_with_key_for_driver_property() {
		configuration.setDriver(POSTGRESQL_DRIVER);

		assertThat(configuration.getProperties(), hasKey(DRIVER_KEY));
	}

	@Test
	public void get_method_should_return_a_map_with_key_for_url_property() {
		configuration.setUrl(POSTGRESQL_URL);

		assertThat(configuration.getProperties(), hasKey(URL_KEY));
	}

	@Test
	public void get_method_should_return_a_map_with_key_for_user_property() {
		configuration.setUser(POSTGRESQL_USER);

		assertThat(configuration.getProperties(), hasKey(USER_KEY));
	}

	@Test
	public void get_method_should_return_a_map_with_key_for_passowrd_property() {
		configuration.setPassword(POSTGRESQL_PASSWORD);

		assertThat(configuration.getProperties(), hasKey(PASSWORD_KEY));
	}

	@Test
	public void get_method_should_return_a_map_with_key_for_dialect_property() {
		configuration.setDialect(HIBERNATE_DIALECT);

		assertThat(configuration.getProperties(), hasKey(DIALECT_KEY));
	}

	@Test
	public void get_method_should_return_a_map_with_key_for_default_schema_property() {
		configuration.setDefaultSchema(DEFAULT_SCHEMA);

		assertThat(configuration.getProperties(), hasKey(DEFAULT_SCHEMA_KEY));
	}

	@Test
	public void get_method_should_return_a_map_with_key_for_show_sql_property() {
		configuration.setShowSql(SHOW_SQL);

		assertThat(configuration.getProperties(), hasKey(SHOW_SQL_KEY));
	}

	@Test
	public void get_method_should_return_a_map_with_key_for_connection_autocommit_property() {
		configuration.setAutoCommit(CONNECTION_AUTOCOMMIT);

		assertThat(configuration.getProperties(), hasKey(CONNECTION_AUTOCOMMIT_KEY));
	}

	@Test
	public void get_method_should_return_a_map_with_key_for_hbm2ddl_auto_property() {
		configuration.setHbm2DllAuto(HBM2DLL_AUTO);

		assertThat(configuration.getProperties(), hasKey(HBM2DLL_AUTO_KEY));
	}

	@Test
	public void get_method_should_return_a_map_with_value_for_driver_property() {
		configuration.setDriver(POSTGRESQL_DRIVER);

		assertThat(configuration.getProperties(), hasValue(POSTGRESQL_DRIVER));
	}

	@Test
	public void get_method_should_return_a_map_with_value_for_url_property() {
		configuration.setUrl(POSTGRESQL_URL);

		assertThat(configuration.getProperties(), hasValue(POSTGRESQL_URL));
	}

	@Test
	public void get_method_should_return_a_map_with_value_for_user_property() {
		configuration.setUser(POSTGRESQL_USER);

		assertThat(configuration.getProperties(), hasValue(POSTGRESQL_USER));
	}

	@Test
	public void get_method_should_return_a_map_with_value_for_passowrd_property() {
		configuration.setPassword(POSTGRESQL_PASSWORD);

		assertThat(configuration.getProperties(), hasValue(POSTGRESQL_PASSWORD));
	}

	@Test
	public void get_method_should_return_a_map_with_value_for_dialect_property() {
		configuration.setDialect(HIBERNATE_DIALECT);

		assertThat(configuration.getProperties(), hasValue(HIBERNATE_DIALECT));
	}

	@Test
	public void get_method_should_return_a_map_with_value_for_default_schema_property() {
		configuration.setDefaultSchema(DEFAULT_SCHEMA);

		assertThat(configuration.getProperties(), hasValue(DEFAULT_SCHEMA));
	}

	@Test
	public void get_method_should_return_a_map_with_value_for_show_sql_property() {
		configuration.setShowSql(SHOW_SQL);

		assertThat(configuration.getProperties(), hasValue(SHOW_SQL));
	}

	@Test
	public void get_method_should_return_a_map_with_value_for_connection_autocommit_property() {
		configuration.setAutoCommit(CONNECTION_AUTOCOMMIT);

		assertThat(configuration.getProperties(), hasValue(CONNECTION_AUTOCOMMIT));
	}

	@Test
	public void get_method_should_return_a_map_with_value_for_hbm2ddl_auto_property() {
		configuration.setHbm2DllAuto(HBM2DLL_AUTO);

		assertThat(configuration.getProperties(), hasValue(HBM2DLL_AUTO));
	}
}
