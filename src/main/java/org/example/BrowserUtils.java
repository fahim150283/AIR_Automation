package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils extends ReadJson {
    public static WebDriver driver;
    public static String[] returnedarray = ReadJson.readJsonData();  //This is just to call the function to read the files.
    // This is not gonna be used anywhere but the json data will be


    public static void setDriverChrome() {
        System.setProperty("webdriver.chrome.driver", "C:/BrowserDriver/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:/BrowserDriver/chrome-win64/chrome-win64/chrome.exe");
        driver = new ChromeDriver(co);
    }

    public static void setDriverFirefox(){
        // Setup Firefox WebDriver using webdrivermanager
        System.setProperty("webdriver.gecko.driver", "D:/Software/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:/Users/h.abul/AppData/Local/Mozilla Firefox/firefox.exe");
        driver = new FirefoxDriver(options);
    }

    public static void closedriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public static void cssSelectorPressEnter(String cssSelector) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.sendKeys(Keys.ENTER);
    }

    public static void pressEnterById(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.sendKeys(Keys.ENTER);
    }

    public static void waitById(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public static void waitByName(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public static void waitByxpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void waitByCssSelector(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }

    public static void clickbyxpath(String s) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s)));
        WebElement element = driver.findElement(By.xpath(s));
        element.click();
    }


    public static void inputbyxpath(String xpath, String s) {
        waitByxpath(xpath);
        WebElement element = driver.findElement(By.xpath(xpath));
        //element.click();
        element.sendKeys(s);
    }

    public static void clickbyId(String s) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
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
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(s)));
        WebElement element = driver.findElement(By.cssSelector(s));
        element.click();
    }


    public static void inputbycssselector(String cssSelector, String s) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        // element.click();
        element.sendKeys(s);
    }

    public static void inputbyName(String name, String s) {
        WebElement element = driver.findElement(By.name(name));
        // element.click();
        element.sendKeys(s);
    }

    public static void clickByName(String name) {
        WebElement element = driver.findElement(By.name(name));
        element.click();
    }

    public static void clickByClassName(String name) {
        WebElement element = driver.findElement(By.className(name));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.className(name)));
        element.click();
    }
}

