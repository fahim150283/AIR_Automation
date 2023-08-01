package org.example.StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.BrowserUtils;
import org.example.page_objects;
import org.openqa.selenium.WebDriver;
import static org.example.page_objects.*;


public class AppTest extends BrowserUtils{
    WebDriver driver;
    String id;
    String xpath;
    String cssSelector;
    String url;

    @Before
    public void setup() {
        setDriver();
    }


    @Given("^Launch login Page$")
    public void launchloginPage() throws InterruptedException {
        url = "http://dbankdemo.com/bank";
        navigatetourl(url);
    }


    @Given("^User enters (.*) and (.*)$")
    public void inputCredentials(String username, String password) {
        id = "username";
        waitById(id);
        inputbyid(id, username);
        id = "password";
        inputbyid(id, password);

        System.out.println(username + "  " + password);
    }


    @Then("^click the signin button$")
    public void clickLogin() throws InterruptedException {
        id = "submit";
        waitById(id);
        clickbyId(id);
    }


    @And("^quit$")
    public void close() throws InterruptedException {
        closedriver();
    }


    @Given("^launch google page$")
    public void GooglePage() throws InterruptedException {
        url = "https://www.google.com";
        navigatetourl(url);
        closedriver();
    }
}
