package org.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtility {

	private WebDriver driver;    // (just declared here, not initialized)

	public WebDriver Startup(String url,String bName) {

		if(bName.equalsIgnoreCase("ch")|| bName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver= new ChromeDriver();       // Upcasting

		}else if( bName.equalsIgnoreCase("ff")||  bName.equalsIgnoreCase("firefox")) {  
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();    // Upcasting

		}else if( bName.equalsIgnoreCase("edge")) {    
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();    // Upcasting
			
		}else {
			System.out.println("Incorrect browser Name");
		}    
		driver.manage().window().maximize();    // to maximize the window
		//	driver.manage().window().minimize();    //present in selenium 4 onwadrs
		//	driver.manage().window().setSize(new Dimension(250,350));

		//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //upto selenium 3
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(url);

		return driver;
	}

	public void WaitForVisibilityOfElementLocated(WebDriver driver,int time, String type, String Locator) {

		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));

		switch(type) {
		case "id":	wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locator)));
		break;
		case "xpath":	wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator)));
		break;
		case "css":	wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Locator)));
		break;
		case "name":	wt.until(ExpectedConditions.visibilityOfElementLocated(By.name(Locator)));
		break;
		case "className":	wt.until(ExpectedConditions.visibilityOfElementLocated(By.className(Locator)));
		break;
		case "tagName":	wt.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(Locator)));
		break;
		case "linkText":	wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(Locator)));
		break;
		case "partialLinkText":	wt.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(Locator)));
		break;
		}
	}
	public void WaitForInvisibilityByLocator(WebDriver driver ,int time ,String type, String Locator) {

		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));

		switch(type) {
		case "id":	wt.until(ExpectedConditions.invisibilityOfElementLocated(By.id(Locator)));
		break;
		case "xpath": wt.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Locator)));
		break;
		case "css":	wt.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Locator)));
		break;
		case "name": wt.until(ExpectedConditions.invisibilityOfElementLocated(By.name(Locator)));
		break;
		case "className": wt.until(ExpectedConditions.invisibilityOfElementLocated(By.className(Locator)));
		break;
		case "tagName":	wt.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(Locator)));
		break;
		case "linkText": wt.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(Locator)));
		break;
		case "partialLinkText":	wt.until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText(Locator)));
		break;
		}
	}
	//wait untill Element to be Clickable (BY WebElement)
	// first u have to find webElement here & then only u can use this.
	// sometimes Error/Exception occurs when java unable to find element.then u cant use this method  
	public void ElementToBeClickableByWebElement (WebDriver driver,int time,WebElement element) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Element to be Clickable (By Locator)
	// here no need to find element, just locate element in DOM & use it before finding element  
	public void WaitForElementToBeClickableByLOcator(WebDriver driver ,int time ,String type, String Locator) {

		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));

		switch(type) {
		case "id":	wt.until(ExpectedConditions.elementToBeClickable(By.id(Locator)));
		break;
		case "xpath":	wt.until(ExpectedConditions.elementToBeClickable(By.xpath(Locator)));
		break;
		case "css":	wt.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Locator)));
		break;
		case "name":	wt.until(ExpectedConditions.elementToBeClickable(By.name(Locator)));
		break;
		case "className":	wt.until(ExpectedConditions.elementToBeClickable(By.className(Locator)));
		break;
		case "tagName":	wt.until(ExpectedConditions.elementToBeClickable(By.tagName(Locator)));
		break;
		case "linkText":	wt.until(ExpectedConditions.elementToBeClickable(By.linkText(Locator)));
		break;
		case "partialLinkText":	wt.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(Locator)));
		break;
		}
	}
	// find Element and enter/ add data inside that
	public void SendDatatoElement(String type ,String Locator,String data) {
		switch(type) {

		case "id":	driver.findElement(By.id(Locator)).sendKeys(data);
		break;
		case "className":	driver.findElement(By.className(Locator)).sendKeys(data);
		break;
		case "cssSelector":	driver.findElement(By.cssSelector(Locator)).sendKeys(data);
		break;
		case "linkText":driver.findElement(By.linkText(Locator)).sendKeys(data);
		break;
		case "name":driver.findElement(By.name(Locator)).sendKeys(data);
		break;
		case "partialLinkText":driver.findElement(By.partialLinkText(Locator)).sendKeys(data);
		break;
		case "xpath":	driver.findElement(By.xpath(Locator)).sendKeys(data);
		break;
		case "tagName":	driver.findElement(By.tagName(Locator)).sendKeys(data);
		break;
		}
	}
	// find Element and Click on it
	public void clickElement(String type ,String Locator) {
		switch(type) {

		case "id":	driver.findElement(By.id(Locator)).click();;
		break;
		case "className":	driver.findElement(By.className(Locator)).click();
		break;
		case "cssSelector":	driver.findElement(By.cssSelector(Locator)).click();
		break;
		case "linkText":driver.findElement(By.linkText(Locator)).click();
		break;
		case "name":driver.findElement(By.name(Locator)).click();
		break;
		case "partialLinkText":driver.findElement(By.partialLinkText(Locator)).click();
		break;
		case "xpath":	driver.findElement(By.xpath(Locator)).click();
		break;
		case "tagName":	driver.findElement(By.tagName(Locator)).click();
		break;
		}
	}
	// click on particular WebElement(Button/Image) By JavaScript
	public void ClickByJS(WebDriver driver,WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
	// click on particular WebElement(Button/Image) By Actions Class
	public void ClickByAC(WebDriver driver,WebElement ele) {
		Actions actions = new Actions(driver);
		actions.click(ele).perform();
	}
	// Scroll down upto the Webelement u have mentioned
	public void ScrollByJS(WebDriver driver,WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	//ScrollDown the Number of times u have mentioned
	public void ScrollByPageDown (WebDriver driver,int num) {
		for(int i=1 ;i<=num ;i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		}
	}
	// to print group of text / string of text from the DropDown list,created by'Select'tag 
	public ArrayList<String> getAllTextFromDDL (WebElement ele) {
		ArrayList <String> ar = new ArrayList <String> ();
		Select sel = new Select(ele);
		List <WebElement> allEle = sel.getOptions();
		for(int i =0; i<allEle.size() ; i++ ) {
			ar.add(allEle.get(i).getText());
		}
		return ar;
	}
	// returns List of WebElement only(will not print text )
	public List<WebElement> getAllOptionsFromDDL (WebElement ele) {
		Select sel = new Select(ele);
		return sel.getOptions();
	}

	// to get/print the count/size of dropdown list
	public int getNumberOfOptionsFromDDL (WebElement ele) {
		Select sel = new Select(ele);
		return sel.getOptions().size();
	}

	//** to Select All the Options from Multi-select DropDown
	public void SelectAllOptinsFromDDL (WebElement ele) {
		Select sel = new Select(ele);
		for(int i =0; i<sel.getOptions().size() ; i++ ) {
			sel.selectByIndex(i);
		}
	}

	// to get the text of selected option from single selected dropdown
	public void getFirstSelectedOptionText (WebElement ele) {
		Select sel = new Select(ele);
		String selectedOptn =	sel.getFirstSelectedOption().getText();
		System.out.println("Selected option ="+selectedOptn);
	}

	// to get WebElement /selected option from single selected dropdown
	public void getFirstSelectedOptionElement(WebElement ele) {
		Select sel = new Select(ele);
		WebElement selectedOptn = sel.getFirstSelectedOption();
		System.out.println("Selected element =" + selectedOptn);
	}

	// get String which contains text of all selected options from multi selected dropdown
	public ArrayList<String> getAllSelectedOptionText (WebElement ele) {
		ArrayList<String> ar = new ArrayList<String>();
		Select sel = new Select(ele);
		List<WebElement>selectedoptn=sel.getAllSelectedOptions();
		for (int i = 0; i < selectedoptn.size(); i++) { 
			ar.add(selectedoptn.get(i).getText());
		}
		return ar;
	}		

	// get size of all selected options  from multi selected dropdown
	public int getAllSelectedOptionSize (WebElement ele) {
		Select sel = new Select(ele);
		return 	sel.getAllSelectedOptions().size();
	}		

	// returns List of selected WebElements only(will not print text ) from multi selected dropdown
	public List<WebElement> getAllSelectedOptionsWebElement (WebElement ele) {
		Select sel = new Select(ele);
		return sel.getAllSelectedOptions();
	}

	// select value from DropDown which is created by using 'select' tag
	public void selectDropDownValue(WebElement ele, String type, String value) {
		Select sel = new Select(ele);
		switch(type) {
		case "index" : sel.selectByIndex(Integer.parseInt(value));
		break;
		case "value" : sel.selectByValue(value);
		break;
		case "visibletext" : sel.selectByVisibleText(value);
		break;

		}
	}
	// switch to child window for single window handle
	public void switchToChildWind (WebDriver driver) {
		String parentId = driver.getWindowHandle();
		Set<String> allWinIds = driver.getWindowHandles();
		Iterator<String> itr =	allWinIds.iterator();
		String  id1 = itr.next();
		if(id1.equals(parentId)) {
			id1= itr.next();
		}
		driver.switchTo().window(id1);
	}
	// after clicking on element/button,we will execute/call this method to check whether alert is present or not
	//this method will return boolean.
	//if there is alert then it will return true and will wait else if will give Exception
	public boolean isAlertPresent(WebDriver driver,int time) {
		try {
			WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
			wt.until(ExpectedConditions.alertIsPresent());
			return true;
		}catch(Exception e) {
			return false;	
		}
	}
        //	if(bu.isAlertPresent(driver, 20)== true) {
		//    driver.switchTo().alert().accept();}
	          


	//Drag and Drop by Actions class
	public void DragAndDropByActions (WebDriver driver,WebElement src,WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}

	//Drag and Drop by Actions class,when destination element is not present
	public void DragAndDropByCoordinates (WebDriver driver,WebElement src,WebElement dest,int x,int y) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(src,x,y).perform();
	}
	// click and hold and release by Actions class
	public void ClickAndHoldByActions (WebDriver driver,WebElement src,WebElement dest) {
		Actions act = new Actions(driver);
		act.moveToElement(src).clickAndHold(src).moveToElement(dest).release().perform();

	}

	// Double click on specified element by Actions class
	public void DoubleClickByActions (WebDriver driver,WebElement Dbtn) {
		Actions act = new Actions(driver);
		act.doubleClick(Dbtn).perform();
	}
	// Right click on specified element by Actions class
	public void RightClickByActions (WebDriver driver,WebElement Rbtn) {
		Actions act = new Actions(driver);
		act.contextClick(Rbtn).perform();
	}
	//  click on specified element by Actions class
	public void ClickByActions (WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.click(ele).perform();
	}
	//  Move To specified element by Actions class
	public void MoveToElementByActions (WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	//  SendKeys To specified element by Actions class
	public void SendKeysByActions (WebDriver driver,WebElement ele,String Text) {
		Actions act = new Actions(driver);
		act.sendKeys(ele, Text).perform();
	}

	// the test data is stored in Config.Properties file in the form of key value pair
	//ConfigReader, by calling this method we will pass the key(which is present in .properties file) as parameter. we will get the value of that key
	public String getTestData(String key, String ConfigPropertiesPath) {

		try {
			FileInputStream fis = new FileInputStream(ConfigPropertiesPath);
			Properties prop = new Properties();
			prop.load(fis);

			return prop.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public int getTotalSheets (String Excelfilepath) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getNumberOfSheets();
	}

	public void PrintAllSheetName (String Excelfilepath) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		int	totalsheets=wb.getNumberOfSheets();
		for(int i =0; i<totalsheets ; i++) {
			System.out.println(wb.getSheetName(i));
		}
	}

	public void PrintAllCellData(String Excelfilepath,String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet(SheetName);
		int lastRownum = s1.getLastRowNum();
		Row r =null;
		Cell c =null;
		for (int i =0; i<=lastRownum; i++) {
			r =s1.getRow(i);
			for(int k =0; k<r.getLastCellNum();k++) {
				c= r.getCell(k);
				CellType ct =c.getCellType();

				switch(ct) {
				case STRING :System.out.println(c.getStringCellValue());
				break;
				case NUMERIC :
					if(DateUtil.isCellDateFormatted(c)) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						System.out.println(  sdf.format(c.getDateCellValue()));
					}else {
						System.out.println((long)c.getNumericCellValue());
					}
					break;
				case BOOLEAN :System.out.println(c.getBooleanCellValue());
				break;
				case FORMULA :System.out.println(c.getCellFormula());
				break;
				case BLANK : System.out.println("Cell is blank");
				break;
				}

			}
			System.out.println(" ");
		}

	}
	public int retunlastRowNum(String ExcelFilePath,String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 =	wb.getSheet(SheetName);
		return	s1.getLastRowNum();
	}
	//
	// int lastRoWNum = bu.retunlastRowNum(String ExcelFilePath,String SheetName);

	public int retunlastCellNum(String ExcelFilePath,String SheetName,int RowNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s =	wb.getSheet(SheetName);
		Row r =	s.getRow(RowNum);
		return r.getLastCellNum();
	}
	// int lastCellNum = retunlastCellNum(String ExcelFilePath,String SheetName,int RowNum)

	// it will print particular cell data
	public void PrintParticularCellData(String Excelfilepath,String SheetName,int RowNum, int CellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet(SheetName);
		Row r = s1.getRow(RowNum);
		Cell c = r.getCell(CellNum);
		CellType ct =c.getCellType();

		switch(ct) {
		case STRING :System.out.println(c.getStringCellValue());
		break;
		case NUMERIC :
			if(DateUtil.isCellDateFormatted(c)) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				System.out.println(  sdf.format(c.getDateCellValue()));
			}else {
				System.out.println((long)c.getNumericCellValue());
			}
			break;
		case BOOLEAN :System.out.println(c.getBooleanCellValue());
		break;
		case FORMULA :System.out.println(c.getCellFormula());
		break;
		case BLANK : System.out.println("Cell is blank");
		break;
		}

	}
	//to print cell data / value:-

	//BaseUtility bu = new BaseUtility()
	//	bu.PrintParticularCellData(ExcelFilePath, sheetName,RowNum, cellNum);


	// it will return particular cell value as a Object , we have to capture that cell value in object & print it
	public Object getObjectOfParticularCell(String Excelfilepath,String SheetName,int RowNum,int CellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet(SheetName);
		Row r = s1.getRow(RowNum);

		Cell c= r.getCell(CellNum);
		CellType ct =c.getCellType();

		switch(ct) {
		case STRING :return(c.getStringCellValue());

		case NUMERIC :
			if(DateUtil.isCellDateFormatted(c)) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				return (  sdf.format(c.getDateCellValue()));
			}else {
				return ((long)c.getNumericCellValue());
			}

		case BOOLEAN :return(c.getBooleanCellValue());

		case FORMULA :return(c.getCellFormula());

		case BLANK : return("Cell is blank");



		}
		return null ; 
	}
	//to print cell data / value:-

	//BaseUtility bu = new BaseUtility()
	//  Object obj = bu.getObjectOfParticularCell(ExcelFilePath, sheetName, RowNum, cellNum);
	//  System.out.println(obj);

	public void PrintAllCellType(String Excelfilepath,String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet(SheetName);
		int lastRownum = s1.getLastRowNum();
		Row r =null;
		Cell c =null;
		for (int i =0; i<=lastRownum; i++) {
			r =s1.getRow(i);
			for(int k =0; k<r.getLastCellNum();k++) {
				c= r.getCell(k);
				System.out.println(c.getCellType());
			}
			System.out.println(" ");
		}
	}

	public void WriteDataInAllCell(String Excelfilepath,String SheetName, int CellNum, String CellData) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);	
		Sheet s1 = wb.getSheet(SheetName);
		int lastRowNum = s1.getLastRowNum();
		for(int i =1; i<=lastRowNum ; i++) {
			Row r =s1.getRow(i);
			Cell c4 =	r.createCell(CellNum);
			c4.setCellValue(CellData);

			FileOutputStream fos = new FileOutputStream(Excelfilepath);
			wb.write(fos);
			fos.close();
		}
	}
	public void WriteInParticularCell(String Excelfilepath,String SheetName,int RowNum, int CellNum, String CellData) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);	
		Sheet s1 = wb.getSheet(SheetName);
		Row r =	s1.getRow(RowNum);
		Cell c4 =	r.createCell(CellNum);
		c4.setCellValue(CellData);

		FileOutputStream fos = new FileOutputStream(Excelfilepath);
		wb.write(fos);
		fos.close();
	}
	public void PrintParticularRowData(String Excelfilepath,String SheetName,int RowNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet(SheetName);

		Row r =null;
		Cell c =null;
		r =s1.getRow(RowNum);

		for(int i =0; i<r.getLastCellNum();i++) {
			c= r.getCell(i);
			CellType ct =c.getCellType();

			switch(ct) {
			case STRING :System.out.println(c.getStringCellValue());
			break;
			case NUMERIC :
				if(DateUtil.isCellDateFormatted(c)) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					System.out.println(  sdf.format(c.getDateCellValue()));
				}else {
					System.out.println((long)c.getNumericCellValue());
				}
				break;
			case BOOLEAN :System.out.println(c.getBooleanCellValue());
			break;
			case FORMULA :System.out.println(c.getCellFormula());
			break;
			case BLANK : System.out.println("Cell is blank");
			break;
			}
		}
		System.out.println(" ");
		//return null;
	}

	public Object returnDataOFAnyCellWrtToTableHeading(String requiredkey ,String ExcelFilePath,String sheetName,int RowNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1= wb.getSheet(sheetName);
		Row R0=s1.getRow(0);
		HashMap <String ,Object> h1 = new HashMap <String ,Object>();
		for(int i=0; i<R0.getLastCellNum();i++) {
			String key = R0.getCell(i).getStringCellValue();
			Object value =  getObjectOfParticularCell(ExcelFilePath, sheetName, RowNum,i);
			h1.put(key, value);
		}
		//	System.out.println(h1);
		return h1.get(requiredkey);
	}
	//this method will return data of any cell wrt to heading(1st row).store it in string &use it
	// String fName =(String) bu.returnDataOFAnyCellWrtToTableHeading("First Name", ExcelFilePath, sheetName, i);


	// this method will get the data from Specified ExcelSheeet and will store in 2-D Array
	
	public Object[][] getDataOfDataProvider(String ExcelFilePath,String sheetName) throws EncryptedDocumentException, IOException{
		//BaseUtility bu = new BaseUtility();
		int lastRowNum = /*bu.*/retunlastRowNum(ExcelFilePath, sheetName);
		int lastCellNum =  /*bu.*/ retunlastCellNum(ExcelFilePath, sheetName, 0);

		Object[][] ar = new Object[lastRowNum][lastCellNum];
		// i & j for getting data from excel sheet
		for(int i =1,k=0; i<=lastRowNum; i++,k++) {
			for(int j =0,l=0; j<lastCellNum; j++,l++) {
				// k & l for storing data in array	
				ar[k][l]= /*bu.*/getObjectOfParticularCell(ExcelFilePath, sheetName, i, j);
				
				//	System.out.println(ar[k][l]);
			}
		}

		return ar;
	}
	//BaseUtility bu = new BaseUtility();
	//Object[][] ar=bu.getDataOfDataProvider(ExcelFilePath, sheetName);
	//System.out.println(ar[0][0]);

}
