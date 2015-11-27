package br.org.studio.tool.repository.datasource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class HibernatePostgrePropertyTest {

	private static final String DIALECT = "hibernate.dialect";
	private static final String DEFAULT_SCHEMA = "hibernate.default_schema";
	private static final String SHOW_SQL = "hibernate.show_sql";
	private static final String AUTOCOMMIT = "hibernate.connection.autocommit";
	private static final String HBM2DLL_AUTO = "hibernate.hbm2ddl.auto";

	@Test
	public void the_DIALECT_property_must_be_equal_to_hibernate_dialect() {
		assertThat(HibernatePostgreProperty.DIALECT.getValue(), equalTo(DIALECT));
	}
	
	@Test
	public void the_DEFAULT_SCHEMA_property_must_be_equal_to_hibernate_default_schema() {
		assertThat(HibernatePostgreProperty.DEFAULT_SCHEMA.getValue(), equalTo(DEFAULT_SCHEMA));
	}
	
	@Test
	public void the_SHOW_SQL_property_must_be_equal_to_hibernate_show_sql() {
		assertThat(HibernatePostgreProperty.SHOW_SQL.getValue(), equalTo(SHOW_SQL));
	}
	
	@Test
	public void the_AUTO_COMMIT_property_must_be_equal_to_hibernate_autocommit() {
		assertThat(HibernatePostgreProperty.AUTOCOMMIT.getValue(), equalTo(AUTOCOMMIT));
	}
	
	@Test
	public void the_HBM2DLL_AUTO_property_must_be_equal_to_hibernate_hbm2dll_auto() {
		assertThat(HibernatePostgreProperty.HBM2DLL_AUTO.getValue(), equalTo(HBM2DLL_AUTO));
	}

}
