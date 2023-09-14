package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Apps extends Page_Options {

    /*
    create a new app
    */
    @Given("login for creating new  app")
    public void login_for_creating_new_app() {
        Login(user_Fahim);

        //click the Apps option from the Side bar
        cssSelector = ".menues-bar:nth-child(6) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("create new  app")
    public void create_new_app() throws InterruptedException {
        Thread.sleep(500);
        //click the create new button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        Thread.sleep(500);
        //fillup name
        id = "add_name";
        waitById(id);
        inputbyid(id, "fight club");

        //fillup Display name
        id = "add_d_name";
        waitById(id);
        inputbyid(id, "fight club");

        //functions
        xpath = "//*[@id=\"add_apps_form\"]/div/div[3]/div/span/span[1]/span";
        waitByxpath(xpath);
        for (int i = 0; i < 7; i++) {
            waitByxpath(xpath);
            pressDownbyXpath(xpath);
            pressEnterbyXpath(xpath);
        }
        clickbyxpath(xpath);

        //Status
        xpath = "//*[@id=\"add_status\"]";
        boolean active = false;
        if (active == false) {
            clickbyxpath(xpath);
            pressDownbyXpath(xpath);
            pressEnterbyXpath(xpath);
        }

        //click the save button
        xpath = "//*[@id=\"add_apps_form\"]/div/div[5]/div/button";
        waitByxpath(xpath);
        clickbyxpath(xpath);
    }

    @And("verify that the app is created and listed in the apps list")
    public void verifyThatTheAppIsCreatedAndListedInTheAppsList() throws InterruptedException {
        Thread.sleep(500);
        int ttlRow = getTotalRowCountByXpath("//*[@id=\"apps_table\"]");
        boolean found_app = false;
        for (int i = 0; i < ttlRow; i++) {
            xpath = "//*[@id=\"apps_table\"]/tr[" + (i + 1) + "]/td[2]/p";
            String s = getTextbyXpath(xpath);
            name = "fight club";

            if (name.equals(s)) {
                found_app = true;
            }
        }
        Assert.assertTrue(found_app);
    }

    @Then("close driver for creating apps")
    public void close_driver_for_apps() throws InterruptedException {
        closedriver();
    }


    /*
    editing an app
    */
    @Given("login for editing an app")
    public void login_for_editing_an_app() {
        Login(user_Fahim);

        //click the Apps option from the Side bar
        cssSelector = ".menues-bar:nth-child(6) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for the app")
    public void search_for_the_app() throws InterruptedException {
        Thread.sleep(500);
        id = "search_input";
        waitById(id);
        inputbyid(id, "fight club");
    }

    @And("edit the app")
    public void editTheApp() throws InterruptedException {
        Thread.sleep(1000);

        // click the edit button of the displayed app
        WebElement table = driver.findElement(By.id("apps_tableData"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "Add App Permissions" button for the visible row
                WebElement editButton = row.findElement(By.id("btn_edit"));
                editButton.click();
            }
        }

        //edit name
        Thread.sleep(300);
        id = "edit_name";
        waitById(id);
        clearById(id);
        inputbyid(id, "Fight_Club");

        //edit display name
        id = "edit_d_name";
        waitById(id);
        clearById(id);
        inputbyid(id, "Fight_Club");

        //status
        xpath = "//*[@id=\"edit_status\"]";
        String status = getTextbyXpath(xpath);
        if (status != "Active") {
            clickbyxpath(xpath);
            pressUPbyXpath(xpath);
            pressEnterbyXpath(xpath);
        }
        //save
        id = "edit_apps";
        clickbyId(id);
    }

    @Then("verify that the app is edited")
    public void verify_that_the_app_is_edited() throws InterruptedException {
        //search the app
        Thread.sleep(2000);
        id = "search_input";
        waitById(id);
        inputbyid(id, "Fight_Club");
        Thread.sleep(500);

        WebElement table = driver.findElement(By.id("apps_tableData"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                //verify name
                WebElement element1 = row.findElement(By.xpath(".//td[2]/p"));
                String name = element1.getText();
                Assert.assertEquals(name, "Fight_Club");
                System.out.println("Name is perfect");

                //verify display name
                WebElement element2 = row.findElement(By.xpath(".//td[3]/p"));
                String display_name = element2.getText();
                Assert.assertEquals(display_name, "Fight_Club");
                System.out.println("Display Name is perfect");

                //verify status
                WebElement element3 = row.findElement(By.xpath(".//td[5]/p"));
                String status = element3.getText();
                Assert.assertEquals(status, "Active");
                System.out.println("Status is perfect");
            }
        }
    }

    @And("close the driver for editing apps")
    public void close_the_driver_for_editing_apps() throws InterruptedException {
        closedriver();
    }


    /*
    Give permission to a user for an App
    */
    @Given("login for giving access to an user")
    public void login_for_giving_access_to_an_user() {
        Login(user_Fahim);

        //click the Apps option from the Side bar
        cssSelector = ".menues-bar:nth-child(6) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for the app to give access")
    public void search_for_the_app_to_give_access() throws InterruptedException {
        Thread.sleep(1000);
        id = "search_input";
        waitById(id);
        inputbyid(id, "fight");
    }

    @And("add permission")
    public void add_permission() throws InterruptedException {
        Thread.sleep(1000);
        // click the edit button of the displayed app
        WebElement table = driver.findElement(By.id("apps_tableData"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "Add App Permissions" button for the visible row
                WebElement addButton = row.findElement(By.id("btn_add_emp"));
                addButton.click();
            }
        }

        for (int i = 1; i <= 3; i++) {
            //click the employees field
            xpath = "//*[@id=\"select2-add_emp_list_1-container\"]";
            waitById(id);
            clickbyId(id);
//            //search for user
//            xpath = "//*[@id=\"modal_emp\"]/span/span/span[1]/input";
//            waitByxpath(xpath);
//            if (i != 1) {
//                inputbyxpath(xpath, "2062");
//            } else {
//                inputbyxpath(xpath, "1221");
//            }
//            pressEnterbyXpath(xpath);
//            if (i < 2) {
//                //add another row
//                id = "add-row";
//                clickbyId(id);
//            }
        }
    }

    @Then("Close the driver for app permission")
    public void close_the_driver_for_app_permission() {

    }

}