package br.org.studio.tool.repository.datasource;

public class PostgreDataSource implements DataSource {

	private static final String POOL_SUFIX = "Pool";
	private static final String DRIVER_NAME = "postgresql-9.4-1203.jdbc4.jar";
	private static final String DRIVER_CLASS = "org.postgresql.Driver";

	private String jndiName;
	private String connectionUrl;
	private String dataSourceName;
	private String username;
	private String password;
	private String poolName;

	public PostgreDataSource(String jndiName, String connectionUrl, String dataSourceName, String username,
			String password) {
		this.jndiName = jndiName;
		this.connectionUrl = connectionUrl;
		this.dataSourceName = dataSourceName;
		this.username = username;
		this.password = password;
		this.poolName = dataSourceName + POOL_SUFIX;
	}

	@Override
	public String getJndiName() {
		return jndiName;
	}

	@Override
	public String getConnectionUrl() {
		return connectionUrl;
	}

	@Override
	public String getName() {
		return dataSourceName;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getPoolName() {
		return poolName;
	}

	@Override
	public String getDriverName() {
		return DRIVER_NAME;
	}

	@Override
	public String getDriverClass() {
		return DRIVER_CLASS;
	}

}
