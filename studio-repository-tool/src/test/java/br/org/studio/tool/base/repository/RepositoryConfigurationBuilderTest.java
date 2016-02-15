package br.org.studio.tool.base.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Test;

import br.org.studio.tool.base.repository.configuration.RepositoryConfiguration;
import br.org.studio.tool.base.repository.configuration.RepositoryConfigurationBuilder;

public class RepositoryConfigurationBuilderTest {

    private static final String DBNAME = "dbname";
    private static final String HOST = "myHost";
    private static final String LOCALHOST = "localhost";
    private static final String PORT = "1123";
    private static final String DEFAULT_PORT = "27017";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

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

        builder.withHost(HOST);
        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getHostName(), equalTo(HOST));
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_default_host_when_host_is_not_defined() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getHostName(), equalTo(LOCALHOST));
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_port() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        builder.withPort(PORT);
        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getPort(), equalTo(PORT));
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_default_port_when_port_is_not_defined() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getPort(), equalTo(DEFAULT_PORT));
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_user() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        builder.withUser(USER);
        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getUser(), equalTo(USER));
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

        builder.withDatabaseName(DBNAME).withHost(HOST).withPort(PORT).withUser(USER).withPassword(PASSWORD);
        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getDatabaseName(), equalTo(DBNAME));
        assertThat(configuration.getHostName(), equalTo(HOST));
        assertThat(configuration.getPort(), equalTo(PORT));
        assertThat(configuration.getUser(), equalTo(USER));
        assertThat(configuration.getPassword(), equalTo(PASSWORD));
    }

    @Test
    public void build_method_should_return_an_instance_of_RepositoryConfiguration_with_all_default_paramenters() {
        RepositoryConfigurationBuilder builder = new RepositoryConfigurationBuilder();

        builder.withDatabaseName(DBNAME);
        RepositoryConfiguration configuration = builder.buildForMongo();

        assertThat(configuration.getDatabaseName(), equalTo(DBNAME));
        assertThat(configuration.getHostName(), equalTo(LOCALHOST));
        assertThat(configuration.getPort(), equalTo(DEFAULT_PORT));
    }

}
