package StepDefenitions.Api;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.ExtentReportSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateProfile {
	
	public Response response;
	
	@When("^(.+) provides (.+),(.+) and (.+)$")
	public void update_profile(String validuser,String username,String phone,String company){
		
		 String baseUrl = "https://practice.expandtesting.com/notes/api";

	        // API endpoint for the POST request
	        String endpoint = "/users/profile";

	        // Request headers using a Map
	       Map<String, String> headers = new HashMap<>();
	        headers.put("Content-Type", "application/json");
	        if(validuser.equalsIgnoreCase("y")) {
	        headers.put("x-auth-token","c356403d1f354b4c93e5334aa98ed8365d3f72a86c1d460b8c3f1e978b15be5c");}
	         // Replace with your actual access token

	        // Request body in Map format
	        Map<String, Object> requestBody = new HashMap<>();
	       requestBody.put("name", username);
	        requestBody.put("phone", phone);
	        requestBody.put("company", company);
	        ExtentTest test = ExtentReportSetup.getTest();
	        test.log(Status.INFO, "request body : "+ requestBody);
	        
	        response = RestAssured.given()
	                .baseUri(baseUrl)
	                .basePath(endpoint)
	                .contentType(ContentType.JSON).
	                headers(headers).body(requestBody).patch();
		
		
	}
	
	@Then("^update returns (.+)$")
	public void Loginreturns(String expectedResponseCode) {
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
