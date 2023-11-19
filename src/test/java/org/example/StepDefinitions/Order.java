package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Order extends Page_Options {

    @Given("Login to Search Order")
    public void login_to_search_order() {
       Login_AIR2_AIR(user_Fahim);

        cssSelector = ".menues-bar:nth-child(23) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for Order")
    public void search_for_order() {
        xpath = "//*[@id=\"tableData_filter\"]/label/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, OrderSearchInfo);
    }

    @And("description of a Order")
    public void description_of_a_order() throws InterruptedException {
        Thread.sleep(2000);
        xpath = "//*[@id=\"btn_view\"]/i";
        clickbyxpath(xpath);
    }

    @Then("close Order for search")
    public void close_order_for_search() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }

    @Given("login for creating new Order")
    public void login_for_creating_new_order() throws InterruptedException {
        Login_AIR2_AIR(user_Fahim);

        cssSelector = ".menues-bar:nth-child(23) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @And("create new Order")
    public void create_new_order() throws InterruptedException {
        //click the new order button
        xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //set date
        id = "c_inv_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id, getToday());

        //wait and click distributors
        xpath = "//*[@id=\"select2-distributor_list-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        //search for bhai bhai and hit enter
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "bhai bhai");
        cssSelectorPressEnter(cssSelector);


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


        //important notes
        id = "c_notes";
        inputbyid(id, OrderNote);

        //click the items bar and add items
        for (int i = 0; i < OrderItems.length; i++) {
            xpath = "//*[@id=\"add_invoice_form\"]/div/div[3]/div[4]/span/span[1]/span";
            Thread.sleep(300);
            System.out.println(OrderItems[i]);
            inputbyxpath(xpath, OrderItems[i]);
            Thread.sleep(300);
            pressEnterbyXpath(xpath);
            Thread.sleep(300);

            // press the plus button
            id = "c_add_inv_prod";
            clickbyId(id);
        }

        //click the amount buttons for the quantity of the items
        for (int i = 0; i < OrderItems.length; i++) {
            //ctn(quantity)
            xpath = "//*[@id=\"c_inv_items_list\"]/tr["+(i+1)+"]/td[5]/input";
            waitByxpath(xpath);
            clearByXpath(xpath);
            inputbyxpath(xpath, OrderItemQuantity);
            //pcs(quantity)
            xpath = "//*[@id=\"c_inv_items_list\"]/tr["+(i+1)+"]/td[6]/input";
            waitByxpath(xpath);
            clearByXpath(xpath);
            inputbyxpath(xpath, OrderItemQuantity);
        }

        //remove an item
        WebElement table = driver.findElement(By.id("c_inv_items_list"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            if (i% 5 == 0) {
                // Find and click the "delete" button for the visible row
                WebElement delete_Button = row.findElement(By.xpath("//*[@id=\"c_inv_items_list\"]/tr["+(i+1)+"]/td[12]/button"));
                delete_Button.click();
            }
        }

        //save
        xpath = "//*[@id=\"add_region\"]";
        clickbyxpath(xpath);
        AlertAccept();
    }


    @Then("close the Order window")
    public void close_the_order_window() throws InterruptedException {
        closedriver();
    }

}
