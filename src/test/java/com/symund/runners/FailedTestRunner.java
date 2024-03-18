package com.symund.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * This class serves as a runner for failed Cucumber test scenarios.
 */
@RunWith(Cucumber.class)
@CucumberOptions(

        // Specifies the location of the failed test scenarios list
        features = "@target/rerun.txt",

        // Specifies the package where step definitions are located
        glue= "com/symund/step_definitions"

)
public class FailedTestRunner {
}
