package br.org.studio.tool.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.org.studio.tool.repository.database.PostgresDatabase;
import br.org.studio.tool.repository.database.Repository;
import br.org.studio.tool.repository.database.RepositoryUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RepositoryManagerFacade.class })
public class RepositoryManagerFacadeTest {

	private static final String REPOSITORY_NAME = "db_name";

	@Mock
	private PostgresDatabase database;
	@Mock
	private Repository repository;
	@Mock
	private RepositoryUtils repositoryUtils;
	@Mock
	private RepositoryConfiguration repositoryConfiguration;

	@Before
	public void setup() throws Exception {
		whenNew(PostgresDatabase.class).withArguments(repositoryConfiguration).thenReturn(database);
		whenNew(Repository.class).withArguments(repositoryConfiguration).thenReturn(repository);
		when(repositoryConfiguration.getName()).thenReturn(REPOSITORY_NAME);
		when(repositoryConfiguration.getDatabase()).thenReturn(database);
		when(repository.getUtils()).thenReturn(repositoryUtils);
	}

	@Test
	public void createRepository_method_should_call_createDatabase_from_Database_object() throws SQLException {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();

		rmf.createRepository(repositoryConfiguration);

		verify(database).createDatabase();
	}

	@Test
	public void createRepository_method_should_call_initializeRepository_from_Repository_object() throws SQLException {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();

		rmf.createRepository(repositoryConfiguration);

		verify(repository).initialize();
	}

	@Test
	public void deleteRepository_method_should_call_dropDatabase_from_Database_object() throws SQLException {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();

		rmf.deleteRepository(repositoryConfiguration);

		verify(database).dropDatabase();
	}

	@Test
	public void connectRepository_method_should_call_load_from_Repository_object() throws SQLException {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();

		rmf.connectRepository(repositoryConfiguration);

		verify(repository).load();
	}

	@Test
	public void connectRepository_method_should_return_an_instance_of_RepositoryUtils() throws SQLException {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();

		RepositoryUtils object = rmf.connectRepository(repositoryConfiguration);

		assertThat(object, instanceOf(RepositoryUtils.class));
	}

}
