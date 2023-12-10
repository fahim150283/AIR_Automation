package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PreviousPendingDelivery extends Page_Options {
    @Given("Login to Search Previous Pending Delivery")
    public void login_to_search_previous_pending_delivery() {
        Login_AIR2_AIR(Users.user_Fahim);

        cssSelector = ".active:nth-child(5) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for Previous Pending Delivery")
    public void search_for_previous_pending_delivery() throws InterruptedException {
        Thread.sleep(500);
        id = "search_input";
        waitById(id);
        inputbyid(id, PreviousPendingDelivery.SearchInfo);
    }

    @And("description of a Previous Pending Delivery")
    public void description_of_a_previous_pending_delivery() throws InterruptedException {
        Thread.sleep(500);

        //remove an item
        WebElement table = driver.findElement(By.id("pending_pro_del_table"));
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
    }

    @Then("close Previous Pending Delivery for search")
    public void close_previous_pending_delivery_for_search() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }

    @Given("login for creating new Previous Pending Delivery")
    public void login_for_creating_new_previous_pending_delivery() {
        Login_AIR2_AIR(Users.user_Fahim);

        cssSelector = ".active:nth-child(5) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("create new Previous Pending Delivery")
    public void create_new_previous_pending_delivery() throws InterruptedException {
        //click the plus button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]/i";
        clickbyxpath(xpath);

        //switch to modal
//        SwitchToModal("form");

        //set date
        id = "ch_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id, getToday());

        //wait and click distributors
        xpath = "//*[@id=\"select2-distri_list-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        //search for bhai bhai and hit enter
        xpath = "/html/body/span/span/span[1]/input";
        inputbyxpath(xpath,PreviousPendingDelivery.DistributorSearch);
        pressEnterbyXpath(xpath);


//        //wait and click routes
//        xpath = "//*[@id=\"add_pre_invoice_form\"]/div/div[2]/div[3]/span";
//        Thread.sleep(2000);
//        clickbyxpath(xpath);
////      //select the first route
////        xpath = "//*[@id=\"select2-c_routes_list-result-4ofp-5\"]";
//        pressDownbyXpath(xpath);
//        pressEnterbyXpath(xpath);
//        //wait and click outlet
//        xpath = "//*[@id=\"add_pre_invoice_form\"]/div/div[1]/div[4]/span/span[1]/span";
//        waitByxpath(xpath);
//        clickbyxpath(xpath);
//        //click the checkbox for regular or pending
//        int chkbox = 1; 	//For checkbox    Regular = 1 and pending = 0
//        if(chkbox == 0) {
//            xpath = "//*[@id=\"pre_pending\"]";
//            waitByxpath(xpath);
//            clickbyxpath(xpath);

        //select the store
        Thread.sleep(200);
        id = "select2-c_store_id-container";
        clickbyId(id);
        xpath = "/html/body/span/span/span[1]/input";
        inputbyxpath(xpath, PreviousPendingDelivery.Store);
        pressEnterbyXpath(xpath);

        //invoice reference no
        id = "c_inv_ref";
        inputbyid(id, "Automated Test");

        //important notes
        id = "c_notes";
        inputbyid(id, "Automated Test");

        //click the items bar and choose product
        for (int i = 0; i < PreviousPendingDelivery.Items.length; i++) {
            xpath = "//*[@id=\"add_pending_product_delivery_form\"]/div/div[4]/div[4]/span/span[1]/span";
            Thread.sleep(100);
            System.out.println(PreviousPendingDelivery.Items[i]);
            inputbyxpath(xpath, PreviousPendingDelivery.Items[i]);
            Thread.sleep(200);
            pressEnterbyXpath(xpath);
            Thread.sleep(100);

            // press the plus button
            id = "c_add_ch_prod";
            clickbyId(id);
        }

        //click the amount buttons for the quantity of the items
        for (int i = 0; i < PreviousPendingDelivery.Items.length; i++) {
            //ctn(quantity)
            xpath = "//*[@id=\"c_inv_items_list\"]/tr["+(i+1)+"]/td[4]/input[1]";
            waitByxpath(xpath);
            clearByXpath(xpath);
            inputbyxpath(xpath, PreviousPendingDelivery.ItemQuantity);
            //pcs(quantity)
            xpath = "//*[@id=\"c_inv_items_list\"]/tr["+(i+1)+"]/td[5]/input[1]";
            waitByxpath(xpath);
            clearByXpath(xpath);
            inputbyxpath(xpath, PreviousPendingDelivery.ItemQuantity);
        }

        //remove an item
        WebElement table = driver.findElement(By.id("c_inv_items_list"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            if (i% 5 == 0) {
                // Find and click the "delete" button for the visible row
                WebElement delete_Button = row.findElement(By.id("delete_table_row"));
                delete_Button.click();
            }
        }

        //Save
        cssSelector = "#add_pending_product_delivery_form > div > div.col-md-12.mt-3 > button";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);

        AlertAccept();
    }

    @Then("close the Previous Pending Delivery window")
    public void close_the_previous_pending_delivery_window() throws InterruptedException {
        Thread.sleep(4000);
        closedriver();
    }
}