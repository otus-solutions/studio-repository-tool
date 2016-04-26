package br.org.studio.tool.mongodb.database;

public enum MetaInformation {

	COLLECTION("database_info"), 
	HOST("host"), 
	PORT("port"), 
	DBNAME("name"), 
	REPOSITORY("repository_name"), 
	DESCRIPTION("repository_description"),
	CREATION_DATE("creation_date");

	private String value;

	private MetaInformation(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
