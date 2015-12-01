package br.org.studio.tool.persitence;

import br.org.studio.tool.database.PostgresDatabase;

public class PersistenceConfigurationBuilder {

	private static final String POSTGRES = "postgres";
	private static final String PUBLIC = "public";
	private static final String TRUE = "true";
	private static final String FALSE = "false";

	private String driver;
	private String url;
	private String user;
	private String password;
	private String dialect;
	private String hbm2dllAuto;

	public PersistenceConfigurationBuilder(String url) {
		this.url = url;
	}

	public PersistenceConfiguration build() {
		PersistenceConfiguration configuration = new PersistenceConfiguration();

		configuration.setUrl(url);

		configuration.setDriver(getDriver());
		configuration.setUser(getUser());
		configuration.setPassword(getPassword());

		configuration.setDefaultSchema(PUBLIC);
		configuration.setShowSql(FALSE);
		configuration.setAutoCommit(TRUE);
		configuration.setDialect(getDialect());
		configuration.setHbm2DllAuto(getHbm2DllAuto());

		return configuration;
	}

	public PersistenceConfigurationBuilder withDriver(String value) {
		this.driver = value;
		return this;
	}

	public PersistenceConfigurationBuilder withUrl(String value) {
		this.url = value;
		return this;
	}

	public PersistenceConfigurationBuilder withUser(String value) {
		this.user = value;
		return this;
	}

	public PersistenceConfigurationBuilder withPassword(String value) {
		this.password = value;
		return this;
	}

	public PersistenceConfigurationBuilder withDialect(String value) {
		this.dialect = value;
		return this;
	}

	public PersistenceConfigurationBuilder withHbm2dllAuto(String value) {
		this.hbm2dllAuto = value;
		return this;
	}

	private String getDriver() {
		if (driver == null || driver.isEmpty()) {
			return PostgresDatabase.DRIVER;
		} else {
			return driver;
		}
	}

	private String getUser() {
		if (user == null || user.isEmpty()) {
			return POSTGRES;
		} else {
			return user;
		}
	}

	private String getPassword() {
		if (password == null || password.isEmpty()) {
			return POSTGRES;
		} else {
			return password;
		}
	}

	private String getDialect() {
		if (dialect == null || dialect.isEmpty()) {
			return PostgresDatabase.DIALECT;
		} else {
			return dialect;
		}
	}

	private String getHbm2DllAuto() {
		if (hbm2dllAuto == null || hbm2dllAuto.isEmpty()) {
			return "validate";
		} else {
			return hbm2dllAuto;
		}
	}

}