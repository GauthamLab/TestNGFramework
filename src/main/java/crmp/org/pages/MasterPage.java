package crmp.org.pages;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MasterPage {
	private WebDriver driver ;
	
	String value = "conreteProduction";
	private By titleTextBox = By.xpath("//input[@id='new-title']");
	
	private By adddTitleButton = By.xpath("//button[contains(text(),'Add Title')]");
	private By AddButton = By.xpath("//button[contains(text(),'Add')]");
	
	
	public MasterPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	
	public void enterTitle(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleTextBox));
		WebElement titleWebElement = driver.findElement(titleTextBox);
		
		titleWebElement.sendKeys(title);
		titleWebElement.sendKeys(Keys.TAB);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		selectAddButton();
		
	}
	public void selectAddTitleButton()
	{
		waitForHomePageToLoad();
		WebElement AddTitleBUtton = driver.findElement(adddTitleButton);
		AddTitleBUtton.click();
	}
	public void selectAddButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddButton));
		WebElement addButton = driver.findElement(AddButton);
		addButton.click();
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
			 Assert.assertEquals(verficationOfTitle.getText(), title_value);
		 }
		 else
		 {
			 System.out.print("title not added");
		 }
	}

}
