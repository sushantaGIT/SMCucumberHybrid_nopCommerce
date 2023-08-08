package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features="src\\test\\resources\\features\\SearchCustomer.feature",
		features="src\\test\\resources\\features\\AddCustomer.feature",
		//features="src\\test\\resources\\features\\Login.feature",
		glue= {"stepdefinitions","hooks"},
		dryRun=false,
		monochrome=true,
		publish=true,
		//tags= {"@sanity, @regression"} //Both sanity and regression scenarios will execute 
		//tags={"@sanity"}
		plugin= {"pretty","html:target/CucumberReports/CucumberReport.html"}
		
		)
public class TestRunner {
	
	
}
