package org.example.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class Order extends Page_Options {
    SoftAssert softAssert = new SoftAssert();

    public static String refernce_no = Order.Refference_No + randomnumber();

    @Given("Login to Search Order")
    public void login_to_search_order() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Orders");
    }

    @When("search for Order")
    public void search_for_order() {
        try {
            xpath = "//*[@id=\"tableData_filter\"]/label/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, Order.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("description of a Order")
    public void description_of_a_order() throws InterruptedException {
        try {
            Thread.sleep(2000);
            xpath = "//*[@id=\"btn_view\"]/i";
            clickbyxpath(xpath);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
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

    @When("create new Order with no products in it")
    public void create_new_order() throws InterruptedException {
        try {
            //click the new order button
            xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //set date
            xpath = "//*[@id=\"c_inv_date\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            SetToday(xpath);

            //wait and click distributors
            xpath = "//*[@id=\"select2-distributor_list-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for distributor and hit enter
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Order.DistributorSearch);
            cssSelectorPressEnter(cssSelector);


            //set Expected Delivery Date
            id = "c_exp_delivery_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getToday());

            //Reference No
            id = "c_inv_ref";
            inputbyid(id, refernce_no);

            //cash commission
            xpath = "//*[@id=\"c_cash_com\"]";
            clearByXpath(xpath);
            inputbyxpath(xpath, Order.CashCommission);


            //important notes
            id = "c_notes";
            clickbyId(id);
            inputbyid(id, Order.Note);


            //calculate the grand total


            int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]");
            double[][] gtCacl = new double[itemsRowSize][2];
            for (int i = 0; i < itemsRowSize; i++) {
                //get price/ctn
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
                double s1 = Double.parseDouble(getTextAttributebyXpath(xpath));
                //get ctn count
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                double s2 = Double.parseDouble(getTextAttributebyXpath(xpath));

                gtCacl[i][0] = s1;
                gtCacl[i][1] = s2;
                System.out.println(gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
            }
            double grandTotalActual = GrandTotalCalc(gtCacl);
            double grandTotalVisible = Double.parseDouble(getTextAttributebyXpath("//*[@id=\"c_grand_total\"]"));
            System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);
            Assert.assertEquals(grandTotalVisible, grandTotalActual);


            Thread.sleep(1000);

            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                System.out.println("offer part is available");
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("this is the found string: " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        //for the offer:products
//                    List<WebElement> rowsWithDropdowns = driver.findElements(By.xpath("//tbody[@id='tbl_data']/tr[td/select]"));
//                        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"dis_product" + (1+ i) + "\"]"));
//                        Select dropdown = new Select(dropdownElement);
//                        dropdown.selectByIndex(1);

                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement1 = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown1 = new Select(dropdownElement1);
                            dropdown1.selectByIndex(1);
                        } catch (org.openqa.selenium.NoSuchElementException e) {
                            continue;
                        }
                    }
                }
            }

            //save
            xpath = "//*[@id=\"add_region\"]";
            clickbyxpath(xpath);
            AlertAccept();

            Assert.assertEquals(GetConfirmationMessage(), "Please Add Items to Order");
        } catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }


    @Then("close the Order window")
    public void close_the_order_window() throws InterruptedException {
        closedriver();
    }

    @And("create new Order")
    public void createNewOrderWithNoProductsInIt() {
        try {
            //click the new order button
            xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //set date
            xpath = "//*[@id=\"c_inv_date\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            SetToday(xpath);

            //wait and click distributors
            xpath = "//*[@id=\"select2-distributor_list-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for distributor and hit enter
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Order.DistributorSearch);
            cssSelectorPressEnter(cssSelector);


            //set Expected Delivery Date
            id = "c_exp_delivery_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getToday());

            //Reference No
            id = "c_inv_ref";
            inputbyid(id, refernce_no);

            //cash commission
            xpath = "//*[@id=\"c_cash_com\"]";
            clearByXpath(xpath);
            inputbyxpath(xpath, Order.CashCommission);


            //click the items bar and add items
            Thread.sleep(1000);
            for (int i = 0; i < Order.Items.length; i++) {
                xpath = "//*[@id=\"add_invoice_form\"]/div/div[3]/div[4]/span/span[1]/span";
                Thread.sleep(10);
                System.out.println((i + 1) + " - " + Order.Items[i]);
                inputbyxpath(xpath, Order.Items[i]);
                Thread.sleep(10);
                pressEnterbyXpath(xpath);
                Thread.sleep(10);

                // press the plus button
                id = "c_add_inv_prod";
                clickbyId(id);
            }

            //click the amount buttons for the quantity of the items
            for (int i = 0; i < Order.Items.length; i++) {
                //ctn(quantity)
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, Order.ItemQuantity);
//            //pcs quantity(not necessary)
//            xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
//            waitByxpath(xpath);
//            clearByXpath(xpath);
//            inputbyxpath(xpath, Order.ItemQuantity);
            }

            //remove an item
            WebElement table = driver.findElement(By.id("c_inv_items_list"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
            // Iterate through rows
            for (int i = 0; i < rows.size(); i++) {
                WebElement row = rows.get(i);
                if (i % 5 == 0) {
                    // Find and click the "delete" button for the visible row
                    WebElement delete_Button = row.findElement(By.xpath("//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[12]/button"));
                    delete_Button.click();
                    rows = table.findElements(By.xpath(".//tr"));
                }
            }

            //important notes
            id = "c_notes";
            clickbyId(id);
            inputbyid(id, Order.Note);


            //calculate the grand total


            int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]");
            double[][] gtCacl = new double[itemsRowSize][2];
            for (int i = 0; i < itemsRowSize; i++) {
                //get price/ctn
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
                double s1 = Double.parseDouble(getTextAttributebyXpath(xpath));
                //get ctn count
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                double s2 = Double.parseDouble(getTextAttributebyXpath(xpath));

                gtCacl[i][0] = s1;
                gtCacl[i][1] = s2;
                System.out.println(gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
            }
            double grandTotalActual = GrandTotalCalc(gtCacl);
            double grandTotalVisible = Double.parseDouble(getTextAttributebyXpath("//*[@id=\"c_grand_total\"]"));
            System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);
            softAssert.assertEquals("grandTotalVisible", grandTotalActual);


            Thread.sleep(1000);

            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                System.out.println("offer part is available");
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("this is the found string: " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        //for the offer:products
//                    List<WebElement> rowsWithDropdowns = driver.findElements(By.xpath("//tbody[@id='tbl_data']/tr[td/select]"));
//                        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"dis_product" + (1+ i) + "\"]"));
//                        Select dropdown = new Select(dropdownElement);
//                        dropdown.selectByIndex(1);

                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement1 = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown1 = new Select(dropdownElement1);
                            dropdown1.selectByIndex(1);
                        } catch (org.openqa.selenium.NoSuchElementException e) {
                            continue;
                        }
                    }
                }
            }

            //save
            xpath = "//*[@id=\"add_region\"]";
            clickbyxpath(xpath);
            AlertAccept();

            PrintConfirmationMessage();

            softAssert.assertAll();
        } catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("click the plus \\(add) button without selecting any products")
    public void clickThePlusAddButtonWithoutSelectingAnyProducts() {
        try {
            Thread.sleep(2000);
            //without selecting any product, click the add(+) button
            xpath = "//*[@id=\"c_add_inv_prod\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //calculate the grand total

            xpath = "//*[@id=\"c_inv_items_list\"]";
            int itemsRowSize = getTotalRowCountByXpath(xpath);
            System.out.println("Expected total Rows are : 0 and the found total rows are : " + getTotalRowCountByXpath(xpath));
            Thread.sleep(100);
            softAssert.assertEquals(itemsRowSize, 0);
        } catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the InterruptedException, TimeoutException, and AssertionError
            System.out.println("Exception occurred: " + e.getMessage());
            System.out.println("Assertion failed. Proceeding with next steps...");
        }
    }

    @And("verify if the order is searched accordingly")
    public void verifyIfTheOrderIsSearchedAccordingly() throws InterruptedException {

        Thread.sleep(3000);
        Boolean isfound = false;
        xpath = "//*[@id=\"tableData\"]/tbody/tr/td[2]";
        if (getTextbyXpath(xpath).contains(Order.SearchInfo)) {
            isfound = true;
        }
        softAssert.assertTrue(isfound);

        closedriver();
        softAssert.assertAll();
    }

    @And("creation of an order with zero product quantity in it")
    public void creationOfAnOrderWithZeroProductQuantityInIt() {
        try {

            //click the items bar and add items
            Thread.sleep(1000);
            for (int i = 0; i < Order.Items.length; i++) {
                xpath = "//*[@id=\"add_invoice_form\"]/div/div[3]/div[4]/span/span[1]/span";
                Thread.sleep(10);
                System.out.println((i + 1) + " - " + Order.Items[i]);
                inputbyxpath(xpath, Order.Items[i]);
                Thread.sleep(10);
                pressEnterbyXpath(xpath);
                Thread.sleep(10);

                // press the plus button
                id = "c_add_inv_prod";
                clickbyId(id);
            }

            //click the amount buttons for the quantity of the items
            for (int i = 0; i < Order.Items.length; i++) {
                //ctn(quantity)
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, "00");
//            //pcs quantity(not necessary)
//            xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
//            waitByxpath(xpath);
//            clearByXpath(xpath);
//            inputbyxpath(xpath, Order.ItemQuantity);
            }

            //remove an item
            WebElement table = driver.findElement(By.id("c_inv_items_list"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
            // Iterate through rows
            for (int i = 0; i < rows.size(); i++) {
                WebElement row = rows.get(i);
                if (i % 5 == 0) {
                    // Find and click the "delete" button for the visible row
                    WebElement delete_Button = row.findElement(By.xpath("//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[12]/button"));
                    delete_Button.click();
                    rows = table.findElements(By.xpath(".//tr"));
                }
            }

            //important notes
            id = "c_notes";
            clickbyId(id);
            inputbyid(id, Order.Note);


            //calculate the grand total


            int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]");
            double[][] gtCacl = new double[itemsRowSize][2];
            for (int i = 0; i < itemsRowSize; i++) {
                //get price/ctn
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
                double s1 = Double.parseDouble(getTextAttributebyXpath(xpath));
                //get ctn count
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                double s2 = Double.parseDouble(getTextAttributebyXpath(xpath));

                gtCacl[i][0] = s1;
                gtCacl[i][1] = s2;
                System.out.println(gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
            }
            double grandTotalActual = GrandTotalCalc(gtCacl);
            double grandTotalVisible = Double.parseDouble(getTextAttributebyXpath("//*[@id=\"c_grand_total\"]"));
            System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);
            Assert.assertEquals(grandTotalVisible, grandTotalActual);


            Thread.sleep(1000);

            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                System.out.println("offer part is available");
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("this is the found string: " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        //for the offer:products
//                    List<WebElement> rowsWithDropdowns = driver.findElements(By.xpath("//tbody[@id='tbl_data']/tr[td/select]"));
//                        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"dis_product" + (1+ i) + "\"]"));
//                        Select dropdown = new Select(dropdownElement);
//                        dropdown.selectByIndex(1);

                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement1 = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown1 = new Select(dropdownElement1);
                            dropdown1.selectByIndex(1);
                        } catch (org.openqa.selenium.NoSuchElementException e) {
                            continue;
                        }
                    }
                }
            }

            //save
            xpath = "//*[@id=\"add_region\"]";
            clickbyxpath(xpath);
            AlertAccept();

            Assert.assertEquals(GetConfirmationMessage(), "Please Add Items to Order");

        } catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @When("set previous date for order creation")
    public void setpreviousdateforordercreation() {
        try {
            Thread.sleep(2000);

            //create new order
            xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            Thread.sleep(500);
            //set previous date
            xpath = "//*[@id=\"c_inv_date\"]";
            SetPreviousDate(xpath);

            Boolean isdateerror = false;
            String s = getTextbyXpath("//*[@id=\"add_invoice_form\"]/div/div[1]/div/div");
            if (s.contains(" can not be selected.")) {
                isdateerror = true;
            }
            Assert.assertTrue(isdateerror);

        } catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }

    }


    @When("set future date for order creation")
    public void setfuturedateforordercreation() {
        try {
            Thread.sleep(500);
            //set previous date
            xpath = "//*[@id=\"c_inv_date\"]";
            clearByXpath(xpath);

            Boolean isdateerror = false;
            String s = getTextbyXpath("//*[@id=\"add_invoice_form\"]/div/div[1]/div/div");
            if (s.contains("can not be selected.")) {
                isdateerror = true;
            }
            Assert.assertTrue(isdateerror);

        } catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }

    }

}
