package br.org.studio.tool.base.persitence;

public enum PersistenceProperty {

	URL("javax.persistence.jdbc.url"),
	DRIVER("javax.persistence.jdbc.driver"),
	USER("javax.persistence.jdbc.user"), 
	PASSWORD("javax.persistence.jdbc.password");

	private String value;

	private PersistenceProperty(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
