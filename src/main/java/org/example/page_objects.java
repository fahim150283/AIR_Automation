package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;

public class page_objects extends BrowserUtils{
    public static String id;
    public static String xpath;
    public static String cssSelector;

    public static void navigatetourl(String url) {
        driver.get(url);
    }

    public static void asserttrueorfalse(String s){
        String issuccessful = driver.getTitle();
//        softAssert.assertEquals(s,issuccessful);
    }
}
