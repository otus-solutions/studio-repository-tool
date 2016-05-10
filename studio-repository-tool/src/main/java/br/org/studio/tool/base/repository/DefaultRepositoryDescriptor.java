package br.org.studio.tool.base.repository;

public class DefaultRepositoryDescriptor implements RepositoryDescriptor {

	private String databasName;
    private String user;
    private String password;
    private RepositoryConnectionDataDescriptor repositoryConnectionDataDescriptor;

    @Override
    public String getDatabaseName() {
        return databasName;
    }

    public void setDatabaseName(String databasName) {
        this.databasName = databasName;
    }

    @Override
    public String getUserName() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public RepositoryConnectionDataDescriptor getRepositoryConnectionDataDescriptor() {
		return repositoryConnectionDataDescriptor;
	}

	public void setRepositoryConnectionDataDescriptor(
			RepositoryConnectionDataDescriptor repositoryConnectionDataDescriptor) {
		this.repositoryConnectionDataDescriptor = repositoryConnectionDataDescriptor;
	}

}
