package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

import java.util.Random;

public class Collections extends Page_Options {
    @Given("Login to Search Collection")
    public void login_to_search_collection() {
        Login("h.abul");

        cssSelector = ".menues-bar:nth-child(8) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for Collection")
    public void search_for_collection() throws InterruptedException {
        xpath = "//*[@id=\"tableData_filter\"]/label/input";
        Thread.sleep(4500);
        inputbyxpath(xpath, "Bhai Bhai Confectionary");
    }

    @And("description of a Collection")
    public void description_of_a_collection() {
        //scroll for now
        scrollToTheBottom();
    }

    @Then("close Collection")
    public void close_collection() throws InterruptedException {
        closedriver();
    }


    @Given("login for creating Collection")
    public void login_for_creating_collection() {
        Login("h.abul");

        cssSelector = ".menues-bar:nth-child(8) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("create new Collection")
    public void create_new_collection() {
        //click the create new button
        xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
        clickbyxpath(xpath);

        //select date
        xpath = "//*[@id=\"col_date\"]";
        waitByxpath(xpath);
        inputbyxpath(xpath, getToday());

        //select Distributor
        xpath = "//*[@id=\"select2-distri-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        //search for bhai bhai and hit enter
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "bhai bhai");
        cssSelectorPressEnter(cssSelector);

        //collected by
        id = "col_by";
        inputbyid(id, "The Automated Process");

        //Advance Collection or Collection for order
        Boolean advanceCollection = false;
        if (advanceCollection == true) {
            //enter pay amount
            id = "pay_amount";
            waitById(id);
            clearById(id);
            inputbyid(id, "100000");

            //money receipt number
            Random random = new Random();
            id = "mny_rcpt_num";
            waitById(id);
            inputbyid(id, String.valueOf(random.nextInt(10000000)));
        } else {
            //Adjust from Advance or regular collection
            Boolean adjustFromAdvance = false;
            if (adjustFromAdvance == true) {
                //click the checkbox
                id = "adjust_advance";
                clickbyId(id);
            } else {
                //enter pay amount
                id = "pay_amount";
                waitById(id);
                clearById(id);
                String temp = String.valueOf(getValuebyXpath("//*[@id=\"rcv_amount\"]"));// it stores the value of payable amount
                System.out.println(temp);
                waitById(id);
                inputbyid(id, temp);


                //money receipt number
                Random random = new Random();
                id = "mny_rcpt_num";
                waitById(id);
                inputbyid(id, String.valueOf(random.nextInt(10000000)));
            }

            //click the order
            name = "order_id[]";
            clickByName(name);

        }
        //click the save button
        id = "add_col";
        clickbyId(id);
    }

    @Then("close the Collection window")
    public void close_the_collection_window() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }
}
