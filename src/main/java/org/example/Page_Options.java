package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Page_Options extends BrowserUtils {
    public static String id;
    public static String classname;
    public static String name;
    public static String xpath;
    public static String cssSelector;
    public static String url;
    public static String username;
    public static String tempName;

    public static void navigatetourl(String URL) {
        setDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public static void scrollToTheBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight * 0.9)");
    }

    public static void scrollTo_ByXpath(String s){
        WebElement element = driver.findElement(By.xpath(s));

        // Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);

    }

    public static String getToday() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();

        LocalDate today = LocalDate.now();
        String todayDate = dtf.format(today);
        return todayDate;
    }

    public static String getTodaynTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the date and time with AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyyyy'T'hh:mm a");
        String formattedDateTime = currentDateTime.format(formatter);
//        System.out.println(formattedDateTime);
        return formattedDateTime;
    }

    public static String getLastMonth() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();

        LocalDate today = LocalDate.now();
        LocalDate lastMonthDate = today.minusMonths(2);
        String date = dtf.format(lastMonthDate);
        return date;
    }

    public static String getlastMonthAndTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime futureDateTime = currentDateTime.minusMonths(1);

        // Format the date and time with AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyyyy'T'hh:mm a");
        String formattedDateTime = futureDateTime.format(formatter);
        System.out.println(formattedDateTime);
        return formattedDateTime;
    }

    public static void clearById(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.clear();
    }

    public static void clearByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
    }

    public static void clearByid(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.clear();
    }

    public static void clearByName(String s) {
        WebElement element = driver.findElement(By.name(s));
        element.clear();
    }

    public static void clearByCssSelector(String cssSelector) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.clear();
    }

    public static void pressEnterbyXpath(String s) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath((s))));
        WebElement element = driver.findElement(By.xpath(s));
        element.sendKeys(Keys.ENTER);
    }

    public static void pressESCbyXpath(String s) {
        WebElement element = driver.findElement(By.xpath(s));
        element.sendKeys(Keys.ESCAPE);
    }

    public static void pressDownbyXpath(String s) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s)));
        WebElement element = driver.findElement(By.xpath(s));
        element.sendKeys(Keys.ARROW_DOWN);
    }

    public static void pressDownbyid(String s) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(s)));
        WebElement element = driver.findElement(By.id(s));
        element.sendKeys(Keys.ARROW_DOWN);
    }

    public static void pressDownbyCssSelector(String s) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(s)));
        WebElement element = driver.findElement(By.cssSelector(s));
        element.sendKeys(Keys.ARROW_DOWN);
    }

//    public static void selectByindex(String s, int i){
//        Select stateDropdown = new Select(driver.findElement(By.id(s)));
//        stateDropdown.selectByIndex(i); // Haryana
//    }

    public static void AlertAccept() {
        driver.switchTo().alert().accept();
    }


    public static void switchTab(){
        String mainWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break; // Switch to the first non-main window (new tab)
            }
        }
    }

    public static double getValuebyName(String s){
        WebElement inputElement = driver.findElement(By.name(s));

        // Check if the input has a value
        String value = inputElement.getAttribute("value");
        double Value = Double.parseDouble(value);
        return Value;
    }

    public static double getValuebyXpath(String s){
        WebElement inputElement = driver.findElement(By.xpath(s));

        // Check if the input has a value
        String value = inputElement.getAttribute("value");
        double Value = Double.parseDouble(value);
        return Value;
    }

    public static double getValuebyId(String s){
        WebElement inputElement = driver.findElement(By.id(s));

        // Check if the input has a value
        String value = inputElement.getAttribute("value");
        double Value = Double.parseDouble(value);
        return Value;
    }

    public static double getTextbyXpath(String s){
        WebElement inputElement = driver.findElement(By.xpath(s));

        // Check if the input has a value
        String value = inputElement.getText();
        double Value = Double.parseDouble(value);
        return Value;
    }

    public static void Login(String username){
        url = "http://192.168.11.182/air_2/air";
        navigatetourl(url);
        id = "username";
        inputbyid(id, username);
        id = "password";
        inputbyid(id, "savoy123");
        id = "login";
        clickbyId(id);
    }

    public static String randomTestString(){
        // Create a Random object
        Random random = new Random();
        // Generate a random number
        int randomNumber = random.nextInt(99999);
        // Concatenate the random number to the string
        String result = "TEST" + randomNumber;
        return result;
    }
}