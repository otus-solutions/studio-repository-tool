package br.org.studio.tool;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.org.studio.tool.RepositoryManagerFacade;
import br.org.studio.tool.base.repository.RepositoryType;
import br.org.studio.tool.base.repository.RepositoryUtils;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.postgres.database.PostgresDatabase;
import br.org.studio.tool.postgres.repository.PostgresRepository;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RepositoryManagerFacade.class })
public class RepositoryManagerFacadeTest {

	private static final String REPOSITORY_NAME = "db_name";

	@Mock
	private PostgresDatabase database;
	@Mock
	private PostgresRepository repository;
	@Mock
	private RepositoryUtils repositoryUtils;
	@Mock
	private RepositoryConfiguration repositoryConfiguration;

	@Before
	public void setup() throws Exception {
		whenNew(PostgresDatabase.class).withArguments(repositoryConfiguration).thenReturn(database);
		whenNew(PostgresRepository.class).withArguments(repositoryConfiguration).thenReturn(repository);

		when(repositoryConfiguration.getName()).thenReturn(REPOSITORY_NAME);
		when(repositoryConfiguration.getRepositoryType()).thenReturn(RepositoryType.POSTGRESQL);
		when(repositoryConfiguration.buildMetaDatabase()).thenReturn(database);
		when(repository.getUtils()).thenReturn(repositoryUtils);
	}

	@Test
	public void createRepository_method_should_call_initializeRepository_from_Repository_object() throws Exception {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();

		rmf.createRepository(repositoryConfiguration);

		verify(repository).initialize();
	}

	@Test
	public void deleteRepository_method_should_call_dropDatabase_from_Database_object() throws Exception {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();
		rmf.createRepository(repositoryConfiguration);

		rmf.deleteRepository(repositoryConfiguration);

		verify(repository).delete();
	}

	@Test
	public void connectRepository_method_should_call_load_from_Repository_object() throws Exception {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();
		rmf.createRepository(repositoryConfiguration);

		rmf.connectRepository(repositoryConfiguration);

		verify(repository).load();
	}

	@Test
	public void connectRepository_method_should_return_an_instance_of_RepositoryUtils() throws Exception {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();
		rmf.createRepository(repositoryConfiguration);

		RepositoryUtils object = rmf.connectRepository(repositoryConfiguration);

		assertThat(object, instanceOf(RepositoryUtils.class));
	}

}
