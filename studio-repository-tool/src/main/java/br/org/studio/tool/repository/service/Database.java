package br.org.studio.tool.repository.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface Database {

	Boolean hasError();

	Connection getConnection() throws Exception;

	void createDatabase() throws SQLException;

	void dropDatabase(String databaseName) throws SQLException;

	String getName();

	String getHost();

	String getPort();

	String getUser();

	String getPassword();
	
	String getDriver();
	
	String getDialect();

	String getUrl();

}
