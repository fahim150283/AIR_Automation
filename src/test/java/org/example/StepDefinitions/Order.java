package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

public class Order extends Page_Options {

    @Given("Login to Search Order")
    public void login_to_search_order() {
       Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Orders");
    }

    @When("search for Order")
    public void search_for_order() {
        xpath = "//*[@id=\"tableData_filter\"]/label/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, Order.SearchInfo);
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
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Orders");
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


        //set Expected Delivery Date
        id = "c_exp_delivery_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id, getToday());

        //Refference No
        id = "c_inv_ref";
        inputbyid(id, Order.Refference_No);

        //cash commission
        xpath = "//*[@id=\"c_cash_com\"]";
        clearByXpath(xpath);
        inputbyxpath(xpath, Order.CashCommission);


        //click the items bar and add items
        Thread.sleep(1000);
        for (int i = 0; i < Order.Items.length; i++) {
            xpath = "//*[@id=\"add_invoice_form\"]/div/div[3]/div[4]/span/span[1]/span";
            Thread.sleep(30);
            System.out.println(Order.Items[i]);
            inputbyxpath(xpath, Order.Items[i]);
            Thread.sleep(30);
            pressEnterbyXpath(xpath);
            Thread.sleep(30);

            // press the plus button
            id = "c_add_inv_prod";
            clickbyId(id);
        }

        //click the amount buttons for the quantity of the items
        for (int i = 0; i < Order.Items.length; i++) {
            //ctn(quantity)
            xpath = "//*[@id=\"c_inv_items_list\"]/tr["+(i+1)+"]/td[5]/input";
            waitByxpath(xpath);
            clearByXpath(xpath);
            inputbyxpath(xpath, Order.ItemQuantity);
            //pcs(quantity)
            xpath = "//*[@id=\"c_inv_items_list\"]/tr["+(i+1)+"]/td[6]/input";
            waitByxpath(xpath);
            clearByXpath(xpath);
            inputbyxpath(xpath, Order.ItemQuantity);
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

        Thread.sleep(1000);

        //offer part
        if (ElementVisible("//*[@id=\"tbl_data\"]")) {
            System.out.println("offer part is available");
            for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                System.out.println("this is the found string: " + s);
                if (Objects.equals(s, "Offer Type: Product")) {          //for the offer:products
//                    List<WebElement> rowsWithDropdowns = driver.findElements(By.xpath("//tbody[@id='tbl_data']/tr[td/select]"));
//                        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"dis_product" + (1+ i) + "\"]"));
//                        Select dropdown = new Select(dropdownElement);
//                        dropdown.selectByIndex(1);

                    String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i+1) + "]/td[5]//select";
                    //Selecting the dropdown options only for where available
                    try {
                        WebElement dropdownElement = driver.findElement(By.xpath(dropdownXpath));
                        Select dropdown = new Select(dropdownElement);
                        dropdown.selectByIndex(1);
                    } catch (org.openqa.selenium.NoSuchElementException e) {
                        continue;
                    }
                }
            }
        }

        //important notes
        id = "c_notes";
        inputbyid(id, Order.Note);


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
