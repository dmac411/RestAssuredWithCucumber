package stepDefs;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDStepDefs {

	Response response;
	RequestSpecification request;
	Map<String, Object> mapObj;

	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {
		// Write code here that turns the phrase above into concrete actions

		request = RestAssured.given().baseUri(URI);
	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
		// Write code here that turns the phrase above into concrete actions

		response = request.get();

	}
	@When("I create a new employee with name {string} and salary {string}")
	public void i_create_a_new_employee_with_name_and_salary(String name, String salary) 
	{
	    // Write code here that turns the phrase above into concrete actions
	 
		mapObj = new HashMap<String, Object>();
		mapObj.put("name", name);
		mapObj.put("salary", salary);
		
		
	}

	@When("I perform a Post operation")
	public void i_perform_a_Post_operation() {
	    // Write code here that turns the phrase above into concrete actions
		
		response = request.given().contentType(ContentType.JSON).accept(ContentType.JSON)
		        .body(mapObj).post("create");
		
		
		
		//response = 	
			//	request.contentType(ContentType.JSON)
				//.accept(ContentType.JSON)
				//.body(mapObj)
				//.when()
				//.post("employees/create")	;
				
	}
	
	

	// change to int expResponseCode
	@Then("Response code should be {int}")
	public void response_code_should_be(int expResponseCode) {
		// Write code here that turns the phrase above into concrete actions

		Assert.assertEquals(expResponseCode, response.getStatusCode());
	}

}
