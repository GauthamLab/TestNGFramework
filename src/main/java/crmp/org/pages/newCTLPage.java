package crmp.org.pages;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Set;

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

import crmp.org.util.dataHelper;
import io.cucumber.java.Scenario;

public class newCTLPage {

	private WebDriver driver;

	// Login page Locator
	private By Login = By.xpath("//a[text()='Login']");
	private String passwordXpath = "//input[@id='usrCheckKey']";
	private String passwordXapth_Updated = "//input[@id='usrCheckKey']";
	private By Login_Button = By.xpath("//input[@id='btnLogin-2']");
		private String OwnerLink = "//td[contains(@class, 'lastName') and contains(@onclick, 'funEasyLogin')][1]";

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
	private String clearXpath = "//button[@id='btnClear-lg']";
	private String CancelXpath = "//button[@id='btnCancel-lg']";
	private String ClientList = "//td[@class='align-middle white-space-nowrap deadline ps-3 name sorting_1']//a[contains(text(),'CLIENT')]";
	private String searchXpath = "//input[@type='search']";
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
	private String Expense_Icon = "//a[contains(@class, 'nav-link') and contains(@href, 'expensetypecenter.do')]";
	private String Expense_createNewExpenseButton = "//button[contains(@onclick, 'funCreateExpenseType()')]";
	private String Expnse_expenseType = "//input[@id='expenseType']";
	private String Expense_Save = "//input[@id='btnSave-lg']";

//Xapth for Task 
	private String Task_Icon = "//a[contains(@class, 'nav-link') and contains(@href, 'taskcenter.do')]";
	private String Task_newTaskCreateButton = "//button[contains(@onclick, 'funCreateTask()')]";
	private String Task_taskCode = "//input[@id='taskCode']";
	private String Task_taskDescription = "//input[@id='task']";
	private String Task_Save = "//button[@id='btnSave-lg']";

//Xpath for Staff
	private String Staff_Icon = "//a[contains(@class, 'nav-link') and contains(@href, 'stafftypecenter.do')]";
	private String Staff_createStaff = "//button[contains(@onclick, 'funCreateStaffType()')]";
	private String Staff_staffTypeCode = "//input[@id='staffTypeCode']";
	private String Staff_staffTypeDescription = "//input[@id='staffType']";
	private String Staff_staffTypeBillRate = "//input[@id='standardBillRate']";
	private String Staff_Save = "//button[@id='btnSave-lg']";
//new page xpath 
	private By Click_Me = By.xpath("//input[contains(@onclick, 'javascript:funCheckin()')]");
	private By search_TextBox_Xpath = By.xpath("//input[@type='search']");
	private By first_record_Xpath = By.xpath("//a[contains(@onclick,\"funLogin('REY-C', 'REY-C')\")]");
	private By ProceedToDashBoard_Xpath = By
			.xpath("(//a[contains(@onclick,\"funProcess\") and contains(text(),\"Proceed to Dashboard\")])[1]");
	private By AMD_Xpath = By.xpath("//a[span[contains(text(), 'BMD')]]");
	private By Entries_Xpath = By.xpath("(//li[contains(@id, 'navChild')]/a[contains(text(), 'Entries')])[3]");
	private By settings_Button_xpath = By.xpath("//a[@id='btnSettings']");
	private By manageProposal = By.xpath("//li[contains(@id, 'ManageProposal')]/a[contains(text(), 'Manage Proposal')]");
	private By search_option = By.xpath("//select[@id='searchType']/option[@value='Search']");
	private By list_button = By.xpath("//input[@value='List']");
	private By dropDown = By.xpath("(//i[@class='fa fa-angle-down'])[2]");
	private By select_Dep = By.xpath("//ul[@id='branchlistdropdowns']//a[contains(@onclick,'13')]");
	private By proposal_No = By.xpath("//a[@id='spanProposalEssentials40164']");
	//private WebElement proposal_Noxapth = By.xpath("//a[contains(@onclick,'javascript:funLoadProposalInfo('40164'))]");
	private   By secondLinkLocator = By.xpath("//a[contains(@onclick,'javascript:funEditReviseEstimation(40164)')]");
	private   By equipment_button = By.xpath("//button[text()='Equipment']");
	
	
	
	
	// COnsturctor
	public newCTLPage(WebDriver driver) {
		this.driver = driver;

	}

