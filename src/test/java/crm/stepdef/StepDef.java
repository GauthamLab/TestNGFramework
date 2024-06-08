package crm.stepdef;

import crmp.org.pages.LoginPage;
//import crmp.org.pages.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
    
    private static WebDriver driver;
    private LoginPage loginPage;
   // private loginPage loginPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver); // Initializing LoginPage object
    }

    @After 
    public void teardown() {
        if (driver != null) {
           // driver.quit();
        }
    }
    
    @Given("I have selected my account")
    public void myAccount() {
        loginPage.SelectLogin();
    }
    
    @Given("I am on the OpenCart Login page")
    public void openCartLoginPage() {
        driver.get("https://naveenautomationlabs.com/opencart/");
    }
    
    @When("I have entered invalid {string} and {string}")
    public void invalidCredentials(String email, String password) {
    	
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }
    
    @When("I click on the login button")
    public void loginButton() {
    	loginPage.waitForLoginPageToLoad();
        loginPage.click_Login();
    }
    
    @Then("I should see an error message indicating {string}")
    public void validateErrorMessage(String errorMessage) {
    	WebElement errorMessageElement = driver.findElement(By.cssSelector(".alert-danger"));
        Assert.assertTrue(errorMessageElement.isDisplayed());
        if(errorMessageElement.isDisplayed())
        {
        	String screenshotPath = loginPage.captureScreenshot();
            Reporter.log("<br><img src='" + screenshotPath + "' height='200' width='200'/><br>");
        }
    }
    @Given("I am on crm page")
    public void I_am_on_crm_page()
    {
    	driver.get("E://bala.html");
    	
    }
    @Given("I have selected Add Title")
    public void I_have_selected_Add_Title()
    {
    	try {
    	loginPage.selectAddTitleButton();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    @Then("I have entered Title {string}")
    public void I_have_entered_Title(String title_content)
    {
    	try {
    		loginPage.enterTitle(title_content);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
    @And("Selected AddButton")
    public void Selected_AddButton()
    {
    	try {
    	loginPage.selectAddButton();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    @Then("Verify that {string} is added")
    public void Verify_that_title_is_added(String title_value)
    {
    	try {
    		loginPage.verifyTitleIsAdded(title_value);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
    @And("Delete The created title")
    public void Delete_The_created_title()
    {
    	loginPage.deleteRecord();
    }
    @AfterStep
	public static void takescreenshot(Scenario scenario)
	{
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot,"image/png","image");
	}
}
