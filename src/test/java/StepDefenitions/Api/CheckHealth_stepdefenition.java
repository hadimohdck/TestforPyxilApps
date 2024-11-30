package StepDefenitions.Api;

import static org.testng.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import Utils.ExtentReportSetup;

public class CheckHealth_stepdefenition {
	public Response response;
	@Given("^the test case id is (.+)$")
	public void tco1(String testid) {
		 ExtentTest test = ExtentReportSetup.getTest();
	        test.log(Status.INFO, "Executing Test Case :"+testid);// Write code here that turns the phrase above into concrete actions
	    
	}
	@When("I hit the health check endpoint")
	public void i_hit_the_endpoint_with_hai_and() {
		
		 // Base URL of the API
        String baseUrl = "https://practice.expandtesting.com/notes/api";

        // API endpoint for the POST request
        String endpoint = "/health-check";

        // Request headers using a Map
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//         // Replace with your actual access token
//
//        // Request body in Map format
//        Map<String, Object> requestBody = new HashMap<>();
//        requestBody.put("username", username);
//        requestBody.put("password", password);
        response = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(endpoint)
                .contentType(ContentType.JSON)
                .get();
        // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("^I verify the (.+)$")
	public void i_verify_the(String expectedResponseCode) {
		ExtentTest test = ExtentReportSetup.getTest();
	    String code=""+response.getStatusCode();
	    if(code.equalsIgnoreCase(expectedResponseCode)) {
	    	test.log(Status.PASS, "The test passed with response code :"+code+" and response body "+response.asPrettyString());// Write code here that turns the phrase above into concrete actions
		     	 }
	    else
	    	{test.log(Status.FAIL, "The test failed with response code :"+code+" and response body "+response.asPrettyString());// Write code here that turns the phrase above into concrete actions
	    	Assert.fail();}
	    // Write code here that turns the phrase above into concrete actions
	    
	}

}
