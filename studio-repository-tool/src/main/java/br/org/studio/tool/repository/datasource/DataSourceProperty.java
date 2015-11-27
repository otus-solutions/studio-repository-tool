package br.org.studio.tool.repository.datasource;

public enum DataSourceProperty {

	JNDI_NAME("jndi-name"), 
	CONNECTION_URL("connection-url"),
	DRIVER_CLASS("driver-class"),
	DRIVER_NAME("driver-name"), 
	USER_NAME("user-name"), 
	PASSWORD("password"), 
	POOL_NAME("pool-name");

	private String value;

	private DataSourceProperty(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
