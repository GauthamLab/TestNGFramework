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

import crmp.org.util.dataHelper;
import io.cucumber.java.Scenario;


public class Project {
	
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
private String Task_newTaskCreateButton = "//button[contains(@onclick, 'funCreateTask()')]";
private String Task_taskCode = "//input[@id='taskCode']";
private String Task_taskDescription = "//input[@id='task']";
private String Task_Save = "//button[@id='btnSave-lg']";

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

//Project 
private String Project_projectIcon = "//a[contains(@class, 'nav-link') and contains(@href, 'project.do')]";
private String Project_createStaff = "//button[contains(@onclick, 'funCreateProjectModal()')][1]";
private String Project_clientName = "//input[@id='clientName']";
private String Project_projectName = "//input[@id='projectName']";
private String Project_MangerId = "//select[@id='projectManagerId']";
private String Project_saveAndClose = "//input[@value='Save & Close']";

	//COnsturctor
	public Project(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	
	 public void selectProject(Map<String, String> map) throws InterruptedException {
	    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
	    	//clienticon.click();
	    	//dataHelper.waitForElementAndClickUsingJS(By.xpath(Project_projectIcon), driver);
	    	dataHelper.waitForElementAndClickUsingJS(By.xpath(Project_createStaff), driver);
	    	dataHelper.waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Project_clientName), map.get("clientname"), driver);
	    	dataHelper.waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Project_projectName), map.get("projectname"), driver);
	    	WebElement projectManager_web = driver.findElement(By.xpath(Project_MangerId));
	    	Select projectManager = new Select(projectManager_web);
	    	projectManager.selectByValue("1");
	    	
	    	dataHelper.captureScreenshot("Saved Staff",driver);
	    	
	    	
	    	
	    	
	    }
	 public void click_ProjectSave()
		{
		 
		 dataHelper.waitForElementAndClickUsingJS(By.xpath(Project_saveAndClose),driver);
			
		 dataHelper.captureScreenshot("Save Button Clicked",driver);
		        
		}
//	 public void selectRecordBySearch_staff(String location)
//	    {
//	    	String name = location;
//	    	
//	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
//	    	String updatedExpenseList = Staff_list_link.replace("LOCATION", name);
//	    	waitForElementToBeClickable(By.xpath(updatedExpenseList));
//	    	
//	    	
//	    	
//	    }
//	 public void selectRecordBySearch_staff_update(String location)
//	    {
//	    	String name = location;
//	    	
//	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(searchXpath),name);
//	    	String updatedExpenseList = Staff_list_link.replace("LOCATION", name);
//	    	waitForElementAndClickUsingJS(By.xpath(updatedExpenseList));
//	    	
//	    	
//	    	
//	    }
//	 public void updateStaff(Map<String, String> map) throws InterruptedException {
//	    	//WebElement clienticon = waitForElementAndClickUsingJS(By.xpath(client));
//	    	//clienticon.click();
//	    //	waitForElementAndClickUsingJS(By.xpath(Staff_userIcon));
//	    	//waitForElementAndClickUsingJS(By.xpath(Staff_Icon));
//	    	//Thread.sleep(5000);
//	    	
//	    	//waitForElementAndClickUsingJS(By.xpath(Staff_createStaff));
//	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Staff_staffTypeCode), map.get("typecode"));
//	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Staff_staffTypeDescription), map.get("description"));
//	    	waitForElementToBeVisibleAndInteractUsingJS(By.xpath(Staff_staffTypeBillRate), map.get("billrate"));
//	    	
//	    	 captureScreenshot("updated Staff");
//	    	
//	    	
//	    	
//	    	
//	    }
//	 public void click_staff_Update()
//		{
//		 
//		 waitForElementAndClickUsingJS(By.xpath(Staff_updateButton));
//			
//		        captureScreenshot("Update Button Clicked");
//			
//
//		}public void activeToinActive_staff()
//	    {
//	    	
//	    	waitForElementAndClickUsingJS(By.xpath(Staff_Status));
//	    	waitForElementAndClickUsingJS(By.xpath(YesButton));
//	    	waitForElementAndClickUsingJS(By.xpath(confirmationPane));
//	    	waitForElementAndClickUsingJS(By.xpath(YesDeleteButton));
//	    	//waitForElementAndClickUsingJS(By.xpath(deleteIcon));
//	    	captureScreenshot("Deleted Sucessfully");
//	    }
//		
	    	
	    	
	    	
	    	
	    }


