package crmp.org.pages;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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


public class ProjectPulseLoginPage {
	
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



	
	
	//COnsturctor
	public ProjectPulseLoginPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	// Method to enter username and password
    public void enterUsernameAndPassword(String username, String password) {
        WebElement usernameField = waitForElementToBeVisible(By.xpath(usernameXpath));
        WebElement passwordField = waitForElementToBeVisible(By.xpath(passwordXpath));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        captureScreenshot("enterUsernameAndPassword");
    }

    public void selectCleint(String clientName ,String clientNotes ,
    		                 String physicalAddress2 , String physicalAddress1 ,
    		                 String physicalState, String physicalCity,
    		                 String physicalZip, String billingAddress1,
    		                 String billingAddress2, String billingState,
    		                 String billingCity, String billingZip,
    		                 String firstName, String lastName,
    		                 String phone, String email,
    		                 String mobile,String physicalcountry,String billingCountry) throws InterruptedException {
    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
    	//clienticon.click();
    	waitForElementAndClickUsingJS(By.xpath(client));
    	Thread.sleep(5000);
    	waitForElementAndClickUsingJS(By.xpath(clientButton));
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(client),clientName);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalAddress2Xpath),physicalAddress2);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalAddress1Xpath),physicalAddress1);
    	WebElement countryDropdown = driver.findElement(By.id("physicalCountry"));
    	Select selectCountry = new Select(countryDropdown);
    	selectCountry.selectByValue(physicalcountry);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalStateXpath),physicalState);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalCityXpath),physicalCity);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(physicalZipXpath),physicalZip);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingAddress1Xpath),billingAddress1);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingAddress2Xpath),billingAddress2);
    	WebElement billingCountryDropdown = driver.findElement(By.id("billingCountry"));
    	Select selectBillingCountry = new Select(billingCountryDropdown);
    	selectBillingCountry.selectByValue(billingCountry);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingStateXpath),billingState);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingCityXpath),billingCity);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(billingZipXpath),billingZip);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(firstNameXpath),firstName);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(lastNameXpath),lastName);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(phoneXpath),phone);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(emailXpath),email);
    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(mobileXpath),mobile);
    	
    	
    	
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
 
 // Helper method to wait for page load, wait for element to be visible, click using JS, and send text
    private void waitForElementToBeVisibleAndInteractUsingJS(By locator, String textToSend) {
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
        element.sendKeys(textToSend);
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
        new WebDriverWait(driver, Duration.ofSeconds(100)).until(
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
}

