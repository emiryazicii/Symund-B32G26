package com.symund.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * JUnit runner class for executing Cucumber tests.
 */
@RunWith(Cucumber.class)
@CucumberOptions(

        // Add any desired plugins for reporting here
        plugin = {

                // Generates HTML reports in the specified directory
                "html:target/cucumber-reports.html",

                // Generates rerun file in the specified directory
                "rerun:target/rerun.txt",

                // Enables Allure reporting
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",

                // Generates JSON report for Cucumber results in the specified directory
                "json:target/cucumber.json"
        },

        // Specifies the location of feature files
        features = "src/test/resources/features",

        // Specifies the package where step definitions are located
        glue = "com/symund/step_definitions",

        // Whether to execute a dry run of the feature files
        dryRun = false,

        // Specifies the tags to include/exclude specific scenarios or features
        tags = "",

        // Whether to publish the results
        publish = true

)
public class CukesRunner {
}
