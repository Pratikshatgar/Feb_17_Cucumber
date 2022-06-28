package org.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUtilityOld {
	   WebDriver obj;
	   ChromeDriver objch ;  // Null    (just declared here, not initialized)
		FirefoxDriver objff ;// Null
		EdgeDriver objed ;   // Null
		
		
	public void Startup(String url,String bName) {
  	  
		if(bName.equalsIgnoreCase("ch")|| bName.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	//		ChromeDriver objch = new ChromeDriver();    // opens ChromeBrowser
	//		objch.get(url);
	//	  objch = new ChromeDriver();      //Initialized the object
		  obj = new ChromeDriver();       // Upcasting
		  
		}else if( bName.equalsIgnoreCase("ff")||  bName.equalsIgnoreCase("firefox")) {  
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
	//		FirefoxDriver objff = new FirefoxDriver();    // opens FirefoxBrowser
	//		objff.get(url);
	//		objff = new FirefoxDriver();     //Initialized the object
			obj = new FirefoxDriver();    // Upcasting
			
		}else if( bName.equalsIgnoreCase("edge")) {    
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
	//		EdgeDriver objed = new EdgeDriver();        // opens EdgeBrowser
	//		objed.get(url);
	//		objed = new EdgeDriver();   //Initialized the object
			obj = new EdgeDriver();    // Upcasting
			
		}else {
			System.out.println("Incorrect browser Name");
		}    
		     obj.get(url);
      }

}
