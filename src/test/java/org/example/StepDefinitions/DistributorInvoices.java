package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class DistributorInvoices extends Page_Options {
    @Given("Login to Search Invoice")
    public void login_to_search_invoice() {
        Login(user_Fahim);

        cssSelector = ".menues-bar:nth-child(13) .active";
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
        id = "btn_view";
        waitById(id);
        clickbyId(id);
    }

    @Then("close Invoice for search")
    public void close_invoice_for_search() throws InterruptedException {
        Thread.sleep(1500);
        closedriver();
    }


    @Given("login for Invoice")
    public void login_for_invoice() {
        Login(user_Fahim);

        cssSelector = ".menues-bar:nth-child(13) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("create new Invoice")
    public void create_new_invoice() {
        //click the create new button
        xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //set date
        xpath = "//*[@id=\"c_actual_inv_date\"]";
        waitByxpath(xpath);
        inputbyxpath(xpath, getToday());

        //order list
        xpath = "//*[@id=\"select2-order_list-container\"]";
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

        //notes
        id = "c_notes";
        inputbyid(id, "Automated Test");

        //select the quantity
        //partial  or full
        Boolean fullCancel = false;
        if (fullCancel == false) {
            xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[5]/input";
            waitByxpath(xpath);
            clearByXpath(xpath);
            waitByxpath(xpath);
            inputbyxpath(xpath, "5"); //here the number is the quantity that will be invoiced
        }

        //save
        xpath = "//*[@id=\"add_region\"]";
        clickbyxpath(xpath);

        AlertAccept();
    }

    @Then("close the Invoice window")
    public void close_the_invoice_window() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }
}