	// Method to enter username and password
	public void enterUsernameAndPassword(String username, String password) {
		// WebElement usernameField =
		// waitForElementToBeVisible(By.xpath(usernameXpath));
		WebElement passwordField = waitForElementToBeVisible(By.xpath(passwordXpath));
		// usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		captureScreenshot("captured");
	}

	public void enterPassword(String password) {
		// WebElement usernameField =
		// waitForElementToBeVisible(By.xpath(usernameXpath));
		WebElement passwordField = waitForElementToBeVisible(By.xpath(passwordXapth_Updated));
		// usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		captureScreenshot("captured");
	}

	public void selectCleint(Map<String, String> map) throws InterruptedException {
		// WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
		// clienticon.click();
		waitForElementAndClickUsingJS(By.xpath(client));
		// Thread.sleep(5000);
		waitForElementAndClickUsingJS(By.xpath(clientButton));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(clientNameXpath), map.get("clientName"));
		cName = map.get("clientName");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalAddress2Xpath), map.get("physicalAddress2"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalAddress1Xpath), map.get("physicalAddress1"));
		WebElement countryDropdown = driver.findElement(By.id("physicalCountry"));
		Select selectCountry = new Select(countryDropdown);
		selectCountry.selectByValue("6");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalStateXpath), map.get("physicalState"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalCityXpath), map.get("physicalCity"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalZipXpath), map.get("physicalZip"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingAddress1Xpath), map.get("billingAddress1"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingAddress2Xpath), map.get("billingAddress2"));
		WebElement billingCountryDropdown = driver.findElement(By.id("billingCountry"));
		Select selectBillingCountry = new Select(billingCountryDropdown);
		selectBillingCountry.selectByValue("6");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingStateXpath), map.get("billingState"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingCityXpath), map.get("billingCity"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingZipXpath), map.get("billingZip"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(firstNameXpath), map.get("firstName"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(lastNameXpath), map.get("lastName"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(phoneXpath), map.get("phone"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(emailXpath), map.get("email"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(mobileXpath), map.get("mobile"));
		waitForElementAndClickUsingJS(By.xpath(SaveXpath));
		// Thread.sleep(60000);
		captureScreenshot("captured");

	}

	public void updateClientData(Map<String, String> map) throws InterruptedException {
		// WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
		// clienticon.click();
		// waitForElementAndClickUsingJS(By.xpath(client));
		// Thread.sleep(5000);
		// waitForElementAndClickUsingJS(By.xpath(clientButton));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(clientNameXpath), map.get("clientName"));
		cName = map.get("clientName");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalAddress2Xpath), map.get("physicalAddress2"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalAddress1Xpath), map.get("physicalAddress1"));
		WebElement countryDropdown = driver.findElement(By.id("physicalCountry"));
		Select selectCountry = new Select(countryDropdown);
		selectCountry.selectByValue("6");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalStateXpath), map.get("physicalState"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalCityXpath), map.get("physicalCity"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalZipXpath), map.get("physicalZip"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingAddress1Xpath), map.get("billingAddress1"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingAddress2Xpath), map.get("billingAddress2"));
		WebElement billingCountryDropdown = driver.findElement(By.id("billingCountry"));
		Select selectBillingCountry = new Select(billingCountryDropdown);
		selectBillingCountry.selectByValue("6");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingStateXpath), map.get("billingState"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingCityXpath), map.get("billingCity"));
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

	public void selectRecordBySearch(String cname) {
		String name = cname;

		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath), name);
		String updatedClientList = ClientList.replace("CLIENT", name);
		waitForElementToBeClickable(By.xpath(updatedClientList));

	}

	public void selectClientBySearch(String cname) throws InterruptedException {
		String name = cname;

		// waitForElementAndClickUsingJS(By.xpath(searchXpath));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath), name);
		String updatedClientList = ClientList.replace("CLIENT", name);
		waitForElementToBeClickable(By.xpath(updatedClientList));
		waitForElementAndClickUsingJS(By.xpath(status));
		waitForElementAndClickUsingJS(By.xpath(YesButton));
		waitForElementAndClickUsingJS(By.xpath(confirmationPane));
		waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
		waitForElementAndClickUsingJS(By.xpath(deleteIcon));
		captureScreenshot("Deleted Sucessfully");
	}

	public void click_Login() {
		WebElement Login_Click = driver.findElement(Click_Me);
		// WebElement MyAccount = driver.findElement(myAccount);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
		// MyAccount.click();
		Login_Click.click();
		// WebElement successPromptElement =
		// waitForElementToBeVisible(By.xpath(loginScreen));
		// Assert.assertTrue(successPromptElement.isDisplayed(), "Login Screen Loaded");
		captureScreenshot("Login Screen Loaded");

	}
	public void select_BMD() throws InterruptedException
	{
		dataHelper.waitForElementToBeVisibleAndClick(AMD_Xpath, driver);
		dataHelper.waitForElementToBeVisibleAndClick(Entries_Xpath, driver);
		dataHelper.waitForElementToBeVisibleAndClick(manageProposal, driver);
		String originalWindow = driver.getWindowHandle();
		String desiredWindowTitle = "Proposal :: Management ";
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get all the window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Switch to the new tab
		for (String windowHandle : allWindows) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().equals(desiredWindowTitle)) {
				System.out.println("Switched to the desired window: " + driver.getTitle());
				break;
			}
		}
		Thread.sleep(5000);
		dataHelper.waitForElementToBeVisibleAndClick(dropDown, driver);
		dataHelper.waitForElementToBeVisibleAndClick(select_Dep, driver);
		Thread.sleep(5000);
		dataHelper.waitForElementToBeVisibleAndClick(search_option, driver);
		dataHelper.waitForElementToBeVisibleAndClick(list_button, driver);
		//dataHelper.waitForElementToBeVisibleAndClick(proposal_No, driver);
		// Perform hover action on the first link
		// Hover over the first link
		Thread.sleep(5000);
		dataHelper.hoverOverElement(proposal_No, driver);

        // Wait for the second link to be visible and click it
		dataHelper.waitForElementToBeVisibleAndClick(secondLinkLocator, driver);
		Thread.sleep(5000);
		dataHelper.waitForElementToBeVisibleAndClick(settings_Button_xpath, driver);
		dataHelper.waitForElementToBeVisibleAndClick(equipment_button, driver);
		
	}

	public void search_Employee(String employee) throws InterruptedException {
		
		
		// WebElement MyAccount = driver.findElement(myAccount);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
		// MyAccount.click();

		dataHelper.waitForElementToBeVisibleAndInteractUsingJS(search_TextBox_Xpath, employee, driver);
		//dataHelper.waitForElementToBeVisibleAndClick(search_TextBox_Xpath, driver);
		dataHelper.waitForElementToBeVisibleAndClick(first_record_Xpath, driver);
		
		//Thread.sleep(3000);
		String originalWindow = driver.getWindowHandle();
		String desiredWindowTitle = "CTL :: Taskcenteric";
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get all the window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Switch to the new tab
		for (String windowHandle : allWindows) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().equals(desiredWindowTitle)) {
				System.out.println("Switched to the desired window: " + driver.getTitle());
				break;
			}
		}
		dataHelper.waitForElementToBeVisibleAndClick(ProceedToDashBoard_Xpath, driver);

		// WebElement successPromptElement =
		// waitForElementToBeVisible(By.xpath(loginScreen));
		// Assert.assertTrue(successPromptElement.isDisplayed(), "Login Screen Loaded");
		captureScreenshot("Employee Found");

	}

	public void click_ClickMe() {
		WebElement Login_Click = driver.findElement(Click_Me);
		// WebElement MyAccount = driver.findElement(myAccount);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
		// MyAccount.click();
		Login_Click.click();
		// WebElement successPromptElement =
		// waitForElementToBeVisible(By.xpath(loginScreen));
		// Assert.assertTrue(successPromptElement.isDisplayed(), "Login Screen Loaded");
		captureScreenshot("Login Screen Loaded");

	}

	public void select_owner() {

		String originalWindow = driver.getWindowHandle();
		waitForElementAndClickUsingJS(By.xpath(OwnerLink));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get all the window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Switch to the new tab
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		captureScreenshot("Login Screen Loaded");
		// Example action in the new tab
		System.out.println("New tab title: " + driver.getTitle());

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

	public void captureScreenshot(String fileName) {

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

	// Helper method to wait for page load, wait for element to be visible, click
	// using JS, and send text
	private void waitForElementToBeVisibleAndInteractUsingJS(By locator, String textToSend) {
		// Wait for the page to be fully loaded
		new WebDriverWait(driver, Duration.ofSeconds(100)).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));

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

	private void waitForElementToBeVisibleAndInteractUsingJSTabKey(By locator, String textToSend)
			throws InterruptedException {
		// Wait for the page to be fully loaded
		new WebDriverWait(driver, Duration.ofSeconds(100)).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));

		// Wait for the element to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		// Use JavaScript Executor to click the element
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);

		// Send text to the element (after clicking)
		// element.clear();
		// element.sendKeys(textToSend);
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		// element.wait(10000);
	}

	// Helper method to wait for an element to be clickable
	private WebElement waitForElementToBeClickable(By locator) {
		// Wait for the page to be fully loaded
		new WebDriverWait(driver, Duration.ofSeconds(100)).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));

		// Now wait for the element to be clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Helper method to wait for an element and click using JavaScript Executor
	private void waitForElementAndClickUsingJS(By locator) {
		// Wait for the page to be fully loaded
		new WebDriverWait(driver, Duration.ofSeconds(300)).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));

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

	public void selectAddTitleButton() {
		waitForHomePageToLoad();
//		WebElement AddTitleBUtton = driver.findElement(adddTitleButton);
//		AddTitleBUtton.click();
	}

	public void selectAddButton() {
		// outs().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForHomePageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(adddTitleButton));
	}

	public void verifyTitleIsAdded(String title_value) {
		// String value = "conreteProduction";
		By TitleAdded = By.xpath("//span[contains(text(),'" + title_value + "')]");
		WebElement verficationOfTitle = driver.findElement(TitleAdded);
		if (verficationOfTitle.isDisplayed()) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Assert.assertEquals(verficationOfTitle.getText(), title_value);

		} else {
			System.out.print("title not added");
		}
	}

	// location
	public void selectlocation(Map<String, String> map) throws InterruptedException {
		// WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
		// clienticon.click();
		waitForElementAndClickUsingJS(By.xpath(location_userIcon));
		waitForElementAndClickUsingJS(By.xpath(location_location));
		// Thread.sleep(5000);

		waitForElementAndClickUsingJS(By.xpath(location_createnewlocationButton));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationtextBox), map.get("location"));
		// cName = map.get("clientName");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_codetextBox), map.get("code"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_add1textBox), map.get("add1"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_add2textBox), map.get("add2"));
		WebElement countryDropdown = driver.findElement(By.xpath(location_locationCountryXpath));
		Select selectCountry = new Select(countryDropdown);
		selectCountry.selectByValue("6");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationstatetextBox), map.get("state"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationCity), map.get("city"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_countryTextBox), map.get("country"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_zip), map.get("zip"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_salesTax), map.get("salestax"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_overhead_burdenRate), map.get("overheadrate"));

		// waitForElementAndClickUsingJS(By.xpath(location_saveButton));
		// Thread.sleep(60000);
		captureScreenshot("Saved Loacation");

	}

	public void updateLocationData(Map<String, String> map) throws InterruptedException {
		// WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
		// clienticon.click();
		// waitForElementAndClickUsingJS(By.xpath(location_userIcon));
		// waitForElementAndClickUsingJS(By.xpath(location_location));
		// Thread.sleep(5000);

		// waitForElementAndClickUsingJS(By.xpath(location_createnewlocationButton));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationtextBox), map.get("location"));
		// cName = map.get("clientName");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_codetextBox), map.get("code"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_add1textBox), map.get("add1"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_add2textBox), map.get("add2"));
		WebElement countryDropdown = driver.findElement(By.xpath(location_locationCountryXpath));
		Select selectCountry = new Select(countryDropdown);
		selectCountry.selectByValue("6");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationstatetextBox), map.get("state"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_locationCity), map.get("city"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_countryTextBox), map.get("country"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_zip), map.get("zip"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_salesTax), map.get("salestax"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(location_overhead_burdenRate), map.get("overheadrate"));

		waitForElementAndClickUsingJS(By.xpath(location_updateButton));
		// Thread.sleep(60000);
		captureScreenshot("Updated Loacation");

	}

	public void selectLocationBySearch(String location) throws InterruptedException {
		String name = location;

		// waitForElementAndClickUsingJS(By.xpath(searchXpath));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath), name);
		String updatedClientList = location_locationtList.replace("LOCATION", name);
		waitForElementToBeClickable(By.xpath(updatedClientList));
		waitForElementAndClickUsingJS(By.xpath(location_status));
		waitForElementAndClickUsingJS(By.xpath(YesButton));
		waitForElementAndClickUsingJS(By.xpath(confirmationPane));
		waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
		// waitForElementAndClickUsingJS(By.xpath(deleteIcon));
		captureScreenshot("Deleted Sucessfully");
	}

	public void selectRecordBySearch_loc(String location) {
		String name = location;

		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath), name);
		String updatedClientList = location_locationtList.replace("LOCATION", name);
		waitForElementAndClickUsingJS(By.xpath(updatedClientList));

	}

	public void selectRecordBySearch_emp(String location) {
		String name = location;

		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath), name);
		String updatedEmpList = Employee_list_link.replace("LOCATION", name);
		waitForElementAndClickUsingJS(By.xpath(updatedEmpList));

	}

	public void activeToinActive_emp() {

		waitForElementAndClickUsingJS(By.xpath(Employee_status));
		waitForElementAndClickUsingJS(By.xpath(YesButton));
		waitForElementAndClickUsingJS(By.xpath(confirmationPane));
		waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
		// waitForElementAndClickUsingJS(By.xpath(deleteIcon));
		captureScreenshot("Deleted Sucessfully");
	}

	public void activeToinActive_loc() {

		waitForElementAndClickUsingJS(By.xpath(Employee_status));
		waitForElementAndClickUsingJS(By.xpath(YesButton));
		waitForElementAndClickUsingJS(By.xpath(confirmationPane));
		waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
		// waitForElementAndClickUsingJS(By.xpath(deleteIcon));
		captureScreenshot("Deleted Sucessfully");
	}

	public void click_Save() {

		waitForElementAndClickUsingJS(By.xpath(location_saveButton));

		captureScreenshot("Save Button Clicked");
	}

	public void click_Update() {

		waitForElementAndClickUsingJS(By.xpath(location_updateButton));

		captureScreenshot("Update Button Clicked");

	}

	// employee
	public void selectemployee(Map<String, String> map) throws InterruptedException {
		// WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
		// clienticon.click();
		waitForElementAndClickUsingJS(By.xpath(Employee_userIcon));
		waitForElementAndClickUsingJS(By.xpath(Employee_employeeIcon));
		// Thread.sleep(5000);

		waitForElementAndClickUsingJS(By.xpath(Employee_createNewEmployeeButton));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_jobTitle), map.get("title"));
		WebElement countryDropdown = driver.findElement(By.xpath(Employee_countryDropDown));
		Select emp_countryDropdown = new Select(countryDropdown);
		emp_countryDropdown.selectByValue("1");
		WebElement locationDropdown = driver.findElement(By.xpath(Employee_locationDropDown));
		Select emp_locationDropdown = new Select(locationDropdown);
		emp_locationDropdown.selectByValue("1");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_firstName), map.get("firstName"));
		// cName = map.get("clientName");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_lastName), map.get("lastName"));

		WebElement userDropdown = driver.findElement(By.xpath(Employee_userDropDown));
		Select selectusrType = new Select(userDropdown);
		selectusrType.selectByValue("1");

		WebElement genderDropdown = driver.findElement(By.xpath(Employee_genderDropDown));
		Select genderdrop = new Select(genderDropdown);
		genderdrop.selectByValue("0");

		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_address1), map.get("add1"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_address2), map.get("add2"));
