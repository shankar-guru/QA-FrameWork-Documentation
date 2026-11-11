package com.TestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.BaseClass.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
glue = {"com.StepDefinition","com.Hooks"},
dryRun = false,
plugin = {"pretty","summary","html:target/cucumber-reports/cucumber.html",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class TestRunner {
	@BeforeClass
	public static void launch() {
		BaseClass.browserLaunch();
	}
	
	@AfterClass
	public static void close() {
		BaseClass.closeBrowser();
	}
}
