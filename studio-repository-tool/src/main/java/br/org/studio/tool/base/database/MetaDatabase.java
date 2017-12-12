package br.org.studio.tool.base.database;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;

public abstract class MetaDatabase implements Database {

	private RepositoryConfiguration configuration;
	private Object warnings;

	public MetaDatabase(RepositoryConfiguration configuration) {
		this.configuration = configuration;
	}

	protected RepositoryConfiguration getConfiguration() {
		return configuration;
	}

	@Override
	public String getName() {
		return configuration.getDatabaseName();
	}

	@Override
	public String getUser() {
		return configuration.getUserName();
	}

	@Override
	public String getPassword() {
		return configuration.getPassword();
	}

	@Override
	public Boolean hasError() {
		return (warnings == null) ? false : true;
	}

	protected void setError(Object error) {
		warnings = error;
	}
	
	@Override
	public String getPort(){
		return configuration.getRepositoryConnectionDataDescriptor().getPort();
	}
	
	@Override
	public String getHost(){
		return configuration.getRepositoryConnectionDataDescriptor().getHost();
	}

	@Override
	public String getUrl() {
		return configuration.getUrl();
	}

	@Override
	public abstract String getDriver();

}
