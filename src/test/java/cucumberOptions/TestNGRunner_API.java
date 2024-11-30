package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/Api",glue={"StepDefenitions.Api"},monochrome=true,tags="@RunALLAPITests",plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_screenshot.txt"})
public class TestNGRunner_API extends AbstractTestNGCucumberTests{
	
		@Override
		@DataProvider(parallel=false)
		public Object[][] scenarios(){
			
			return super.scenarios();		}

}