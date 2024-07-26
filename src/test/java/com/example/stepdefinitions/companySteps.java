package com.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public class companySteps {
    public RequestSpecification httpRequest;
    public Response response;
    public String requestBody;

    @Given("I have the valid details to access the company api end point")
    public void iHaveTheValidDetailsToAccessTheCompanyApiEndPoint() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @When("I send a GET request to company end point")
    public void iSendAGETRequestToCompanyEndPoint() {
        httpRequest = given();
        response = httpRequest.get("/company");
    }

    @And("response body should contain valid details")
    public void responseBodyShouldContainValidDetails() {
        System.out.println(response.getBody().asString());
    }

    @Then("I should recieve a response code as {int}")
    public void i_should_recieve_a_response_code_as(Integer response_code) {
        int actualResponseCode = response.getStatusCode();
        System.out.println("Actual Response Code: " + actualResponseCode);
        Assert.assertEquals((int)response_code, actualResponseCode);

    }



    @Given("I have the valid details to create a new company")
    public void iHaveTheValidDetailsToCreateANewCompany() {
        RestAssured.baseURI = "http://localhost:3000";

    }


    @Then("response body should contain id {} for project {}")
    public void responseBodyShouldContainIdForProject(String id, String project) {
        // Extract the project name for the given id within the departments
        String actualProject = response.jsonPath()
                .getString("departments.management.find { it.id == '" + id + "' }.project");

        Assert.assertEquals(project, actualProject);
    }

    @When("I send a POST request to {string} end point")
    public void iSendAPOSTRequestToEndPoint(String endpoint) {
        String requestBody_for_comp = """
                {
                  "name": "examplecorp",
                  "employees": [
                    {
                      "id": "1",
                      "name": "John Doe",
                      "role": "Engineer",
                      "contact": {
                        "email": "john.doe@example.com",
                        "phone": "555-1234"
                      }
                    },
                    {
                      "id": "2",
                      "name": "Jane Smith",
                      "role": "Manager",
                      "contact": {
                        "email": "jane.smith@example.com",
                        "phone": "555-5678"
                      }
                    }
                  ],
                  "departments": {
                    "engineering": [
                      {
                        "id": "1",
                        "project": "Project Alpha"
                      },
                      {
                        "id": "2",
                        "project": "Project Beta"
                      }
                    ],
                    "management": [
                      {
                        "id": "3",
                        "project": "Project Gamma"
                      }
                    ]
                  }
                }
                """;
        response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody_for_comp)
                .post(endpoint);
        System.out.println("Sending POST request to: " + endpoint);

    }
}
