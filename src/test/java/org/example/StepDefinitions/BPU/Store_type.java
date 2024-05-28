package org.example.StepDefinitions.BPU;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Objects;

public class Store_type extends Page_Options {

    SoftAssert softAssert = new SoftAssert();
    int ijsj = randomnumber();
    String Store_type_name = StoreType.FullName + ijsj;
    String Store_type_Short_name = StoreType.ShortName+ ijsj;
    String Store_type_edited_Short_name = StoreType.E_ShortName+ ijsj;
    String Store_type_edited_name = StoreType.E_FullName+ ijsj;

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
        inputbyid(id,StoreType.SearchInfo);
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

    @When("Create a Store_type with active status and visibility inactive")
    public void createAStore_typeWithActiveStatus() throws InterruptedException {
        Thread.sleep(1000);
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        //full name
        id = "f_name";
        inputbyid(id,Store_type_name);

        //short name
        id = "s_name";
        inputbyid(id,Store_type_Short_name);

        // Select the Status as active
        WebElement dropdown1 = driver.findElement(By.id("is_active"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Active");

        // Select the visiblity as inactive
        WebElement dropdown2 = driver.findElement(By.id("is_pos"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Inactive");

        //click the save button
        id = "save_btn";
        clickbyId(id);

        softAssert.assertEquals(GetConfirmationMessage(), "Store Type has been saved");
    }

    @And("check if this store type is active or not and visibility in stores is inactive or not")
    public void checkIfThisStoreTypeIsActiveOrNotAndVisibilityInStoresIsInactiveOrNot() throws InterruptedException {

        //search for the store type in the list
        Thread.sleep(2000);
        id = "search_input";
        waitById(id);
        inputbyid(id,Store_type_name);

        // verify the Store type
        Boolean Status = false;
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                softAssert.assertEquals(row.findElement(By.xpath(".//td[5]/p")).getText(),"Active" , "Status is Inactive");
            }
        }


        //verify that the visibility in stores is inactive or not


        Click_from_leftSideBar("INV Stores");
        Thread.sleep(1100);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        // check the visiblity as inactive
        WebElement dropdown = driver.findElement(By.id("store_type_id"));
        Boolean visible = false;

        // Get all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Iterate over each option and print its text
        for (WebElement option : options) {
            String expected_storeType = option.getText();
            System.out.println(option.getText());
            if(expected_storeType.contains(Store_type_name)){
                visible = true;
                break;
            }
        }
        softAssert.assertFalse(visible ,"visiblity as active");

        closedriver();
        softAssert.assertAll();
    }

    @When("Create a Store_type with active status and visiblity active")
    public void createAStore_typeWithActiveStatusAndVisiblityActive() throws InterruptedException {
        Thread.sleep(1000);
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        //full name
        id = "f_name";
        inputbyid(id,Store_type_name);

        //short name
        id = "s_name";
        inputbyid(id,Store_type_Short_name);

        // Select the Status as active
        WebElement dropdown1 = driver.findElement(By.id("is_active"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Active");

        // Select the visiblity as inactive
        WebElement dropdown2 = driver.findElement(By.id("is_pos"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Active");

        //click the save button
        id = "save_btn";
        clickbyId(id);

        softAssert.assertEquals(GetConfirmationMessage(), "Store Type has been saved");
    }

    @And("check if this store type is active or not and visibility in stores is active or not")
    public void checkIfThisStoreTypeIsActiveOrNotAndVisibilityInStoresIsActiveOrNot() throws InterruptedException {

        //search for the store type in the list
        Thread.sleep(2000);
        id = "search_input";
        waitById(id);
        inputbyid(id,Store_type_name);

        // verify the Store type
        Boolean Status = false;
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                softAssert.assertEquals(row.findElement(By.xpath(".//td[5]/p")).getText(),"Active" , "Status is Inactive");
            }
        }


        //verify that the visibility in stores is inactive or not


        Click_from_leftSideBar("INV Stores");
        Thread.sleep(2100);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        // check the visiblity as inactive
        WebElement dropdown = driver.findElement(By.id("store_type_id"));
        Boolean visible = false;

        // Get all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Iterate over each option and print its text
        for (WebElement option : options) {
            String expected_storeType = option.getText();
            System.out.println(option.getText());
            if(expected_storeType.contains(Store_type_name)){
                visible = true;
                break;
            }
        }
        softAssert.assertTrue(visible ,"visiblity as active");

        closedriver();
        softAssert.assertAll();
    }

    @When("Create a Store_type with inactive status and visibility inactive")
    public void createAStore_typeWithInactiveStatusAndVisibilityInactive() throws InterruptedException {
        Thread.sleep(1000);
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        //full name
        id = "f_name";
        inputbyid(id,Store_type_name);

        //short name
        id = "s_name";
        inputbyid(id,Store_type_Short_name);

        // Select the Status as active
        WebElement dropdown1 = driver.findElement(By.id("is_active"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Inactive");

        // Select the visiblity as inactive
        WebElement dropdown2 = driver.findElement(By.id("is_pos"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Inactive");

        //click the save button
        id = "save_btn";
        clickbyId(id);

        softAssert.assertEquals(GetConfirmationMessage(), "Store Type has been saved");
    }

    @And("check if this store type is inactive or not and visibility in stores is inactive or not")
    public void checkIfThisStoreTypeIsInactiveOrNotAndVisibilityInStoresIsInactiveOrNot() throws InterruptedException {

        //search for the store type in the list
        Thread.sleep(2000);
        id = "search_input";
        waitById(id);
        inputbyid(id,Store_type_name);

        // verify the Store type
        Boolean Status = false;
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                softAssert.assertEquals(row.findElement(By.xpath(".//td[5]/p")).getText(),"Inactive" , "Status is active");
            }
        }


        //verify that the visibility in stores is inactive or not


        Click_from_leftSideBar("INV Stores");
        Thread.sleep(2100);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        // check the visiblity as inactive
        WebElement dropdown = driver.findElement(By.id("store_type_id"));
        Boolean visible = false;

        // Get all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Iterate over each option and print its text
        for (WebElement option : options) {
            String expected_storeType = option.getText();
            System.out.println(option.getText());
            if(expected_storeType.contains(Store_type_name)){
                visible = true;
                break;
            }
        }
        softAssert.assertFalse(visible ,"visiblity as active");

        closedriver();
        softAssert.assertAll();
    }
}
