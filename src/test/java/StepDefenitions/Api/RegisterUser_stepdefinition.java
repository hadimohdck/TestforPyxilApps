package StepDefenitions.Api;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.ExtentReportSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RegisterUser_stepdefinition {
	
	public Response response;
	
	
	@When("^I hit the endpoint with (.+),(.+) and (.+)$")
	public void createuser(String username,String email,String password) {
		
		 // Base URL of the API
        String baseUrl = "https://practice.expandtesting.com/notes/api";

        // API endpoint for the POST request
        String endpoint = "/users/register";

        // Request headers using a Map
       Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
         // Replace with your actual access token

        // Request body in Map format
        Map<String, Object> requestBody = new HashMap<>();
       requestBody.put("name", username);
       requestBody.put("email", email);
        requestBody.put("password", password);
        response = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(endpoint)
                .contentType(ContentType.JSON).
                headers(headers).body(requestBody)
                .post();
		
	}
	
	@Then("^registration returns (.+)$")
	public void i_verify_the(String expectedResponseCode) {
		ExtentTest test = ExtentReportSetup.getTest();
	    String code=""+response.getStatusCode();
	    if(code.equalsIgnoreCase(expectedResponseCode)) {
	    	test.log(Status.PASS, "The test passed with response code :"+code+" and response body "+response.asPrettyString());// Write code here that turns the phrase above into concrete actions
		     	 }
	    else
	    	{test.log(Status.FAIL, "The test passed with response code :"+code+" and response body "+response.asPrettyString());// Write code here that turns the phrase above into concrete actions
	    	Assert.fail();}
	    // Write code here that turns the phrase above into concrete actions
	    
	}

}
