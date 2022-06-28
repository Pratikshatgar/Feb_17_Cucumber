package org.testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/org/feature",
		glue = {"org/stepDefination","org/applicationHooks"},
		monochrome = true,
		dryRun = false,
		tags ="@Smoke or @Regression",
		plugin = {
				"pretty",
				"html:reports/junit/html_report/cucumber_report.html",
				"json:reports/junit/json_report/json_report.json",
				"junit:reports/junit/junit_report/junit_report.xml", 
				 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" //for extent report
		}
		
		
		)
public class TestRunnerWith_Junit {

}
