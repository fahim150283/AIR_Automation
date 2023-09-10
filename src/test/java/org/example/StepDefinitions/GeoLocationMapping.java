package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeoLocationMapping extends Page_Options {

    /*
       Create a new  Geo Location Mapping
    */
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

//        int rowCount = 1 + count_row_number_BYID("geo_loc_map_prevData_History_table");


        Thread.sleep(500);

        //click the checkbox
        xpath = "//*[@id=\"record_all\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //date
        id = "add_eff_start_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id, getLastMonth());

        for (int i = 0; i < 3; i++) {
            //choose region
            id = "select2-region_" + i + "-container";
            waitById(id);
            clickbyId(id);
            //enter the region name
            xpath = "/html/body/span/span/span[1]/input";
            clickbyxpath(xpath);
            for (int j = 0; j < i + 3; j++) {
                pressDownbyXpath(xpath);
            }
            pressEnterbyXpath(xpath);

            //choose depot
            id = "select2-depot_" + i + "-container";
            waitById(id);
            clickbyId(id);
            //enter the depot name
            xpath = "/html/body/span/span/span[1]/input";
            clickbyxpath(xpath);
            for (int j = 0; j < i + 3; j++) {
                pressDownbyXpath(xpath);
            }
            pressEnterbyXpath(xpath);

            //choose area
            id = "select2-area_" + i + "-container";
            waitById(id);
            clickbyId(id);
            //enter the area name
            xpath = "/html/body/span/span/span[1]/input";
            clickbyxpath(xpath);
            for (int j = 0; j < i + 3; j++) {
                pressDownbyXpath(xpath);
            }
            pressEnterbyXpath(xpath);

            //choose territory
            id = "select2-territory_" + i + "-container";
            waitById(id);
            clickbyId(id);
            //enter the territory name
            xpath = "/html/body/span/span/span[1]/input";
            clickbyxpath(xpath);
            for (int j = 0; j < i + 3; j++) {
                pressDownbyXpath(xpath);
            }
            pressEnterbyXpath(xpath);

            if (i < 2) {
                //click plus button
                id = "add-row";
                waitById(id);
                clickbyId(id);
            }
        }

        //click the checkbox of the last row
        id = "rwdr_record_2";
        waitById(id);
        clickbyId(id);

        //delete last row by clicking delete button
        id = "delete-row";
        waitById(id);
        clickbyId(id);

        //click save
        id = "add_distributors";
        clickbyId(id);

        AlertAccept();
    }

    @Then("close the Geo Location Mapping window")
    public void close_the_geo_location_mapping_window() throws InterruptedException {
        closedriver();
    }


    /*
       Create a new  Geo Location Mapping
    */
    @Given("Login to Search  Geo Location Mapping")
    public void login_to_search_geo_location_mapping() throws InterruptedException {
        Login(user_Siam);
        Thread.sleep(1000);
        driver.get("http://192.168.11.182/air_2/views/geo_location_mapping/");
    }

    @When("search for Geo Location Mappings of an user and copy important elements from Geo Location Mapping")
    public void search_for_geo_location_mappings_of_an_user_and_copy_important_elements_from_geo_location_mapping() throws InterruptedException {
        xpath = "//*[@id=\"geo_location_mapping_table\"]";
        getRowCountByNameAndDate(xpath, "Sheikh Salah Uddin (1085)");
//        System.out.println(x);
//        //a 2 dimensional array to store data
//        String[][] arr = new String[x][5];
//        int count = 0;
//
//        // Find all the rows in the table
//        java.util.List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"geo_location_mapping_table\"]/tr"));
//
//        // Loop through each row to find the matching criteria
//        for (WebElement row : rows) {
//            WebElement nameElement = row.findElement(By.xpath(".//td[2]/p"));
//            WebElement dateElement = row.findElement(By.xpath(".//td[4]/p"));
//
//            String name = nameElement.getText();
//            String date = dateElement.getText();
//
//            // Check if the name matches and date is empty
//            if (name.equals("Sheikh Salah Uddin (1085)") && date.isEmpty()) {
//                count++;
//                // Click the "btn_view" element within this row
//                id = "btn_view";
//                WebElement btnView = row.findElement(By.id(id));
//                btnView.click();
//                Thread.sleep(1000);
//
//                //copy elements
//                xpath = "//*[@id=\"part1_body\"]/tr[2]/td[2]/p";
//                arr[count][0] = getTextbyXpath(xpath);
//                xpath = "//*[@id=\"part1_body\"]/tr[4]/td[2]/p";
//                arr[count][1] = getTextbyXpath(xpath);
//                xpath = "//*[@id=\"part1_body\"]/tr[5]/td[2]/p";
//                arr[count][2] = getTextbyXpath(xpath);
//                xpath = "//*[@id=\"part1_body\"]/tr[6]/td[2]/p";
//                arr[count][3] = getTextbyXpath(xpath);
//                xpath = "//*[@id=\"part1_body\"]/tr[7]/td[2]/p";
//                arr[count][4] = getTextbyXpath(xpath);
//
//
//                //unnecessary
//                for (int i = 10; i < 5; i++) {
//                    System.out.println(arr[count][i]);
//                }
//            }
//        }



    }

    @Then("close  Geo Location Mapping for search")
    public void close_geo_location_mapping_for_search() throws InterruptedException {
        closedriver();
    }

}
