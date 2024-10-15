package crmp.org.pages;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.cucumber.java.Scenario;


public class task {
	
	private WebDriver driver ;
	
	
	//Login page Locator
	private By Login = By.xpath("//a[text()='Login']");
	private String passwordXpath = "//input[@id='ngPdwIO']";
	private By Login_Button = By.xpath("//input[@id='btnLogin-2']");
	
private String usernameXpath = "//input[@id='ngIOEid']";
private String loginScreen = "//input[@id='searchByProject-md']";
private String client = "//span[text()='Client']";
private String clientButton = "//button[contains(@onclick, 'funCreateClient()')]";
private String clientNameXpath = "//input[@id='clientName']";
private String clientNotesXpath = "//input[@id='clientNotes']";
private String physicalAddress1Xpath = "//input[@id='physicalAddress1']";
private String physicalAddress2Xpath = "//input[@id='physicalAddress2']";
private String physicalStateXpath = "//input[@id='physicalState']";
private String physicalCityXpath = "//input[@id='physicalCity']";
private String physicalZipXpath = "//input[@id='physicalZip']";
private String countryXpathXpath = "//select[@id='physicalCountry']/option[@value='6']";
private String billingAddress1Xpath = "//input[@id='billingAddress1']";
private String billingAddress2Xpath = "//input[@id='billingAddress2']";
private String billingCountryXpath = "//select[@id='billingCountry']/option[@value='6']";
private String billingStateXpath = "//input[@id='billingState']";
private String billingCityXpath = "//input[@id='billingCity']";
private String billingZipXpath = "//input[@id='billingZip']";
private String TitleXpath = "//select[@id='title']/option[@value='Ms.']";
private String firstNameXpath = "//input[@id='firstName']";
private String lastNameXpath = "//input[@id='lastName']";
private String phoneXpath = "//input[@id='phone']";
private String emailXpath = "//input[@id='emailId']";
private String mobileXpath = "//input[@id='mobile']";
private String SaveXpath = "//button[@id='btnSave-lg']";
private String SaveAndCreateXpath = "//button[@id='btnSaveCreateNew-lg']";
private String clearXpath ="//button[@id='btnClear-lg']";
private String CancelXpath ="//button[@id='btnCancel-lg']";
private String ClientList = "//td[@class='align-middle white-space-nowrap deadline ps-3 name sorting_1']//a[contains(text(),'CLIENT')]";
private String searchXpath ="//input[@type='search']";
private String status = "//input[contains(@id, 'clientIsActive')]";
private String YesButton = "//button[@id='btnStatusConfirmation-lg']";
private String confirmationPane = "//span[@id='crpToastCustomSuccessMsg' and text()='Status changed successfully']";
private String deleteIcon = "//a[contains(@href, 'funDelete(')]";
private String YesDeleteButton = "//button[@id='btnDeleteConfirmation-lg']";
//searchBar.sendKeys("your search text");

private String cName;
//Location xpath starts
private String location_userIcon = "//a[@id='navbarDropdownUser']";
private String location_location = "//a[contains(@class, 'nav-link') and contains(@href, 'locationcenter.do')]";
private String location_createnewlocationButton = "//button[contains(@onclick, 'funCreateLocation()')]";
private String location_locationtextBox = "//input[@id='locationName']";
private String location_codetextBox = "//input[@id='code']";
private String location_add1textBox = "//input[@id='addressOne']";
private String location_add2textBox = "//input[@id='addressTwo']";
private String location_locationCountryXpath = "//select[@id='countryId']";
private String location_locationstatetextBox = "//input[@id='state']";
private String location_locationCity = "//input[@id='city']";
private String location_countryTextBox = "//input[@id='county']";
private String location_zip = "//input[@id='zip']";
private String location_salesTax = "//input[@id='salesTax']";
private String location_overhead_burdenRate = "//input[@id='ohBurdenRate']";
private String location_saveButton = "//input[@value='Save']";
private String location_updateButton = "//input[@value='Update'][2]";
private String location_locationtList = "//td[@class='align-middle white-space-nowrap start ps-3 companyName sorting_1']//a[contains(text(),'LOCATION')]";
private String location_status = "//input[contains(@id, 'locationIsActive-1')]";
//Employee Xapth 
private String Employee_userIcon = "//a[@id='navbarDropdownUser']";
private String Employee_employeeIcon = "//a[contains(@class, 'nav-link') and contains(@href, 'employeecenter.do')]";
private String Employee_createNewEmployeeButton = "//button[contains(@onclick, 'funCreateEmployee()')]";
private String Employee_firstName = "//input[@id='firstName']";
private String Employee_lastName = "//input[@id='lastName']";
private String Employee_genderDropDown = "//select[@id='gender']";
private String Employee_userDropDown = "//select[@id='userId']";
private String Employee_locationDropDown = "//select[@id='locationId']";
private String Employee_countryDropDown = "//select[@id='countryId']";
private String Employee_address1 = "//input[@id='addressLine1']";
private String Employee_address2 = "//input[@id='addressLine2']";
private String Employee_statetTextBox = "//input[@id='state']";
private String Employee_locationCity = "//input[@id='city']";
private String Employee_countryTextBox = "//input[@id='county']";
private String Employee_zip = "//input[@id='zip']";
private String Employee_emailId = "//input[@id='emailId']";
private String Employee_phone = "//input[@id='phone']";
private String Employee_extn = "//input[@id='extn']";
private String Employee_mobile = "//input[@id='mobile']";
private String Employee_jobTitle = "//input[@id='jobTitle']";
private String Employee_userType = "//select[@id='userId']/option[@value='1']";
private String Employee_payRate = "//input[@id='payRate']";
private String Employee_billRate = "//input[@id='billRate']";
private String Employee_Save = "//button[@id='btnSave-lg']";
private String Employee_list_link = "//td[@class='align-middle white-space-nowrap deadline ps-3 name sorting_1']//a[contains(text(),'LOCATION')]";
private String Employee_updateButton = "//button[@id='btnSave-lg']";
private String Employee_status = "//input[contains(@id, 'employeeIsActive')]";
//Xpath for Expense
private String Expense_userIcon = "//a[@id='navbarDropdownUser']";
private String Expense_Icon = "//a[contains(@class, 'nav-link') and contains(@href, 'expensetypecenter.do')]";
private String Expense_createNewExpenseButton = "(//a[contains(@onclick, 'funCreateExpenseType()')])[2]";
private String Expnse_expenseType = "//input[@id='expenseType']";
private String Expense_Save = "//input[@id='btnSave-lg']";
private String Expense_list_link = "//td[@class='align-middle white-space-nowrap start ps-3 companyName sorting_1']//a[contains(text(),'LOCATION')]";
private String Expense_status = "//input[contains(@id, 'expenseTypeIsActive')]";
private String Expense_updateButton = "//input[@id='btnSave-lg']";
//Xapth for Task 
private String Task_userIcon = "//a[@id='navbarDropdownUser']";
private String Task_Icon = "//a[contains(@class, 'nav-link') and contains(@href, 'taskcenter.do')]";
private String Task_newTaskCreateButton = "//button[contains(@onclick, 'funCreateTask()')][1]";
private String Task_taskCode = "//input[@id='taskCode']";
private String Task_taskDescription = "//input[@id='task']";
private String Task_Save = "//button[@id='btnSave-lg']";
private String Task_Status ="//input[contains(@id, 'taskIsActive')]";
private String Task_updateButton = "//button[@id='btnSave-sm']";

//private String Task_list_link = "//td[@class='align-middle white-space-nowrap deadline ps-3 sorting_1']//a[contains(text(),'LOCATION')]";
private String Task_list_link = "//span[contains(@onclick, \\\"funEditTask\\\")]";
//Xpath for Staff
private String Staff_userIcon = "//a[@id='navbarDropdownUser']";
private String Staff_Icon = "//a[contains(@class, 'nav-link') and contains(@href, 'stafftypecenter.do')]";
private String Staff_createStaff = "//button[contains(@onclick, 'funCreateStaffType()')]";
private String Staff_staffTypeCode = "//input[@id='staffTypeCode']";
private String Staff_staffTypeDescription = "//input[@id='staffType']";
private String Staff_staffTypeBillRate = "//input[@id='standardBillRate']";
private String Staff_list_link = "//td[@class='align-middle white-space-nowrap deadline ps-3 sorting_1']//a[contains(text(),'LOCATION')]";

private String Staff_Save = "//button[@id='btnSave-lg']";
private String Staff_updateButton = "//button[@id='btnSave-sm']";
private String Staff_Status = "//input[contains(@id, 'staffTypeIsActive')]";

