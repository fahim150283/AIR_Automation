package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static String url;
    public static String user_Fahim;
    public static String user_Polash;
    public static String user_Siam;
    public static String password;

    public static String[] readJsonData(){
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("Config.json")) {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            url = (String) jsonObject.get("url");
            user_Fahim = (String) jsonObject.get("user_Fahim");
            user_Polash = (String) jsonObject.get("user_Polash");
            user_Siam = (String) jsonObject.get("user_Siam");
            password = (String) jsonObject.get("password");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        String[] array= {url,user_Fahim,user_Polash,user_Siam,password};
        return array;
    }
}
