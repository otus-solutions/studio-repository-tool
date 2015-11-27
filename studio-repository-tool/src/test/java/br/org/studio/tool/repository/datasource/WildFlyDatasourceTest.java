package br.org.studio.tool.repository.datasource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jboss.dmr.ModelNode;
import org.junit.Ignore;
import org.junit.Test;

import br.org.studio.tool.repository.datasource.PostgreDataSource;
import br.org.studio.tool.repository.datasource.WildFlyDatasourceManager;

@Ignore
public class WildFlyDatasourceTest {

	private static final String REPOSITORY = "Repository";
	private static final String STUDIO_DATASOURCE = "Studio";
	private static final String INEXISTENT_DATASOURCE = "inexistent-ds";
	private static final String JNDI_NAME = "java:jboss/datasources/repository";

	@Test
	public void createPostgreDatasource_method_should_add_a_new_datasource_in_datasources_subsystem() throws Exception {
		WildFlyDatasourceManager datasourceManager = new WildFlyDatasourceManager();

		datasourceManager.createPostgreDatasource(buildPostgreDataSource());
		ModelNode datasource = datasourceManager.getDatasource(REPOSITORY);

		assertThat(datasource.asProperty().getName(), equalTo(REPOSITORY));
	}

	@Test
	public void getDatasource_method_should_return_a_datasource_entry_from_standalone_xml_when_it_exists()
			throws Exception {
		WildFlyDatasourceManager datasourceManager = new WildFlyDatasourceManager();

		ModelNode datasource = datasourceManager.getDatasource(STUDIO_DATASOURCE);

		assertThat(datasource.asProperty().getName(), equalTo(STUDIO_DATASOURCE));
	}

	@Test(expected = Exception.class)
	public void getDatasource_method_should_throws_an_exception_when_datasource_not_exist_in_standalone_xml()
			throws Exception {
		WildFlyDatasourceManager datasourceManager = new WildFlyDatasourceManager();

		ModelNode datasource = datasourceManager.getDatasource(INEXISTENT_DATASOURCE);

		assertThat(datasource.asProperty().getName(), equalTo(INEXISTENT_DATASOURCE));
	}

	private PostgreDataSource buildPostgreDataSource() {
		String connectionUrl = "jdbc:postgresql://localhost:5432/studio";
		String username = "postgres";
		String password = "postgres";
		return new PostgreDataSource(JNDI_NAME, connectionUrl, REPOSITORY, username, password);
	}

}
