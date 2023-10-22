package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class CancelOrder extends Page_Options {

    @Given("Login to Search CancelOrder")
    public void login_to_search_cancel_order() {
        Login(user_Fahim);

        cssSelector = ".menues-bar:nth-child(8) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for CancelOrder")
    public void search_for_cancel_order() {
        xpath = "//*[@id=\"tableData_filter\"]/label/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, CancelOrderSearchInfo);
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
        Login(user_Fahim);

        cssSelector = ".menues-bar:nth-child(8) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("create new Cancel Order")
    public void create_new_order_to_cancel() throws InterruptedException {
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
        inputbycssselector(cssSelector, CancelOrderDistributorSearch);
        cssSelectorPressEnter(cssSelector);

        //important notes
        id = "c_notes";
        inputbyid(id, CancelOrderNote);

        //partial cancel or full cancel
        Boolean fullCancel = false; //Default is Full Cancel

            for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {
                if (fullCancel == false && i%2 ==0 ) {
                //CTN
                Thread.sleep(200);
                xpath = "//*[@id=\"c_inv_items_list\"]/tr["+(i+1)+"]/td[5]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, CancelOrderItemQuantity); //here the number is the quantity that will be deleted

                //PCS
                Thread.sleep(200);
                xpath = "//*[@id=\"c_inv_items_list\"]/tr["+(i+1)+"]/td[6]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, CancelOrderItemQuantity); //here the number is the quantity that will be deleted
            }
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

