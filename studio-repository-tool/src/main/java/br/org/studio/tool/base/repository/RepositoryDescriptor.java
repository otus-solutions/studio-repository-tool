package br.org.studio.tool.base.repository;

public interface RepositoryDescriptor {

    String getRepositoryName();
    
    String getDatabaseName();
    
    String getHostName();
    
    String getPort();
    
    String getUser();
    
    String getPassword();
    
    String getDescription();
    
}
