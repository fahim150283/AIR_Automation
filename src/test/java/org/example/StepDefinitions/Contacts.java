package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.TimeoutException;

public class Contacts extends Page_Options {

    @Given("^login for accessing Contacts$")
    public void contacts() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Contacts");
    }

    @When("search for employee")
    public void search_for_employee() throws InterruptedException {
        try{
        id = "search";
        waitById(id);
        Thread.sleep(2000);
        inputbyid(id,ContactsSearchInfo);
        }catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("^close Contacts$")
    public void close() throws InterruptedException {
        closedriver();
    }

}
