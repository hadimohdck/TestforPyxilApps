package StepDefenitions.Api;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import Utils.ExtentReportSetup;

public class Hooks {

	

	public Hooks() {
		

	}
	 @Before
	    public void setup(Scenario scenario) {
	        ExtentReports extent = ExtentReportSetup.getExtent();
	        ExtentTest test = extent.createTest(scenario.getName());
	        ExtentReportSetup.setTest(test);
	    }

	  @After
	    public void tearDown(Scenario scenario) {
	        ExtentReports extent = ExtentReportSetup.getExtent();
	        ExtentTest test = ExtentReportSetup.getTest();

	        if (scenario.isFailed()) {
	            test.log(Status.FAIL, "Scenario failed.");
	        } else {
	            test.log(Status.PASS, "Scenario passed.");
	        }

	        extent.flush();
	    }}


