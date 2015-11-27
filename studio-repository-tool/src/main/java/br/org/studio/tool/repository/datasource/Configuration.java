package br.org.studio.tool.repository.datasource;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

	Map<String, String> properties = new HashMap<>();

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public Configuration() {
		properties = new HashMap<>();
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setDriver(String value) {
		properties.put(JpaProperty.DRIVER.getValue(), value);
	}

	public void setUrl(String value) {
		properties.put(JpaProperty.URL.getValue(), value);
	}

	public void setUser(String value) {
		properties.put(JpaProperty.USER.getValue(), value);
	}

	public void setPassword(String value) {
		properties.put(JpaProperty.PASSWORD.getValue(), value);
	}

	public void setDialect(String value) {
		properties.put(HibernatePostgreProperty.DIALECT.getValue(), value);
	}

	public void setDefaultSchema(String value) {
		properties.put(HibernatePostgreProperty.DEFAULT_SCHEMA.getValue(), value);
	}

	public void setShowSql(String value) {
		properties.put(HibernatePostgreProperty.SHOW_SQL.getValue(), value);
	}

	public void setAutoCommit(String value) {
		properties.put(HibernatePostgreProperty.AUTOCOMMIT.getValue(), value);
	}

	public void setHbm2DllAuto(String value) {
		properties.put(HibernatePostgreProperty.HBM2DLL_AUTO.getValue(), value);
	}
}
