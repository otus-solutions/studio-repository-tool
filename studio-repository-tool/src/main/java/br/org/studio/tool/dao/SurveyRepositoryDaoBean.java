package br.org.studio.tool.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(SurveyRepositoryDao.class)
public class SurveyRepositoryDaoBean extends GenericDaoBean implements SurveyRepositoryDao {

}
