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
private String loginScreen = "//input[@id='search']";
private String client = "//span[text()='Client']";
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
        WebElement usernameField = waitForElementToBeClickable(By.xpath(usernameXpath));
        WebElement passwordField = waitForElementToBeClickable(By.xpath(passwordXpath));
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
    	WebElement clienticon = waitForElementToBeClickable(By.xpath(client));
    	clienticon.click();
    	Thread.sleep(5000);
    	waitForElementToBeVisibleAndInteract(By.xpath(client),clientName);
    	waitForElementToBeVisibleAndInteract(By.xpath(physicalAddress2Xpath),physicalAddress2);
    	waitForElementToBeVisibleAndInteract(By.xpath(physicalAddress1Xpath),physicalAddress1);
    	WebElement countryDropdown = driver.findElement(By.id("physicalCountry"));
    	Select selectCountry = new Select(countryDropdown);
    	selectCountry.selectByValue(physicalcountry);
    	waitForElementToBeVisibleAndInteract(By.xpath(physicalStateXpath),physicalState);
    	waitForElementToBeVisibleAndInteract(By.xpath(physicalCityXpath),physicalCity);
    	waitForElementToBeVisibleAndInteract(By.xpath(physicalZipXpath),physicalZip);
    	waitForElementToBeVisibleAndInteract(By.xpath(billingAddress1Xpath),billingAddress1);
    	waitForElementToBeVisibleAndInteract(By.xpath(billingAddress2Xpath),billingAddress2);
    	WebElement billingCountryDropdown = driver.findElement(By.id("billingCountry"));
    	Select selectBillingCountry = new Select(billingCountryDropdown);
    	selectBillingCountry.selectByValue(billingCountry);
    	waitForElementToBeVisibleAndInteract(By.xpath(billingStateXpath),billingState);
    	waitForElementToBeVisibleAndInteract(By.xpath(billingCityXpath),billingCity);
    	waitForElementToBeVisibleAndInteract(By.xpath(billingZipXpath),billingZip);
    	waitForElementToBeVisibleAndInteract(By.xpath(firstNameXpath),firstName);
    	waitForElementToBeVisibleAndInteract(By.xpath(lastNameXpath),lastName);
    	waitForElementToBeVisibleAndInteract(By.xpath(phoneXpath),phone);
    	waitForElementToBeVisibleAndInteract(By.xpath(emailXpath),email);
    	waitForElementToBeVisibleAndInteract(By.xpath(mobileXpath),mobile);
    	
    	
    	
    }
	public void click_Login()
	{
		WebElement Login_Click = driver.findElement(Login_Button);
	//	WebElement MyAccount = driver.findElement(myAccount);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
		//MyAccount.click();
		Login_Click.click();
		 WebElement successPromptElement = waitForElementToBeVisible(By.xpath(loginScreen));
		 Assert.assertTrue(successPromptElement.isDisplayed(), "Not Saved Successfully prompt not displayed");
	        captureScreenshot("selectnotSavePrompt");
		

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

 // Helper method to wait for an element to be clickable
    private WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
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

