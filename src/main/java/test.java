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

        url = "http://192.168.11.182/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);

        cssSelector = ".active:nth-child(5) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);



        closedriver();
    }
}
