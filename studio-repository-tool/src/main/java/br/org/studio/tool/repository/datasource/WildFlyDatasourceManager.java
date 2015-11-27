package br.org.studio.tool.repository.datasource;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.OperationBuilder;
import org.jboss.as.controller.client.helpers.ClientConstants;
import org.jboss.dmr.ModelNode;

public class WildFlyDatasourceManager {

	private static final String DATA_SOURCE_NODE_VALUE = "datasources";
	private static final String DATA_SOURCE_NODE = "data-source";
	private static final String SUBSYSTEM = "subsystem";

	public void createPostgreDatasource(DataSource datasource) throws Exception {
		ModelNode request = createOperationRequest(datasource);
		configureOperationRequest(datasource, request);
		executeOperationRequest(request);
	}

	public ModelNode getDatasource(String datasourceName) throws Exception {
		ModelNode request = createDataSourceOperation(ClientConstants.READ_RESOURCE_OPERATION);
		request.get("recursive").set(false);
		ModelNode response = executeOperationRequest(request);
		ModelNode datasources = response.get(ClientConstants.RESULT).get(DATA_SOURCE_NODE);
		return searchDatasource(datasourceName, datasources);
	}

	private ModelNode createOperationRequest(DataSource datasource) {
		ModelNode request = createDataSourceOperation(ClientConstants.ADD);
		request.get(ClientConstants.OP_ADDR).add(DATA_SOURCE_NODE, datasource.getName());
		return request;
	}

	private ModelNode searchDatasource(String datasourceName, ModelNode datasources) throws Exception {
		if (datasources.isDefined()) {
			List<ModelNode> datasourceList = datasources.asList();
			for (ModelNode dataSource : datasourceList) {
				String dataSourceName = dataSource.asProperty().getName();
				if (dataSourceName.equals(datasourceName)) {
					return dataSource;
				}
			}
		}
		throw new Exception();
	}

	private ModelNode createDataSourceOperation(String operation) {
		ModelNode request = new ModelNode();
		request.get(ClientConstants.OP).set(operation);
		request.get(ClientConstants.OP_ADDR).add(SUBSYSTEM, DATA_SOURCE_NODE_VALUE);
		return request;
	}

	private void configureOperationRequest(DataSource datasource, ModelNode request) {
		request.get(DataSourceProperty.JNDI_NAME.getValue()).set(datasource.getJndiName());
		request.get(DataSourceProperty.CONNECTION_URL.getValue()).set(datasource.getConnectionUrl());
		request.get(DataSourceProperty.DRIVER_CLASS.getValue()).set(datasource.getDriverClass());
		request.get(DataSourceProperty.DRIVER_NAME.getValue()).set(datasource.getDriverName());
		request.get(DataSourceProperty.USER_NAME.getValue()).set(datasource.getUsername());
		request.get(DataSourceProperty.PASSWORD.getValue()).set(datasource.getPassword());
		request.get(DataSourceProperty.POOL_NAME.getValue()).set(datasource.getPoolName());
	}

	private ModelNode executeOperationRequest(ModelNode request) throws UnknownHostException, IOException {
		ModelControllerClient client = ModelControllerClient.Factory.create(InetAddress.getByName("127.0.0.1"), 9990);
		return client.execute(new OperationBuilder(request).build());
	}

}
