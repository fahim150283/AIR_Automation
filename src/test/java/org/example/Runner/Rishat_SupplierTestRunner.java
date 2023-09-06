package org.example.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports-html/Rishat_Supplier.html",
                "json:target/cucumber-reports/Rishat_Supplier.json"},
        features = {"G:/Abul Hossain Chowdhury/Projects/Cucumber_For_AIR/src/test/resources/Features/Rishat_Supplier.feature"},
        glue = {"org.example.StepDefinitions"}
//        ,tags = "@regression" //it runs all the scenarios of the feature file that contains @regression
//        ,tags = "@google"  //it runs all the scenarios of the feature file that contains @google
//        ,tags = " @practice"  //it runs all the scenarios of the feature file that contains @google
)
public class Rishat_SupplierTestRunner extends AbstractTestNGCucumberTests {
}
