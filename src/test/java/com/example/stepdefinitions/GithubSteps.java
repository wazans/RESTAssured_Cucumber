package com.example.stepdefinitions;

import com.example.Utils.RequestBodyUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class GithubSteps {

    public Response response;
    public String requestBody;


    @Given("user has valid git credentials to access git hub URI")
    public void userHasValidGitCredentialsToAccessGitHubURI() {
        RestAssured.baseURI = "http://localhost:3000/";
    }



    @When("i request to create new details")
    public void iRequestToCreateNewDetails() {
        requestBody = RequestBodyUtils.createRequestBodyForIPL();
        response =  given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("http://localhost:3000/top-scorers");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
    }



    @Then("player {} should have an average of {}")
    public void playerShouldHaveAnAverageOf(String player, double expectedAverage) {
        // Fetch the average for the given player
        double actualAverage = response.jsonPath().getDouble("find { it.player == '" + player + "' }.average");

        // Assert the actual average matches the expected average
        Assert.assertEquals("Average for player " + player + " did not match", expectedAverage, actualAverage);

    }
}
