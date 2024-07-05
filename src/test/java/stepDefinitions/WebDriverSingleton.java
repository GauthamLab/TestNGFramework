package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSingleton {
	
	 private static WebDriver driver;

	    private WebDriverSingleton() {
	        // private constructor to prevent instantiation
	    }

	    public static WebDriver getDriver() {
	        if (driver == null) {
	            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        }
	        return driver;
	    }

	    public static void closeDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }

}
