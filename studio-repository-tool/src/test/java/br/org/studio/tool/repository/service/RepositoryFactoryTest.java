package br.org.studio.tool.repository.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.util.Map;

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
import br.org.studio.tool.repository.datasource.Configuration;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RepositoryFactory.class, Persistence.class })
public class RepositoryFactoryTest {

	@Mock
	private Persistence persistence;
	@Mock
	private Configuration configuration;
	@Mock
	private EntityManagerFactory entityManagerFactory;
	@Mock
	private EntityManager entityManager;
	@Mock
	private RepositoryConfiguration repositoryConfiguration;

	private Map<String, String> properties;

	@Before
	public void setup() throws Exception {
		buildPropertieMap();
		mockStatic(Persistence.class);
		when(Persistence.createEntityManagerFactory(RepositoryFactory.UNIT_NAME, properties)).thenReturn(entityManagerFactory);

		whenNew(Configuration.class).withNoArguments().thenReturn(configuration);
		when(configuration.getProperties()).thenReturn(properties);

		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
	}

	@Test
	public void initializeRepository_method_should_call_createEntityManagerFactory_from_Persistence() {
		RepositoryFactory repositoryFactory = new RepositoryFactory();

		repositoryFactory.initializeRepository(repositoryConfiguration);

		verifyStatic();
		Persistence.createEntityManagerFactory(RepositoryFactory.UNIT_NAME, properties);
	}

	@Test
	public void initializeRepository_method_should_call_createEntityManager_from_EntityManagerFactory() {
		RepositoryFactory repositoryFactory = new RepositoryFactory();

		repositoryFactory.initializeRepository(repositoryConfiguration);

		verify(entityManagerFactory).createEntityManager();
	}

	private void buildPropertieMap() {
		Configuration configuration = new Configuration();

		configuration.setDriver("org.postgresql.Driver");
		configuration.setUrl("jdbc:postgresql://localhost:5432/repository");
		configuration.setUser("postgres");
		configuration.setPassword("postgres");

		configuration.setDialect("org.hibernate.dialect.PostgreSQLDialect");
		configuration.setDefaultSchema("public");
		configuration.setShowSql("true");
		configuration.setAutoCommit("true");
		configuration.setHbm2DllAuto("create");

		properties = configuration.getProperties();
	}

}
