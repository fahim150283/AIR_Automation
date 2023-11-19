package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CancelInvoice extends Page_Options {
    @Given("Login to Search cancelled Invoice")
    public void login_to_search_cancelled_invoice() {
        Login_AIR2_AIR(user_Fahim);

        cssSelector = ".menues-bar:nth-child(7) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for cancelled Invoice")
    public void search_for_cancelled_invoice() throws InterruptedException {
        Thread.sleep(100);
        xpath = "//*[@id=\"search_input\"]";
        waitByxpath(xpath);
        inputbyxpath(xpath, CancelInvoiceSearchInfo);
    }

    @And("description of a cancelled Invoice")
    public void description_of_a_cancelled_invoice() throws InterruptedException {
        Thread.sleep(100);
        // verify the created product
        WebElement table = driver.findElement(By.id("invoice_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "Add App Permissions" button for the visible row
                WebElement editButton = row.findElement(By.id("btn_view"));
                editButton.click();
            }
        }
    }

    @Then("close cancelled Invoice for search")
    public void close_cancelled_invoice_for_search() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }

    @Given("login for cancellation of an Invoice")
    public void login_for_cancellation_of_an_invoice() {
        Login_AIR2_AIR(user_Fahim);

        cssSelector = ".menues-bar:nth-child(7) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @And("create new cancel Invoice")
    public void create_new_cancel_invoice() throws InterruptedException {
        //click the plus button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[4]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //date
        xpath = "//*[@id=\"c_actual_inv_date\"]";
        waitByxpath(xpath);
        inputbyxpath(xpath, getToday());

        //order list
        Thread.sleep(200);
        xpath = "//*[@id=\"select2-invoice_list-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        //search for bhai bhai and hit enter
        xpath = "/html/body/span/span/span[1]/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, CancelInvoiceDistributorSearch);
        pressEnterbyXpath(xpath);

        //select the store
        id = "select2-c_store_id-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, CancelInvoiceStore);
        cssSelectorPressEnter(cssSelector);

        //important notes
        id = "c_notes";
        inputbyid(id, CancelInvoiceNote);

        //save
        id = "add_region";
        waitById(id);
        clickbyId(id);

        AlertAccept();
    }

    @Then("close the cancel Invoice window")
    public void close_the_cancel_invoice_window() throws InterruptedException {
        Thread.sleep(1500);
        closedriver();
    }
}
