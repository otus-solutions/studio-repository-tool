package br.org.studio.tool.mongodb.database;

public enum MetaInformation {

	COLLECTION("database_info"), 
	HOST("host"), 
	PORT("port"), 
	DBNAME("name");

	private String value;

	private MetaInformation(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
