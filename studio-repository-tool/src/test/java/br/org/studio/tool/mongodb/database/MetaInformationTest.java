package br.org.studio.tool.mongodb.database;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class MetaInformationTest {
	
	@Test
	public void the_MetaInformation_should_has_the_collection_property() {
		assertThat(MetaInformation.COLLECTION.getValue(), equalTo("database_info"));
	}
	
	@Test
	public void the_MetaInformation_should_has_the_host_property() {
		assertThat(MetaInformation.HOST.getValue(), equalTo("host"));
	}
	
	@Test
	public void the_MetaInformation_should_has_the_port_property() {
		assertThat(MetaInformation.PORT.getValue(), equalTo("port"));
	}
	
	@Test
	public void the_MetaInformation_should_has_the_database_name_property() {
		assertThat(MetaInformation.DBNAME.getValue(), equalTo("name"));
	}
	
	@Test
    public void the_MetaInformation_should_has_the_repository_name_property() {
        assertThat(MetaInformation.REPOSITORY.getValue(), equalTo("repository_name"));
    }
	
	@Test
    public void the_MetaInformation_should_has_the_repository_description_property() {
        assertThat(MetaInformation.DESCRIPTION.getValue(), equalTo("repository_description"));
    }

}
