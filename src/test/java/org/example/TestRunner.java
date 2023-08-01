package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-reports-html/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"},
        features = {"G:/Abul Hossain Chowdhury/Projects/Ultimate_Cucumber_learning/src/test/resources/Features"},
        glue = {"org.example.StepDefinitions"},
        tags = "@regression" //it runs all the scenarios of the feature file that contains @regression
//        tags = "@google"  //it runs all the scenarios of the feature file that contains @google
//        tags = " @practice"  //it runs all the scenarios of the feature file that contains @google
)

public class TestRunner extends AbstractTestNGCucumberTests {

}

