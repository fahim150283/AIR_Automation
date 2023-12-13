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
import java.util.Objects;
import java.util.Random;

public class test extends Page_Options {
    String arr[] = new String[2];
    String s = "0 - Kazi Polash (Officer)";

    @Test
    public void login_for_creating_new_pre_invoice() throws InterruptedException {
        int quantity = 10;
        System.out.println("SearchInfo "+Invoices.SearchInfo);
        System.out.println("DistributorSearch "+Invoices.DistributorSearch);
        System.out.println("Store "+Invoices.Store);
        System.out.println("ctnOffer "+Invoices.ctnOffer);
        System.out.println("Note "+Invoices.Note);
        System.out.println("ItemQuantity "+Invoices.ItemQuantity);
        System.out.println("OfferQuantity "+Invoices.OfferQuantity);
        System.out.println("CancelPartial "+Invoices.CancelPartial);
//        if(quantity > 2) {
//            System.out.println("nice");
//        }else {
//            System.out.println("not nice");
//        }
    }
}
