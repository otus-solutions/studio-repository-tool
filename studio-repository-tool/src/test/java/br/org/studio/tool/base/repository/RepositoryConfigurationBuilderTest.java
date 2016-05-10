package br.org.studio.tool.base.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Before;
import org.junit.Test;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.base.repository.configuration.RepositoryConfigurationBuilder;

public class RepositoryConfigurationBuilderTest {

    private static final String DBNAME = "dbname";
    private static final String HOST = "myHost";
    private static final String PORT = "1123";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    
    private RepositoryConnectionData repositoryConnectionData;
    
    @Before
    public void setUp() {
    	repositoryConnectionData = new RepositoryConnectionData();
    	repositoryConnectionData.setHost(HOST);
    	repositoryConnectionData.setPort(PORT);
    	repositoryConnectionData.setPassword(PASSWORD);
    	repositoryConnectionData.setUsername(USER);
    	repositoryConnectionData.setDatabase(DBNAME);
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryDatabase() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        Object object = builder.buildForMongo();

        assertThat(object, instanceOf(RepositoryConfiguration.class));
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_name() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        builder.withDatabaseName(DBNAME);
        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getDatabaseName(), equalTo(DBNAME));
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_host() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        builder.withRepositoryConnectionData(repositoryConnectionData);
        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getRepositoryConnectionDataDescriptor().getHost(), equalTo(HOST));
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_port() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        builder.withRepositoryConnectionData(repositoryConnectionData);
        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getRepositoryConnectionDataDescriptor().getPort(), equalTo(PORT));
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_user() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        builder.withUser(USER);
        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getUserName(), equalTo(USER));
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_password() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        builder.withPassword(PASSWORD);
        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getPassword(), equalTo(PASSWORD));
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_all_user_paramenters() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        builder.withDatabaseName(DBNAME).withUser(USER).withPassword(PASSWORD).withRepositoryConnectionData(repositoryConnectionData);
        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getDatabaseName(), equalTo(DBNAME));
        assertThat(configuration.getRepositoryConnectionDataDescriptor().getHost(), equalTo(HOST));
        assertThat(configuration.getRepositoryConnectionDataDescriptor().getPort(), equalTo(PORT));
        assertThat(configuration.getUserName(), equalTo(USER));
        assertThat(configuration.getPassword(), equalTo(PASSWORD));
    }

}
