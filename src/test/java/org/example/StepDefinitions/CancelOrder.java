package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class CancelOrder extends Page_Options {

    @Given("Login to Search CancelOrder")
    public void login_to_search_cancel_order() {
        url = "http://192.168.11.182/air_2/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);

        cssSelector = ".menues-bar:nth-child(7) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for CancelOrder")
    public void search_for_cancel_order() {
        xpath = "//*[@id=\"tableData_filter\"]/label/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, "SO-00000010");
    }

    @And("description of a cancelled Order")
    public void description_of_a_order_to_cancel() {
        id = "btn_view";
        waitById(id);
        clickbyId(id);
    }

    @Then("close CancelOrder for search")
    public void close_cancel_order_for_search() throws InterruptedException {
        Thread.sleep(1500);
        closedriver();
    }

    @Given("login for Cancelling a Order")
    public void login_for_creating_new_order_to_cancel() {
        url = "http://192.168.11.182/air_2/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);

        cssSelector = ".menues-bar:nth-child(7) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("create new Cancel Order")
    public void create_new_order_to_cancel() {
        //click the create new cancel order button
        xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
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

        //important notes
        id = "c_notes";
        inputbyid(id, "Automated Test");

        //partial cancel or full cancel
        Boolean fullCancel = false; //Default is Full Cancel
        if (fullCancel == false) {
            xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[5]/input";
            waitByxpath(xpath);
            clearByXpath(xpath);
            waitByxpath(xpath);
            inputbyxpath(xpath, "5"); //here the number is the quantity that will be deleted
        }

        //save
        xpath = "//*[@id=\"add_region\"]";
        clickbyxpath(xpath);

        AlertAccept();

    }


    @Then("close the CancelOrder window")
    public void close_the_cancel_order_window() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }
}

