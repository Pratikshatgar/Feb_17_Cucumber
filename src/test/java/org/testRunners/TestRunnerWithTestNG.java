package org.testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ="src/test/resources/org/feature",
		glue = {"org/stepDefination","org/applicationHooks"},
		monochrome = true,
		dryRun = false,
		plugin = {
				"pretty",
				"html:reports/testNG/html_report/cucumber_report.html",
				"json:reports/testNG/json_report/json_report.json",
				"junit:reports/testNG/junit_report/junit_report.xml",
			//	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter"
		}
		
		
		)
public class TestRunnerWithTestNG extends AbstractTestNGCucumberTests{

}
