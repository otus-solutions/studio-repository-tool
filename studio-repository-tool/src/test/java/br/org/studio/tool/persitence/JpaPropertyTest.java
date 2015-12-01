package br.org.studio.tool.persitence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import br.org.studio.tool.persitence.JpaProperty;

public class JpaPropertyTest {

	private static final String URL = "javax.persistence.jdbc.url";
	private static final String DRIVER = "javax.persistence.jdbc.driver";
	private static final String USER = "javax.persistence.jdbc.user";
	private static final String PASSWORD = "javax.persistence.jdbc.password";

	@Test
	public void the_URL_property_must_be_equal_to_jdb_url() {
		assertThat(JpaProperty.URL.getValue(), equalTo(URL));
	}

	@Test
	public void the_DRIVER_property_must_be_equal_to_jdbc_driver() {
		assertThat(JpaProperty.DRIVER.getValue(), equalTo(DRIVER));
	}

	@Test
	public void the_USER_property_must_be_equal_to_jdbc_user() {
		assertThat(JpaProperty.USER.getValue(), equalTo(USER));
	}

	@Test
	public void the_PASSWORD_property_must_be_equal_to_jdbc_password() {
		assertThat(JpaProperty.PASSWORD.getValue(), equalTo(PASSWORD));
	}

}
