package org.example.StepDefinitions.BPU;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Store_type extends Page_Options {

    SoftAssert softAssert = new SoftAssert();
    String Store_type_name = StoreType.FullName;
    String Store_type_Short_name = StoreType.ShortName;
    String Store_type_edited_Short_name = StoreType.E_ShortName;
    String Store_type_edited_name = StoreType.E_FullName;

    @Given("login to Search for Store_type")
    public void loginToSearchForStore_type() throws InterruptedException {
        Login_BPU(Users.L1Tester);
        Click_from_leftSideBar("INV Store Types");
    }
    @When("Search for the Store_type")
    public void searchForTheStore_type() throws InterruptedException {
        Thread.sleep(2000);

        id = "search_input";
        waitById(id);
        inputbyid(id,Store_type_name);
    }

    @Then("verify if the Store_type is visible accordingly")
    public void verifyIfTheStore_typeIsVisibleAccordingly() throws InterruptedException {
        Thread.sleep(1000);
        Boolean search_found = false;

        // verify the searched Store type
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                String SearchedItem = row.findElement(By.xpath(".//td[3]/p")).getText();
                if(SearchedItem.contains(Store_type_name)){
                    search_found = true;
                }
            }
        }
        softAssert.assertTrue(search_found);
        closedriver();
        softAssert.assertAll();
    }

    @When("Create a Store_type with active status")
    public void createAStore_typeWithActiveStatus() throws InterruptedException {
        Thread.sleep(1000);
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        id = "f_name";
        inputbyid(id,Store_type_name);
    }
}
