package br.org.studio.tool.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "survey_repository", catalog = "studio", schema = "public")
@SequenceGenerator(name = "SurveyRepositorySequence", sequenceName = "survey_repository_seq", initialValue = 1, allocationSize = 1, catalog = "studio", schema = "public")
public class SurveyRepository implements Serializable {

	private static final long serialVersionUID = 3469302031251338134L;

	@Id
	@GeneratedValue(generator = "SurveyRepositorySequence", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@NotNull
	private String name;

	@NotNull
	private String description;

	@NotNull
	private String url;

	@NotNull
	private Integer port;

	@NotNull
	private String username;

	@NotNull
	private String password;

	public SurveyRepository(String name, String description) {
		this.name = name;
		this.description = description;
		this.port = 5432;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

	public Integer getPort() {
		return port;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
