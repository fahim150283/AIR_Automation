package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SalesReturn extends Page_Options {
    @Given("Login to Search Sales Return")
    public void login_to_search_sales_return() {
        Login_AIR2_AIR(user_Fahim);

        id = "menu-search";
        waitById(id);
        List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@id='menu']//span[text()='Sales Return']"));

        // Click on the first search result found
            WebElement firstResult = searchResults.get(0);
            firstResult.click();
    }

    @When("search for Sales Return")
    public void search_for_sales_return() throws InterruptedException {
        Thread.sleep(1000);
        xpath = "//*[@id=\"search_input\"]";
        waitByxpath(xpath);
        inputbyxpath(xpath, "SI-00000025");
    }

    @And("description of a Sales Return")
    public void description_of_a_sales_return() throws InterruptedException {
        xpath = "(//a[@id='btn_view']/i)[10]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
    }

    @Then("close Sales Return")
    public void close_sales_return() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }


    @Given("login for creating Sales Return")
    public void login_for_creating_sales_return() {
        Login_AIR2_AIR(user_Fahim);

        id = "menu-search";
        waitById(id);
        List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@id='menu']//span[text()='Sales Return']"));

        // Click on the first search result found
        WebElement firstResult = searchResults.get(0);
        firstResult.click();
    }

    @And("create new Sales Return")
    public void create_new_sales_return() throws InterruptedException {
        //click the plus button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        Thread.sleep(1000);

        //Invoice date from
//        id = "invoice_date_from";
//        waitById(id);
//        clickbyId(id);
//        inputbyid(id, getLastMonth() );
//        Thread.sleep(500);


        //Invoice date till
//        id = "invoice_date_till";
//        waitById(id);
//        clickbyId(id);
//        inputbyid(id, getToday());
//
//        Thread.sleep(500);

        //invoice list
        id = "select2-order_list-container";
        waitById(id);
        clickbyId(id);
        //search for bhai and hit enter
        xpath = "//input[@type='search']";
        waitByxpath(xpath);
        inputbyxpath(xpath,"bhai");
        pressEnterbyXpath(xpath);


//        classname = "select2 select2-container select2-container--default select2-container--above select2-container--focus";
//        clickByClassName(classname);



        //select the store
        id = "select2-c_store_id-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "barisal");
        cssSelectorPressEnter(cssSelector);

        //Return Date
        id = "sales_return_date";
        inputbyid(id, getToday());

        //Important notes
        id = "c_notes";
        inputbyid(id, "Automated Test");


        //Full or partial return
        Boolean fullReturn = true;
        xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[5]";
        String s = String.valueOf(getText_double_byXpath(xpath));

        if (fullReturn == true) {
            xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[9]/input";
            waitByxpath(xpath);
            clearByXpath(xpath);
            waitByxpath(xpath);
            inputbyxpath(xpath, s);
        } else {
            xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[5]";
            s = String.valueOf(getText_double_byXpath(xpath) - 1);
            xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[9]/input";
            waitByxpath(xpath);
            clearByXpath(xpath);
            waitByxpath(xpath);
            inputbyxpath(xpath, s);
        }

        id = "add_region";
        waitById(id);
        clickbyId(id);

    }

    @Then("close the Sales Return window")
    public void close_the_sales_return_window() throws InterruptedException {
        Thread.sleep(1000);
        closedriver();
    }


}
