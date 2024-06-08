package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features", glue = { "crm.stepdef" }, plugin = { "pretty",
		"html:target/cucumber-reports", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true, publish = true,tags="@addMaster")
public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	//@DataProvider(parallel = true)
	@DataProvider()
	public Object[][] scenarios() {
		return super.scenarios();

	}
}
