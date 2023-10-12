package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static String url;
    public static String ItemsArray [] = new String[5];
    public static String user_Fahim;
    public static String user_Polash;
    public static String user_Siam;
    public static String password;
    public static String ContactsSearchInfo;
    public static String PreInvoiceSearchInfo;
    public static String PreInvoiceDistributorSearch;
    public static String PreInvoiceItemQuantity;
    public static String PreInvoiceItems [] = new String[5];;


    public static String[] readJsonData(){
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("Config.json")) {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            // Read data from the "Login" object
            JSONObject loginObject = (JSONObject) jsonObject.get("Login");
            url = (String) loginObject.get("url");
            user_Fahim = (String) loginObject.get("user_Fahim");
            user_Polash = (String) loginObject.get("user_Polash");
            user_Siam = (String) loginObject.get("user_Siam");
            password = (String) loginObject.get("password");

            // Read data from the "Contacts" object
            JSONObject ContactsObject = (JSONObject) jsonObject.get("Contacts");
            ContactsSearchInfo = (String) ContactsObject.get("SearchInfo");

            // Read data from the "Items" object
            JSONObject ItemsObject = (JSONObject) jsonObject.get("Items");
            ItemsArray[0] = (String) ItemsObject.get("Item1");
            ItemsArray[1] = (String) ItemsObject.get("Item2");
            ItemsArray[2] = (String) ItemsObject.get("Item3");
            ItemsArray[3] = (String) ItemsObject.get("Item4");
            ItemsArray[4] = (String) ItemsObject.get("Item5");


            // Read data from the "PreInvoice" object
            JSONObject PreInvoiceObject = (JSONObject) jsonObject.get("PreInvoice");
            PreInvoiceSearchInfo = (String) PreInvoiceObject.get("SearchInfo");
            PreInvoiceItemQuantity = (String) PreInvoiceObject.get("ItemQuantity");
            PreInvoiceDistributorSearch = (String) PreInvoiceObject.get("DistributorSearch");
            PreInvoiceItems = ItemsArray;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        String[] array= {};
        return array;
    }
}
