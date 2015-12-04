package br.org.studio.tool.base.persitence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

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
import br.org.studio.tool.base.persitence.PersistenceContext;
import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.postgres.PostgresRepositoryConfiguration;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Persistence.class)
public class PersistenceContextTest {

	private static final String UNIT_NAME = "RepositoryPool";

	private RepositoryConfiguration repositoryConfiguration;
	private PersistenceConfiguration configuration;

	@Mock
	private EntityManagerFactory entityManagerFactory;
	@Mock
	private EntityManager entityManager;

	@Before
	public void setup() {
		buildRepositoryConfiguration();
		buildPersistenceConfiguration();

		mockStatic(Persistence.class);
		when(Persistence.createEntityManagerFactory(UNIT_NAME, configuration.getProperties())).thenReturn(entityManagerFactory);
		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
	}

	private void buildRepositoryConfiguration() {
		repositoryConfiguration = PostgresRepositoryConfiguration.create("postgres", "localhost", "5432", "postgres", "postgres");
	}

	private void buildPersistenceConfiguration() {
		configuration = new PersistenceConfiguration();

		configuration.setDriver(repositoryConfiguration.getDriver());
		configuration.setUrl(repositoryConfiguration.getUrl());
		configuration.setUser(repositoryConfiguration.getUser());
		configuration.setPassword(repositoryConfiguration.getPassword());

		configuration.setDialect(repositoryConfiguration.getDialect());
		configuration.setDefaultSchema("public");
		configuration.setShowSql("false");
		configuration.setAutoCommit("true");
		configuration.setHbm2DllAuto("create");
	}

	@Test
	public void load_method_should_return_the_PersistenceContext_instance() {
		assertThat(PersistenceContext.load(configuration), instanceOf(PersistenceContext.class));
	}

	@Test
	public void load_method_should_call_createEntityManagerFactory_from_Persistence() {
		PersistenceContext.load(configuration);

		verifyStatic();
		Persistence.createEntityManagerFactory(UNIT_NAME, configuration.getProperties());
	}

	@Test
	public void load_method_should_call_createEntityManager_from_EntityManagerFactory() {
		PersistenceContext.load(configuration);

		verify(entityManagerFactory).createEntityManager();
	}

	@Test
	public void close_method_should_call_close_from_EntityManager() {
		PersistenceContext context = PersistenceContext.load(configuration);

		context.close();

		verify(entityManager).close();
	}

}
