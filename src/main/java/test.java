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

public class test extends Page_Options {
    //    @BeforeMethod
    @Test
    public void login_for_creating_new_pre_invoice() throws InterruptedException {
        navigatetourl("https://www.google.com/");
        name = "q";
        driver.findElement(By.name(name)).sendKeys("522");
        Thread.sleep(0500);
        int i = getValuebyName(name);
        System.out.println(i);
        int k = i -(i-1);
        driver.findElement(By.name(name)).clear();
        driver.findElement(By.name(name)).sendKeys( String.valueOf(k));
        Thread.sleep(0500);
        String x = driver.findElement(By.name(name)).getAttribute("value");
        System.out.println(x);
        closedriver();
    }
}
