package crmp.org.util;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class dataHelper {
	

    public static Map<String, Map<String, String>> getExcelData(String filePath, String sheetName) throws IOException {
        Map<String, Map<String, String>> data = new HashMap<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();

        Iterator<Row> rowIterator = sheet.iterator();
        Row headerRow = rowIterator.next(); // Assuming the first row is the header row
        String[] headers = new String[headerRow.getPhysicalNumberOfCells()];
        for (int i = 0; i < headers.length; i++) {
            headers[i] = formatter.formatCellValue(headerRow.getCell(i));
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Map<String, String> rowData = new HashMap<>();
            for (int i = 0; i < headers.length; i++) {
                rowData.put(headers[i], formatter.formatCellValue(row.getCell(i)));
            }
            data.put(rowData.get("TestCaseId"), rowData);
        }
        workbook.close();
        fis.close();
        return data;
    }

    
    public static void captureScreenshot(String  fileName, WebDriver driver) {
    	
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
    public void waitForElementToBeVisibleAndInteract(By locator, String textToSend, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        element.sendKeys(textToSend);
    }
 
 // Helper method to wait for page load, wait for element to be visible, click using JS, and send text
    public static void waitForElementToBeVisibleAndInteractUsingJS(By locator, String textToSend, WebDriver driver) {
        // Wait for the page to be fully loaded
        new WebDriverWait(driver, Duration.ofSeconds(200)).until(
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
        element.clear();
        element.sendKeys(textToSend);
        element.sendKeys(Keys.TAB);
    }
    public void waitForElementToBeVisibleAndInteractUsingJSTabKey(By locator, String textToSend, WebDriver driver) throws InterruptedException {
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
      //  element.clear();
       // element.sendKeys(textToSend);
        element.sendKeys(Keys.TAB);
        element.sendKeys(Keys.ENTER);
       // element.wait(10000);
    }


 // Helper method to wait for an element to be clickable
    public WebElement waitForElementToBeClickable(By locator,WebDriver driver ) {
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
    public static void waitForElementAndClickUsingJS(By locator, WebDriver driver) {
        // Wait for the page to be fully loaded
        try {
			new WebDriverWait(driver, Duration.ofSeconds(300)).until(
			    webDriver -> ((JavascriptExecutor) webDriver)
			        .executeScript("return document.readyState")
			        .equals("complete")
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Wait for the element to be present in the DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        
        // Use JavaScript Executor to click the element
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public static void waitForElementToBeVisibleAndClick(By locator, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }

    // Helper method to wait for an element to be visible
    public WebElement waitForElementToBeVisible(By locator, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Helper method to click an element
    public static void clickElement(WebElement element, WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    
    
//    public MasterPage(WebDriver driver)
//	{
//		this.driver = driver;
//		
//	}
	
	
}
