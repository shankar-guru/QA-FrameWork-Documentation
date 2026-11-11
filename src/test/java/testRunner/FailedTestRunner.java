package testRunner;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "@target/failed_scenarios.txt",
	    glue = { "stepDefinition","hooks"},
	    plugin = {
	        "pretty",
	        "html:target/rerun-report.html",
	        "io.qameta.allure.cucumber8jvm.AllureCucumber8Jvm"
	    }
	)
public class FailedTestRunner extends AbstractTestNGCucumberTests{

	  @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios(ITestContext context) {
	        return super.scenarios(context);
	    }
}
