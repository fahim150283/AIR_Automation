package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    public static WebDriver driver;

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void closedriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public static void cssSelectorPressEnter(String cssSelector){
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.sendKeys(Keys.ENTER);
    }

    public static void waitById(String id) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public static void waitByxpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void waitByCssSelector(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }

    public static void clickbyxpath(String s) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s)));
        WebElement element = driver.findElement(By.xpath(s));
        element.click();
    }


    public static void inputbyxpath(String xpath, String s) {
        WebElement element = driver.findElement(By.xpath(xpath));
        //element.click();
        element.sendKeys(s);
    }

    public static void clickbyId(String s) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(s)));
        WebElement element = driver.findElement(By.id(s));
        element.click();
    }


    public static void inputbyid(String id, String s) {
        WebElement element = driver.findElement(By.id(id));
        //element.click();
        element.sendKeys(s);
    }


    public static void clickbycssselector(String s) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(s)));
        WebElement element = driver.findElement(By.cssSelector(s));
        element.click();
    }


    public static void inputbycssselector(String cssSelector, String s) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
       // element.click();
        element.sendKeys(s);
    }
}

