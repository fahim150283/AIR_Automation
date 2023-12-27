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
        inputbyxpath(xpath,getTodaynTime());
        WebElement dateTimeInput = driver.findElement(By.xpath(xpath));

        // Use JavaScript to set the value of the datetime-local input field
        String script = "arguments[0].value='2023-12-25T12:00'";
        ((JavascriptExecutor) driver).executeScript(script, dateTimeInput);

    }
}
