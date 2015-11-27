package br.org.studio.tool.repository.service;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.org.studio.tool.repository.SurveyRepository;
import br.org.studio.tool.repository.SurveyRepositoryDao;

@Ignore
@RunWith(PowerMockRunner.class)
@PrepareForTest({ SurveyRepositoryServiceBean.class })
public class SurveyRepositoryServiceBeanTest {

	@InjectMocks
	private SurveyRepositoryServiceBean service;

	@Mock
	private SurveyRepositoryDao dao;
	@Mock
	private SurveyRepository respository;

	@Before
	public void setup() throws Exception {
		whenNew(SurveyRepository.class).withNoArguments().thenReturn(respository);
	}

	@Test
	public void createRepository_method_should_call_insert_method_from_SurveyRepositoryDao() {
		service.createRepository();

		verify(dao).persist(respository);
	}

}
