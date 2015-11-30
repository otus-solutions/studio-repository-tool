package br.org.studio.tool.repository;

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

import br.org.studio.tool.repository.service.PostgreDatabase;
import br.org.studio.tool.repository.service.RepositoryFactory;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RepositoryManagerFacade.class })
public class RepositoryManagerFacadeTest {

	private static final String REPOSITORY_NAME = "db_name";

	@Mock
	private PostgreDatabase database;
	@Mock
	private RepositoryFactory repositoryFactory;
	@Mock
	private RepositoryConfiguration repositoryConfiguration;

	@Before
	public void setup() throws Exception {
		whenNew(PostgreDatabase.class).withArguments(REPOSITORY_NAME).thenReturn(database);
		whenNew(RepositoryFactory.class).withNoArguments().thenReturn(repositoryFactory);
		when(repositoryConfiguration.getName()).thenReturn(REPOSITORY_NAME);
	}

	@Test
	public void createRepository_method_should_call_createDatabase_from_Database_object() throws SQLException {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();

		rmf.createRepository(repositoryConfiguration);

		verify(database).createDatabase(REPOSITORY_NAME);
	}

	@Test
	public void createRepository_method_should_call_initializeRepository_from_RepositoryFactory_object() throws SQLException {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();

		rmf.createRepository(repositoryConfiguration);

		verify(repositoryFactory).initializeRepository(repositoryConfiguration);
	}

	@Test
	public void deleteRepository_method_should_call_dropDatabase_from_Database_object() throws SQLException {
		RepositoryManagerFacade rmf = new RepositoryManagerFacade();

		rmf.deleteRepository(repositoryConfiguration);

		verify(database).dropDatabase(REPOSITORY_NAME);
	}

}
