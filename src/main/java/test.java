import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class test extends Page_Options {
    //    @BeforeMethod
    @Test
    public void login_for_creating_new_pre_invoice() throws InterruptedException {
        Random random = new Random();

        // Generate a random integer between 0 (inclusive) and a specified upper bound (exclusive)
        double randomNumber = 100.01; // Change 100 to the desired upper bound

        System.out.println("Random number: " + randomNumber);
    }
}
