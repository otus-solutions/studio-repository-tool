package br.org.studio.tool.base.database;

public interface Database {

	Boolean hasError();

	String getName();

	String getHost();

	String getPort();

	String getUser();

	String getPassword();

	String getDriver();

	String getUrl();

}
