package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Collections extends Page_Options {
    @Given("Login to Search Collection")
    public void login_to_search_collection() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Collections");
    }

    @When("search for Collection")
    public void search_for_collection() throws InterruptedException {
        try {
            xpath = "//*[@id=\"tableData_filter\"]/label/input";
            Thread.sleep(1000);
            inputbyxpath(xpath, Collection.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("description of a Collection")
    public void description_of_a_collection() {
        //scroll for now
        scrollToTheBottom();
    }

    @Then("close Collection")
    public void close_collection() throws InterruptedException {
        closedriver();
    }


    @Given("login for creating Collection")
    public void login_for_creating_collection() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Collections");
    }

    @And("create new Collection")
    public void create_new_collection() {
        try {

            //click the create new button
            xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
            clickbyxpath(xpath);

            //select date
            xpath = "//*[@id=\"col_date\"]";
            waitByxpath(xpath);
            inputbyxpath(xpath, getToday());

            //select Distributor
            xpath = "//*[@id=\"select2-distri-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for bhai bhai and hit enter
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Collection.DistributorSearch);
            cssSelectorPressEnter(cssSelector);

            //collected by
            id = "col_by";
            inputbyid(id, Collection.CollectedBy);

            //Advance Collection or Collection for order
            Boolean advanceCollection = Collection.AdvanceCollection;
            if (advanceCollection == true) {
                //enter pay amount
                id = "pay_amount";
                waitById(id);
                clearById(id);
                inputbyid(id, Collection.CollectionAmount);

                //money receipt number
                Random random = new Random();
                id = "mny_rcpt_num";
                waitById(id);
                inputbyid(id, Collection.MoneyReceipt + random);
            } else {
                //Adjust from Advance or regular collection
                Boolean adjustFromAdvance = Collection.AdjustFromAdvance;
                if (adjustFromAdvance == true) {
                    //click the checkbox
                    id = "adjust_advance";
                    clickbyId(id);
                } else {
                    //enter pay amount
                    id = "pay_amount";
                    waitById(id);
                    clearById(id);
                    String temp = String.valueOf(getValuebyXpath("//*[@id=\"rcv_amount\"]"));// it stores the value of payable amount
                    System.out.println(temp);
                    waitById(id);
                    inputbyid(id, temp);


                    //money receipt number
                    Random random = new Random();
                    id = "mny_rcpt_num";
                    waitById(id);
                    inputbyid(id, Collection.MoneyReceipt);
                }

                //click the order
                String name = "order_id[]";
                clickByName(name);

            }


            Boolean isCash = driver.findElement(By.xpath("//*[@id=\"inlineRadio1\"]")).isSelected();
            if (isCash != Collection.CollectionInCash) {
                if (Collection.InstrumentType.contains("Direct Debit")) {
                    // Find the dropdown element
                    // Select "Bank Cheque" by visible text
                    WebElement dropdown = driver.findElement(By.id("sel_instr_type"));
                    Select select = new Select(dropdown);
                    select.selectByVisibleText("Direct Debit");

                    //input date
                    xpath = "//*[@id=\"instru_date\"]";
                    inputbyxpath(xpath, getToday());

                    //input the  ac/slip/cheque/card number
                    xpath = "//*[@id=\"instru_num\"]";
                    inputbyxpath(xpath, Collection.Field1);

                    //input the  Bank
                    xpath = "//*[@id=\"instru_issuer\"]";
                    inputbyxpath(xpath, Collection.Field2);

                    //input the  card/branch/paid through
                    xpath = "//*[@id=\"instru_issue_to\"]";
                    inputbyxpath(xpath, Collection.Field3);

                    //input the name
                    xpath = "//*[@id=\"instru_provider\"]";
                    inputbyxpath(xpath, Collection.Field4);

                } else if (Collection.InstrumentType.contains("Bank Cheque")) {
                    // Find the dropdown element
                    // Select "Bank Cheque" by visible text
                    WebElement dropdown = driver.findElement(By.id("sel_instr_type"));
                    Select select = new Select(dropdown);
                    select.selectByVisibleText("Bank Cheque");

                    //input date
                    xpath = "//*[@id=\"instru_date\"]";
                    inputbyxpath(xpath, getToday());

                    //input the  ac/slip/cheque/card number
                    xpath = "//*[@id=\"instru_num\"]";
                    inputbyxpath(xpath, Collection.Field1);

                    //input the  Bank
                    xpath = "//*[@id=\"instru_issuer\"]";
                    inputbyxpath(xpath, Collection.Field2);

                    //input the  card/branch/paid through
                    xpath = "//*[@id=\"instru_issue_to\"]";
                    inputbyxpath(xpath, Collection.Field3);

                    //input the name
                    xpath = "//*[@id=\"instru_provider\"]";
                    inputbyxpath(xpath, Collection.Field4);

                } else if (Collection.InstrumentType.contains("Credit Transfer")) {
                    // Find the dropdown element
                    // Select "Bank Cheque" by visible text
                    WebElement dropdown = driver.findElement(By.id("sel_instr_type"));
                    Select select = new Select(dropdown);
                    select.selectByVisibleText("Credit Transfer");

                    //input date
                    xpath = "//*[@id=\"instru_date\"]";
                    inputbyxpath(xpath, getToday());

                    //input the  ac/slip/cheque/card number
                    xpath = "//*[@id=\"instru_num\"]";
                    inputbyxpath(xpath, Collection.Field1);

                    //input the  Bank
                    xpath = "//*[@id=\"instru_issuer\"]";
                    inputbyxpath(xpath, Collection.Field2);

                    //input the  card/branch/paid through
                    xpath = "//*[@id=\"instru_issue_to\"]";
                    inputbyxpath(xpath, Collection.Field3);

                    //input the name
                    xpath = "//*[@id=\"instru_provider\"]";
                    inputbyxpath(xpath, Collection.Field4);

                } else if (Collection.InstrumentType.contains("Credit Card")) {
                    // Find the dropdown element
                    // Select "Bank Cheque" by visible text
                    WebElement dropdown = driver.findElement(By.id("sel_instr_type"));
                    Select select = new Select(dropdown);
                    select.selectByVisibleText("Credit Transfer");

                    //input date
                    xpath = "//*[@id=\"instru_date\"]";
                    inputbyxpath(xpath, getToday());

                    //input the  ac/slip/cheque/card number
                    xpath = "//*[@id=\"instru_num\"]";
                    inputbyxpath(xpath, Collection.Field1);

                    //input the  Bank
                    xpath = "//*[@id=\"instru_issuer\"]";
                    inputbyxpath(xpath, Collection.Field2);

                    //input the  card/branch/paid through
                    xpath = "//*[@id=\"instru_issue_to\"]";
                    inputbyxpath(xpath, Collection.Field3);

                    //input the name
                    xpath = "//*[@id=\"instru_provider\"]";
                    inputbyxpath(xpath, Collection.Field4);

                } else if (Collection.InstrumentType.contains("Debit Card")) {
                    // Find the dropdown element
                    // Select "Bank Cheque" by visible text
                    WebElement dropdown = driver.findElement(By.id("sel_instr_type"));
                    Select select = new Select(dropdown);
                    select.selectByVisibleText("Debit Card");

                    //input date
                    xpath = "//*[@id=\"instru_date\"]";
                    inputbyxpath(xpath, getToday());

                    //input the  ac/slip/cheque/card number
                    xpath = "//*[@id=\"instru_num\"]";
                    inputbyxpath(xpath, Collection.Field1);

                    //input the  Bank
                    xpath = "//*[@id=\"instru_issuer\"]";
                    inputbyxpath(xpath, Collection.Field2);

                    //input the  card/branch/paid through
                    xpath = "//*[@id=\"instru_issue_to\"]";
                    inputbyxpath(xpath, Collection.Field3);

                    //input the name
                    xpath = "//*[@id=\"instru_provider\"]";
                    inputbyxpath(xpath, Collection.Field4);

                } else if (Collection.InstrumentType.contains("E-Money")) {
                    // Find the dropdown element
                    // Select "Bank Cheque" by visible text
                    WebElement dropdown = driver.findElement(By.id("sel_instr_type"));
                    Select select = new Select(dropdown);
                    select.selectByVisibleText("E-Money");

                    //input date
                    xpath = "//*[@id=\"instru_date\"]";
                    inputbyxpath(xpath, getToday());

                    //input the  ac/slip/cheque/card number
                    xpath = "//*[@id=\"instru_num\"]";
                    inputbyxpath(xpath, Collection.Field1);

                    //input the  Bank
                    xpath = "//*[@id=\"instru_issuer\"]";
                    inputbyxpath(xpath, Collection.Field2);

                    //input the  card/branch/paid through
                    xpath = "//*[@id=\"instru_issue_to\"]";
                    inputbyxpath(xpath, Collection.Field3);

                    //input the name
                    xpath = "//*[@id=\"instru_provider\"]";
                    inputbyxpath(xpath, Collection.Field4);

                } else if (Collection.InstrumentType.contains("Telex Transfer (TT)")) {
                    // Find the dropdown element
                    // Select "Bank Cheque" by visible text
                    WebElement dropdown = driver.findElement(By.id("sel_instr_type"));
                    Select select = new Select(dropdown);
                    select.selectByVisibleText("Telex Transfer (TT)");

                    //input date
                    xpath = "//*[@id=\"instru_date\"]";
                    inputbyxpath(xpath, getToday());

                    //input the  ac/slip/cheque/card number
                    xpath = "//*[@id=\"instru_num\"]";
                    inputbyxpath(xpath, Collection.Field1);

                    //input the  Bank
                    xpath = "//*[@id=\"instru_issuer\"]";
                    inputbyxpath(xpath, Collection.Field2);

                    //input the  card/branch/paid through
                    xpath = "//*[@id=\"instru_issue_to\"]";
                    inputbyxpath(xpath, Collection.Field3);

                    //input the name
                    xpath = "//*[@id=\"instru_provider\"]";
                    inputbyxpath(xpath, Collection.Field4);

                } else if (Collection.InstrumentType.contains("Demand Draft (DD)")) {
                    // Find the dropdown element
                    // Select "Bank Cheque" by visible text
                    WebElement dropdown = driver.findElement(By.id("sel_instr_type"));
                    Select select = new Select(dropdown);
                    select.selectByVisibleText("Demand Draft (DD)");

                    //input date
                    xpath = "//*[@id=\"instru_date\"]";
                    inputbyxpath(xpath, getToday());

                    //input the  ac/slip/cheque/card number
                    xpath = "//*[@id=\"instru_num\"]";
                    inputbyxpath(xpath, Collection.Field1);

                    //input the  Bank
                    xpath = "//*[@id=\"instru_issuer\"]";
                    inputbyxpath(xpath, Collection.Field2);

                    //input the  card/branch/paid through
                    xpath = "//*[@id=\"instru_issue_to\"]";
                    inputbyxpath(xpath, Collection.Field3);

                    //input the name
                    xpath = "//*[@id=\"instru_provider\"]";
                    inputbyxpath(xpath, Collection.Field4);

                } else if (Collection.InstrumentType.contains("Credit Note")) {
                    // Find the dropdown element
                    // Select "Bank Cheque" by visible text
                    WebElement dropdown = driver.findElement(By.id("sel_instr_type"));
                    Select select = new Select(dropdown);
                    select.selectByVisibleText("Credit Note");

                    //input date
                    xpath = "//*[@id=\"instru_date\"]";
                    inputbyxpath(xpath, getToday());

                    //input the  ac/slip/cheque/card number
                    xpath = "//*[@id=\"instru_num\"]";
                    inputbyxpath(xpath, Collection.Field1);

                    //input the name
                    xpath = "//*[@id=\"instru_provider\"]";
                    inputbyxpath(xpath, Collection.Field4);

                }
            }

            //click the save button
            id = "add_col";
            clickbyId(id);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close the Collection window")
    public void close_the_collection_window() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }
}
