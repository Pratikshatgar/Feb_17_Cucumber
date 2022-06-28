package org.applicationHooks;

import java.util.Properties;

import org.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {

	private WebDriver driver;
	public static Properties prop;   //here we have

	@Before         // just opening the browser
	public void launchBrowser() {
		ConfigReader cr = new ConfigReader();
		prop = cr.init_Prop();  // here initialized the 'Properties' class
		//'init_prop'method will return object'prop' which is stored here 
		// further can use as-> (AppHooks.prop.getProperty("userName")

		DriverFactory df = new DriverFactory();
		driver = df.initDriver(prop.getProperty("BrowserName")); // initialized the driver
	}

	@After(order =2)
	public void takeScreenshot(Scenario scn) {
		if(scn.isFailed()) {
			String  screenshotName= scn.getName().replaceAll(" ", "");
			byte[] srcPath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scn.attach(srcPath, "image/png", screenshotName);
		}	


	}
	@After(order =1)
	public void tearDown() {

		driver.close();
	}
}
