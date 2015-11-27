package br.org.studio.tool.repository.datasource;

public enum HibernatePostgreProperty {

	DIALECT("hibernate.dialect"), 
	DEFAULT_SCHEMA("hibernate.default_schema"), 
	SHOW_SQL("hibernate.show_sql"), 
	AUTOCOMMIT("hibernate.connection.autocommit"), 
	HBM2DLL_AUTO("hibernate.hbm2ddl.auto");

	private String value;

	private HibernatePostgreProperty(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
