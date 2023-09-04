package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Page_Options;

public class GeoLocationMapping extends Page_Options {

    @Given("login for creating new  Geo Location Mapping")
    public void login_for_creating_new_geo_location_mapping() throws InterruptedException {
        Login(user_Fahim);
        Thread.sleep(1000);
        url = "http://192.168.11.182/air_2/views/geo_location_mapping/";
        driver.get(url);
    }
    @And("create new  Geo Location Mapping")
    public void create_new_geo_location_mapping() throws InterruptedException {
        Thread.sleep(500);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div[1]/div[3]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //click the employee list
        id = "select2-add_emp_list-container";
        waitById(id);
        clickbyId(id);

        //type int the name of the employee and select
        xpath = "/html/body/span/span/span[1]/input";
        clickbyxpath(xpath);
        inputbyxpath(xpath, "siam");
        pressEnterbyXpath(xpath);

        Thread.sleep(500);

        //click the checkbox
        xpath = "//*[@id=\"record_5\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

    }
    @Then("close the Geo Location Mapping window")
    public void close_the_geo_location_mapping_window() {

    }

}
