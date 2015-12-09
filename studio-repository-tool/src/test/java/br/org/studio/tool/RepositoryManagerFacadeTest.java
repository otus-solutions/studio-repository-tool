package br.org.studio.tool;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.org.studio.tool.base.repository.Repository;
import br.org.studio.tool.base.repository.RepositoryType;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.mongodb.database.StudioMongoDatabase;
import br.org.studio.tool.mongodb.repository.MongoRepository;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RepositoryManagerFacade.class })
public class RepositoryManagerFacadeTest {

    private static final String REPOSITORY_NAME = "db_name";

    @Mock
    private StudioMongoDatabase database;
    @Mock
    private MongoRepository repository;
    @Mock
    private RepositoryConfiguration repositoryConfiguration;

    @Before
    public void setup() throws Exception {
        whenNew(StudioMongoDatabase.class).withArguments(repositoryConfiguration).thenReturn(database);
        whenNew(MongoRepository.class).withArguments(repositoryConfiguration).thenReturn(repository);

        when(repositoryConfiguration.getName()).thenReturn(REPOSITORY_NAME);
        when(repositoryConfiguration.getRepositoryType()).thenReturn(RepositoryType.POSTGRESQL);
    }

    @Test
    public void createRepository_method_should_call_initializeRepository_from_Repository_object_when_repository_is_accessible()
            throws Exception {
        when(repository.isAccessible()).thenReturn(true);
        RepositoryManagerFacade rmf = new RepositoryManagerFacade();

        rmf.createRepository(repositoryConfiguration);

        verify(repository).initialize();
    }

    @Test
    public void createRepository_method_should_return_null_when_repository_is_not_accessible() throws Exception {
        when(repository.isAccessible()).thenReturn(false);
        RepositoryManagerFacade rmf = new RepositoryManagerFacade();

        Repository createdRepository = rmf.createRepository(repositoryConfiguration);

        assertThat(createdRepository, nullValue());
    }

    @Test
    public void deleteRepository_method_should_call_dropDatabase_from_Database_object() throws Exception {
        when(repository.isAccessible()).thenReturn(true);
        RepositoryManagerFacade rmf = new RepositoryManagerFacade();

        rmf.deleteRepository(repositoryConfiguration);

        verify(repository).delete();
    }

    @Test
    public void deleteRepository_method_should_not_call_delete_method_from_Repository_when_repository_is_not_accessible() throws Exception {
        when(repository.isAccessible()).thenReturn(false);
        RepositoryManagerFacade rmf = new RepositoryManagerFacade();

        rmf.deleteRepository(repositoryConfiguration);

        verify(repository, times(0)).delete();
    }

    @Test
    public void connectRepository_method_should_call_load_from_Repository_object() throws Exception {
        when(repository.isAccessible()).thenReturn(true);
        RepositoryManagerFacade rmf = new RepositoryManagerFacade();

        rmf.connectRepository(repositoryConfiguration);

        verify(repository).load();
    }

    @Test
    public void connectRepository_method_should_return_null_when_repository_is_not_accessible() throws Exception {
        when(repository.isAccessible()).thenReturn(false);
        RepositoryManagerFacade rmf = new RepositoryManagerFacade();

        Repository connectedRepository = rmf.connectRepository(repositoryConfiguration);

        assertThat(connectedRepository, nullValue());
    }

    @Test
    public void isRepositoryAccessible_method_should_call_isAccessible_from_Repository_object() throws Exception {
        RepositoryManagerFacade rmf = new RepositoryManagerFacade();

        rmf.isRepositoryAccessible(repositoryConfiguration);

        verify(repository).isAccessible();
    }

}
