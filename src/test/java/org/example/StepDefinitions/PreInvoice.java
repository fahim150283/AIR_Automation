package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.testng.annotations.Test;

public class PreInvoice extends Page_Options {


    @Given("^Login to Search PreInvoice$")
    public void login_for_accessing_pre_invoice() {
        url = "http://192.168.11.182/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);

        cssSelector = ".active:nth-child(4) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for preInvoice")
    public void search_for_pre_invoice() {
        xpath = "//*[@id=\"tableData_filter\"]/label/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, "12012");
    }

    @And("description of a preinvoice")
    public void description_of_a_preinvoice() {
        id = "btn_view";
        waitById(id);
        clickbyId(id);
    }

    @Then("^close PreInvoice for search$")
    public void closePreInvoice() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }

//    @Given("login for creating new preInvoice")
    @Test
    public void login_for_creating_new_pre_invoice() {
        url = "http://192.168.11.182/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);
        //click pre invoice from left bar
        cssSelector = ".active:nth-child(4) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
//    }
//
//    @Given("create new preInvoice")
//    public void create_new_pre_invoice() {
        //click the create new pre invoice
        xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
        clickbyxpath(xpath);
        //pre Invoice date
        xpath = "//*[@id=\\\"c_inv_date\\\"]";
        clearByXpath(xpath);
        waitByxpath(xpath);
        clickbyxpath(xpath);
        inputbyxpath(xpath,getToday());
//        //wait and click distributors //*[@id="add_pre_invoice_form"]/div/div[2]/div[1]/span/span[1]/span
//        xpath = "//*[@id=\"add_pre_invoice_form\"]/div/div[1]/div[1]/span";
//        waitByxpath(xpath);
//        clickbyxpath(xpath);
//        //search for bhai bhai and hit enter
//        cssSelector = ".select2-search--dropdown > .select2-search__field";
//        inputbycssselector(cssSelector,"bhai bhai");
//        cssSelectorPressEnter(cssSelector);
//        //wait and click routes
//        xpath = "//*[@id=\"add_pre_invoice_form\"]/div/div[1]/div[3]/span/span[1]/span";
//        waitByxpath(xpath);
//        clickbyxpath(xpath);
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
//        }

    }

    @Then("close the PreInvoice window")
    public void close_the_pre_invoice_window() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }

}
