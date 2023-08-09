package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class Contacts extends Page_Options {

    @Given("^login for accessing Contacts$")
    public void contacts() {
        url = "http://192.168.11.182/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);
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
