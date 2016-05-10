package br.org.studio.tool.base.repository;

public interface RepositoryDescriptor {
    
    String getDatabaseName();
    
    String getUserName();
    
    String getPassword();
    
    RepositoryConnectionDataDescriptor getRepositoryConnectionDataDescriptor();
    
    
}
