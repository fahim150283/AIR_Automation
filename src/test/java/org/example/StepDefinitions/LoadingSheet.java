package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class LoadingSheet extends Page_Options {
    @Given("login for creating new  Loading sheet")
    public void login_for_creating_new_loading_sheet() {
        Login(user_Fahim);
        cssSelector = ".menues-bar:nth-child(19) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @When("create new Loading sheet")
    public void create_new_loading_sheet() throws InterruptedException {
        Thread.sleep(2000);

        //click the create new button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
        clickbyxpath(xpath);

        //click load from
        id = "select2-req_from_store-container";
        waitById(id);
        clickbyId(id);
        //search for store or vehicle
        xpath = "/html/body/span/span/span[1]/input";
        inputbyxpath(xpath,"4425");
        Thread.sleep(300);
        pressEnterbyXpath(xpath);

        //click load to
        id = "select2-req_to-container";
        waitById(id);
        clickbyId(id);
        //search for store or vehicle
        xpath = "/html/body/span/span/span[1]/input";
        inputbyxpath(xpath,"store");
        Thread.sleep(300);
        pressEnterbyXpath(xpath);

        //load start date
        id = "load_start_date";
        inputbyid(id,getlastMonthAndTime());


        //load start date
        id = "load_end_date";
        inputbyid(id,getTodaynTime());
    }
    @When("verify that the Loading sheet is created and listed in the Loading sheet list")
    public void verify_that_the_loading_sheet_is_created_and_listed_in_the_loading_sheet_list() {

    }
    @Then("close driver for creating Loading sheet")
    public void close_driver_for_creating_loading_sheet() throws InterruptedException {
//        closedriver();
    }
}
