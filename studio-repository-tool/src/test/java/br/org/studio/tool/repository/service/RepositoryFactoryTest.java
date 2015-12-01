package br.org.studio.tool.repository.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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

import br.org.studio.tool.repository.RepositoryConfiguration;
import br.org.studio.tool.repository.persitence.PersistenceConfiguration;
import br.org.studio.tool.repository.persitence.PersistenceConfigurationBuilder;
import br.org.studio.tool.repository.persitence.PersistenceContext;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RepositoryFactory.class, Persistence.class })
public class RepositoryFactoryTest {

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

		when(configurationBuilder.build()).thenReturn(configuration);
		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
	}

	@Test
	public void initialize_method_should_call_load_from_PersistenceContext() {
		RepositoryFactory repositoryFactory = new RepositoryFactory();

		repositoryFactory.initialize(repositoryConfiguration);

		verify(persistenceContext).load(configuration);
	}

	@Test
	public void initialize_method_should_call_close_from_PersistenceContext() {
		RepositoryFactory repositoryFactory = new RepositoryFactory();

		repositoryFactory.initialize(repositoryConfiguration);

		verify(persistenceContext).close();
	}
	
	@Test
	public void load_method_should_call_load_from_PersistenceContext() {
		RepositoryFactory repositoryFactory = new RepositoryFactory();

		repositoryFactory.load(repositoryConfiguration);

		verify(persistenceContext).load(configuration);
	}

	@Test
	public void load_method_should_call_close_from_PersistenceContext() {
		RepositoryFactory repositoryFactory = new RepositoryFactory();

		repositoryFactory.load(repositoryConfiguration);

		verify(persistenceContext).close();
	}

}
