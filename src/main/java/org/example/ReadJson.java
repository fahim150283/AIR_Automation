package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static String url;
    public static String ItemsArray[] = new String[15];
    public static String user_Fahim;
    public static String user_Polash;
    public static String user_Siam;
    public static String password;
    public static String ContactsSearchInfo;
    public static String PreInvoiceSearchInfo;
    public static String PreInvoiceDistributorSearch;
    public static String PreInvoiceItemQuantity;
    public static String PreInvoiceItems[] = new String[15];
    public static String PreviousPendingDeliveryItems[] = new String[15];
    public static String PreviousPendingDeliveryDistributorSearch;
    public static String PreviousPendingDeliveryItemQuantity;
    public static String PreviousPendingDeliverySearchInfo;
    public static String PreviousPendingDeliveryStore;
    public static String AppsSearchInfo;
    public static String AppsDisplayName;
    public static String AppsName;
    public static String AppsEditedDisplayName;
    public static String AppsEditedName;
    public static String AppsLink;
    public static String AppsEmployeeInfo[] = new String[10];
    public static String OrderItems[] = new String[15];
    public static String OrderSearchInfo;
    public static String OrderItemQuantity;
    public static String OrderDistributorSearch;
    public static String OrderNote;
    public static String CancelOrderSearchInfo;
    public static String CancelOrderDistributorSearch;
    public static String CancelOrderItemQuantity;
    public static String CancelOrderNote;
    public static String DistributorInvoiceSearchInfo;
    public static String DistributorInvoiceDistributorSearch;
    public static String DistributorInvoiceStore;
    public static String DistributorInvoiceNote;
    public static String DistributorInvoiceItemQuantity;
    public static String CancelInvoiceSearchInfo;
    public static String CancelInvoiceDistributorSearch;
    public static String CancelInvoiceStore;
    public static String CancelInvoiceNote;
    public static String CancelInvoiceItemQuantity;
    public static String ComplementaryInvoiceSearchInfo;
    public static String ComplementaryInvoiceItemQuantity;
    public static String ComplementaryInvoiceDistributorSearch;
    public static String ComplementaryInvoiceStore;
    public static String ComplementaryInvoiceNote;
    public static String ComplementaryInvoiceInvoiceReferenceNo;
    public static String ComplementaryInvoiceItems [] = new String[15];
    public static String CollectionSearchInfo;
    public static String CollectionDistributorSearch;
    public static String CollectionCollectedBy;
    public static String CollectionCollectionAmount;
    public static String CollectionMoneyReceipt;
    public static String GROVS_InvoiceItems [] = new String[15];
    public static String GROVS_SearchInfo;
    public static String GROVS_RequestFrom;
    public static String GROVS_RequestTo;
    public static String GROVS_Vehicle;
    public static String GROVS_AcceptedQuantity;
    public static String GROVS_ItemQuantity;
    public static String FGS_SearchInfo;
    public static String FGS_EditedCode;
    public static String FGS_EditedName;


    public static String[] readJsonData() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("Test_Data.json")) {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            {// Read data from the "Login" object
                JSONObject loginObject = (JSONObject) jsonObject.get("Login");
                url = (String) loginObject.get("url");
                user_Fahim = (String) loginObject.get("user_Fahim");
                user_Polash = (String) loginObject.get("user_Polash");
                user_Siam = (String) loginObject.get("user_Siam");
                password = (String) loginObject.get("password");
            }
            {// Read data from the "Contacts" object
                JSONObject ContactsObject = (JSONObject) jsonObject.get("Contacts");
                ContactsSearchInfo = (String) ContactsObject.get("SearchInfo");
            }
            {// Read data from the "Items" object
                JSONObject ItemsObject = (JSONObject) jsonObject.get("Items");
                for (int i = 0; i < ItemsArray.length; i++) {
                    ItemsArray[i] = (String) ItemsObject.get("Item" + (i + 1));
                }
            }
            {// Read data from the "PreInvoice" object
                JSONObject PreInvoiceObject = (JSONObject) jsonObject.get("PreInvoice");
                PreInvoiceSearchInfo = (String) PreInvoiceObject.get("SearchInfo");
                PreInvoiceItemQuantity = (String) PreInvoiceObject.get("ItemQuantity");
                PreInvoiceDistributorSearch = (String) PreInvoiceObject.get("DistributorSearch");
                PreInvoiceItems = ItemsArray;
            }
            {// Read data from the "PreviousPendingDelivery" object
                JSONObject PreviousPendingDeliveryObject = (JSONObject) jsonObject.get("PreviousPendingDelivery");
                PreviousPendingDeliverySearchInfo = (String) PreviousPendingDeliveryObject.get("SearchInfo");
                PreviousPendingDeliveryItemQuantity = (String) PreviousPendingDeliveryObject.get("ItemQuantity");
                PreviousPendingDeliveryDistributorSearch = (String) PreviousPendingDeliveryObject.get("DistributorSearch");
                PreviousPendingDeliveryStore = (String) PreviousPendingDeliveryObject.get("Store");
                PreviousPendingDeliveryItems = ItemsArray;
            }
            {// Read data from the "Apps" object
                JSONObject AppsObject = (JSONObject) jsonObject.get("Apps");
                AppsSearchInfo = (String) AppsObject.get("SearchInfo");
                AppsName = (String) AppsObject.get("Name");
                AppsDisplayName = (String) AppsObject.get("Display Name");
                AppsLink = (String) AppsObject.get("Link");
                AppsEditedName = (String) AppsObject.get("Edited Name");
                AppsEditedDisplayName = (String) AppsObject.get("Edited Display Name");
                for (int i = 0; i < AppsEmployeeInfo.length; i++) {
                    AppsEmployeeInfo[i] = (String) AppsObject.get("Employee info" + (i + 1));
                }
            }
            {// Read data from the "Order" object
                JSONObject OrderObject = (JSONObject) jsonObject.get("Order");
                OrderSearchInfo = (String) OrderObject.get("SearchInfo");
                OrderItemQuantity = (String) OrderObject.get("ItemQuantity");
                OrderDistributorSearch = (String) OrderObject.get("DistributorSearch");
                OrderNote = (String) OrderObject.get("Note");
                OrderItems = ItemsArray;
            }
            {// Read data from the "CancelOrder" object
                JSONObject CancelOrderObject = (JSONObject) jsonObject.get("CancelOrder");
                CancelOrderSearchInfo = (String) CancelOrderObject.get("SearchInfo");
                CancelOrderItemQuantity = (String) CancelOrderObject.get("ItemQuantity");
                CancelOrderDistributorSearch = (String) CancelOrderObject.get("DistributorSearch");
                CancelOrderNote = (String) CancelOrderObject.get("Note");
            }
            {// Read data from the "DistributorInvoice" object
                JSONObject DistributorInvoiceObject = (JSONObject) jsonObject.get("DistributorInvoice");
                DistributorInvoiceSearchInfo = (String) DistributorInvoiceObject.get("SearchInfo");
                DistributorInvoiceItemQuantity = (String) DistributorInvoiceObject.get("ItemQuantity");
                DistributorInvoiceDistributorSearch = (String) DistributorInvoiceObject.get("DistributorSearch");
                DistributorInvoiceStore = (String) DistributorInvoiceObject.get("Store");
                DistributorInvoiceNote = (String) DistributorInvoiceObject.get("Note");
            }
            {// Read data from the "CancelInvoice" object
                JSONObject CancelInvoiceObject = (JSONObject) jsonObject.get("Cancel Invoice");
                CancelInvoiceSearchInfo = (String) CancelInvoiceObject.get("SearchInfo");
                CancelInvoiceItemQuantity = (String) CancelInvoiceObject.get("ItemQuantity");
                CancelInvoiceDistributorSearch = (String) CancelInvoiceObject.get("DistributorSearch");
                CancelInvoiceStore = (String) CancelInvoiceObject.get("Store");
                CancelInvoiceNote = (String) CancelInvoiceObject.get("Note");
            }
            {// Read data from the "Complementary Invoice" object
                JSONObject ComplementaryInvoiceObject = (JSONObject) jsonObject.get("Complementary Invoice");
                ComplementaryInvoiceSearchInfo = (String) ComplementaryInvoiceObject.get("SearchInfo");
                ComplementaryInvoiceItemQuantity = (String) ComplementaryInvoiceObject.get("ItemQuantity");
                ComplementaryInvoiceDistributorSearch = (String) ComplementaryInvoiceObject.get("DistributorSearch");
                ComplementaryInvoiceStore = (String) ComplementaryInvoiceObject.get("Store");
                ComplementaryInvoiceNote = (String) ComplementaryInvoiceObject.get("Note");
                ComplementaryInvoiceInvoiceReferenceNo = (String) ComplementaryInvoiceObject.get("InvoiceReferenceNo");
                ComplementaryInvoiceItems = ItemsArray;
            }
            {// Read data from the "Collection" object
                JSONObject CollectionObject = (JSONObject) jsonObject.get("Collection");
                CollectionSearchInfo = (String) CollectionObject.get("SearchInfo");
                CollectionDistributorSearch = (String) CollectionObject.get("DistributorSearch");
                CollectionCollectedBy = (String) CollectionObject.get("CollectedBy");
                CollectionCollectionAmount = (String) CollectionObject.get("CollectionAmount");
                CollectionMoneyReceipt = (String) CollectionObject.get("MoneyReceipt");
            }
            {// Read data from the "Good Requisition and On Vehicle Store" object
                JSONObject GROVS_Object = (JSONObject) jsonObject.get("Good Requisition and On Vehicle Store");
                GROVS_SearchInfo = (String) GROVS_Object.get("SearchInfo");
                GROVS_Vehicle = (String) GROVS_Object.get("Vehicle");
                GROVS_RequestFrom = (String) GROVS_Object.get("RequestFrom");
                GROVS_RequestTo = (String) GROVS_Object.get("RequestTo");
                GROVS_ItemQuantity = (String) GROVS_Object.get("ItemQuantity");
                GROVS_AcceptedQuantity = (String) GROVS_Object.get("AcceptedQuantity");
                GROVS_InvoiceItems = ItemsArray;
            }
            {// Read data from the "FG Store" object
                JSONObject FGS_Object = (JSONObject) jsonObject.get("FG Store");
                FGS_SearchInfo = (String) FGS_Object.get("SearchInfo");
                FGS_EditedCode = (String) FGS_Object.get("EditedCode");
                FGS_EditedName = (String) FGS_Object.get("EditedName");
                // GROVS_RequestFrom = (String) FGS_Object.get("RequestFrom");
                // GROVS_RequestTo = (String) FGS_Object.get("RequestTo");
                // GROVS_ItemQuantity = (String) FGS_Object.get("ItemQuantity");
                // GROVS_AcceptedQuantity = (String) FGS_Object.get("AcceptedQuantity");
                // GROVS_InvoiceItems = ItemsArray;
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        String[] array = {};
        return array;
    }
}