	//COnsturctor
	public task(WebDriver driver)
	{
		this.driver = driver;
		
	}
	// Method to enter username and password
    public void enterUsernameAndPassword(String username, String password) {
        WebElement usernameField = waitForElementToBeVisible(By.xpath(usernameXpath));
        WebElement passwordField = waitForElementToBeVisible(By.xpath(passwordXpath));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        captureScreenshot("captured");
    }


    public void selectCleint(Map<String, String> map) throws InterruptedException {
    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
    	//clienticon.click();
    	waitForElementAndClickUsingJS(By.xpath(client));
    	//Thread.sleep(5000);
    	waitForElementAndClickUsingJS(By.xpath(clientButton));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(clientNameXpath),map.get("clientName"));
    	cName = map.get("clientName");
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalAddress2Xpath),map.get("physicalAddress2"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalAddress1Xpath),map.get("physicalAddress1"));
    	WebElement countryDropdown = driver.findElement(By.id("physicalCountry"));
    	Select selectCountry = new Select(countryDropdown);
    	selectCountry.selectByValue("6");
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalStateXpath),map.get("physicalState"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalCityXpath), map.get("physicalCity"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalZipXpath), map.get("physicalZip"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingAddress1Xpath), map.get("billingAddress1"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingAddress2Xpath), map.get("billingAddress2"));
    	WebElement billingCountryDropdown = driver.findElement(By.id("billingCountry"));
    	Select selectBillingCountry = new Select(billingCountryDropdown);
    	selectBillingCountry.selectByValue("6");
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingStateXpath), map.get("billingState"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingCityXpath),  map.get("billingCity"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingZipXpath), map.get("billingZip"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(firstNameXpath), map.get("firstName"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(lastNameXpath), map.get("lastName"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(phoneXpath), map.get("phone"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(emailXpath), map.get("email"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(mobileXpath), map.get("mobile"));
    	waitForElementAndClickUsingJS(By.xpath(SaveXpath));
    	//Thread.sleep(60000);
    	 captureScreenshot("captured");
    	
    	
    	
    	
    }
    public void updateClientData(Map<String, String> map) throws InterruptedException {
    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
    	//clienticon.click();
    	//waitForElementAndClickUsingJS(By.xpath(client));
    	//Thread.sleep(5000);
    	//waitForElementAndClickUsingJS(By.xpath(clientButton));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(clientNameXpath),map.get("clientName"));
    	cName = map.get("clientName");
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalAddress2Xpath),map.get("physicalAddress2"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalAddress1Xpath),map.get("physicalAddress1"));
    	WebElement countryDropdown = driver.findElement(By.id("physicalCountry"));
    	Select selectCountry = new Select(countryDropdown);
    	selectCountry.selectByValue("6");
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalStateXpath),map.get("physicalState"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalCityXpath), map.get("physicalCity"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalZipXpath), map.get("physicalZip"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingAddress1Xpath), map.get("billingAddress1"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingAddress2Xpath), map.get("billingAddress2"));
    	WebElement billingCountryDropdown = driver.findElement(By.id("billingCountry"));
    	Select selectBillingCountry = new Select(billingCountryDropdown);
    	selectBillingCountry.selectByValue("6");
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingStateXpath), map.get("billingState"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingCityXpath),  map.get("billingCity"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingZipXpath), map.get("billingZip"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(firstNameXpath), map.get("firstName"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(lastNameXpath), map.get("lastName"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(phoneXpath), map.get("phone"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(emailXpath), map.get("email"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(mobileXpath), map.get("mobile"));
    	waitForElementAndClickUsingJS(By.xpath(SaveXpath));
    	Thread.sleep(6000);
    	 captureScreenshot("updated Profile");
    	
    	
    	
    	
    }
    public void selectRecordBySearch(String cname) throws InterruptedException
    {
    	String name = cname;
    	Thread.sleep(9000);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
    	String updatedClientList = ClientList.replace("CLIENT", name);
    	waitForElementToBeClickable(By.xpath(updatedClientList));
    	
    }
    public void selectClientBySearch(String cname) throws InterruptedException
    {
    	String name = cname;
    	
    	//waitForElementAndClickUsingJS(By.xpath(searchXpath));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
    	String updatedClientList = ClientList.replace("CLIENT", name);
    	waitForElementToBeClickable(By.xpath(updatedClientList));
    	waitForElementAndClickUsingJS(By.xpath(status));
    	waitForElementAndClickUsingJS(By.xpath(YesButton));
    	waitForElementAndClickUsingJS(By.xpath(confirmationPane));
    	waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
    	waitForElementAndClickUsingJS(By.xpath(deleteIcon));
    	captureScreenshot("Deleted Sucessfully");
    }
	public void click_Login()
	{
		WebElement Login_Click = driver.findElement(Login_Button);
	//	WebElement MyAccount = driver.findElement(myAccount);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
		//MyAccount.click();
		Login_Click.click();
		// WebElement successPromptElement = waitForElementToBeVisible(By.xpath(loginScreen));
		// Assert.assertTrue(successPromptElement.isDisplayed(), "Login Screen Loaded");
	        captureScreenshot("Login Screen Loaded");
		

	}
//	public void SelectLogin()
//	{
//		WebElement LoginIcon = driver.findElement(Login);
//		WebElement MyAccount = driver.findElement(myAccount);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
//		MyAccount.click();
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait1.until(ExpectedConditions.visibilityOfElementLocated(Login));
//		LoginIcon.click();
//
//	}
	// Example of using explicit wait
    public void waitForLoginPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Login_Button));
    }
    
    public void captureScreenshot(String  fileName) {
    	
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        String filePath = "screenshots/" + fileName + "_" + timestamp + ".png";
        File destinationFile = new File(filePath);
        try {
            FileUtils.copyFile(screenshot, destinationFile);
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void waitForElementToBeVisibleAndInteract(By locator, String textToSend) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        element.sendKeys(textToSend);
    }
 
 // Helper method to wait for page load, wait for element to be visible, click using JS, and send text
    private void waitForElementToBeVisibleAndInteractUsingJS(By locator, String textToSend) {
        // Wait for the page to be fully loaded
        new WebDriverWait(driver, Duration.ofSeconds(200)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")
                .equals("complete")
        );

        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Use JavaScript Executor to click the element
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);

        // Send text to the element (after clicking)
        element.clear();
        element.sendKeys(textToSend);
        element.sendKeys(Keys.TAB);
    }
    private void waitForElementToBeVisibleAndInteractUsingJSTabKey(By locator, String textToSend) throws InterruptedException {
        // Wait for the page to be fully loaded
        new WebDriverWait(driver, Duration.ofSeconds(100)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")
                .equals("complete")
        );

        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Use JavaScript Executor to click the element
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);

        // Send text to the element (after clicking)
      //  element.clear();
       // element.sendKeys(textToSend);
        element.sendKeys(Keys.TAB);
        element.sendKeys(Keys.ENTER);
       // element.wait(10000);
    }


 // Helper method to wait for an element to be clickable
    private WebElement waitForElementToBeClickable(By locator) {
        // Wait for the page to be fully loaded
        new WebDriverWait(driver, Duration.ofSeconds(100)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")
                .equals("complete")
        );
        
        // Now wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
 // Helper method to wait for an element and click using JavaScript Executor
    private void waitForElementAndClickUsingJS(By locator) {
        // Wait for the page to be fully loaded
        new WebDriverWait(driver, Duration.ofSeconds(300)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")
                .equals("complete")
        );
        
        // Wait for the element to be present in the DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        
        // Use JavaScript Executor to click the element
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    private void waitForElementToBeVisibleAndClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }

    // Helper method to wait for an element to be visible
    private WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Helper method to click an element
    private void clickElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    
    
//    public MasterPage(WebDriver driver)
//	{
//		this.driver = driver;
//		
//	}
	
	
	
	
	public void selectAddTitleButton()
	{
		waitForHomePageToLoad();
//		WebElement AddTitleBUtton = driver.findElement(adddTitleButton);
//		AddTitleBUtton.click();
	}
	public void selectAddButton()
	{
		//outs().implicitlyWait(Duration.ofSeconds(20));
	}
	
	 public void waitForHomePageToLoad() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	//        wait.until(ExpectedConditions.visibilityOfElementLocated(adddTitleButton));
	    }
		
	public void verifyTitleIsAdded(String title_value)
	{
		//String value = "conreteProduction";
		 By TitleAdded = By.xpath("//span[contains(text(),'"+title_value+"')]");
		 WebElement verficationOfTitle = driver.findElement(TitleAdded);
		 if(verficationOfTitle.isDisplayed())
		 {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 Assert.assertEquals(verficationOfTitle.getText(), title_value);
			
			 
		 }
		 else
		 {
			 System.out.print("title not added");
		 }
	}
	
	//location 
	public void selectlocation(Map<String, String> map) throws InterruptedException {
    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
    	//clienticon.click();
    	waitForElementAndClickUsingJS(By.xpath(location_userIcon));
    	waitForElementAndClickUsingJS(By.xpath(location_location));
    	//Thread.sleep(5000);
    	
    	waitForElementAndClickUsingJS(By.xpath(location_createnewlocationButton));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationtextBox),map.get("location"));
    	//cName = map.get("clientName");
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_codetextBox),map.get("code"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_add1textBox),map.get("add1"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_add2textBox),map.get("add2"));
    	WebElement countryDropdown = driver.findElement(By.xpath(location_locationCountryXpath));
    	Select selectCountry = new Select(countryDropdown);
    	selectCountry.selectByValue("6");
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationstatetextBox),map.get("state"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationCity),map.get("city"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_countryTextBox), map.get("country"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_zip), map.get("zip"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_salesTax), map.get("salestax"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_overhead_burdenRate), map.get("overheadrate"));
    	
    	//waitForElementAndClickUsingJS(By.xpath(location_saveButton));
    	//Thread.sleep(60000);
    	 captureScreenshot("Saved Loacation");
    	
    	
    	
    	
    }
	public void updateLocationData(Map<String, String> map) throws InterruptedException {
    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
    	//clienticon.click();
    	//waitForElementAndClickUsingJS(By.xpath(location_userIcon));
    	//waitForElementAndClickUsingJS(By.xpath(location_location));
    	//Thread.sleep(5000);
    	
    	//waitForElementAndClickUsingJS(By.xpath(location_createnewlocationButton));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationtextBox),map.get("location"));
    	//cName = map.get("clientName");
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_codetextBox),map.get("code"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_add1textBox),map.get("add1"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_add2textBox),map.get("add2"));
    	WebElement countryDropdown = driver.findElement(By.xpath(location_locationCountryXpath));
    	Select selectCountry = new Select(countryDropdown);
    	selectCountry.selectByValue("6");
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationstatetextBox),map.get("state"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationCity),map.get("city"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_countryTextBox), map.get("country"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_zip), map.get("zip"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_salesTax), map.get("salestax"));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_overhead_burdenRate), map.get("overheadrate"));
    	
    	waitForElementAndClickUsingJS(By.xpath(location_updateButton));
    	//Thread.sleep(60000);
    	 captureScreenshot("Updated Loacation");
    	
    	
    	
    	
    }
	public void selectLocationBySearch(String location) throws InterruptedException
    {
    	String name = location;
    	
    	//waitForElementAndClickUsingJS(By.xpath(searchXpath));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
    	String updatedClientList = location_locationtList.replace("LOCATION", name);
    	waitForElementToBeClickable(By.xpath(updatedClientList));
    	waitForElementAndClickUsingJS(By.xpath(location_status));
    	waitForElementAndClickUsingJS(By.xpath(YesButton));
    	waitForElementAndClickUsingJS(By.xpath(confirmationPane));
    	waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
    	//waitForElementAndClickUsingJS(By.xpath(deleteIcon));
    	captureScreenshot("Deleted Sucessfully");
    }
	 public void selectRecordBySearch_loc(String location)
	    {
	    	String name = location;
	    	
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
	    	String updatedClientList = location_locationtList.replace("LOCATION", name);
	    	waitForElementAndClickUsingJS(By.xpath(updatedClientList));
	    	
	    	
	    }
	 public void selectRecordBySearch_expense(String location)
	    {
	    	String name = location;
	    	
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
	    	String updatedExpenseList = Expense_list_link.replace("LOCATION", name);
	    	waitForElementAndClickUsingJS(By.xpath(updatedExpenseList));
	    	
	    	
	    	
	    }
	 public void activeToinActive_expense()
	    {
	    	
	    	waitForElementAndClickUsingJS(By.xpath(Expense_status));
	    	waitForElementAndClickUsingJS(By.xpath(YesButton));
	    	waitForElementAndClickUsingJS(By.xpath(confirmationPane));
	    	waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
	    	//waitForElementAndClickUsingJS(By.xpath(deleteIcon));
	    	captureScreenshot("Deleted Sucessfully");
	    }
	 public void activeToinActive_loc()
	    {
	    	
	    	waitForElementAndClickUsingJS(By.xpath(Employee_status));
	    	waitForElementAndClickUsingJS(By.xpath(YesButton));
	    	waitForElementAndClickUsingJS(By.xpath(confirmationPane));
	    	waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
	    	//waitForElementAndClickUsingJS(By.xpath(deleteIcon));
	    	captureScreenshot("Deleted Sucessfully");
	    }
	 public void click_Save()
		{
		 
		 waitForElementAndClickUsingJS(By.xpath(location_saveButton));
			
		        captureScreenshot("Save Button Clicked");
		}
	 
	 public void click_Update()
		{
		 
		 waitForElementAndClickUsingJS(By.xpath(location_updateButton));
			
		        captureScreenshot("Update Button Clicked");
			

		}
	//employee
	 public void selectExpense(Map<String, String> map) throws InterruptedException {
	    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
	    	//clienticon.click();
	    	waitForElementAndClickUsingJS(By.xpath(Expense_userIcon));
	    	waitForElementAndClickUsingJS(By.xpath(Expense_Icon));
	    	//Thread.sleep(5000);
	    	
	    	waitForElementAndClickUsingJS(By.xpath(Expense_createNewExpenseButton));
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Expnse_expenseType), map.get("expense"));
	    	
	    	 captureScreenshot("Saved Expense");
	    	
	    	
	    	
	    	
	    }
	 public void updateExpense(Map<String, String> map) throws InterruptedException {
		//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
	    	//clienticon.click();
	    	//waitForElementAndClickUsingJS(By.xpath(Expense_userIcon));
	    	//waitForElementAndClickUsingJS(By.xpath(Expense_Icon));
	    	//Thread.sleep(5000);
	    	
	    	//waitForElementAndClickUsingJS(By.xpath(Expense_createNewExpenseButton));
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Expnse_expenseType), map.get("expense"));
	    	
	    	 captureScreenshot("Updated Expense");
	    	
	    }
	 public void click_exp_Update()
		{
		 
		 waitForElementAndClickUsingJS(By.xpath(Expense_updateButton));
			
		        captureScreenshot("Update Button Clicked");
			

		}
	 public void click_ExpenseSave()
		{
		 
		 waitForElementAndClickUsingJS(By.xpath(Expense_Save));
			
		        captureScreenshot("Save Button Clicked");
		        
		}
	 public void selectLocationBySearch_emp(String location) throws InterruptedException
	    {
	    	String name = location;
	    	
	    	//waitForElementAndClickUsingJS(By.xpath(searchXpath));
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
	    	String updatedEmpList = Employee_list_link.replace("LOCATION", name);
	    	waitForElementToBeClickable(By.xpath(updatedEmpList));
	    	
	    	waitForElementAndClickUsingJS(By.xpath(location_status));
	    	waitForElementAndClickUsingJS(By.xpath(YesButton));
	    	waitForElementAndClickUsingJS(By.xpath(confirmationPane));
	    	waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
	    	waitForElementAndClickUsingJS(By.xpath(deleteIcon));
	    	captureScreenshot("Deleted Sucessfully");
	    }
	 public void selectRecordByExpense(String cname) throws InterruptedException
	    {
	    	String name = cname;
	    	Thread.sleep(9000);
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
	    	String updatedClientList = ClientList.replace("CLIENT", name);
	    	waitForElementToBeClickable(By.xpath(updatedClientList));
	    	
	    }
	 public void selectStaff(Map<String, String> map) throws InterruptedException {
	    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
	    	//clienticon.click();
	    	waitForElementAndClickUsingJS(By.xpath(Staff_userIcon));
	    	waitForElementAndClickUsingJS(By.xpath(Staff_Icon));
	    	//Thread.sleep(5000);
	    	
	    	waitForElementAndClickUsingJS(By.xpath(Staff_createStaff));
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Staff_staffTypeCode), map.get("typecode"));
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Staff_staffTypeDescription), map.get("description"));
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Staff_staffTypeBillRate), map.get("billrate"));
	    	
	    	 captureScreenshot("Saved Staff");
	    	
	    	
	    	
	    	
	    }
	 public void click_StaffSave()
		{
		 
		 waitForElementAndClickUsingJS(By.xpath(Staff_Save));
			
		        captureScreenshot("Save Button Clicked");
		        
		}
	 public void selectRecordBySearch_staff(String location)
	    {
	    	String name = location;
	    	
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
	    	String updatedExpenseList = Staff_list_link.replace("LOCATION", name);
	    	waitForElementToBeClickable(By.xpath(updatedExpenseList));
	    	
	    	
	    	
	    }
	 public void selectRecordBySearch_staff_update(String location)
	    {
	    	String name = location;
	    	
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
	    	String updatedExpenseList = Staff_list_link.replace("LOCATION", name);
	    	waitForElementAndClickUsingJS(By.xpath(updatedExpenseList));
	    	
	    	
	    	
	    }
	 public void updateStaff(Map<String, String> map) throws InterruptedException {
	    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
	    	//clienticon.click();
	    //	waitForElementAndClickUsingJS(By.xpath(Staff_userIcon));
	    	//waitForElementAndClickUsingJS(By.xpath(Staff_Icon));
	    	//Thread.sleep(5000);
	    	
	    	//waitForElementAndClickUsingJS(By.xpath(Staff_createStaff));
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Staff_staffTypeCode), map.get("typecode"));
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Staff_staffTypeDescription), map.get("description"));
	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Staff_staffTypeBillRate), map.get("billrate"));
	    	
	    	 captureScreenshot("updated Staff");
	    	
	    	
	    	
	    	
	    }
	 public void click_staff_Update()
		{
		 
		 waitForElementAndClickUsingJS(By.xpath(Staff_updateButton));
			
		        captureScreenshot("Update Button Clicked");
			

		}public void activeToinActive_staff()
	    {
	    	
	    	waitForElementAndClickUsingJS(By.xpath(Staff_Status));
	    	waitForElementAndClickUsingJS(By.xpath(YesButton));
	    	waitForElementAndClickUsingJS(By.xpath(confirmationPane));
	    	waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
	    	//waitForElementAndClickUsingJS(By.xpath(deleteIcon));
	    	captureScreenshot("Deleted Sucessfully");
	    }
		 public void selectTask(Map<String, String> map) throws InterruptedException {
		    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
		    	//clienticon.click();
		    	waitForElementAndClickUsingJS(By.xpath(Task_userIcon));
		    	waitForElementAndClickUsingJS(By.xpath(Task_Icon));
		    	//Thread.sleep(5000);
		    	
		    	waitForElementAndClickUsingJS(By.xpath(Task_newTaskCreateButton));
		    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Task_taskCode), map.get("taskcode"));
		    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Task_taskDescription), map.get("description"));
		    	
		    	 captureScreenshot("Saved Task");
		    	
		    	
		    	
		    	
		    }
		 public void click_TaskSave()
			{
			 
			 waitForElementAndClickUsingJS(By.xpath(Task_Save));
				
			        captureScreenshot("Save Button Clicked");
			        
			}
		 public void selectRecordBySearch_task_update(String location)
		    {
		    	String name = location;
		    	
		    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
		    	String updatedExpenseList = Task_list_link.replace("\\","");
		    //	updatedExpenseList = "//"+Task_list_link;
		    	waitForElementAndClickUsingJS(By.xpath(updatedExpenseList));
		    	
		    	
		    	
		    }
		 public void updateTask(Map<String, String> map) throws InterruptedException {
		    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
		    	//clienticon.click();
		    	//waitForElementAndClickUsingJS(By.xpath(Task_userIcon));
		    	//waitForElementAndClickUsingJS(By.xpath(Task_Icon));
		    	//Thread.sleep(5000);
		    	
		    	//waitForElementAndClickUsingJS(By.xpath(Task_newTaskCreateButton));
		    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Task_taskCode), map.get("taskcode"));
		    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Task_taskDescription), map.get("description"));
		    	
		    	 captureScreenshot("Updated Task");
		    	
		    	
		    	
		    	
		    }
		 public void click_task_Update()
			{
			 
			 waitForElementAndClickUsingJS(By.xpath(Task_updateButton));
				
			        captureScreenshot("Update Button Clicked");
				

			}
		 public void selectRecordBySearch_task(String location)
		    {
		    	String name = location;
		    	
		    	
		    	
		    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
		    	String updatedExpenseList = Task_list_link.replace("\\","");
		    //	updatedExpenseList = "//"+Task_list_link;
		    	waitForElementToBeClickable(By.xpath(updatedExpenseList));
		    	
		    	
		    }
		 public void activeToinActive_task()
		    {
		    	
		    	waitForElementAndClickUsingJS(By.xpath(Task_Status));
		    	waitForElementAndClickUsingJS(By.xpath(YesButton));
		    	waitForElementAndClickUsingJS(By.xpath(confirmationPane));
		    	waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
		    	//waitForElementAndClickUsingJS(By.xpath(deleteIcon));
		    	captureScreenshot("Deleted Sucessfully");
		    }
		 
}

