package com.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {

    @Before
    public void setUp() {
        // Code to set up the test environment
        RestAssured.baseURI = "http://localhost:3000";
        System.out.println("Setup before each scenario");
    }

    @After
    public void tearDown() {
        // Code to clean up after each scenario
        System.out.println("Cleanup after each scenario");
    }
}
