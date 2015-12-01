package br.org.studio.tool.repository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.org.studio.tool.RepositoryConfiguration;
import br.org.studio.tool.persitence.PersistenceConfiguration;
import br.org.studio.tool.persitence.PersistenceConfigurationBuilder;
import br.org.studio.tool.persitence.PersistenceContext;
import br.org.studio.tool.repository.Repository;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Repository.class, Persistence.class, PersistenceContext.class })
public class RepositoryTest {

	@Mock
	private PersistenceContext persistenceContext;
	@Mock
	private EntityManagerFactory entityManagerFactory;
	@Mock
	private EntityManager entityManager;

	@Mock
	private PersistenceConfigurationBuilder configurationBuilder;
	@Mock
	private RepositoryConfiguration repositoryConfiguration;
	@Mock
	private PersistenceConfiguration configuration;

	@Before
	public void setup() throws Exception {
		whenNew(PersistenceContext.class).withNoArguments().thenReturn(persistenceContext);
		whenNew(PersistenceConfiguration.class).withNoArguments().thenReturn(configuration);
		whenNew(PersistenceConfigurationBuilder.class).withArguments(repositoryConfiguration.getUrl()).thenReturn(configurationBuilder);

		mockStatic(PersistenceContext.class);
		when(PersistenceContext.load(configuration)).thenReturn(persistenceContext);
		when(configurationBuilder.build()).thenReturn(configuration);
		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
	}

	@Test
	public void a_Repository_instance_should_has_a_configuration() {
		Repository repository = new Repository(repositoryConfiguration);

		MatcherAssert.assertThat(repository.getConfiguration(), Matchers.instanceOf(RepositoryConfiguration.class));
	}

	@Test
	public void initialize_method_should_call_load_from_PersistenceContext() {
		Repository repository = new Repository(repositoryConfiguration);

		repository.initialize();

		verifyStatic();
		PersistenceContext.load(configuration);
	}

	@Test
	public void close_method_should_call_close_from_PersistenceContext() {
		Repository repository = new Repository(repositoryConfiguration);
		repository.initialize();

		repository.close();

		verify(persistenceContext).close();
	}

	@Test
	public void load_method_should_call_load_from_PersistenceContext() {
		Repository repository = new Repository(repositoryConfiguration);

		repository.load();

		verifyStatic();
		PersistenceContext.load(configuration);
	}

}
