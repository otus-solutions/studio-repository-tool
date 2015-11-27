package br.org.studio.tool.repository.datasource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import br.org.studio.tool.repository.datasource.DataSource;
import br.org.studio.tool.repository.datasource.PostgreDataSource;

public class PostgreDataSourceTest {
	
	private static final String POSTGRESQL = "postgresql-9.4-1203.jdbc4.jar";
	private static final String DRIVER_CLASS = "org.postgresql.Driver";
	private static final String JNDI_NAME = "Studio";
	private static final String CONNECTION_URL = "connection_url";
	private static final String DATASOURCE_NAME = "datasourcename";
	private static final String USER_NAME = "user_name";
	private static final String PASSWORD = "passoword";
	private static final String POOL_SUFIX = "Pool";

	private DataSource dataSource;

	@Before
	public void setup() {
		dataSource = new PostgreDataSource(JNDI_NAME, CONNECTION_URL, DATASOURCE_NAME, USER_NAME, PASSWORD);
	}

	@Test
	public void getJndiName_method_should_return_a_value_equal_to_jndiName_paramenter() {
		assertThat(dataSource.getJndiName(), equalTo(JNDI_NAME));
	}

	@Test
	public void getConnectionUrl_method_should_return_a_value_equal_to_connectionUrl_paramenter() {
		assertThat(dataSource.getConnectionUrl(), equalTo(CONNECTION_URL));
	}

	@Test
	public void getName_method_should_return_a_value_equal_to_dataSourceName_paramenter() {
		assertThat(dataSource.getName(), equalTo(DATASOURCE_NAME));
	}

	@Test
	public void getUsername_method_should_return_a_value_equal_to_username_paramenter() {
		assertThat(dataSource.getUsername(), equalTo(USER_NAME));
	}

	@Test
	public void getPassword_method_should_return_a_value_equal_to_password_paramenter() {
		assertThat(dataSource.getPassword(), equalTo(PASSWORD));
	}
	
	@Test
	public void getPoolName_method_should_return_a_value_equal_to_dataSourceName_paramenter_with_Pool_sufix() {
		assertThat(dataSource.getPoolName(), equalTo(DATASOURCE_NAME + POOL_SUFIX));
	}
	
	@Test
	public void getDriverName_method_should_return_a_value_equal_to_postgre_driver_name() {
		assertThat(dataSource.getDriverName(), equalTo(POSTGRESQL));
	}
	
	@Test
	public void getDriverClass_method_should_return_a_value_equal_to_postgre_driver_class() {
		assertThat(dataSource.getDriverClass(), equalTo(DRIVER_CLASS));
	}

}
