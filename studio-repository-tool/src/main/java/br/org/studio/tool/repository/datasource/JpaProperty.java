package br.org.studio.tool.repository.datasource;

public enum JpaProperty {

	URL("javax.persistence.jdbc.url"),
	DRIVER("javax.persistence.jdbc.driver"),
	USER("javax.persistence.jdbc.user"), 
	PASSWORD("javax.persistence.jdbc.password");

	private String value;

	private JpaProperty(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
