package br.org.studio.tool.repository.service;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.org.studio.tool.repository.SurveyRepositoryDao;

@Stateless
@Local(SurveyRepositoryService.class)
public class SurveyRepositoryServiceBean implements SurveyRepositoryService {

	@Inject
	private SurveyRepositoryDao dao;

	@Override
	public void createRepository() {
		// SurveyRepository newRespository = new SurveyRepository();
		// dao.persist(newRespository);
	}

}
