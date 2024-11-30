package StepDefenitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.ecommerceLandingPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ecommercenetifyStepDefinition {
	
	
	public WebDriver driver;
	public TestContextSetup ts;
	
	public ecommerceLandingPage ep;
	
	public ecommercenetifyStepDefinition(TestContextSetup ts)
	{
		
		this.ts=ts;
		this.ep=ts.pom.getecommerceLandingPage();
		
		
	}
	@Given("User is on Ecommerce landing page")
	public void user_is_on_Ecommerce_landing_page() throws InterruptedException {
	    
	    Thread.sleep(5000);
	    Assert.assertTrue(ep.gettitleofPage().contains("Freshness"));
//	    
	    }
	
	@When("User clicks on add button")
	public void user_clicks_on_add_button() throws InterruptedException {
		
		this.ep.addproduct();
		Thread.sleep(2000);
		this.ep.filldetails();
		Thread.sleep(5000);
		this.ep.CreateProduct();
		Thread.sleep(10000);
	}
	
	@Then("Product is added successfully")
	public void product_is_added_succesfully() throws InterruptedException{
		
		Assert.assertTrue(this.ep.checkcreatedproductpresent());
		Thread.sleep(3000);
	}
	
	@Then("User edits the product")
	public void user_edits_the_prodduct()throws InterruptedException{
		this.ep.editproductdetails();
		Thread.sleep(10000);
	}
	
	@Then("User edit is successful")
	public void user_edit_is_succesful()throws InterruptedException{
		Assert.assertTrue(this.ep.checkeditedproductpresent());
	}
	
	
	@Then("User deletes a product")
	public void user_deletes_a_product()throws InterruptedException{
		this.ep.deletecreatedproduct();
		Thread.sleep(5000);
	}
	
	@Then("User deletion is successful")
	public void user_delete_is_successful() throws InterruptedException{
		Assert.assertFalse(this.ep.checkdeletedproductpresent());
		Thread.sleep(3000);
	}
	
	@Then("User searches a product and search is successful")
	public void user_searches_a_product() throws InterruptedException{
		this.ep.entersearchtext();
		Thread.sleep(7000);
		Assert.assertTrue(this.ep.verifyresult());
		
	}
}
