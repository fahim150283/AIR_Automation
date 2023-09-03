import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class test extends Page_Options {
    //    @BeforeMethod
    @Test
    public void login_for_creating_new_pre_invoice() throws InterruptedException {
        Login("h.abul");
        cssSelector = ".menues-bar:nth-child(14) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);

        Thread.sleep(1000);

        id = "search";
        waitById(id);
        inputbyid(id, "CashTEST88481");

        Thread.sleep(1000);


        row_element_click_By_xpath_and_id("//tbody[@id='offer_table']//tr[./td[contains(text(),'CashTEST88481')]]","btn_view");
    }
}
