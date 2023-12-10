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
    @Given("login for creating new app")
    public void login_for_creating_new_app() {
        Login_AIR2_AIR(Users.user_Fahim);

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
        inputbyid(id, Apps.Name);

        //fillup Display name
        id = "add_d_name";
        waitById(id);
        inputbyid(id, Apps.DisplayName);

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
        Thread.sleep(5000);
        int ttlRow = getTotalRowCountByXpath("//*[@id=\"apps_table\"]");
        boolean found_app = false;
        for (int i = 0; i < ttlRow; i++) {
            xpath = "//*[@id=\"apps_table\"]/tr[" + (i + 1) + "]/td[2]/p";
            String s = getTextbyXpath(xpath);
            name = Apps.Name;

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
        Login_AIR2_AIR(Users.user_Fahim);

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
        inputbyid(id, Apps.Name);
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
        inputbyid(id, Apps.EditedName);

        //edit display name
        id = "edit_d_name";
        waitById(id);
        clearById(id);
        inputbyid(id, Apps.EditedDisplayName);

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
        inputbyid(id, Apps.EditedName);
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
                Assert.assertEquals(name, Apps.EditedName);
                System.out.println("Name is perfect");

                //verify display name
                WebElement element2 = row.findElement(By.xpath(".//td[3]/p"));
                String display_name = element2.getText();
                Assert.assertEquals(display_name, Apps.EditedDisplayName);
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
        Login_AIR2_AIR(Users.user_Fahim);

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
        inputbyid(id, Apps.EditedName);
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

        //info about employee table
        WebElement emptable = driver.findElement(By.id("include_emp_func_tbody"));
        java.util.List<WebElement> rows1 = emptable.findElements(By.xpath(".//tr"));

        for (int i = 0; i < Apps.EmployeeInfo.length; i++) {
            Thread.sleep(200);
            //click the employees field
            xpath = "//*[@id=\"select2-add_emp_list_" + (i + 1) + "-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for user
            Thread.sleep(100);
            xpath = "//*[@id=\"modal_emp\"]/span/span/span[1]/input";
            clickbyxpath(xpath);
            waitByxpath(xpath);
            inputbyxpath(xpath, Apps.EmployeeInfo[i]);
            Thread.sleep(100);
            pressEnterbyXpath(xpath);
            if (Apps.EmployeeInfo.length > rows1.size() && (i + 1) < Apps.EmployeeInfo.length) {
                //add another row
                id = "add-row";
                clickbyId(id);
            } else if (Apps.EmployeeInfo.length < rows1.size() && (i) > Apps.EmployeeInfo.length) {
                //click the selected row
                xpath = "//*[@id=\"include_emp_func_tbody\"]/tr[" + (i + 1) + "]/td[1]/input";
                clickbyxpath(xpath);
                //remove a row
                id = "delete-row";
                clickbyId(id);
            }
        }

        // Locate all the rows in the table
        WebElement table1 = driver.findElement(By.id("include_emp_func_tbody"));
        java.util.List<WebElement> rows2 = table.findElements(By.tagName("tr"));

        //delete an employee
        // Iterate through the rows to find the one with "1077" in the dropdown
        for (int i = 0; i<Apps.EmployeeInfo.length; i++) {
            xpath = "//*[@id=\"select2-add_emp_list_"+(i+1)+"-container\"]";
            String s = getTextbyXpath(xpath);
            System.out.println(s);

            if (s.contains(Apps.EmployeeInfo[9])) {
                //select the row
                xpath = "//*[@id=\"include_emp_func_tbody\"]/tr["+(i+1)+"]/td[1]/input";
                clickbyxpath(xpath);

                Thread.sleep(200);
                //click the delete button
                id = "delete-row";
                clickbyId(id);
            }
        }

        //add functions for the employees
        id = "check_APPR";
        clickbyId(id);
        id = "check_CREATE";
        clickbyId(id);
        id = "check_EDIT";
        clickbyId(id);
        id = "check_LIST";
        clickbyId(id);
        id = "check_PRINT";
        clickbyId(id);
        id = "check_PRINTL";
        clickbyId(id);
        id = "check_VIEW";
        clickbyId(id);

        //click the save button
        id = "save";
        clickbyId(id);
    }

    @Then("Close the driver for app permission")
    public void close_the_driver_for_app_permission() throws InterruptedException {
        closedriver();
    }


    /*
    verify if the user has access to the app
    */
    @Given("login for checking access of first user")
    public void login_for_checking_access_of_first_user() {
        Login_AIR2_AIR(Users.user_Siam);
    }

    @And("verify from the side panel for the first user")
    public void verify_from_the_side_panel_for_the_first_user() throws InterruptedException {
        Thread.sleep(2000);
        // Specify the XPath to locate the element containing the string
        String xpathExpression = "//*[contains(text(), 'Fight_Club')]";

        // Find the element using the XPath
        WebElement element = driver.findElement(By.xpath(xpathExpression));

        Boolean found = false;
        if (element != null) {
            found = true;
        }
        Assert.assertTrue(found);
    }

    @And("close driver for verification of app permission for first user")
    public void close_driver_for_verification_of_app_permission_for_first_user() throws InterruptedException {
        closedriver();
    }

    @Then("login for checking access of 2nd user")
    public void login_for_checking_access_of_2nd_user() {
        Login_AIR2_AIR(Users.user_Fahim);
    }

    @And("verify from the side panel for the 2nd user")
    public void verify_from_the_side_panel_for_the_2nd_user() throws InterruptedException {
        Thread.sleep(2000);
        // Specify the XPath to locate the element containing the string
        String xpathExpression = "//*[contains(text(), 'Fight_Club')]";

        // Find the element using the XPath
        WebElement element = driver.findElement(By.xpath(xpathExpression));

        Boolean found = false;
        if (element != null) {
            found = true;
        }
        Assert.assertTrue(found);
    }

    @And("close driver for verification of app permission for 2nd user")
    public void close_driver_for_verification_of_app_permission_for_2nd_user() throws InterruptedException {
        closedriver();
    }

}