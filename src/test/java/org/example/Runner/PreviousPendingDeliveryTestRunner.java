package org.example.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports-html/PreviousPendingDelivery.html",
                "json:target/cucumber-reports/PreviousPendingDelivery.json"},
        features = {"G:/Abul Hossain Chowdhury/Projects/Cucumber_For_AIR/src/test/resources/Features/PreviousPendingDelivery.feature"},
        glue = {"org.example.StepDefinitions"}
//        ,tags = "@regression" //it runs all the scenarios of the feature file that contains @regression
//        ,tags = "@google"  //it runs all the scenarios of the feature file that contains @google
//        ,tags = " @practice"  //it runs all the scenarios of the feature file that contains @google
)
public class PreviousPendingDeliveryTestRunner extends AbstractTestNGCucumberTests {
}
