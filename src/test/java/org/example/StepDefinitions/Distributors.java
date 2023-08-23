package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Page_Options;

public class Distributors extends Page_Options {
    @Given("login for creation of a Distributor")
    public void login_for_creation_of_a_distributor() {
        url = "http://192.168.11.182/air_2/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);

        cssSelector = ".menues-bar:nth-child(10) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @And("create new Distributor")
    public void create_new_distributor() throws InterruptedException {
        //click the create new button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        Thread.sleep(1500);

        //Reference
        id = "add_ref";
        inputbyid(id,"Fahim bhai");
        //SDF
        id = "add_sdf";
        inputbyid(id,"Fahim bhai");
        //RDF
        id = "add_rdf";
        inputbyid(id,"Fahim bhai");
        //date
        id = "add_start_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id,getToday());
        //Region
        id = "select2-region_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "Cumilla");
        cssSelectorPressEnter(cssSelector);

        //depot
        id = "select2-depot_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "Noakhali");
        cssSelectorPressEnter(cssSelector);

        //Area
        id = "select2-area_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "area");
        cssSelectorPressEnter(cssSelector);

        //territory
        id = "select2-area_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "area");
        cssSelectorPressEnter(cssSelector);

        //B P code

        //RSM

        //  ASM / Sr. ASM

        //FPR

        //Running FPR

        //Effective date
        xpath = "//*[@id=\"add_eff_running_fpr_start_date\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        inputbyxpath(xpath,getToday());

        //
    }
    @Then("close the Distributor window")
    public void close_the_distributor_window() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }
}
