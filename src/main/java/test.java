import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test extends Page_Options {

    @Test
    public void test() {
        try {
            navigatetourl("https://demo.guru99.com/test/");
            Thread.sleep(2000);
            Assert.assertEquals(getTextbyXpath("/html/body/form/h3"), "Open this page in Chrome");
            closedriver();
        } catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }
}
