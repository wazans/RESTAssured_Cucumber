package com.example.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// Focus
// Grow
// Thrive
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = {"com.example.stepdefinitions"}, // Package containing your step definitions
        tags = "@profile1", // Tags to filter scenarios
        plugin = {"pretty", "json:target/cucumber-report.json", "html:target/cucumber-report_wasim99.html"}// Report plugins
        //strict = false // Fail the test suite if there are undefined or pending steps
)
public class TestRunner {
}