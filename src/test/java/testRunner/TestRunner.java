package testRunner;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

	    features = "src/test/resources/features",

	    glue = {
	        "stepDefintion",
	        "hooks"
	    },

	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/cucumber.html",
	        "json:target/cucumber-reports/cucumber.json",
	        "rerun:target/failed-scenarios.txt",
	        "io.qameta.allure.cucumber8jvm.AllureCucumber8Jvm"
	    },

	 
	    dryRun = false
	)

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios(ITestContext context){
		return super.scenarios(context);
	}
}
