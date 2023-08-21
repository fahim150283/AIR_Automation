package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class PreviousPendingDelivery extends Page_Options {
    @Given("Login to Search Previous Pending Delivery")
    public void login_to_search_previous_pending_delivery() {
        url = "http://192.168.11.182/air_2/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);

        cssSelector = ".active:nth-child(5) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for Previous Pending Delivery")
    public void search_for_previous_pending_delivery() {
        id = "search_input";
        waitById(id);
        inputbyid(id, "CH-23-001501");
    }

    @And("description of a Previous Pending Delivery")
    public void description_of_a_previous_pending_delivery() throws InterruptedException {
        Thread.sleep(3000);
        id = "btn_view";
        waitById(id);
        clickbyId(id);
    }

    @Then("close Previous Pending Delivery for search")
    public void close_previous_pending_delivery_for_search() throws InterruptedException {
        Thread.sleep(4000);
        closedriver();
    }

    @Given("login for creating new Previous Pending Delivery")
    public void login_for_creating_new_previous_pending_delivery() {
        url = "http://192.168.11.182/air_2/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);

        cssSelector = ".active:nth-child(5) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("create new Previous Pending Delivery")
    public void create_new_previous_pending_delivery() throws InterruptedException {
        //click the plus button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]/i";
        clickbyxpath(xpath);

        //switch to modal
//        SwitchToModal("form");

        //set date
        id = "ch_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id, getToday());

        //wait and click distributors
        xpath = "//*[@id=\"select2-distri_list-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //search for bhai bhai and hit enter
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "bhai bhai");
        cssSelectorPressEnter(cssSelector);


//        //wait and click routes
//        xpath = "//*[@id=\"add_pre_invoice_form\"]/div/div[2]/div[3]/span";
//        Thread.sleep(2000);
//        clickbyxpath(xpath);
////      //select the first route
////        xpath = "//*[@id=\"select2-c_routes_list-result-4ofp-5\"]";
//        pressDownbyXpath(xpath);
//        pressEnterbyXpath(xpath);
//        //wait and click outlet
//        xpath = "//*[@id=\"add_pre_invoice_form\"]/div/div[1]/div[4]/span/span[1]/span";
//        waitByxpath(xpath);
//        clickbyxpath(xpath);
//        //click the checkbox for regular or pending
//        int chkbox = 1; 	//For checkbox    Regular = 1 and pending = 0
//        if(chkbox == 0) {
//            xpath = "//*[@id=\"pre_pending\"]";
//            waitByxpath(xpath);
//            clickbyxpath(xpath);

        //select the store
        id = "select2-c_store_id-container";
        waitById(id);
        clickbyId(id);

        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "bogura depot");
        cssSelectorPressEnter(cssSelector);

        //invoice reference no
        id = "c_inv_ref";
        inputbyid(id, "Automated Test");

        //Scroll
        scrollToTheBottom();

        //click the items bar
        cssSelector = ".select2-selection--multiple";
        Thread.sleep(0500);
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
        Thread.sleep(1500);
        clickbycssselector(cssSelector);
        Thread.sleep(1500);
        pressDownbyCssSelector(cssSelector);
        cssSelectorPressEnter(cssSelector);

        //plus button
        id = "c_add_ch_prod";
        clickbyId(id);

        //select quantity for item
        xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[4]/input[1]";
        waitByxpath(xpath);
        clearByXpath(xpath);
        waitByxpath(xpath);
        inputbyxpath(xpath, "10");

        //important notes
        id = "c_notes";
        inputbyid(id, "Automated Test");

        //Save
        cssSelector = "#add_pending_product_delivery_form > div > div.col-md-12.mt-3 > button";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);

        AlertAccept();
    }

    @Then("close the Previous Pending Delivery window")
    public void close_the_previous_pending_delivery_window() throws InterruptedException {
        Thread.sleep(4000);
        closedriver();
    }

}