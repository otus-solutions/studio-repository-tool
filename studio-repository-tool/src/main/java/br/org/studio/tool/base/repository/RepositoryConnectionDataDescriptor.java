package br.org.studio.tool.base.repository;

public interface RepositoryConnectionDataDescriptor {
	
	String getDatabase();
	
	String getPort();
	
	String getHost();
	
	String getPassword();
	
	String getUsername();

}
