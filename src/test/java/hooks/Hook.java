package hooks;

import core.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hook {
	
	@After
	public void tearDown(Scenario scenario){
		DriverFactory.destroy();
	}
	
}
