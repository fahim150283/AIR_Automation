package org.example;

public class page_objects extends BrowserUtils{
    public static String id;
    public static String xpath;
    public static String cssSelector;

    public static void navigatetourl(String url) {
        driver.get(url);
    }
}
