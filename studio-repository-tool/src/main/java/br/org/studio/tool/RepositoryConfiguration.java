package br.org.studio.tool;

import br.org.studio.tool.database.HibernateDatabase;
import br.org.studio.tool.database.postgres.PostgresDatabase;
import br.org.studio.tool.repository.RepositoryConfigurationBuilder;
import br.org.studio.tool.repository.RepositoryDatabase;

public class RepositoryConfiguration {

	private String name;
	private String host;
	private String port;
	private String user;
	private String password;
	private RepositoryType repositoryType;

	public RepositoryConfiguration(RepositoryType repositoryType) {
		this.repositoryType = repositoryType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriver() {
		return PostgresDatabase.DRIVER;
	}

	public String getDialect() {
		return PostgresDatabase.DIALECT;
	}

	public RepositoryType getRepositoryType() {
		return repositoryType;
	}

	public String getUrl() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(PostgresDatabase.JDBC);
		stringBuilder.append(getHost());
		stringBuilder.append(":");
		stringBuilder.append(getPort());
		stringBuilder.append("/");
		stringBuilder.append(getName());
		return stringBuilder.toString();
	}

	public HibernateDatabase buildMetaDatabase() {
		RepositoryDatabase repository = new RepositoryDatabase(getName());
		repository.setHost(getHost());
		repository.setPort(getPort());
		repository.setUser(getUser());
		repository.setPassword(getPassword());
		return repository;
	}

	public static RepositoryConfiguration forPostgre(String name, String host, String port, String user, String password) {
		RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();
		builder.withName(name).withHost(host).withPort(port).withUser(user).withPassword(password);
		return builder.buildPostgresConfiguration();
	}

}
