package crmp.org.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class TitleMaster {

    private WebDriver driver;
    private String titleValue;

    // Locators
    private String branchXpathTemplate = "(//span[contains(text(),'REPLACE')])[1]";
    private String titleXpath = "//input[@name='descriptionTitle']";
    private String addButton = "//input[@value='Add']";
    private String cancelButton = "//input[@value='Cancel']";
    private String updateButton = "//input[@value='Update']";
    private String editIcon="//a[@title='Click to Edit']";
    private String createTitleButtonXpath = "(//a[contains(text(),'Title')])[2]";
    private String saveButtonXpath = "//input[@value='Save']";
    private String loginButtonXpath = "//a[@id='logIn']";
    private String usernameXpath = "//input[@id='loginUserName']";
    private String passwordXpath = "//input[@id='loginPassWord']";
    private String alreadyExistXpath = "(//span[contains(text(),'Data already exists')])";
    private String xpathSuscess = "(//span[contains(text(),'Saved Successfully')])[2]";
    private String DeletedSucessfullyPromptXpath = "(//span[contains(text(),'Deleted Successfully')])[2]";
    private String titleXpatSuscess = "(//td[contains(text(),'Are you sure to Delete?')])";
    private String yesButtonXPath = "//input[@value='Yes']";
    private String xpathFailure = "(//span[contains(text(),'Not Saved Successfully')])[2]";
    private String xpathTitle = "//span[contains(text(),'Title is required')]";
    private String madeInActiveXpath = "(//span[contains(text(),'Made Inactive Successfully')])";
    private String udpateSuccessfullyXpath = "(//span[contains(text(),'Updated Successfully')])[2]";
    private String searchXpath = "(//input[@id='searchTitle'])";
    private String activeToInactiveXpath = "//a[@title='Click to make this Inactive']";
    private String inactiveToInactiveXpath = "//a[@title='Click to make this Active']";
    private String deleteXpath = "//a[@title='Click to Delete']";
    private String goButton = "(//input[@value='Go'])";
    private String titleListValueTemplate = "//td[contains(text(),'REPLACE')]";
    private String inUseXpath = "(//a[@title='Inactive entry can only be deleted'])[1]";

    // Constructor
    public TitleMaster(WebDriver driver) {
        this.driver = driver;
    }

    // Method to select a branch
    public void selectBranch(String branch) {
        String branchXpath = branchXpathTemplate.replace("REPLACE", branch);
        WebElement branchElement = waitForElementToBeClickable(By.xpath(branchXpath));
        clickElement(branchElement);
        captureScreenshot("selectBranch_" + branch);
    }
    
    // Method to enter title value
    public void enterTextBoxMaxLengthCheck(String title) {
        WebElement addButtonWeb = waitForElementToBeClickable(By.xpath(addButton));
        clickElement(addButtonWeb);
        WebElement titleElement = waitForElementToBeClickable(By.xpath(titleXpath));
        titleElement.clear();
        titleElement.sendKeys(title); // Use the title value
        captureScreenshot("enterTextBoxMaxLengthCheck_" + title);
    }

    // Method to enter title value
    public void enterTitleValue(String title) {
        WebElement addButtonWeb = waitForElementToBeClickable(By.xpath(addButton));
        clickElement(addButtonWeb);
        WebElement titleElement = waitForElementToBeClickable(By.xpath(titleXpath));
        titleElement.clear();
        titleElement.sendKeys(title); // Use the title value
        captureScreenshot("enterTitleValue_" + title);
    }

    // Setter for titleValue
    public void setTitleValue(String titleValue) {
        this.titleValue = titleValue;
    }

    // Method to create a title
    public void createTitle() {
        WebElement createTitleButton = waitForElementToBeClickable(By.xpath(createTitleButtonXpath));
        clickElement(createTitleButton);
        captureScreenshot("createTitle");
    }

    // Method to search for a title
    public void searchTitle(String title) {
        WebElement searchTextBox = waitForElementToBeClickable(By.xpath(searchXpath));
        WebElement goButtonWebElement = waitForElementToBeClickable(By.xpath(goButton));
        searchTextBox.clear();
        searchTextBox.sendKeys(title);
        Reporter.log("Searching for Title Value: " + title); // Log for debugging
        clickElement(goButtonWebElement);
        captureScreenshot("searchTitle_" + title);
    }

    // Method to toggle status from inactive to inactive
    public void inactiveToInactive() {
        WebElement activeToInactiveWebElement = waitForElementToBeClickable(By.xpath(inactiveToInactiveXpath));
        clickElement(activeToInactiveWebElement);
        captureScreenshot("inactiveToInactive");
    }

    // Method to toggle status from active to inactive
    public void activeToInactive() {
        WebElement activeToInactiveWebElement = waitForElementToBeClickable(By.xpath(activeToInactiveXpath));
        clickElement(activeToInactiveWebElement);
        captureScreenshot("activeToInactive");
    }
 
    // Method to delete the title
    public void deleteTitle() {
        WebElement deleteIconWebElement = waitForElementToBeClickable(By.xpath(deleteXpath));
        clickElement(deleteIconWebElement);
        captureScreenshot("deleteTitle");
    }

    // Method to check for successful save prompt
    public void titleDeletedMessage() {
        WebElement titlePromptPromptElement = waitForElementToBeVisible(By.xpath(titleXpatSuscess));
        Assert.assertTrue(titlePromptPromptElement.isDisplayed(), "Are you sure to Delete? not displayed");
        WebElement yesButtonWebElement = waitForElementToBeClickable(By.xpath(yesButtonXPath));
        clickElement(yesButtonWebElement);
        WebElement deletedSucessfulyPrompt = waitForElementToBeVisible(By.xpath(DeletedSucessfullyPromptXpath));
        clickElement(deletedSucessfulyPrompt);
        captureScreenshot("titleDeletedMessage");
    }

    // Method to verify title is in the list
    public void verifyTitleIsInTheList(String title) {
        String titleListXpath = titleListValueTemplate.replace("REPLACE", title);
        WebElement titleElement = waitForElementToBeVisible(By.xpath(titleListXpath));
        Assert.assertTrue(titleElement.isDisplayed(), "Title not found in the list: " + title);
        captureScreenshot("verifyTitleIsInTheList_" + title);
    }

    // Method to update the status to inactive
    public void updateWithInActiveStatus() {
        WebElement inUseElement = waitForElementToBeClickable(By.xpath(inUseXpath));
        clickElement(inUseElement);
        captureScreenshot("updateWithInActiveStatus");
    }

    // Method to select the save button and check for already existing data
    public void selectSaveAndAlreadyExist() {
        WebElement saveButton = waitForElementToBeClickable(By.xpath(saveButtonXpath));
        clickElement(saveButton);
        WebElement alreadyExistElement = waitForElementToBeVisible(By.xpath(alreadyExistXpath));
        clickElement(alreadyExistElement);
        Assert.assertTrue(alreadyExistElement.isDisplayed(), "Already Exist prompt not displayed");
        captureScreenshot("selectSaveAndAlreadyExist");
    }

    // Method to check for successful save prompt
    public void selectSavePrompt() {
        WebElement successPromptElement = waitForElementToBeVisible(By.xpath(xpathSuscess));
        Assert.assertTrue(successPromptElement.isDisplayed(), "Save Successful prompt not displayed");
        captureScreenshot("selectSavePrompt");
    }
 
    // Method to check for title required prompt
    public void titleIsRequired() {
        WebElement successPromptElement = waitForElementToBeVisible(By.xpath(xpathTitle));
        Assert.assertTrue(successPromptElement.isDisplayed(), "Title is required prompt not displayed");
        captureScreenshot("titleIsRequired");
    }

    // Method to check for not successful save prompt
    public void selectnotSavePrompt() {
        WebElement successPromptElement = waitForElementToBeVisible(By.xpath(xpathFailure));
        Assert.assertTrue(successPromptElement.isDisplayed(), "Not Saved Successfully prompt not displayed");
        captureScreenshot("selectnotSavePrompt");
    }
    
 // Method to check for not successful save prompt
    public void fieldValidation(String title) {
    	verifyTitleIsInTheList(title);
    }

    // Method to check for inactive prompt
    public void inActivePrompt() {
        WebElement successPromptElement = waitForElementToBeVisible(By.xpath(madeInActiveXpath));
        Assert.assertTrue(successPromptElement.isDisplayed(), "Inactive prompt not displayed");
        captureScreenshot("inActivePrompt");
    }

    // Method to check for updated successfully prompt
    public void updatedSuccessfullyMessage() {
        WebElement successPromptElement = waitForElementToBeVisible(By.xpath(udpateSuccessfullyXpath));
        Assert.assertTrue(successPromptElement.isDisplayed(), "Updated Successfully prompt not displayed");
        captureScreenshot("updatedSuccessfullyMessage");
    }

    // Method to select login
    public void selectLogin() {
        WebElement loginButton = waitForElementToBeClickable(By.xpath(loginButtonXpath));
        clickElement(loginButton);
        captureScreenshot("selectLogin");
    }

    // Method to enter username and password
    public void enterUsernameAndPassword(String username, String password) {
        WebElement usernameField = waitForElementToBeClickable(By.xpath(usernameXpath));
        WebElement passwordField = waitForElementToBeClickable(By.xpath(passwordXpath));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        captureScreenshot("enterUsernameAndPassword");
    }

    // Method to select save button
    public void selectSave() {
        WebElement saveButton = waitForElementToBeClickable(By.xpath(saveButtonXpath));
        clickElement(saveButton);
        captureScreenshot("selectSave");
    }

    // Method to select cancel button
    public void selectCancel() {
        WebElement cancelButtonWebElement = waitForElementToBeClickable(By.xpath(cancelButton));
        clickElement(cancelButtonWebElement);
        captureScreenshot("selectCancel");
    }

    // Method to select update button
    public void selectUpdate() {
        WebElement updateButtonWebElement = waitForElementToBeClickable(By.xpath(updateButton));
        clickElement(updateButtonWebElement);
        captureScreenshot("selectUpdate");
    }
    
    // Method to select edit icon
    public void selectEdit() {
        WebElement editIconWebElement = waitForElementToBeClickable(By.xpath(editIcon));
        clickElement(editIconWebElement);
        captureScreenshot("selectEdit");
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

    // Method to capture a screenshot
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
    
    
}
