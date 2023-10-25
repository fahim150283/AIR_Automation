package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FinishGoodsStore extends Page_Options {
    @Given("Login to Search a FG Store")
    public void login_to_search_a_fg_store() {
        Login(user_Fahim);

        cssSelector = ".menues-bar:nth-child(16) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @When("search for FG Store")
    public void search_for_fg_store() throws InterruptedException {
        Thread.sleep(1000);
        //search a FG store
        id= "search";
        waitById(id);
        inputbyid(id,FGS_SearchInfo);
    }
    @When("description of a store and print")
    public void description_of_a_store() {
        WebElement table = driver.findElement(By.id("fg_store_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "delete" button for the visible row
                WebElement delete_Button = row.findElement(By.id("btn_view"));
                delete_Button.click();
            }
        }

        //print
        xpath = "//*[@id=\"print_area_store\"]/a";
        clickbyxpath(xpath);
    }
    @Then("close window for searching a FG Store")
    public void close_window_for_searching_a_fg_store() throws InterruptedException {
        Thread.sleep(1000);
        closedriver();
    }



    @Given("Login to edit a FG Store")
    public void login_to_edit_a_fg_store() {
        Login(user_Fahim);

        cssSelector = ".menues-bar:nth-child(16) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @When("search for a FG Store")
    public void search_for_a_fg_store() throws InterruptedException {
        Thread.sleep(1000);
        id = "search";
        waitById(id);
        inputbyid(id,FGS_SearchInfo);
    }
    @When("edit a store")
    public void edit_a_store() throws InterruptedException {
        WebElement table = driver.findElement(By.id("fg_store_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "delete" button for the visible row
                WebElement delete_Button = row.findElement(By.id("btn_edit"));
                delete_Button.click();
            }
        }

        Thread.sleep(200);

        //fg store code
        id = "edit_code";
        clearById(id);
        inputbyid(id,FGS_EditedCode+randomnumber());

        //fg store name
        id = "edit_name";
        clearById(id);
        inputbyid(id,FGS_EditedName);

        boolean store= true;
        System.out.println(store);

        if (store == true){
            WebElement dropdownElement = driver.findElement(By.id("edit_type"));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue("Store");
        }else {
            WebElement dropdownElement = driver.findElement(By.id("edit_type"));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue("Vehicle");
        }

    }
    @Then("close window for editing a FG Store")
    public void close_window_for_editing_a_fg_store() throws InterruptedException {
        closedriver();
    }
}
