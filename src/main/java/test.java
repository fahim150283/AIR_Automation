import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.Page_Options;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class test extends Page_Options {
    @Test
    public void login_for_creating_new_pre_invoice() throws InterruptedException {
        Login(user_Siam);
        Thread.sleep(2000);
        driver.get("http://192.168.11.182/air_2/views/geo_location_mapping/");

//        Thread.sleep(2000);
        xpath = "//*[@id=\"geo_location_mapping_tableData\"]";
        getRowCountByNameAndDate(xpath,"nothing");

//        int cnt = 0;
//
//        // Loop through each row and check the conditions
//        for (int i = 0; i < rowCount; i++) {
//
//            WebElement nameElement = driver.findElement(By.xpath(xpath + "/tr[" + (i + 1) + "]/td[2]"));
//            WebElement dateElement = driver.findElement(By.xpath(xpath + "/tr[" + (i + 1) + "]/td[4]"));
//
//            String rowName = nameElement.getText();
//            String rowDate = dateElement.getText();
//
//            if (rowName.equals("SPI-00012119") && rowDate.equals("SPC-00012119")) {
//                cnt++;
//            }
//        }
//        System.out.println(cnt);
        closedriver();
    }
}
