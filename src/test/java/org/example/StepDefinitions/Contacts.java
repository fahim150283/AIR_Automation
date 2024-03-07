package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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

    @And("verify if the the employee is searched or not")
    public void verifyIfTheTheEmployeeIsSearchedOrNot() {

        String s="";

        // view the contact details
        WebElement table = driver.findElement(By.id("wrapper"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//div"));
        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "Add App Permissions" button for the visible row
                WebElement view_Button = row.findElement(By.xpath("/div/div/div/span/p[1]"));
                s = view_Button.getText();
            }
        }
        xpath = "//*[@id=\"wrapper\"]/div[1]/div/div/span/p[1]";
        System.out.println(s+" is the found contact name");
        Assert.assertEquals(s,ContactsSearchInfo);
    }
}
