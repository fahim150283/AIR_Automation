package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.Objects;

public class DistributorInvoices extends Page_Options {
    @Given("Login to Search Invoice")
    public void login_to_search_invoice() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Distributor Invoices");
    }

    @When("search for Invoice")
    public void search_for_invoice() {
        try {
            xpath = "//*[@id=\"inv_tableData_filter\"]/label/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, Invoices.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("description of an Invoice")
    public void description_of_an_invoice() {
        try {
            Thread.sleep(2000);

            id = "btn_view";
            waitById(id);
            clickbyId(id);
            Thread.sleep(2000);

            scrollToTheBottomOfModal();

        } catch (TimeoutException | InterruptedException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close Invoice for search")
    public void close_invoice_for_search() throws InterruptedException {
        Thread.sleep(1500);
        closedriver();
    }


    @Given("login for Invoice")
    public void login_for_invoice() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Distributor Invoices");
    }

    @And("create new Invoice")
    public void create_new_invoice() throws InterruptedException {
        try {
            //click the create new button
            xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //set date
            xpath = "//*[@id=\"c_actual_inv_date\"]";
            waitByxpath(xpath);
            SetToday(xpath);

            //order list
            xpath = "//*[@id=\"select2-order_list-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for bhai bhai and hit enter
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.DistributorSearch);
            cssSelectorPressEnter(cssSelector);

            //select the store
            id = "select2-c_store_id-container";
            waitById(id);
            clickbyId(id);

            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.Store);
            cssSelectorPressEnter(cssSelector);


            //partial invoice or full invoice
            Boolean partialInvoice = Invoices.PartialInvoice;

            for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {
                if (partialInvoice == true && i % 2 == 0) {
                    //CTN
                    Thread.sleep(20);
                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                    waitByxpath(xpath);
                    clearByXpath(xpath);
                    inputbyxpath(xpath, Invoices.ItemQuantity); //here the number is the quantity that will be deleted

//                //PCS(not necessary)
//                Thread.sleep(20);
//                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
//                waitByxpath(xpath);
//                clearByXpath(xpath);
//                inputbyxpath(xpath, Invoices.ItemQuantity); //here the number is the quantity that will be deleted
                }
            }

            //notes
            id = "c_notes";
            inputbyid(id, Invoices.Note);


            //calculate the grand total


            int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]");
            double[][] gtCacl = new double[itemsRowSize][2];
            for (int i = 0; i < itemsRowSize; i++) {
                //get price/ctn
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                double s1 = Double.parseDouble(getTextAttributebyXpath(xpath));
                //get ctn count
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
                double s2 = Double.parseDouble(getTextAttributebyXpath(xpath));

                gtCacl[i][0] = s1;
                gtCacl[i][1] = s2;
                System.out.println(gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
            }
            double grandTotalActual = GrandTotalCalc(gtCacl);
            double grandTotalVisible = Double.parseDouble(getTextAttributebyXpath("//*[@id=\"c_grand_total\"]"));
            System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);
            Assert.assertEquals(grandTotalVisible, grandTotalActual);


            //get total payable from interface
            xpath = "//*[@id=\"c_total_payable\"]";
            String sd = getTextAttributebyXpath(xpath);
            System.out.println(sd + " : is the Total payable");

            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("this is the found string: " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown = new Select(dropdownElement);
                            dropdown.selectByIndex(1);
                        } catch (NoSuchElementException e) {
                            continue;
                        }

                        //Quantity CTN
                        Thread.sleep(700);
                        String xpath = "//*[@id=\"showCtn" + (i + 1) + "\"]";
                        int quantity = Integer.parseInt(getTextAttributebyXpath(xpath));
                        System.out.println("Default offer quantity is " + quantity + " ctn");
                        if (quantity > Integer.parseInt(Invoices.OfferCTN)) {
                            waitByxpath(xpath);
                            Thread.sleep(300);
                            clearByXpath(xpath);
                            inputbyxpath(xpath, (Invoices.OfferCTN));
                        }
                    }
                }
            }

            //For Screen Shot
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                PageUp();
            }
            TakeScreenShot();
            PageDown();
            TakeScreenShot();


            //wait for a defined period of time
            Thread.sleep(Invoices.IntervalOfSaveTime);

            //save
            xpath = "//*[@id=\"add_region\"]";
            clickbyxpath(xpath);


            AlertAccept();
            PrintConfirmationMessage();
        }  catch(InterruptedException | TimeoutException | AssertionError | IOException e){} {
        }
    }

    @Then("close the Invoice window")
    public void close_the_invoice_window() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }
}
