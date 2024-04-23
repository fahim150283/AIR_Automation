import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class test extends Page_Options {
    SoftAssert softAssert = new SoftAssert();

    @Given("test1brumbrum")
    public void test1brumbrum() {
        softAssert.assertEquals("yo", "Open this page in Chrome11");
    }

    @Given("test2brumbrum")
    public void test2() {
        System.out.println("test2");
        softAssert.assertEquals("test2", "hi2");
        softAssert.assertAll();

    }

    @Given("huhu")
    public void huhu() {
        try {
            System.out.println("this is expected");
            softAssert.assertAll();
        } catch (AssertionError | TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void tata() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Products");
        //print the payload
        BrowserMobProxyToPrint("http://10.101.13.28/apis/api_m/api.php");
        closedriver();
    }

    @Test
    public void tatat() throws InterruptedException {
        navigatetourl("google.com");
    }
}
