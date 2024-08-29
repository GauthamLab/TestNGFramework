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
 // Helper method to wait for an element to be clickable
    private WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
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

