package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class Order extends Page_Options {

    @Given("Login to Search Order")
    public void login_to_search_order() {
        url = "http://192.168.11.182/air_2/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);

        cssSelector = ".menues-bar:nth-child(13) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for Order")
    public void search_for_order() throws InterruptedException {
        xpath = "//*[@id=\"tableData_filter\"]/label/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, "SO-00000012");
        Thread.sleep(2000);
    }

    @And("description of a Order")
    public void description_of_a_order() {
        xpath = "//*[@id=\"btn_view\"]/i";
        clickbyxpath(xpath);
    }

    @Then("close Order for search")
    public void close_order_for_search() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }

    @Given("login for creating new Order")
    public void login_for_creating_new_order() throws InterruptedException {
        url = "http://192.168.11.182/air_2/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);

        cssSelector = ".menues-bar:nth-child(13) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @And("create new Order")
    public void create_new_order() throws InterruptedException {
        //click the new order button
        xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //set date
        id = "c_inv_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id, getToday());

        //wait and click distributors
        xpath = "//*[@id=\"select2-distributor_list-container\"]";
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

        //
        scrollToTheBottom();

        //important notes
        id = "c_notes";
        inputbyid(id, "Automated Test");

        //click the items bar
        cssSelector = "#add_invoice_form > div > div.row.mt-3 > div.col-md-11 > span > span.selection > span";
        Thread.sleep(0500);
        clickbycssselector(cssSelector);
        Thread.sleep(0500);
        pressDownbyCssSelector(cssSelector);
        cssSelectorPressEnter(cssSelector);

        //click the plus button
        id = "c_add_inv_prod";
        clickbyId(id);

        //product quantity
        xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[5]/input";
        waitByxpath(xpath);
        clearByXpath(xpath);
        waitByxpath(xpath);
        inputbyxpath(xpath, "10");

        //save
        xpath = "//*[@id=\"add_region\"]";
        clickbyxpath(xpath);
        AlertAccept();
    }


    @Then("close the Order window")
    public void close_the_order_window() throws InterruptedException {
        closedriver();
    }

}
