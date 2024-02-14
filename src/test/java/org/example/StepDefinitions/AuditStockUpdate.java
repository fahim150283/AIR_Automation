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

public class AuditStockUpdate extends Page_Options {
    @Given("login for Audit Stock")
    public void login_for_audit_stock() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Audit Stock Update");
    }

    @When("search for Audit Stock")
    public void search_for_audit_stock() throws InterruptedException {
        Thread.sleep(1000);
        //search an FG store
        xpath = "//*[@id=\"inv_tableData_filter\"]/label/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, AuditStockUpdate.SearchInfo);
    }

    @When("description of an Audit Stock")
    public void description_of_an_audit_stock() throws InterruptedException {
        try {
            Thread.sleep(100);

            xpath = "//*[@id=\"inv_tableData\"]/tbody/tr[1]/td[7]/a";
            waitByxpath(xpath);
            clickbyxpath(xpath);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Given("create new Audit Stock")
    public void create_new_audit_stock() throws InterruptedException {
        try {
            //click the create new button

            xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]/span";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //in the modal form

            //select depot
            xpath = "//*[@id=\"select2-add_depot-container\"]";
            waitByxpath(xpath);
            Thread.sleep(1000);
            clickbyxpath(xpath);
            xpath = "/html/body/span/span/span[1]/input";
            inputbyxpath(xpath, AuditStockUpdate.DepotSearch);
            Thread.sleep(10);
            pressEnterbyXpath(xpath);

            //select store
            xpath = "//*[@id=\"select2-add_store-container\"]";
            waitByxpath(xpath);
            Thread.sleep(1000);
            clickbyxpath(xpath);
            xpath = "/html/body/span/span/span[1]/input";
            inputbyxpath(xpath, AuditStockUpdate.StoreSearch);
            Thread.sleep(10);
            pressEnterbyXpath(xpath);

            //set audit date
            xpath = "//*[@id=\"adjustment_date\"]";
            inputbyxpath(xpath, getToday());

            //set quantity amout
            Thread.sleep(500);
            int rowCnt = getTotalRowCountByXpath("//*[@id=\"product_details\"]");
            for (int i = 0; i < rowCnt; i++) {
                //set ctn amount
                xpath = "//*[@id=\"product_details\"]/tr[" + (i + 1) + "]/td[6]/input";
                clearByXpath(xpath);
                inputbyxpath(xpath, AuditStockUpdate.ItemQuantity);

                //set pcs amount
                xpath = "//*[@id=\"product_details\"]/tr[" + (i + 1) + "]/td[7]/input";
                clearByXpath(xpath);
                inputbyxpath(xpath, AuditStockUpdate.ItemQuantity);
            }

            //click save button
            xpath = "//*[@id=\"add_audit_stock\"]/div/div[3]/div/button";
            clickbyxpath(xpath);

            GetConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close Audit Stock window")
    public void close_audit_stock_window() throws InterruptedException {
        closedriver();
    }
}