package br.org.studio.tool.mongodb.database;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MongoClientFactory.class, MongoConnector.class })
public class MongoClientFactoryTest {

	@Mock
	public MongoConnector connector;
	@Mock
	public MongoClientURI clientUri;
	@Mock
	private MongoClient mongoClient;

	@Before
	public void setup() throws Exception {
		mockStatic(MongoConnector.class);
		when(MongoConnector.localhostConnector()).thenReturn(connector);

		whenNew(MongoClientURI.class).withArguments(connector.getUri()).thenReturn(clientUri);
		whenNew(MongoClient.class).withArguments(clientUri).thenReturn(mongoClient);
	}

	@Test
	public void createClient_method_should_return_an_instance_of_MongoClient() {
		mongoClient = MongoClientFactory.createClient();

		verify(connector, times(2)).getUri();
	}

}
