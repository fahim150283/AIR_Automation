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
    public void create_new_goods_requisition() {
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
    }
    @Then("close the Goods Requisition window")
    public void close_the_goods_requisition_window() {

    }
}
