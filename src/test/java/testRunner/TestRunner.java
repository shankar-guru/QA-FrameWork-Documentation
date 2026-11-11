package testRunner;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
glue= { "stepDefinition","hooks" },
plugin = {"pretty" ,
		"html:target/cucumber-report.html",
		"json:target/cucumber.json",
		"rerun:target/failed_scenarios.txt",
		"io.qameta.allure.cucumber8jvm.AllureCucumber8Jvm"} ,
dryRun = false )

public class TestRunner extends AbstractTestNGCucumberTests{
	   @Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios(ITestContext context) {
	        return super.scenarios(context);
	    }
}
