package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Page_Options;

public class GoodsRequisition extends Page_Options {
    @Given("login for creation of a Goods Requisition")
    public void login_for_creation_of_a_goods_requisition() {
        Login("k.polash");
        cssSelector = ".menues-bar:nth-child(12) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @And("create new Goods Requisition")
    public void create_new_goods_requisition() throws InterruptedException {
        xpath =  "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //date and time
        id = "requested_on";
        waitById(id);
        clickbyId(id);
        inputbyid(id, getTodaynTime());

        //send request from
        id = "select2-req_from-container";
        waitById(id);
        clickbyId(id);
        //search for noakhali and hit enter
        cssSelector = ".select2-search--dropdown > .select2-search__field";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "noakhali");
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
}
