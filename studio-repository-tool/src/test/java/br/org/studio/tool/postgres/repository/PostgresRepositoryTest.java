package br.org.studio.tool.postgres.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.org.studio.tool.base.persitence.PersistenceConfiguration;
import br.org.studio.tool.base.persitence.PersistenceConfigurationBuilder;
import br.org.studio.tool.base.persitence.PersistenceContext;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.postgres.database.PostgresDatabase;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PostgresRepository.class, Persistence.class, PersistenceContext.class, PersistenceConfiguration.class })
public class PostgresRepositoryTest {

	@Mock
	private PersistenceContext persistenceContext;
	@Mock
	private PersistenceConfiguration configuration;
	@Mock
	private EntityManagerFactory entityManagerFactory;
	@Mock
	private EntityManager entityManager;
	@Mock
	private PersistenceConfigurationBuilder configurationBuilder;

	@Mock
	private RepositoryConfiguration repositoryConfiguration;
	@Mock
	private PostgresDatabase postgresql;

	@Before
	public void setup() throws Exception {
		whenNew(PersistenceContext.class).withNoArguments().thenReturn(persistenceContext);
		whenNew(PersistenceConfiguration.class).withNoArguments().thenReturn(configuration);
		whenNew(PersistenceConfigurationBuilder.class).withNoArguments().thenReturn(configurationBuilder);
		whenNew(PostgresDatabase.class).withArguments(repositoryConfiguration).thenReturn(postgresql);

		mockStatic(PersistenceContext.class);
		when(PersistenceContext.load(configuration)).thenReturn(persistenceContext);

		mockStatic(PersistenceConfiguration.class);
		when(PersistenceConfiguration.forCreate(repositoryConfiguration)).thenReturn(configuration);
		when(PersistenceConfiguration.forValidate(repositoryConfiguration)).thenReturn(configuration);

		when(configurationBuilder.build()).thenReturn(configuration);
		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
	}

	@Test
	public void a_Repository_instance_should_has_a_configuration() {
		PostgresRepository repository = new PostgresRepository(repositoryConfiguration);

		assertThat(repository.getConfiguration(), instanceOf(RepositoryConfiguration.class));
	}

	@Test
	public void initialize_method_should_call_load_from_PersistenceContext() throws Exception {
		PostgresRepository repository = new PostgresRepository(repositoryConfiguration);

		repository.initialize();

		verifyStatic();
		PersistenceContext.load(configuration);
	}

	@Test
	public void initialize_method_should_call_createDatabase_from_PostgresDatabase() throws Exception {
		PostgresRepository repository = new PostgresRepository(repositoryConfiguration);

		repository.initialize();

		verify(postgresql).createDatabase();
	}

	@Test
	public void close_method_should_call_close_from_PersistenceContext() throws Exception {
		PostgresRepository repository = new PostgresRepository(repositoryConfiguration);
		repository.initialize();

		repository.close();

		verify(persistenceContext).close();
	}

	@Test
	public void load_method_should_call_load_from_PersistenceContext() {
		PostgresRepository repository = new PostgresRepository(repositoryConfiguration);

		repository.load();

		verifyStatic();
		PersistenceContext.load(configuration);
	}

	@Test
	public void delete_method_should_call_dropDatabase_from_PostgresDatabase() throws Exception {
		PostgresRepository repository = new PostgresRepository(repositoryConfiguration);

		repository.delete();

		verify(postgresql).dropDatabase();
	}

}
