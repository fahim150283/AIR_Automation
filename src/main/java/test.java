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
    String arr[] = new String[2];
    String s = "valobasha naai re vai";

    @Test
    public void login_for_creating_new_pre_invoice() throws InterruptedException {
        arr[0]="valobasha";
        arr[1]="vai";
    }
    @Test
    public void test(){
        boolean t = s.contains(arr[0]);
        System.out.println(t);
        boolean at = s.contains(arr[1]);
        System.out.println(at);
    }
}
