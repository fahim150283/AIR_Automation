package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;


public class Dashboard extends Page_Options {

    @Given("^login for accessing dashboard$")
    public void dashboard() {
        url = "http://192.168.11.182/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);
    }

    @When("^click the Dashboard$")
    public void clickDashboard() {
        cssSelector = ".active:nth-child(2) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @Then("^Close Driver for dashboard$")
    public void closeDriver() throws InterruptedException {
        closedriver();
    }
}