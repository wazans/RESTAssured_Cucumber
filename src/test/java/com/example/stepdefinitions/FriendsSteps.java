package com.example.stepdefinitions;

import com.example.Utils.RequestBodyUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

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
        String fullUrl = RestAssured.baseURI + endpoint;
        httpRequest = given();
        response = httpRequest.get(endpoint);
        if (response != null) {
            System.out.println("Request URL: " + fullUrl);
            System.out.println("Response Body: " + response.getBody().asString());
        } else {
            System.out.println("Response is null");
        }
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
        Assert.assertEquals(responseCode, actualResponseCode);
    }

    @And("the response should contain a list of friends")
    public void theResponseShouldContainAListOfFriends() {
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        responseBody.contains("");
    }
}
