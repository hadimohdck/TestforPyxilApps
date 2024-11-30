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

public class UpdateNote {
	
	public Response response;

	@When("^(.+) user updates a note with id : (.+) title : (.+) for a note in category : (.+) , completed status : (.+) and with description:  (.+)$")
	public void Update_note(String validuser, String id,String title, String category, String completed_status,String description) {

		String baseUrl = "https://practice.expandtesting.com/notes/api";

		// API endpoint for the POST request
		String endpoint = "/notes/"+id;

		// Request headers using a Map
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		if (validuser.equalsIgnoreCase("y")) {
			headers.put("x-auth-token", "c356403d1f354b4c93e5334aa98ed8365d3f72a86c1d460b8c3f1e978b15be5c");
		}
		// Replace with your actual access token

		// Request body in Map format
		Map<String, Object> requestBody = new HashMap<>();
		
		requestBody.put("title", title);
		requestBody.put("category", category);
		requestBody.put("completed", completed_status);
		requestBody.put("description", description);
		

		ExtentTest test = ExtentReportSetup.getTest();
		test.log(Status.INFO, "request body : " + requestBody);

		response = RestAssured.given().baseUri(baseUrl).basePath(endpoint).contentType(ContentType.JSON)
				.headers(headers).body(requestBody).put();

	}
	@Then("^Update note returns (.+)$")
	public void UpdateNotereturns(String expectedResponseCode) {
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