//	    	WebElement emp_countryDropdown = driver.findElement(By.xpath(Employee_countryDropDown));
//	    	Select emp_countryDropdown1 = new Select(emp_countryDropdown);
//	    	emp_countryDropdown1.selectByValue("0");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_statetTextBox), map.get("state"));
		Thread.sleep(5000);
		waitForElementToBeVisibleAndInteractUsingJSTabKey(By.xpath(Employee_statetTextBox), map.get("state"));

		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_locationCity), map.get("city"));
		Thread.sleep(5000);
		waitForElementToBeVisibleAndInteractUsingJSTabKey(By.xpath(Employee_statetTextBox), map.get("city"));

		// waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_countryTextBox),
		// map.get("country"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_countryTextBox), map.get("country"));
		Thread.sleep(5000);
		waitForElementToBeVisibleAndInteractUsingJSTabKey(By.xpath(Employee_countryTextBox), map.get("country"));
		// Thread.sleep(5000);
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_zip), map.get("zip"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_billRate), map.get("billrate"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_extn), map.get("extn"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_mobile), map.get("mobile"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_payRate), map.get("payrate"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_emailId), map.get("email"));

		// waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_Save),
		// map.get("payrate"));

		// waitForElementAndClickUsingJS(By.xpath(Employee_Save));
		// Thread.sleep(60000);
		captureScreenshot("Saved Loacation");

	}

	public void updateEmpData(Map<String, String> map) throws InterruptedException {
		// WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
		// clienticon.click();
		// waitForElementAndClickUsingJS(By.xpath(Employee_userIcon));
		// waitForElementAndClickUsingJS(By.xpath(Employee_employeeIcon));
		// Thread.sleep(5000);

		// waitForElementAndClickUsingJS(By.xpath(Employee_createNewEmployeeButton));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_jobTitle), map.get("title"));
		WebElement countryDropdown = driver.findElement(By.xpath(Employee_countryDropDown));
		Select emp_countryDropdown = new Select(countryDropdown);
		emp_countryDropdown.selectByValue("1");
		WebElement locationDropdown = driver.findElement(By.xpath(Employee_locationDropDown));
		Select emp_locationDropdown = new Select(locationDropdown);
		emp_locationDropdown.selectByValue("1");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_firstName), map.get("firstName"));
		// cName = map.get("clientName");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_lastName), map.get("lastName"));

		WebElement userDropdown = driver.findElement(By.xpath(Employee_userDropDown));
		Select selectusrType = new Select(userDropdown);
		selectusrType.selectByValue("1");

		WebElement genderDropdown = driver.findElement(By.xpath(Employee_genderDropDown));
		Select genderdrop = new Select(genderDropdown);
		genderdrop.selectByValue("0");

		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_address1), map.get("add1"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_address2), map.get("add2"));
