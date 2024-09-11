package com.example.stepdefinitions;

import com.example.Utils.RequestBodyUtils;
import com.example.Utils.RequestBodyUtils_CallingPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class FriendsSteps {
    private RequestSpecification httpRequest;
    private Response response;
    private String requestBody;

    @Given("the API is available")
    public void theApiIsAvailable() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @When("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
       Response resp=given().when().get("friends").then().extract().response();
    }

    @When("I send a POST request to {string} with the body from {string}")
    public void iSendAPostRequestToWithTheBodyFrom(String endpoint, String bodyFilePath) throws IOException {
        requestBody = RequestBodyUtils.createRequestBodyForFriends();
        String fullUrl = RestAssured.baseURI + endpoint;
        response = given()
                .contentType("application/json")
                .body(requestBody)
                .post(endpoint);
        if (response != null) {
            System.out.println("Request URL: " + fullUrl);
            System.out.println("Request Body: " + requestBody);
            System.out.println("Response Body: " + response.getBody().asString());
        } else {
            System.out.println("Response is null");
        }
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int responseCode) {
        int actualResponseCode = response.getStatusCode();
        System.out.println("Actual Response Code: " + actualResponseCode);
        assertEquals(responseCode, actualResponseCode);
    }

    @And("the response should contain a list of friends")
    public void theResponseShouldContainAListOfFriends() {
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        responseBody.contains("");
    }

    @When("I send a POST request with the help of JSON  to {string}")
    public void iSendAPOSTRequestWithTheHelpOfJSONTo(String endpoint) throws JsonProcessingException {
        String requestbody_with_pojo= RequestBodyUtils_CallingPOJO.CreateBodyForFriend_withPojo();
        response=given().contentType("application/json").body(requestbody_with_pojo).post(endpoint);

    }

    @Then("the response should contain first_name post_with_json_shcema to {string}")
    public void theResponseShouldContainFirst_namePost_with_json_shcemaTo(String endpoint) throws JsonProcessingException {
        String requestbody_with_pojo= RequestBodyUtils_CallingPOJO.CreateBodyForFriend_withPojo();
        // 1. Perform operation
        response=RestAssured.given().when().contentType("application/json").body(requestbody_with_pojo).post(endpoint);

        // 2. extract response
        response.then()
                .assertThat()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("friends_schema.json"))
                .body("firstname", equalTo("post_with_json_shcema"))
                .extract().response();

        // 3. Extract JSONPath object from the response
        JsonPath jsonpath=response.jsonPath();

        // 4. Find the user with id "1" and assert their firstname
        String firstname=jsonpath.getString("find { it.id=='1'}.firstname");
        assertEquals("John", firstname, "Firstname for id 1 should be John");

        //To perform an assertion that verifies the JSON response where the id is "1" and the firstname is "John"

        Response response = (Response) RestAssured.given()
                .contentType("application/json")
                .auth()
                .preemptive()
                .oauth2("ds")
                .body(requestbody_with_pojo)
                .post(endpoint)
                .then()
                .assertThat()
                .statusCode(201)
                .body("find { it.id == '1' }.firstname", equalTo("John"));




    }

    @Then("we perform so basic Assertions")
    public void wePerformSoBasicAssertions(String endpoint) throws JsonProcessingException {

        String requestbody_with_pojo= RequestBodyUtils_CallingPOJO.CreateBodyForFriend_withPojo();
//        response.then().assertThat().statusCode(201).
//                                        body("name",notNullValue()).body("");

    }
}