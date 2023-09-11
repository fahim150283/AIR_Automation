package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.testng.Assert;

public class Apps extends Page_Options {

    /*
    create a new app
    */
    @Given("login for creating new  app")
    public void login_for_creating_new_app() {
        Login(user_Fahim);

        //click the Apps option from the Side bar
        cssSelector = ".menues-bar:nth-child(6) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("create new  app")
    public void create_new_app() throws InterruptedException {
        Thread.sleep(500);
        //click the create new button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        Thread.sleep(500);
        //fillup name
        id = "add_name";
        waitById(id);
        inputbyid(id, "fight club");

        //fillup Display name
        id = "add_d_name";
        waitById(id);
        inputbyid(id, "fight club");

        //functions
        xpath = "//*[@id=\"add_apps_form\"]/div/div[3]/div/span/span[1]/span";
        waitByxpath(xpath);
        for (int i = 0; i < 7; i++) {
            waitByxpath(xpath);
            pressDownbyXpath(xpath);
            pressEnterbyXpath(xpath);
        }
        clickbyxpath(xpath);

        //Status
        xpath = "//*[@id=\"add_status\"]";
        boolean active = true;
        if (active == false) {
            clickbyxpath(xpath);
            pressDownbyXpath(xpath);
            pressEnterbyXpath(xpath);
        }

        //click the save button
        xpath = "//*[@id=\"add_apps_form\"]/div/div[5]/div/button";
        waitByxpath(xpath);
        clickbyxpath(xpath);
    }

    @And("verify that the app is created and listed in the apps list")
    public void verifyThatTheAppIsCreatedAndListedInTheAppsList() throws InterruptedException {
        Thread.sleep(500);
        int ttlRow = getTotalRowCountByXpath("//*[@id=\"apps_table\"]");
        boolean found_app = false;
        for (int i = 0; i < ttlRow; i++) {
            xpath = "//*[@id=\"apps_table\"]/tr["+(i+1)+"]/td[2]/p";
            String s = getTextbyXpath(xpath);
            name = "fight club";

            if (name.equals(s)) {
                found_app = true;
            }
        }
        Assert.assertTrue(found_app);
    }

    @Then("close driver for apps")
    public void close_driver_for_apps() throws InterruptedException {
        closedriver();
    }


    /*
    editing an app
    */
    @Given("login for editing an app")
    public void login_for_editing_an_app() {
        Login(user_Fahim);

        //click the Apps option from the Side bar
        cssSelector = ".menues-bar:nth-child(6) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @When("search for the app")
    public void search_for_the_app() {
        id = "search_input";
        waitById(id);
        inputbyid(id, "fight club");
    }
    @When("edit the app")
    public void edit_the_app() {
        //click the edit button
    }
    @Then("close driver for editing apps")
    public void close_driver_for_editing_apps() {

    }
}