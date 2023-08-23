package org.example.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports-html/Complementary_Invoice.html",
                "json:target/cucumber-reports/Complementary_Invoice.json"},
        features = {"G:/Abul Hossain Chowdhury/Projects/Cucumber_For_AIR/src/test/resources/Features/Complementary_Invoice.feature"},
        glue = {"org.example.StepDefinitions"}
//        ,tags = "@regression" //it runs all the scenarios of the feature file that contains @regression
//        ,tags = "@google"  //it runs all the scenarios of the feature file that contains @google
//        ,tags = " @practice"  //it runs all the scenarios of the feature file that contains @google
)

public class Complementary_InvoiceTestRunner extends AbstractTestNGCucumberTests {
}
