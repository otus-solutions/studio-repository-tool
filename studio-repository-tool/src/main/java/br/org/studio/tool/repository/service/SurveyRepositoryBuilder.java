package br.org.studio.tool.repository.service;

import br.org.studio.tool.persistence.dao.SurveyRepository;

public class SurveyRepositoryBuilder {

	public static SurveyRepository newLocalRepository(String name, String description) {
		return new SurveyRepository(name, description);
	}

}
