package stepDefinitions;

import crmp.org.pages.LoginPage;
import crmp.org.pages.ProjectPulseLoginPage;
import crmp.org.util.*;
import crmp.org.pages.TitleMaster;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class StepDef {

    private static WebDriver driver;
    private LoginPage loginPage;
    private TitleMaster titleMaster;
    private ProjectPulseLoginPage ppLogin;
    private String workbookName;
    private String sheetName;
    private String testCaseNumber;
    private static Map<String, Map<String, String>> excelData = new HashMap<>();
  

    @Before
    public void setup() {
        driver = WebDriverSingleton.getDriver();
        loginPage = new LoginPage(driver); // Initializing LoginPage object
        titleMaster = new TitleMaster(driver);
        ppLogin = new ProjectPulseLoginPage(driver);
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
        }
       
    }
    
  
    @AfterStep
    public void afterEachStep(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Step Screenshot");
        Reporter.log("<br><img src='data:image/png;base64," + new String(screenshot) + "' height='200' width='200'/><br>");
    }
   

    @Given("I am on crm page")
    public void I_am_on_crm_page() {
        driver.get("https://uatservice.ctleng.com/CRP/pages/Login.jsp");
    }

    @When("Login with username and password for the test case {string}")
    public void Login(String TestCaseId) {
    	Map<String, String> testCaseData = excelData.get(testCaseNumber);
        if (testCaseData == null) {
            throw new RuntimeException("Test case not found: " + testCaseNumber);
        }
        String username = testCaseData.get("username");
        String password = testCaseData.get("password");
        ppLogin.enterUsernameAndPassword(username, password);
    }
    @When("Enter the values to the fields {string}")
    public void UpdateFields(String TestCaseId) throws InterruptedException {
    	Map<String, String> testCaseDataUpdate = excelData.get(testCaseNumber);
        if (testCaseDataUpdate == null) {
            throw new RuntimeException("Test casfe not found: " + testCaseNumber);
        }
       
        ppLogin.updateClientData(testCaseDataUpdate);
    }
    
    @When("I retrieve data for test case {string}")
    public void i_retrieve_data_for_test_case(String TestCaseId) {
        Map<String, String> testCaseData = excelData.get(TestCaseId);
        if (testCaseData == null) {
            throw new RuntimeException("Test case not found: " + TestCaseId);
        }
        System.out.println("Title: " + testCaseData.get("Title"));
        System.out.println("Age: " + testCaseData.get("age"));
    }

    @Then("Click LoginButton")
    public void Click_LoginButton() {
        ppLogin.click_Login();
    }
    

    @Given("Select Branch {string}")
    public void Select_Branch(String branch) {
        titleMaster.selectBranch(branch);
    }

    @When("Select Create Title")
    public void Select_Create_Title() {
        titleMaster.createTitle();
    }

    @Then("Enter Title Value {string}")
    public void Enter_Title_Value(String title) {
        titleMaster.enterTitleValue(title);
    }

    @Then("Set Title value for further reference {string}")
    public void Set_Title_Value(String title) {
        titleMaster.setTitleValue(title);
    }

    @Then("Change the title to new title {string}")
    public void Enter_new_Title(String newTitle) {
        titleMaster.enterTitleValue(newTitle);
    }

    @Then("Select Save")
    public void Select_Save() {
        titleMaster.selectSave();
    }

    @Then("Select Cancel")
    public void Select_Cancel() {
        titleMaster.selectCancel();
    }

    @Then("Select Update")
    public void Select_Update1() {
        titleMaster.selectUpdate();
    }
    @Then("Select Edit")
    public void Select_edit() {
        titleMaster.selectEdit();
    }
    
    @Then("Check that Already exist modal is getting displayed")
    public void already_exist_check() {
        titleMaster.selectSaveAndAlreadyExist();
    }

    @Then("Check that saved successfully is getting displayed")
    public void saved_successfully() {
        titleMaster.selectSavePrompt();
    }
    @Then("Check that application is allowing only fifty charcters {string}")
    public void not_saved_successfully(String title) {
        titleMaster.fieldValidation(title);
    }
    @Then("Check that title is required is getting displayed")
    public void title_is_required() {
        titleMaster.titleIsRequired();
    }
    

    @Then("Check that Made Inactive successfully is getting displayed")
    public void madeInactive_successfully() {
        titleMaster.inActivePrompt();
    }

    @Then("Check that Updated successfully is getting displayed")
    public void updateMessage_successfully() {
        titleMaster.updatedSuccessfullyMessage();
    }

    @Then("Search the title which is added {string}")
    public void title_is_added(String title) {
        titleMaster.searchTitle(title);
    }

    @Then("Select active to inactive")
    public void Select_active_to_inactive() {
        titleMaster.activeToInactive();
    }

    @Then("Delete The Title")
    public void Delete_The_Title() {
        titleMaster.deleteTitle();
    }
    @Then("Verfiy Title is Deleted")
    public void verify_title_deleted() {
        titleMaster.titleDeletedMessage();
    }
    
    
   

    @Then("Select inactive to active")
    public void Select_inactive_to_active() {
        titleMaster.inactiveToInactive();
    }

    @Then("Verify title is fetched {string}")
    public void title_is_fetched(String title) {
        titleMaster.verifyTitleIsInTheList(title);
    }
    
    

    @Then("Select the record which have USED status")
    public void record_USED_status() {
        titleMaster.updateWithInActiveStatus();
    }
    
   

    @Given("I load the Excel workbook {string} and sheet {string}")
    public void i_load_the_excel_workbook_and_sheet(String workbookName, String sheetName) throws IOException {
        excelData = dataHelper.getExcelData(workbookName, sheetName);
       
    }
    
    @Given("I am on Project Pulse Page")
    public void I_am_on_Project_Pulse() {
        driver.get("https://uat.ctleng.com/sachinalite/signin.do");
    }
    @Given("Select clinet and enter field values {string}")
    public void I_select_Client(String TestCaseId) throws InterruptedException {
    	Map<String, String> testCaseData = excelData.get(testCaseNumber);
        if (testCaseData == null) {
            throw new RuntimeException("Test case not found: " + testCaseNumber);
        }
      
       // ppLogin.check(testCaseData);
    	ppLogin.selectCleint(testCaseData);
    }
    
    
    @Given("Select record by search {string}")
    public void select_record_by_search(String TestCaseId) throws InterruptedException {
       // ppLogin.check(testCaseData);
    	Map<String, String> testCaseDataUpdate = excelData.get(testCaseNumber);
        if (testCaseDataUpdate == null) {
            throw new RuntimeException("Test casfe not found: " + testCaseNumber);
        }
        String value = testCaseDataUpdate.get("clientName");
    	ppLogin.selectRecordBySearch(value);
    }
    @Given("Select client by search and change active to non active and delete the record {string}")
    public void I_select_Client_by_Search(String TestCaseId) throws InterruptedException {
       // ppLogin.check(testCaseData);
    	Map<String, String> testCaseDataUpdate = excelData.get(testCaseNumber);
        if (testCaseDataUpdate == null) {
            throw new RuntimeException("Test casfe not found: " + testCaseNumber);
        }
        String value = testCaseDataUpdate.get("clientName");
    	ppLogin.selectClientBySearch(value);
    }
    @Given("Select location and enter field values {string}")
    public void I_select_location(String TestCaseId) throws InterruptedException {
    	Map<String, String> testCaseData = excelData.get(testCaseNumber);
        if (testCaseData == null) {
            throw new RuntimeException("Test case not found: " + testCaseNumber);
        }
      
       // ppLogin.check(testCaseData);
    	ppLogin.selectlocation(testCaseData);
    }
    @When("Update the location values to the fields {string}")
    public void UpdateFields_location(String TestCaseId) throws InterruptedException {
    	Map<String, String> testCaseDataUpdate = excelData.get(testCaseNumber);
        if (testCaseDataUpdate == null) {
            throw new RuntimeException("Test casfe not found: " + testCaseNumber);
        }
       
        ppLogin.updateLocationData(testCaseDataUpdate);
    }
    @Given("Select location by search and change active to non active and delete the record {string}")
    public void I_select_location_by_Search(String TestCaseId) throws InterruptedException {
       // ppLogin.check(testCaseData);
    	Map<String, String> testCaseDataUpdate = excelData.get(testCaseNumber);
        if (testCaseDataUpdate == null) {
            throw new RuntimeException("Test casfe not found: " + testCaseNumber);
        }
        String value = testCaseDataUpdate.get("location");
    	ppLogin.selectLocationBySearch(value);
    }
    @Given("Select record by search location {string}")
    public void select_record_by_search_loc(String TestCaseId) throws InterruptedException {
       // ppLogin.check(testCaseData);
    	Map<String, String> testCaseDataUpdate = excelData.get(testCaseNumber);
        if (testCaseDataUpdate == null) {
            throw new RuntimeException("Test casfe not found: " + testCaseNumber);
        }
        String value = testCaseDataUpdate.get("clientName");
    	ppLogin.selectRecordBySearch_loc(value);
    }
    @Then("Select Save Button")
    public void Click_SaveButton() {
        ppLogin.click_Save();
    }
    @Then("Select Save Button on employee screen")
    public void Click_SaveButtonemployee() {
        ppLogin.click_employeeSave();
    }
    
    @And("Select Update button")
    public void Click_UpdateButton() {
        ppLogin.click_Update();
    }
    @And("Select employee Update button")
    public void Click_EmpUpdateButton() {
        ppLogin.click_emp_Update();
    }
    @Given("Select employee and enter field values {string}")
    public void I_select_employee(String TestCaseId) throws InterruptedException {
    	Map<String, String> testCaseData = excelData.get(testCaseNumber);
        if (testCaseData == null) {
            throw new RuntimeException("Test case not found: " + testCaseNumber);
        }
      
       // ppLogin.check(testCaseData);
    	ppLogin.selectemployee(testCaseData);
    }
    @Given("Select record by search employee {string}")
    public void select_record_by_search_emp(String TestCaseId) throws InterruptedException {
       // ppLogin.check(testCaseData);
    	Map<String, String> testCaseDataUpdate = excelData.get(testCaseNumber);
        if (testCaseDataUpdate == null) {
            throw new RuntimeException("Test casfe not found: " + testCaseNumber);
        }
        String value = testCaseDataUpdate.get("firstName");
    	ppLogin.selectRecordBySearch_emp(value);
    }
    @When("Update the emp values to the fields {string}")
    public void UpdateFields_emp(String TestCaseId) throws InterruptedException {
    	Map<String, String> testCaseDataUpdate = excelData.get(testCaseNumber);
        if (testCaseDataUpdate == null) {
            throw new RuntimeException("Test casfe not found: " + testCaseNumber);
        }
       
        ppLogin.updateEmpData(testCaseDataUpdate);
    }
    @Given("Select employee by search and change active to non active and delete the record {string}")
    public void I_select_employee_by_Search(String TestCaseId) throws InterruptedException {
       // ppLogin.check(testCaseData);
    	Map<String, String> testCaseDataUpdate = excelData.get(testCaseNumber);
        if (testCaseDataUpdate == null) {
            throw new RuntimeException("Test casfe not found: " + testCaseNumber);
        }
        String value = testCaseDataUpdate.get("firstName");
    	ppLogin.selectRecordBySearch_emp(value);
    }

}