//	    	WebElement emp_countryDropdown = driver.findElement(By.xpath(Employee_countryDropDown));
//	    	Select emp_countryDropdown1 = new Select(emp_countryDropdown);
//	    	emp_countryDropdown1.selectByValue("0");
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_statetTextBox), map.get("state"));
		Thread.sleep(5000);
		waitForElementToBeVisibleAndInteractUsingJSTabKey(By.xpath(Employee_statetTextBox), map.get("state"));
		// Thread.sleep(50000);
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_locationCity), map.get("city"));
		Thread.sleep(5000);
		waitForElementToBeVisibleAndInteractUsingJSTabKey(By.xpath(Employee_statetTextBox), map.get("city"));
		// Thread.sleep(50000);
		// waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_countryTextBox),
		// map.get("country"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_countryTextBox), map.get("country"));
		Thread.sleep(5000);
		waitForElementToBeVisibleAndInteractUsingJSTabKey(By.xpath(Employee_countryTextBox), map.get("country"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_zip), map.get("zip"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_billRate), map.get("billrate"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_extn), map.get("extn"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_mobile), map.get("mobile"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_payRate), map.get("payrate"));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_emailId), map.get("email"));

		// waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Employee_Save),
		// map.get("payrate"));

		// waitForElementAndClickUsingJS(By.xpath(Employee_Save));
		// Thread.sleep(60000);
		captureScreenshot("Saved Loacation");

	}

	public void click_emp_Update() {

		waitForElementAndClickUsingJS(By.xpath(Employee_updateButton));

		captureScreenshot("Update Button Clicked");

	}

	public void click_employeeSave() {

		waitForElementAndClickUsingJS(By.xpath(Employee_Save));

		captureScreenshot("Save Button Clicked");
	}

	public void selectLocationBySearch_emp(String location) throws InterruptedException {
		String name = location;

		// waitForElementAndClickUsingJS(By.xpath(searchXpath));
		waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath), name);
		String updatedEmpList = Employee_list_link.replace("LOCATION", name);
		waitForElementToBeClickable(By.xpath(updatedEmpList));

		waitForElementAndClickUsingJS(By.xpath(location_status));
		waitForElementAndClickUsingJS(By.xpath(YesButton));
		waitForElementAndClickUsingJS(By.xpath(confirmationPane));
		waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
		waitForElementAndClickUsingJS(By.xpath(deleteIcon));
		captureScreenshot("Deleted Sucessfully");
	}
}
