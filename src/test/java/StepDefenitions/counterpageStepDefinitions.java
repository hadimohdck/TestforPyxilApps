package StepDefenitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import PageObjects.counterpage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class counterpageStepDefinitions {
	
	public WebDriver driver;
	public TestContextSetup ts;
	
	public counterpage cp;
	
	public counterpageStepDefinitions(TestContextSetup ts)
	{
		this.ts=ts;
		this.cp=ts.pom.getcounterpage();	
	}
	
	@Given("User clicks on plus button and verifies counter")
	public void user_clicks_on_plus_button() throws InterruptedException {
		Thread.sleep(15000);


		this.cp.clickonplusbutton();
	}



}
