

package stepDefinitions;

import org.junit.Assert;

import base.Utility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;

public class stepDefination extends Utility {

	
	public  String URI = "https://api.ratesapi.io/api/latest";
	public int actualStatusCode;

	
	@Given("^Latest Foreign Exchange rates for Rates API$")
	public void ratesapi() throws Throwable {
		System.out.println(" API endpoint:" + URI);

		// Specifying URI to test
		RestAssured.baseURI = URI;
		httpRequest = RestAssured.given();
		
		// stored the value in response object
		response = httpRequest.get();

		// Verified the actual status
		actualStatusCode = response.getStatusCode();

		// asserting the actual and expected value
		Assert.assertEquals(200, actualStatusCode);

		System.out.println("API response: " + response.asString());
	}

	@When("^The API is available as \"([^\"]*)\"$")
	public void Endpointvalue(String endPoint) throws Throwable {
		System.out.println("trigger the API with url " + endPoint + " and get the response");

		// Specifying URI to test with end-point
		RestAssured.baseURI = URI+endPoint;
		httpRequest = RestAssured.given();

		System.out.println("URI with endpoint: " + RestAssured.baseURI);
	}

	
	@Then("^API Should respond with status code as (\\d+)$")
	public void getStatusCode(int expectedStatusCode) throws Throwable {
		// Verified the actual status code
		actualStatusCode = response.getStatusCode();

		// asserting the actual and expected value
		Assert.assertEquals(expectedStatusCode, actualStatusCode);

		System.out.println("Response : " + expectedStatusCode);
	}

	
	@Then("^API should give sucessful response as \"([^\"]*)\"$")
	public void getvalidateresponse(String expectedResponseValue) throws Throwable {
		System.out.println("response code :");

		// stored the response body
		body = response.getBody();

		// stored the Response body as a String.
		bodyAsString = body.asString();

		// asserting the actual and expected value
		Assert.assertEquals(bodyAsString.contains(expectedResponseValue), true);
		System.out.println(" Expected response : " + expectedResponseValue);
	}

	@Then("^Invalid error Message as \"([^\"]*)\"$")
	public void InvalidErrorMessage(String expectedErrorMessage) throws Throwable {
		System.out.println(" Invalid error message for incorrect/incomplete endpoint");

		// stored the response in body
		body = response.getBody();

		// stored body as String.
		bodyAsString = body.asString();

		// asserting the actual and expected value
		Assert.assertEquals(bodyAsString.contains(expectedErrorMessage), true);
	System.out.println(" Invalid Error message: " + expectedErrorMessage);
	}

	@Then("^API should return the current date rates$")
	public void getvalidateDate() throws Throwable {
		System.out.println(" Validate the current Date with future Date");
		FutureDate();
	}
}
