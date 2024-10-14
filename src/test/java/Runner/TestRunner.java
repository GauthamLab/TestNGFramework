package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import stepDefinitions.WebDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "stepDefinitions"},
        plugin = { "pretty", "html:target/cucumber-reports", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
        monochrome = true,
        publish = true,
        tags = "@projectPulseProject"
)
public class TestRunner extends AbstractTestNGCucumberTests {

//    @BeforeClass
//    public void setup() {
//        WebDriverSingleton.getDriver();  // Initialize the driver
//    }/
//
//    @AfterClass
//    public void tearDown() {
//        WebDriverSingleton.closeDriver();  // Close the driver
//    }
//
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
   // }
}
