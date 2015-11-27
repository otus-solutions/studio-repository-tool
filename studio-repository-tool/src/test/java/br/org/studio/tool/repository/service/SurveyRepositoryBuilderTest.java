package br.org.studio.tool.repository.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Test;

import br.org.studio.tool.repository.SurveyRepository;

public class SurveyRepositoryBuilderTest {

	private static final String LOCAL_REPOSITORY_URL = "jdbc";
	private static final String REPOSITORY_DESCRIPTION = "Local repository description.";
	private static final String REPOSITORY_NAME = "Local Repository";

	@Test
	public void newLocalRepository_method_should_return_a_new_instance_of_SurveyRepository() {
		Object object = SurveyRepositoryBuilder.newLocalRepository(REPOSITORY_NAME, REPOSITORY_DESCRIPTION);

		assertThat(object, instanceOf(SurveyRepository.class));
	}

	@Test
	public void newLocalRepository_method_should_return_a_SurveyRepository_with_name_equal_to_first_parameter() {
		SurveyRepository repository = SurveyRepositoryBuilder.newLocalRepository(REPOSITORY_NAME,
				REPOSITORY_DESCRIPTION);

		assertThat(repository.getName(), equalTo(REPOSITORY_NAME));
	}

	@Test
	public void newLocalRepository_method_should_return_a_SurveyRepository_with_description_equal_to_second_parameter() {
		SurveyRepository repository = SurveyRepositoryBuilder.newLocalRepository(REPOSITORY_NAME,
				REPOSITORY_DESCRIPTION);

		assertThat(repository.getDescription(), equalTo(REPOSITORY_DESCRIPTION));
	}

	@Test
	public void newLocalRepository_method_should_return_a_SurveyRepository_with_url_equal_to_local_database_url() {
		SurveyRepository repository = SurveyRepositoryBuilder.newLocalRepository(REPOSITORY_NAME,
				REPOSITORY_DESCRIPTION);

		assertThat(repository.getDescription(), equalTo(REPOSITORY_DESCRIPTION));
	}

}
