package com.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Assert.*;

public class comments {
    RequestSpecification httprequest;
    Response response;
    ResponseBody body;
    @Given("I have the valid details to access the comments api end point")
    public void iHaveTheValidDetailsToAccessThecommentsApiEndPoint() {
        RestAssured.baseURI = "http://localhost:3000";

    }

    @When("I paas the url of the comments API in the request")
    public void i_paas_the_url_of_the_comments_api_in_the_request() {
        //This line initializes a RequestSpecification object named httprequest =object calls given() method from the RestAssured class
        //RequestSpecification httprequest=RestAssured.given();
        /*RequestSpecification-Interface & RestAssured class that implements given method of RequestSpecification-Interface
         */
        httprequest=RestAssured.given();

        //Response response=httprequest.get("/comments");
        response=httprequest.get("/comments");

    }



    @And("the comment with id {} should have body {string}")
    public void theCommentWithIdShouldHaveBody(String commentId, String expectedBody) {
        String actualBody = response.jsonPath().getString("find { it.id == '" + commentId + "' }.body");
        //{ it.id == id }.email
        System.out.println("Actual Body: " + actualBody);
        Assert.assertEquals(expectedBody, actualBody);
    }
}
