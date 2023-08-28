package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;


public class Dashboard extends Page_Options {

    @Given("^login for accessing dashboard$")
    public void dashboard() {
        Login("h.abul");
    }

    @When("^click the Dashboard$")
    public void clickDashboard() {
        cssSelector = ".active:nth-child(2) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
        switchTab();
        scrollToTheBottom();
    }

    @Then("^Close Driver for dashboard$")
    public void closeDriver() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }
}