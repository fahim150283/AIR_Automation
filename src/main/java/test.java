import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class test extends Page_Options {

    @Test
    public void login_for_creating_new_pre_invoice() throws InterruptedException {
        navigatetourl("https://demo.guru99.com/test/");
        Thread.sleep(1000);
        xpath = "/html/body/form/input[1]";
        getTextbyXpath(xpath);
        DateSet(xpath);
        Thread.sleep(2000);
    }
}
