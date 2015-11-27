package br.org.studio.tool.repository.datasource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import br.org.studio.tool.repository.datasource.DataSourceProperty;

public class DataSourcePropertyTest {

	private static final String JNDI_NAME = "jndi-name";
	private static final String CONNECTION_URL = "connection-url";
	private static final String DRIVER_CLASS = "driver-class";
	private static final String DRIVER_NAME = "driver-name";
	private static final String USER_NAME = "user-name";
	private static final String PASSWORD = "password";
	private static final String POOL_NAME = "pool-name";

	@Test
	public void the_JNDI_NAME_property_must_be_equal_to_jndi_name() {
		assertThat(DataSourceProperty.JNDI_NAME.getValue(), equalTo(JNDI_NAME));
	}

	@Test
	public void the_CONNECTION_URL_property_must_be_equal_to_connection_url() {
		assertThat(DataSourceProperty.CONNECTION_URL.getValue(), equalTo(CONNECTION_URL));
	}

	@Test
	public void the_DRIVER_CLASS_property_must_be_equal_to_driver_class() {
		assertThat(DataSourceProperty.DRIVER_CLASS.getValue(), equalTo(DRIVER_CLASS));
	}

	@Test
	public void the_DRIVER_NAME_property_must_be_equal_to_driver_name() {
		assertThat(DataSourceProperty.DRIVER_NAME.getValue(), equalTo(DRIVER_NAME));
	}

	@Test
	public void the_USER_NAME_property_must_be_equal_to_user_name() {
		assertThat(DataSourceProperty.USER_NAME.getValue(), equalTo(USER_NAME));
	}

	@Test
	public void the_PASSWORD_property_must_be_equal_to_password() {
		assertThat(DataSourceProperty.PASSWORD.getValue(), equalTo(PASSWORD));
	}

	@Test
	public void the_POOL_NAME_property_must_be_equal_to_pool_name() {
		assertThat(DataSourceProperty.POOL_NAME.getValue(), equalTo(POOL_NAME));
	}

}
