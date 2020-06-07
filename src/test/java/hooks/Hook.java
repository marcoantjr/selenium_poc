package hooks;

import core.DataLakeClient;
import core.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	
	@Before
	public void setUp(Scenario scenario) {
		DataLakeClient.getData();
	}
	
	
	@After
	public void tearDown(Scenario scenario){
		DriverManager.destroy();
	}
	
}
