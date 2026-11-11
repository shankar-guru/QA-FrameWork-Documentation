package testRunner;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/failed-scenarios.txt",
	    glue = {"stepDefinition", "hooks"},
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/mobile-failed-report.html",
	        "io.qameta.allure.cucumber8jvm.AllureCucumber8Jvm"
		})
		
		

public class FailedTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios(ITestContext context){
		return super.scenarios(context); 
}}
