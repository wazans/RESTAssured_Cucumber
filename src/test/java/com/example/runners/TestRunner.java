package com.example.runners;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/test/resources/features" ,// Path to your feature files
                //glue =  {"com.example.stepdefinitions","com.example.hooks"}, // Package containing your step definitions and hook
                glue =  {"com.example.stepdefinitions"},
                tags = "@post" // Tags to filter scenarios
//                dryRun =  true,
//                        // Enable dryRun , When set to true,
//                                // Cucumber will check for missing step definitions but won’t execute the scenarios.
//                strict = true  // Fail the test suite if there are undefined or pending steps
        )
public class TestRunner {
}

