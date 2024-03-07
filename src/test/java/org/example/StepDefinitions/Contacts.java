package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

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
    public void verifyIfTheTheEmployeeIsSearchedOrNot() throws InterruptedException {
        String s = null;
        Thread.sleep(100);

        // Find the parent element containing all the employee details
        WebElement wrapper = driver.findElement(By.id("wrapper"));

        // Find all the visible boxes
        List<WebElement> boxes = wrapper.findElements(By.xpath(".//div[@class='col-md-4 box' and not(contains(@style, 'display: none;'))]"));

        // Iterate through each visible box
        for (WebElement box : boxes) {
            // Find the <p> element with class 'name' inside each box
            WebElement nameElement = null;
            try {
                nameElement = box.findElement(By.xpath(".//p[@class='name']"));
                // Get the text of the <p> element
                String name = nameElement.getText();
                // Print or store the name as needed
                System.out.println("Found contact name: " + name);
                // You can break out of the loop if needed, depending on your use case
                s = name;
            } catch (NoSuchElementException e) {
                // If the name element is not found in the current box, continue to the next box
                continue;
            }
        }

        // Assert if the found name matches the expected name
        Assert.assertEquals(s, ContactsSearchInfo);
    }

}
