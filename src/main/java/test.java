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
//        System.out.println(url);
//        url = "https://www.google.com/";
//        System.out.println(url);
//        Login(user_Siam);
        int s = 3 % 3;
        System.out.println(s);
    }
}
