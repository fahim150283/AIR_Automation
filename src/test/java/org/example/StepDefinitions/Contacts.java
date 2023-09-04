package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class Contacts extends Page_Options {

    @Given("^login for accessing Contacts$")
    public void contacts() {
        Login(user_Fahim);
    }

    @When("search for employee")
    public void search_for_employee() {
        id = "search";
        waitById(id);
        tempName = "Abul Hossain";
        inputbyid(id,tempName);
    }

    @Then("^close Contacts$")
    public void close() throws InterruptedException {
        closedriver();
    }

}
