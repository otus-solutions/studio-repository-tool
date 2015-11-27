package br.org.studio.tool.repository.datasource;

interface DataSource {

	String getJndiName();

	String getConnectionUrl();

	String getName();

	String getUsername();

	String getPassword();

	String getPoolName();

	String getDriverName();

	String getDriverClass();

}
