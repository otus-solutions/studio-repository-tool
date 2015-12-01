package br.org.studio.tool.repository.persitence;

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

import br.org.studio.tool.repository.RepositoryConfiguration;

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
		repositoryConfiguration = RepositoryConfiguration.forPostgre("postgres", "localhost", "5432", "postgres", "postgres");

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
	public void load_method_should_call_createEntityManagerFactory_from_Persistence() {
		PersistenceContext context = new PersistenceContext();

		context.load(configuration);

		verifyStatic();
		Persistence.createEntityManagerFactory(UNIT_NAME, configuration.getProperties());
	}

	@Test
	public void load_method_should_call_createEntityManager_from_EntityManagerFactory() {
		PersistenceContext context = new PersistenceContext();

		context.load(configuration);

		verify(entityManagerFactory).createEntityManager();
	}

	@Test
	public void close_method_should_call_close_from_EntityManager() {
		PersistenceContext context = new PersistenceContext();
		context.load(configuration);

		context.close();

		verify(entityManager).close();
	}

}
