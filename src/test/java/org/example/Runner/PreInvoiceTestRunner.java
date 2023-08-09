package org.example.Runner;

import io.cucumber.java.en.Given;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.example.Page_Options;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports-html/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"},
        features = {"G:/Abul Hossain Chowdhury/Projects/Cucumber_For_AIR/src/test/resources/Features/PreInvoice.feature"},
        glue = {"org.example.StepDefinitions"}
//        ,tags = "@regression" //it runs all the scenarios of the feature file that contains @regression
//        ,tags = "@google"  //it runs all the scenarios of the feature file that contains @google
//        ,tags = " @practice"  //it runs all the scenarios of the feature file that contains @google
)
public class PreInvoiceTestRunner extends AbstractTestNGCucumberTests {

}
