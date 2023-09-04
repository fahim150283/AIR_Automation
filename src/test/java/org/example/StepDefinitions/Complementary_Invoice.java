package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class Complementary_Invoice extends Page_Options {
    @Given("Login to Search Complementary Invoice")
    public void login_to_search_complementary_invoice() {
        Login(user_Fahim);

        cssSelector = ".menues-bar:nth-child(9) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @When("search for Complementary Invoice")
    public void search_for_complementary_invoice() throws InterruptedException {
        id = "search_input";
        waitById(id);
        Thread.sleep(2500);
        inputbyid(id, "CI-23-000071");
    }
    @And("description of a Complementary Invoice")
    public void description_of_a_complementary_invoice() throws InterruptedException {
        cssSelector = "tr:nth-child(5) .fas";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @Then("close Complementary Invoice for search")
    public void close_complementary_invoice_for_search() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }


    @Given("login for creation of an Complementary Invoice")
    public void login_for_creation_of_an_complementary_invoice() {
        Login(user_Fahim);

        cssSelector = ".menues-bar:nth-child(9) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @And("create new Complementary Invoice")
    public void create_new_complementary_invoice() throws InterruptedException {
        //click the create new button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //date
        id = "ch_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id,getToday());

        //distributors list
        id = "select2-distri_list-container";
        waitById(id);
        clickbyId(id);
        //search for bhai bhai
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "bhai bhai");
        cssSelectorPressEnter(cssSelector);

        //Store
        id = "select2-c_store_id-container";
        waitById(id);
        clickbyId(id);

        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "bogura depot");
        cssSelectorPressEnter(cssSelector);

        //invoice reference no
        id = "c_inv_ref";
        inputbyid(id,"Test");

        //important notes
        id = "c_notes";
        inputbyid(id, "Automated Test");

        //click the items bar
        cssSelector = ".select2-selection--multiple";
        Thread.sleep(0500);
        clickbycssselector(cssSelector);
        Thread.sleep(0500);
        pressDownbyCssSelector(cssSelector);
        cssSelectorPressEnter(cssSelector);

        //click the plus button
        xpath = "//*[@id=\"c_add_ch_prod\"]/i";
        clickbyxpath(xpath);

        //quantity
        xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[4]/input";
        waitByxpath(xpath);
        clearByXpath(xpath);
        waitByxpath(xpath);
        inputbyxpath(xpath, "10");

        //save
        xpath = "//*[@id=\"add_pending_product_delivery_form\"]/div/div[6]/button";
        waitByxpath(xpath);
        clickbyxpath(xpath);


        AlertAccept();
    }
    @Then("close the Complementary Invoice window")
    public void close_the_complementary_invoice_window() throws InterruptedException {
        Thread.sleep(1500);
        closedriver();
    }

}