package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class DistributorInvoices extends Page_Options {
    @Given("Login to Search Invoice")
    public void login_to_search_invoice() {
        url = "http://192.168.11.182/air_2/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);

        cssSelector = ".menues-bar:nth-child(11) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @When("search for Invoice")
    public void search_for_invoice() {
        xpath = "//*[@id=\"inv_tableData_filter\"]/label/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, "SO-00000011");
    }
    @And("description of an Invoice")
    public void description_of_an_invoice() {

    }
    @Then("close Invoice for search")
    public void close_invoice_for_search() {

    }
}
