package br.org.studio.tool.database;

import java.sql.Connection;

public interface Database {

	Boolean hasError();

	Connection getConnection() throws Exception;

	String getName();

	String getHost();

	String getPort();

	String getUser();

	String getPassword();

	String getDriver();

	String getDialect();

	String getUrl();

}
