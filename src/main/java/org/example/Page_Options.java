package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Page_Options extends BrowserUtils{
    public static String id;
    public static LocalDate today = LocalDate.now();
    public static LocalDate yesterday = LocalDate.now().minusDays(1);
    public static LocalDate tomorrow = LocalDate.now().plusDays(1);
    public static String xpath;
    public static String cssSelector;
    public static String url;
    public static String tempName;

    public static void navigatetourl(String URL) {
        setDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public static void scrollToTheBottom() {
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight * 0.9)");
    }

    public static String getToday(){
        today = LocalDate.now();
        yesterday = LocalDate.now().minusDays(1);
        tomorrow = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formattedDate = today.format(formatter2);
        return formattedDate;
    }

    public static void clearById(String id){
        WebElement element = driver.findElement(By.id(id));
        element.clear();
    }
    public static void clearByXpath(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
    }
    public static void clearByCssSelector(String cssSelector){
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.clear();
    }
}
