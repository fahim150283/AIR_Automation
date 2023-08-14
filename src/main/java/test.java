import io.cucumber.java.en.Given;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test extends Page_Options {
    @BeforeMethod
    public void login_for_creating_new_pre_invoice() {
        url = "http://192.168.11.182/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, "h.abul");
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);
        //click pre invoice from left bar
        cssSelector = ".active:nth-child(4) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @Test
    public void create_new_pre_invoice() throws InterruptedException {
        //click the create new pre invoice
        xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
        clickbyxpath(xpath);
        //pre Invoice date
        xpath = "//*[@id=\"c_ord_date\"]";
        //waitByxpath(xpath);
        clickbyxpath(xpath);
        inputbyxpath(xpath,getToday());
        //wait and click distributors
        id = "select2-distributor_list-container";
        waitById(id);
        clickbyId(id);
//        pressDownbyXpath(xpath);
//        pressEnterbyXpath(xpath);

        //search for bhai bhai and hit enter
        cssSelector = ".select2-search--dropdown > .select2-search__field";
        inputbycssselector(cssSelector,"bhai bhai");
        cssSelectorPressEnter(cssSelector);

        //click the items bar
        xpath = "//*[@id=\"add_pre_invoice_form\"]/div/div[4]/div[6]/span/span[1]/span";
        Thread.sleep(0500);
//        driver.findElement(By.xpath(xpath)).click();
        scrollToTheBottom();
        driver.findElement(By.xpath(xpath)).sendKeys("kulfi");
        Thread.sleep(1000);
        driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
//        driver.findElement(By.name("#select2-c_sel_item-result-ghw7-1")).click();
    }
}
