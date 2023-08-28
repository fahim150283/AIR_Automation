package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class CancelInvoice extends Page_Options {
    @Given("Login to Search cancelled Invoice")
    public void login_to_search_cancelled_invoice() {
        Login("h.abul");

        cssSelector = ".menues-bar:nth-child(6) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for cancelled Invoice")
    public void search_for_cancelled_invoice() throws InterruptedException {
        xpath = "//*[@id=\"search_input\"]";
        waitByxpath(xpath);
        inputbyxpath(xpath, "SI-00000004");
//        Thread.sleep(1000);
    }

    @And("description of a cancelled Invoice")
    public void description_of_a_cancelled_invoice() {
        id = "btn_view";
        waitById(id);
        clickbyId(id);
    }

    @Then("close cancelled Invoice for search")
    public void close_cancelled_invoice_for_search() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }

    @Given("login for cancellation of an Invoice")
    public void login_for_cancellation_of_an_invoice() {
        Login("h.abul");

        cssSelector = ".menues-bar:nth-child(6) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @And("create new cancel Invoice")
    public void create_new_cancel_invoice() {
        //click the plus button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[4]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //date
        xpath = "//*[@id=\"c_actual_inv_date\"]";
        waitByxpath(xpath);
        inputbyxpath(xpath, getToday());

        //order list
        xpath = "//*[@id=\"select2-invoice_list-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        //search for bhai bhai and hit enter
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "bhai bhai");
        cssSelectorPressEnter(cssSelector);

        //select the store
        id = "select2-c_store_id-container";
        waitById(id);
        clickbyId(id);

        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "bogura depot");
        cssSelectorPressEnter(cssSelector);

        //important notes
        id = "c_notes";
        inputbyid(id, "Automated Test");

        //save
        id = "add_region";
        waitById(id);
        clickbyId(id);

        AlertAccept();
    }

    @Then("close the cancel Invoice window")
    public void close_the_cancel_invoice_window() throws InterruptedException {
        Thread.sleep(1500);
        closedriver();
    }
}
