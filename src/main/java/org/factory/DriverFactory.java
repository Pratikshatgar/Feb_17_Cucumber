package org.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver> ();
	
	// this will initialize the driver and open browser 
	public WebDriver initDriver(String bName) {
		
		if(bName.equalsIgnoreCase("ch")|| bName.equalsIgnoreCase("chrome")) {
		  //System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			tlDriver.set( new ChromeDriver());       // Upcasting

		}else if( bName.equalsIgnoreCase("ff")||  bName.equalsIgnoreCase("firefox")) {  
			//System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set( new FirefoxDriver());    // Upcasting

		}else if( bName.equalsIgnoreCase("edge")) {    
		 //	System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			tlDriver.set( new EdgeDriver());    // Upcasting
			
		}else {
			System.out.println("Incorrect browser Name");
		}    
		
		getDriver().manage().window().maximize();    // to maximize the window
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		

		return getDriver();
	}
	
	// this method will return synchronized driver
	public static synchronized WebDriver getDriver() {
		
		return tlDriver.get();
	}
}
