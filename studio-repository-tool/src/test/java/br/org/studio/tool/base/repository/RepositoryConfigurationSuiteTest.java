package br.org.studio.tool.base.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.org.studio.tool.mongodb.repository.MongoRepositoryConfigurationTest;

@RunWith(Suite.class)
@SuiteClasses({ MongoRepositoryConfigurationTest.class })
public class RepositoryConfigurationSuiteTest {

}
