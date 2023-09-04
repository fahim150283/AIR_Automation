package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class GoodsRequisition extends Page_Options {
    //new good requisition
    @Given("login for creation of a Goods Requisition")
    public void login_for_creation_of_a_goods_requisition() {
        Login(user_Polash);
        cssSelector = ".menues-bar:nth-child(12) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("create new Goods Requisition")
    public void create_new_goods_requisition() throws InterruptedException {
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //date and time
        id = "requested_on";
        waitById(id);
        clickbyId(id);
        inputbyid(id, getTodaynTime());
        pressEnterById(id);

        //send request from
        id = "select2-req_from-container";
        waitById(id);
        clickbyId(id);
        //search for noakhali and hit enter
        cssSelector = ".select2-search--dropdown > .select2-search__field";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "cumilla");
        cssSelectorPressEnter(cssSelector);

        //send request to
        id = "select2-req_to-container";
        waitById(id);
        clickbyId(id);
        //search for factory
        cssSelector = ".select2-search--dropdown > .select2-search__field";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "factory");
        cssSelectorPressEnter(cssSelector);


        //Goods
        xpath = "//*[@id=\"send_req_fg_store\"]/div/div[2]/div[1]/span/span[1]/span";
        Thread.sleep(0500);
        clickbyxpath(xpath);
        Thread.sleep(0500);
        pressDownbyXpath(xpath);
        pressEnterbyXpath(xpath);


        //click the plus button
        id = "add_goods_table";
        waitById(id);
        clickbyId(id);

        //quantity
        cssSelector = "#fg_store_goods_table > tr > td:nth-child(5) > input.p_qty";
        waitByCssSelector(cssSelector);
        clearByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "20");

        //save
        xpath = "//button[@id='send_req_fg_store']";
        clickbyxpath(xpath);
    }

    @Then("close the Goods Requisition window")
    public void close_the_goods_requisition_window() throws InterruptedException {
        closedriver();
    }

    //cancel  a good requisition
    @Given("login for cancellation of a requested Goods Requisition")
    public void login_for_cancellation_of_a_requested_goods_requisition() throws InterruptedException {
        Login(user_Fahim);
        cssSelector = ".menues-bar:nth-child(12) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("cancel the good requisition")
    public void cancel_the_good_requisition() throws InterruptedException {
        //click the eye button
        Thread.sleep(500);
        xpath = "(//a[@id='sent_view1']/i)[2]";
        scrollTo_ByXpath(xpath);
        Thread.sleep(500);
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //cancel
        id = "cancel_permission_btn";
        clickbyId(id);
    }

    @Then("close the Goods Requisition window for the cancellation of the request")
    public void close_the_goods_requisition_window_for_the_cancellation_of_the_request() throws InterruptedException {
        closedriver();
    }

    //accept a good requisition
    @Given("login for accepting of a requested Goods Requisition")
    public void login_for_accepting_of_a_requested_goods_requisition() throws InterruptedException {
        Login(user_Fahim);
        cssSelector = ".menues-bar:nth-child(12) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
        Thread.sleep(2500);
        scrollToTheBottom();
    }

    @And("Accept the good requisition")
    public void accept_the_good_requisition() throws InterruptedException {
        //click the eye button
        Thread.sleep(1000);
        xpath = "(//a[@id='sent_view1']/i)[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //accepted quantity
        Boolean acceptfullRequest = false;
        if (acceptfullRequest == false) {
            id = "adj_ctn_qty";
            waitById(id);
            clearByid(id);
            waitById(id);
            inputbyid(id, "5");

            //Select a vehicle
            id = "select2-select_vehicle-container";
            waitById(id);
            clickbyId(id);
            //search for factory vehicle
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, "factory vehicle");
            cssSelectorPressEnter(cssSelector);
            cssSelectorPressEnter(cssSelector);

            //accepted on date and time
            id = "approved_on";
            waitById(id);
            clickbyId(id);
            inputbyid(id, "Anything Literally");
            pressEnterById(id);
            //Click accept
            pressEnterById(id);


        }
    }

    @Then("close the Goods Requisition window for accepting the request")
    public void close_the_goods_requisition_window_for_accepting_the_request() throws InterruptedException {
        Thread.sleep(1500);
        closedriver();
    }

    //vehicle load
    @Given("login for vehicle load for a requested Goods Requisition")
    public void login_for_vehicle_load_for_a_requested_goods_requisition() {
        Login(user_Fahim);
        cssSelector = ".menues-bar:nth-child(15) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("vehicle load for the good requisition")
    public void vehicle_load_for_the_good_requisition() {
        //select a requisition
        xpath = "//*[@id=\"sent_view2\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //vehicle status
        id = "vehicle_status";
        waitById(id);
        pressDownbyid(id);

        //date
        id = "load_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id, "literally anything");
        pressEnterById(id);

        //click save
        id = "send_req_fg_store";
        waitById(id);
        clickbyId(id);
    }

    @Then("close the Goods Requisition window for vehicle load")
    public void close_the_goods_requisition_window_for_vehicle_load() throws InterruptedException {
        closedriver();
    }

    //Vehicle unload
    @Given("login for vehicle unload for a requested Goods Requisition")
    public void login_for_vehicle_unload_for_a_requested_goods_requisition() {
        Login(user_Fahim);
        cssSelector = ".menues-bar:nth-child(15) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("vehicle unload for the good requisition")
    public void vehicle_unload_for_the_good_requisition() {
        //select a requisition
        xpath = "//*[@id=\"sent_view2\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //vehicle status
        id = "vehicle_status";
        waitById(id);
        pressDownbyid(id);

        //date
        id = "load_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id, "literally anything");
        pressEnterById(id);

        //click save
        id = "send_req_fg_store";
        waitById(id);
        clickbyId(id);
    }

    @Then("close the Goods Requisition window for vehicle unload")
    public void close_the_goods_requisition_window_for_vehicle_unload() throws InterruptedException {
        closedriver();
    }

    @Given("login for Receiving The Goods")
    public void login_for_receiving_the_goods() {
        Login(user_Polash);
        cssSelector = ".menues-bar:nth-child(12) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("Receive The Goods")
    public void receive_the_goods() {
        //click the eye button
        id = "sent_view1";
        waitById(id);
        clickbyId(id);

        //set date
        id = "load_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id, "literally anything");
        pressEnterById(id);

        //click receive button
        xpath = "//*[@id=\"accept_permission_btn\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
    }

    @Then("close the Goods Requisition window for receiving goods")
    public void close_the_goods_requisition_window_for_receiving_goods() throws InterruptedException {
        closedriver();
    }
}
