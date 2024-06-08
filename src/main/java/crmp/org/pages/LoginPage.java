package crmp.org.pages;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

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

public class LoginPage {
	
	private WebDriver driver ;
	
	//Locators
	private By myAccount = By.xpath("//span[2]");
	private By Register = By.xpath("//a[text()='Register']");
	
	private By FirstName = By.xpath("//input[@id='input-firstname']");
	private By LastName = By.xpath("//input[@id='input-lastname']");
	private By Email = By.xpath("//input[@id='input-email']");
	private By Telephone = By.xpath("//input[@id='input-telephone']");
	private By Password = By.xpath("//input[@id='input-password']");
	private By Password_confirm = By.xpath("//input[@id='input-confirm']");
	private By checkBox = By.xpath("//input[@type='checkbox']");
	private By Submit = By.xpath("//input[@value='Continue']");
	//Login page Locator
	private By Login = By.xpath("//a[text()='Login']");
	private By Password_Login = By.xpath("//input[@id='input-password']");
	private By Login_Button = By.xpath("//input[@value='Login']");
	
private By titleTextBox = By.xpath("//input[@id='new-title']");
	
	private By adddTitleButton = By.xpath("//button[contains(text(),'Add Title')]");
	private By AddButton = By.xpath("//button[contains(text(),'Add')]");
	//COnsturctor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	//Methods
	public void enterEmail(String email)
	{
		WebElement email_input = driver.findElement(Email);
		//WebElement LoginLink = driver.findElement(Login);
		//LoginLink.click();
		email_input.sendKeys(email);
		
		

	}
	public void enterPassword(String password)
	{
		WebElement password_input = driver.findElement(Password_Login);
		password_input.sendKeys(password);

	}
	public void click_Login()
	{
		WebElement Login_Click = driver.findElement(Login_Button);
	//	WebElement MyAccount = driver.findElement(myAccount);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
		//MyAccount.click();
		Login_Click.click();

	}
	public void SelectLogin()
	{
		WebElement LoginIcon = driver.findElement(Login);
		WebElement MyAccount = driver.findElement(myAccount);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
		MyAccount.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(Login));
		LoginIcon.click();

	}
	// Example of using explicit wait
    public void waitForLoginPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Login_Button));
    }
	
 // Method to capture screenshot with timestamp-based filename
    public String captureScreenshot() {
        String screenshotPath = "";
        try {
            // Convert WebDriver object to TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Capture screenshot as byte array
            byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);

            // Read byte array into BufferedImage
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(screenshotBytes));

            // Generate timestamp for filename
            String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());

            // Save BufferedImage to file with timestamp as filename
            File output = new File("screenshot_" + timestamp + ".png");
            ImageIO.write(image, "png", output);

            // Get the absolute path of the screenshot
            screenshotPath = output.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
    
    
//    public MasterPage(WebDriver driver)
//	{
//		this.driver = driver;
//		
//	}
	
	
	public void enterTitle(String title)
	{
		
		 // Find the textbox element and set its value using JavaScript
		//String script = "document.getElementById('new-title').value = arguments[0];";
      //  ((JavascriptExecutor) driver).executeScript(script, title);
        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleTextBox));
		WebElement titleWebElement = driver.findElement(titleTextBox);
		titleWebElement.clear();
		titleWebElement.sendKeys(title);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		titleWebElement.sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  // Create Actions object
        Actions actions = new Actions(driver);

        // Simulate pressing the Enter key
        actions.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	public void deleteRecord() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleTextBox));
		WebElement titleWebElement = driver.findElement(titleTextBox);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		titleWebElement.sendKeys(Keys.TAB);
		
		 Actions actions = new Actions(driver);

	        // Simulate pressing the Enter key
		 actions.sendKeys(Keys.TAB).perform();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 actions.sendKeys(Keys.TAB).perform();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        actions.sendKeys(Keys.ENTER).perform();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void selectAddTitleButton()
	{
		waitForHomePageToLoad();
		WebElement AddTitleBUtton = driver.findElement(adddTitleButton);
		AddTitleBUtton.click();
	}
	public void selectAddButton()
	{
		//outs().implicitlyWait(Duration.ofSeconds(20));
	}
	
	 public void waitForHomePageToLoad() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(adddTitleButton));
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

