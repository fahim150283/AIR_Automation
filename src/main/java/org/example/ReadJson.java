package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static String url_AIR_2_AIR;
    public static String url_AIR_2;
    public static String url_AIR;
    public static String ItemsArray [] = new String[15];

    public static String user_Fahim;
    public static String user_Haseeb;
    public static String user_Polash;
    public static String user_Ashik;
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
    public static String ComplementaryInvoiceItems[] = new String[15];
    public static String CollectionSearchInfo;
    public static String CollectionDistributorSearch;
    public static String CollectionCollectedBy;
    public static String CollectionCollectionAmount;
    public static String CollectionMoneyReceipt;
    public static String GROVS_InvoiceItems[] = new String[15];
    public static String GROVS_SearchInfo;
    public static String GROVS_RequestFrom;
    public static String GROVS_RequestTo;
    public static String GROVS_Vehicle;
    public static String GROVS_AcceptedQuantity;
    public static String GROVS_ItemQuantity;
    public static String FGS_SearchInfo;
    public static String FGS_EditedCode;
    public static String FGS_EditedName;
    public static String FGS_Name;
    public static String FGS_Code;
    public static String FGS_Definition;
    public static String FGS_EditedDefinition;
    public static String FGS_EditedAddress;
    public static String FGS_Region;
    public static String FGS_Depots;
    public static String FGS_Address;
    public static String FGS_Store;
    public static String FGS_ItemQuantity;
    public static String[] FGS_Items = new String[15];
    public static String Distributors_Reference;
    public static String Distributors_SDF;
    public static String Distributors_RDF;
    public static String Distributors_Region;
    public static String Distributors_depot;
    public static String Distributors_Area;
    public static String Distributors_territory;
    public static String Distributors_B_P_code;
    public static String Distributors_RSM;
    public static String Distributors_ASM_Sr_ASM;
    public static String Distributors_FPR;
    public static String Distributors_Running_FPR;
    public static String Distributors_Identity_Of_Distributor;
    public static String Distributors_Type_Of_Distributorship;
    public static String Distributors_distributor_info;
    public static String Distributors_Name_Of_Distributor_Firm;
    public static String Distributors_Proprietor_Name;
    public static String Distributors_Proprietor_Mobile_Number;
    public static String Distributors_Contact_Person_Mobile_Number;
    public static String Distributors_Farm_Address;
    public static String Distributors_Proprietor_Permanent_Address;
    public static String Distributors_Proprietor_Present_Address;
    public static String Distributors_Proprietor_National_ID_Number;
    public static String Distributors_Trade_License_Number_Last_Date;
    public static String Distributors_Bank_Name_Branch;
    public static String Distributors_Bank_Account_Number;
    public static String Distributors_Name_Of_Existing_Business1;
    public static String Distributors_Name_Of_Existing_Business2;
    public static String Distributors_Existing_Business1_Starting_Year;
    public static String Distributors_Existing_Business2_Starting_Year;
    public static String Distributors_No_Of_Existing_Van_Puller_Or_DSR;
    public static String Distributors_Number_Of_Existing_Ice_Cream_Van;
    public static String Distributors_Existing_Godown_Size_SQFT;
    public static String Distributors_Relation_With_Golden_Group_Entity;
    public static String Distributors_Area_Demarcation;
    public static String Distributors_Point_Name;
    public static String Distributors_Routes;
    public static String Distributors_Key_Markets;
    public static String Distributors_Ice_Cream_Selling_Outlets_Territory;
    public static String Distributors_Existing_Avg_Market_Size_Tk_Yearly;
    public static String Distributors_discount_type;
    public static String Distributors_discount_amount;
    public static String Distributors_C_Igloo;
    public static String Distributors_C_Polar;
    public static String Distributors_C_Lovello;
    public static String Distributors_C_Kazi;
    public static String Distributors_C_Bloop;
    public static String Distributors_C_Kwality;
    public static String Distributors_C_Others;
    public static String Distributors_D_F_Igloo;
    public static String Distributors_D_F_Polar;
    public static String Distributors_D_F_Lovello;
    public static String Distributors_D_F_Kazi;
    public static String Distributors_D_F_Bloop;
    public static String Distributors_D_F_Kwality;
    public static String Distributors_D_F_Others;
    public static String Distributors_S_Igloo;
    public static String Distributors_S_Polar;
    public static String Distributors_S_Lovello;
    public static String Distributors_S_Kazi;
    public static String Distributors_S_Bloop;
    public static String Distributors_S_Kwality;
    public static String Distributors_S_Others;
    public static String Distributors_F_Igloo;
    public static String Distributors_F_Polar;
    public static String Distributors_F_Lovello;
    public static String Distributors_F_Kazi;
    public static String Distributors_F_Bloop;
    public static String Distributors_F_Kwality;
    public static String Distributors_F_Others;
    public static String Distributors_Total_Investment_Tk;
    public static String Distributors_Initial_Lifting_In_Tk;
    public static String Distributors_Number_Of_SDFs;
    public static String Distributors_Godown_Advance;
    public static String Distributors_Value_Of_SDFs;
    public static String Distributors_Market_Credit;
    public static String Distributors_Number_Of_Van_S;
    public static String Distributors_Running_Capital;
    public static String Distributors_Value_Of_Vans_Tk;
    public static String Distributors_Type_Of_Transaction;
    public static String Distributors_RSMs_or_ASM_in_absence_of_RSM_Recommendation;
    public static String Distributors_GM_DGM_AGMs_Recommendation;
    public static String Distributors_SearchInfo;public static String Distributors_E_Reference;
    public static String Distributors_E_SDF;
    public static String Distributors_E_RDF;
    public static String Distributors_E_Region;
    public static String Distributors_E_depot;
    public static String Distributors_E_Area;
    public static String Distributors_E_territory;
    public static String Distributors_E_B_P_code;
    public static String Distributors_E_RSM;
    public static String Distributors_E_ASM_Sr_ASM;
    public static String Distributors_E_FPR;
    public static String Distributors_E_Running_FPR;
    public static String Distributors_E_Identity_Of_Distributor;
    public static String Distributors_E_Type_Of_Distributorship;
    public static String Distributors_E_distributor_info;
    public static String Distributors_E_Name_Of_Distributor_Firm;
    public static String Distributors_E_Proprietor_Name;
    public static String Distributors_E_Proprietor_Mobile_Number;
    public static String Distributors_E_Contact_Person_Mobile_Number;
    public static String Distributors_E_Farm_Address;
    public static String Distributors_E_Proprietor_Permanent_Address;
    public static String Distributors_E_Proprietor_Present_Address;
    public static String Distributors_E_Proprietor_National_ID_Number;
    public static String Distributors_E_Trade_License_Number_Last_Date;
    public static String Distributors_E_Bank_Name_Branch;
    public static String Distributors_E_Bank_Account_Number;
    public static String Distributors_E_Name_Of_Existing_Business1;
    public static String Distributors_E_Name_Of_Existing_Business2;
    public static String Distributors_E_Existing_Business1_Starting_Year;
    public static String Distributors_E_Existing_Business2_Starting_Year;
    public static String Distributors_E_No_Of_Existing_Van_Puller_Or_DSR;
    public static String Distributors_E_Number_Of_Existing_Ice_Cream_Van;
    public static String Distributors_E_Existing_Godown_Size_SQFT;
    public static String Distributors_E_Relation_With_Golden_Group_Entity;
    public static String Distributors_E_Area_Demarcation;
    public static String Distributors_E_Point_Name;
    public static String Distributors_E_Routes;
    public static String Distributors_E_Key_Markets;
    public static String Distributors_E_Ice_Cream_Selling_Outlets_Territory;
    public static String Distributors_E_Existing_Avg_Market_Size_Tk_Yearly;
    public static String Distributors_E_discount_type;
    public static String Distributors_E_discount_amount;
    public static String Distributors_E_C_Igloo;
    public static String Distributors_E_C_Polar;
    public static String Distributors_E_C_Lovello;
    public static String Distributors_E_C_Kazi;
    public static String Distributors_E_C_Bloop;
    public static String Distributors_E_C_Kwality;
    public static String Distributors_E_C_Others;
    public static String Distributors_E_D_F_Igloo;
    public static String Distributors_E_D_F_Polar;
    public static String Distributors_E_D_F_Lovello;
    public static String Distributors_E_D_F_Kazi;
    public static String Distributors_E_D_F_Bloop;
    public static String Distributors_E_D_F_Kwality;
    public static String Distributors_E_D_F_Others;
    public static String Distributors_E_S_Igloo;
    public static String Distributors_E_S_Polar;
    public static String Distributors_E_S_Lovello;
    public static String Distributors_E_S_Kazi;
    public static String Distributors_E_S_Bloop;
    public static String Distributors_E_S_Kwality;
    public static String Distributors_E_S_Others;
    public static String Distributors_E_F_Igloo;
    public static String Distributors_E_F_Polar;
    public static String Distributors_E_F_Lovello;
    public static String Distributors_E_F_Kazi;
    public static String Distributors_E_F_Bloop;
    public static String Distributors_E_F_Kwality;
    public static String Distributors_E_F_Others;
    public static String Distributors_E_Total_Investment_Tk;
    public static String Distributors_E_Initial_Lifting_In_Tk;
    public static String Distributors_E_Number_Of_SDFs;
    public static String Distributors_E_Godown_Advance;
    public static String Distributors_E_Value_Of_SDFs;
    public static String Distributors_E_Market_Credit;
    public static String Distributors_E_Number_Of_Van_S;
    public static String Distributors_E_Running_Capital;
    public static String Distributors_E_Value_Of_Vans_Tk;
    public static String Distributors_E_Type_Of_Transaction;
    public static String Distributors_E_RSMs_or_ASM_in_absence_of_RSM_Recommendation;
    public static String Distributors_E_GM_DGM_AGMs_Recommendation;
    public static String Ofr_Type;
    public static String Ofr_NumOfCategory;
    public static String Ofr_NumOfOffers;
    public static String [] Ofr_ItemCatg = new String[5];
    public static String [] Ofr_ItemSubCatg = new String[5];
    public static String [] Ofr_ItemProd = new String[5];
    public static String [] Ofr_EItemSubCatg = new String[5];
    public static String [] Ofr_EItemProd = new String[5];
    public static String [] Ofr_GiftItem = new String[5];
    public static String Ofr_Region;
    public static String Ofr_Depot;
    public static String Ofr_Area;
    public static String Ofr_Territory;
    public static String Ofr_Distributor;
    public static String Ofr_ExDistributor;
    public static String Ofr_Active;
    public static String Ofr_CreditAllowed;
    public static String PRODCAT_SearchInfo;
    public static String PRODCAT_Name;
    public static String PRODCAT_MainCategory;
    public static String PRODCAT_Status;
    public static String PRODCAT_E_Name;
    public static String PROD_SearchInfo;
    public static String PROD_Code;
    public static String PROD_Name;
    public static String PROD_Category;
    public static String PROD_flavor;
    public static String PROD_sizeML;
    public static String PROD_CtnPCS;
    public static String PROD_RetailPrice;
    public static String PROD_TradePrice;
    public static String PROD_DistributorPrice;
    public static String E_PROD_Code;
    public static String E_PROD_Name;
    public static String E_PROD_Category;
    public static String E_PROD_flavor;
    public static String E_PROD_sizeML;
    public static String E_PROD_CtnPCS;
    public static String E_PROD_RetailPrice;
    public static String E_PROD_TradePrice;
    public static String E_PROD_DistributorPrice;
    public static String SR_SearchInfo;
    public static String SR_DistributorSearch;
    public static String SR_Store;
    public static String SR_Note;


    public static String[] readJsonData() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/Test_Data.json")) {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            {// Read data from the "Login" object
                JSONObject loginObject = (JSONObject) jsonObject.get("Login");
                url_AIR = (String) loginObject.get("url_AIR");
                url_AIR_2 = (String) loginObject.get("url_AIR_2");
                url_AIR_2_AIR = (String) loginObject.get("url_AIR_2_AIR");
                user_Fahim = (String) loginObject.get("user_Fahim");
                user_Polash = (String) loginObject.get("user_Polash");
                user_Siam = (String) loginObject.get("user_Siam");
                user_Ashik = (String) loginObject.get("user_Ashik");
                user_Haseeb = (String) loginObject.get("user_Haseeb");
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
                FGS_Name = (String) FGS_Object.get("Name");
                FGS_Code = (String) FGS_Object.get("Code");
                FGS_Definition = (String) FGS_Object.get("Definition");
                FGS_EditedDefinition = (String) FGS_Object.get("EditedDefinition");
                FGS_EditedAddress = (String) FGS_Object.get("EditedAddress");
                FGS_Region = (String) FGS_Object.get("Region");
                FGS_Depots = (String) FGS_Object.get("Depots");
                FGS_Address = (String) FGS_Object.get("Address");
                FGS_EditedName = (String) FGS_Object.get("EditedName");
                FGS_Store = (String) FGS_Object.get("Store");
                FGS_Items = ItemsArray;
                FGS_ItemQuantity = (String) FGS_Object.get("Quantity");
            }
            {// Read data from the "Distributors" object
                JSONObject distributorsObject = (JSONObject) jsonObject.get("Distributors");

                Distributors_SearchInfo = (String) distributorsObject.get("SearchInfo");
                //Creation
                JSONObject DistributorCreationObject = (JSONObject) distributorsObject.get("Creation");
                Distributors_Reference = (String) DistributorCreationObject.get("Reference");
                Distributors_SDF = (String) DistributorCreationObject.get("SDF");
                Distributors_RDF = (String) DistributorCreationObject.get("RDF");
                Distributors_Region = (String) DistributorCreationObject.get("Region");
                Distributors_depot = (String) DistributorCreationObject.get("depot");
                Distributors_Area = (String) DistributorCreationObject.get("Area");
                Distributors_territory = (String) DistributorCreationObject.get("territory");
                Distributors_B_P_code = (String) DistributorCreationObject.get("B P code");
                Distributors_RSM = (String) DistributorCreationObject.get("RSM");
                Distributors_ASM_Sr_ASM = (String) DistributorCreationObject.get("ASM / Sr. ASM");
                Distributors_FPR = (String) DistributorCreationObject.get("FPR");
                Distributors_Running_FPR = (String) DistributorCreationObject.get("Running FPR");
                Distributors_Identity_Of_Distributor = (String) DistributorCreationObject.get("Identity Of Distributor");
                Distributors_Type_Of_Distributorship = (String) DistributorCreationObject.get("Type Of Distributorship");
                Distributors_distributor_info = (String) DistributorCreationObject.get("distributor info");
                Distributors_Name_Of_Distributor_Firm = (String) DistributorCreationObject.get("Name Of Distributor/Firm");
                Distributors_Proprietor_Name = (String) DistributorCreationObject.get("Proprietor Name");
                Distributors_Proprietor_Mobile_Number = (String) DistributorCreationObject.get("Proprietor Mobile Number");
                Distributors_Contact_Person_Mobile_Number = (String) DistributorCreationObject.get("Contact Person & Mobile Number");
                Distributors_Farm_Address = (String) DistributorCreationObject.get("Farm Address");
                Distributors_Proprietor_Permanent_Address = (String) DistributorCreationObject.get("Proprietor Permanent Address");
                Distributors_Proprietor_Present_Address = (String) DistributorCreationObject.get("Proprietor Present Address");
                Distributors_Proprietor_National_ID_Number = (String) DistributorCreationObject.get("Proprietor National ID Number");
                Distributors_Trade_License_Number_Last_Date = (String) DistributorCreationObject.get("Trade License Number & Last Date");
                Distributors_Bank_Name_Branch = (String) DistributorCreationObject.get("Bank Name & Branch");
                Distributors_Bank_Account_Number = (String) DistributorCreationObject.get("Bank Account Number");
                Distributors_Name_Of_Existing_Business1 = (String) DistributorCreationObject.get("Name Of Existing Business1");
                Distributors_Name_Of_Existing_Business2 = (String) DistributorCreationObject.get("Name Of Existing Business2");
                Distributors_Existing_Business1_Starting_Year = (String) DistributorCreationObject.get("Existing Business1 Starting Year");
                Distributors_Existing_Business2_Starting_Year = (String) DistributorCreationObject.get("Existing Business2 Starting Year");
                Distributors_No_Of_Existing_Van_Puller_Or_DSR = (String) DistributorCreationObject.get("No. Of Existing Van Puller & Or DSR");
                Distributors_Number_Of_Existing_Ice_Cream_Van = (String) DistributorCreationObject.get("Number Of Existing Ice Cream Van");
                Distributors_Existing_Godown_Size_SQFT = (String) DistributorCreationObject.get("Existing Godown Size (SQFT)");
                Distributors_Relation_With_Golden_Group_Entity = (String) DistributorCreationObject.get("Relation With Golden Group Entity");
                Distributors_Area_Demarcation = (String) DistributorCreationObject.get("Area Demarcation");
                Distributors_Point_Name = (String) DistributorCreationObject.get("Point Name");
                Distributors_Routes = (String) DistributorCreationObject.get("Routes");
                Distributors_Key_Markets = (String) DistributorCreationObject.get("Key Markets");
                Distributors_Ice_Cream_Selling_Outlets_Territory = (String) DistributorCreationObject.get("Ice Cream Selling Outlets Territory");
                Distributors_Existing_Avg_Market_Size_Tk_Yearly = (String) DistributorCreationObject.get("Existing Avg Market Size (Tk) : (Yearly)");
                Distributors_discount_type = (String) DistributorCreationObject.get("discount type");
                Distributors_discount_amount = (String) DistributorCreationObject.get("discount amount");
                Distributors_C_Igloo = (String) DistributorCreationObject.get("C_Igloo");
                Distributors_C_Polar = (String) DistributorCreationObject.get("C_Polar");
                Distributors_C_Lovello = (String) DistributorCreationObject.get("C_Lovello");
                Distributors_C_Kazi = (String) DistributorCreationObject.get("C_Kazi");
                Distributors_C_Bloop = (String) DistributorCreationObject.get("C_Bloop");
                Distributors_C_Kwality = (String) DistributorCreationObject.get("C_Kwality");
                Distributors_C_Others = (String) DistributorCreationObject.get("C_Others");
                Distributors_D_F_Igloo = (String) DistributorCreationObject.get("D/F_Igloo");
                Distributors_D_F_Polar = (String) DistributorCreationObject.get("D/F_Polar");
                Distributors_D_F_Lovello = (String) DistributorCreationObject.get("D/F_Lovello");
                Distributors_D_F_Kazi = (String) DistributorCreationObject.get("D/F_Kazi");
                Distributors_D_F_Bloop = (String) DistributorCreationObject.get("D/F_Bloop");
                Distributors_D_F_Kwality = (String) DistributorCreationObject.get("D/F_Kwality");
                Distributors_D_F_Others = (String) DistributorCreationObject.get("D/F_Others");
                Distributors_S_Igloo = (String) DistributorCreationObject.get("S_Igloo");
                Distributors_S_Polar = (String) DistributorCreationObject.get("S_Polar");
                Distributors_S_Lovello = (String) DistributorCreationObject.get("S_Lovello");
                Distributors_S_Kazi = (String) DistributorCreationObject.get("S_Kazi");
                Distributors_S_Bloop = (String) DistributorCreationObject.get("S_Bloop");
                Distributors_S_Kwality = (String) DistributorCreationObject.get("S_Kwality");
                Distributors_S_Others = (String) DistributorCreationObject.get("S_Others");
                Distributors_F_Igloo = (String) DistributorCreationObject.get("F_Igloo");
                Distributors_F_Polar = (String) DistributorCreationObject.get("F_Polar");
                Distributors_F_Lovello = (String) DistributorCreationObject.get("F_Lovello");
                Distributors_F_Kazi = (String) DistributorCreationObject.get("F_Kazi");
                Distributors_F_Bloop = (String) DistributorCreationObject.get("F_Bloop");
                Distributors_F_Kwality = (String) DistributorCreationObject.get("F_Kwality");
                Distributors_F_Others = (String) DistributorCreationObject.get("F_Others");
                Distributors_Total_Investment_Tk = (String) DistributorCreationObject.get("Total Investment (Tk)");
                Distributors_Initial_Lifting_In_Tk = (String) DistributorCreationObject.get("Initial Lifting (In Tk)");
                Distributors_Number_Of_SDFs = (String) DistributorCreationObject.get("Number Of SDFs");
                Distributors_Godown_Advance = (String) DistributorCreationObject.get("Godown Advance");
                Distributors_Value_Of_SDFs = (String) DistributorCreationObject.get("Value Of SDFs");
                Distributors_Market_Credit = (String) DistributorCreationObject.get("Market Credit");
                Distributors_Number_Of_Van_S = (String) DistributorCreationObject.get("Number Of Van(S)");
                Distributors_Running_Capital = (String) DistributorCreationObject.get("Running Capital");
                Distributors_Value_Of_Vans_Tk = (String) DistributorCreationObject.get("Value Of Vans (Tk)");
                Distributors_Type_Of_Transaction = (String) DistributorCreationObject.get("Type Of Transaction");
                Distributors_RSMs_or_ASM_in_absence_of_RSM_Recommendation = (String) DistributorCreationObject.get("RSM's (or ASM in absence of RSM) Recommendation");
                Distributors_GM_DGM_AGMs_Recommendation = (String) DistributorCreationObject.get("GM/DGM/AGM's Recommendation");
                //Editing
                JSONObject DistributorEditingObject = (JSONObject) distributorsObject.get("Editing");
                Distributors_E_Reference = (String) DistributorEditingObject.get("Reference");
                Distributors_E_SDF = (String) DistributorEditingObject.get("SDF");
                Distributors_E_RDF = (String) DistributorEditingObject.get("RDF");
                Distributors_E_Region = (String) DistributorEditingObject.get("Region");
                Distributors_E_depot = (String) DistributorEditingObject.get("depot");
                Distributors_E_Area = (String) DistributorEditingObject.get("Area");
                Distributors_E_territory = (String) DistributorEditingObject.get("territory");
                Distributors_E_B_P_code = (String) DistributorEditingObject.get("B P code");
                Distributors_E_RSM = (String) DistributorEditingObject.get("RSM");
                Distributors_E_ASM_Sr_ASM = (String) DistributorEditingObject.get("ASM / Sr. ASM");
                Distributors_E_FPR = (String) DistributorEditingObject.get("FPR");
                Distributors_E_Running_FPR = (String) DistributorEditingObject.get("Running FPR");
                Distributors_E_Identity_Of_Distributor = (String) DistributorEditingObject.get("Identity Of Distributor");
                Distributors_E_Type_Of_Distributorship = (String) DistributorEditingObject.get("Type Of Distributorship");
                Distributors_E_distributor_info = (String) DistributorEditingObject.get("distributor info");
                Distributors_E_Name_Of_Distributor_Firm = (String) DistributorEditingObject.get("Name Of Distributor/Firm");
                Distributors_E_Proprietor_Name = (String) DistributorEditingObject.get("Proprietor Name");
                Distributors_E_Proprietor_Mobile_Number = (String) DistributorEditingObject.get("Proprietor Mobile Number");
                Distributors_E_Contact_Person_Mobile_Number = (String) DistributorEditingObject.get("Contact Person & Mobile Number");
                Distributors_E_Farm_Address = (String) DistributorEditingObject.get("Farm Address");
                Distributors_E_Proprietor_Permanent_Address = (String) DistributorEditingObject.get("Proprietor Permanent Address");
                Distributors_E_Proprietor_Present_Address = (String) DistributorEditingObject.get("Proprietor Present Address");
                Distributors_E_Proprietor_National_ID_Number = (String) DistributorEditingObject.get("Proprietor National ID Number");
                Distributors_E_Trade_License_Number_Last_Date = (String) DistributorEditingObject.get("Trade License Number & Last Date");
                Distributors_E_Bank_Name_Branch = (String) DistributorEditingObject.get("Bank Name & Branch");
                Distributors_E_Bank_Account_Number = (String) DistributorEditingObject.get("Bank Account Number");
                Distributors_E_Name_Of_Existing_Business1 = (String) DistributorEditingObject.get("Name Of Existing Business1");
                Distributors_E_Name_Of_Existing_Business2 = (String) DistributorEditingObject.get("Name Of Existing Business2");
                Distributors_E_Existing_Business1_Starting_Year = (String) DistributorEditingObject.get("Existing Business1 Starting Year");
                Distributors_E_Existing_Business2_Starting_Year = (String) DistributorEditingObject.get("Existing Business2 Starting Year");
                Distributors_E_No_Of_Existing_Van_Puller_Or_DSR = (String) DistributorEditingObject.get("No. Of Existing Van Puller & Or DSR");
                Distributors_E_Number_Of_Existing_Ice_Cream_Van = (String) DistributorEditingObject.get("Number Of Existing Ice Cream Van");
                Distributors_E_Existing_Godown_Size_SQFT = (String) DistributorEditingObject.get("Existing Godown Size (SQFT)");
                Distributors_E_Relation_With_Golden_Group_Entity = (String) DistributorEditingObject.get("Relation With Golden Group Entity");
                Distributors_E_Area_Demarcation = (String) DistributorEditingObject.get("Area Demarcation");
                Distributors_E_Point_Name = (String) DistributorEditingObject.get("Point Name");
                Distributors_E_Routes = (String) DistributorEditingObject.get("Routes");
                Distributors_E_Key_Markets = (String) DistributorEditingObject.get("Key Markets");
                Distributors_E_Ice_Cream_Selling_Outlets_Territory = (String) DistributorEditingObject.get("Ice Cream Selling Outlets Territory");
                Distributors_E_Existing_Avg_Market_Size_Tk_Yearly = (String) DistributorEditingObject.get("Existing Avg Market Size (Tk) : (Yearly)");
                Distributors_E_discount_type = (String) DistributorEditingObject.get("discount type");
                Distributors_E_discount_amount = (String) DistributorEditingObject.get("discount amount");
                Distributors_E_C_Igloo = (String) DistributorEditingObject.get("C_Igloo");
                Distributors_E_C_Polar = (String) DistributorEditingObject.get("C_Polar");
                Distributors_E_C_Lovello = (String) DistributorEditingObject.get("C_Lovello");
                Distributors_E_C_Kazi = (String) DistributorEditingObject.get("C_Kazi");
                Distributors_E_C_Bloop = (String) DistributorEditingObject.get("C_Bloop");
                Distributors_E_C_Kwality = (String) DistributorEditingObject.get("C_Kwality");
                Distributors_E_C_Others = (String) DistributorEditingObject.get("C_Others");
                Distributors_E_D_F_Igloo = (String) DistributorEditingObject.get("D/F_Igloo");
                Distributors_E_D_F_Polar = (String) DistributorEditingObject.get("D/F_Polar");
                Distributors_E_D_F_Lovello = (String) DistributorEditingObject.get("D/F_Lovello");
                Distributors_E_D_F_Kazi = (String) DistributorEditingObject.get("D/F_Kazi");
                Distributors_E_D_F_Bloop = (String) DistributorEditingObject.get("D/F_Bloop");
                Distributors_E_D_F_Kwality = (String) DistributorEditingObject.get("D/F_Kwality");
                Distributors_E_D_F_Others = (String) DistributorEditingObject.get("D/F_Others");
                Distributors_E_S_Igloo = (String) DistributorEditingObject.get("S_Igloo");
                Distributors_E_S_Polar = (String) DistributorEditingObject.get("S_Polar");
                Distributors_E_S_Lovello = (String) DistributorEditingObject.get("S_Lovello");
                Distributors_E_S_Kazi = (String) DistributorEditingObject.get("S_Kazi");
                Distributors_E_S_Bloop = (String) DistributorEditingObject.get("S_Bloop");
                Distributors_E_S_Kwality = (String) DistributorEditingObject.get("S_Kwality");
                Distributors_E_S_Others = (String) DistributorEditingObject.get("S_Others");
                Distributors_E_F_Igloo = (String) DistributorEditingObject.get("F_Igloo");
                Distributors_E_F_Polar = (String) DistributorEditingObject.get("F_Polar");
                Distributors_E_F_Lovello = (String) DistributorEditingObject.get("F_Lovello");
                Distributors_E_F_Kazi = (String) DistributorEditingObject.get("F_Kazi");
                Distributors_E_F_Bloop = (String) DistributorEditingObject.get("F_Bloop");
                Distributors_E_F_Kwality = (String) DistributorEditingObject.get("F_Kwality");
                Distributors_E_F_Others = (String) DistributorEditingObject.get("F_Others");
                Distributors_E_Total_Investment_Tk = (String) DistributorEditingObject.get("Total Investment (Tk)");
                Distributors_E_Initial_Lifting_In_Tk = (String) DistributorEditingObject.get("Initial Lifting (In Tk)");
                Distributors_E_Number_Of_SDFs = (String) DistributorEditingObject.get("Number Of SDFs");
                Distributors_E_Godown_Advance = (String) DistributorEditingObject.get("Godown Advance");
                Distributors_E_Value_Of_SDFs = (String) DistributorEditingObject.get("Value Of SDFs");
                Distributors_E_Market_Credit = (String) DistributorEditingObject.get("Market Credit");
                Distributors_E_Number_Of_Van_S = (String) DistributorEditingObject.get("Number Of Van(S)");
                Distributors_E_Running_Capital = (String) DistributorEditingObject.get("Running Capital");
                Distributors_E_Value_Of_Vans_Tk = (String) DistributorEditingObject.get("Value Of Vans (Tk)");
                Distributors_E_Type_Of_Transaction = (String) DistributorEditingObject.get("Type Of Transaction");
                Distributors_E_RSMs_or_ASM_in_absence_of_RSM_Recommendation = (String) DistributorEditingObject.get("RSM's (or ASM in absence of RSM) Recommendation");
                Distributors_E_GM_DGM_AGMs_Recommendation = (String) DistributorEditingObject.get("GM/DGM/AGM's Recommendation");
            }
            {// Read data from the "Offer" object
                JSONObject Offer_Object = (JSONObject) jsonObject.get("Offer");
                Ofr_Type = (String) Offer_Object.get("OfrType");
                Ofr_NumOfCategory = (String) Offer_Object.get("NumOfCategory");
                Ofr_NumOfOffers = (String) Offer_Object.get("NumOfOffers");
                for (int i = 0; i<Integer.parseInt(Ofr_NumOfCategory); i++){
                    Ofr_ItemCatg[i] = (String) Offer_Object.get("ItemCatg"+(i+1));
                }
                for (int i = 0; i<Integer.parseInt(Ofr_NumOfCategory); i++){
                    Ofr_ItemSubCatg[i] = (String) Offer_Object.get("ItemSubCatg"+(i+1));
                }
                for (int i = 0; i<Integer.parseInt(Ofr_NumOfCategory); i++){
                    Ofr_ItemProd[i] = (String) Offer_Object.get("ItemProd"+(i+1));
                }
                for (int i = 0; i<Integer.parseInt(Ofr_NumOfCategory); i++){
                    Ofr_EItemSubCatg[i] = (String) Offer_Object.get("EItemSubCatg"+(i+1));
                }
                for (int i = 0; i<Integer.parseInt(Ofr_NumOfCategory); i++){
                    Ofr_EItemProd[i] = (String) Offer_Object.get("EItemProd"+(i+1));
                }
                for (int i = 0; i<Integer.parseInt(Ofr_NumOfCategory); i++){
                    Ofr_GiftItem[i] = (String) Offer_Object.get("GiftItem"+(i+1));
                }

                Ofr_Region = (String) Offer_Object.get("Region");
                Ofr_Depot = (String) Offer_Object.get("Depot");
                Ofr_Area = (String) Offer_Object.get("Area");
                Ofr_Territory = (String) Offer_Object.get("Territory");
                Ofr_Distributor = (String) Offer_Object.get("Distributor");
                Ofr_ExDistributor = (String) Offer_Object.get("ExDistributor");
                Ofr_Active = (String) Offer_Object.get("Active");
                Ofr_CreditAllowed = (String) Offer_Object.get("CreditAllowed");
            }
            {// Read data from the "Products Category" object
                JSONObject PRODCAT_Object = (JSONObject) jsonObject.get("Products Category");
                PRODCAT_SearchInfo = (String) PRODCAT_Object.get("SearchInfo");
                PRODCAT_Name = (String) PRODCAT_Object.get("name");
                PRODCAT_MainCategory = (String) PRODCAT_Object.get("maincategory");
                PRODCAT_Status = (String) PRODCAT_Object.get("status");
                PRODCAT_E_Name = (String) PRODCAT_Object.get("E_Name");
            }
            {// Read data from the "Products" object
                JSONObject PROD_Object = (JSONObject) jsonObject.get("Products");
                PROD_SearchInfo = (String) PROD_Object.get("SearchInfo");
                PROD_Code = (String) PROD_Object.get("Code");
                PROD_Name = (String) PROD_Object.get("Name");
                PROD_Category = (String) PROD_Object.get("Category");
                PROD_flavor = (String) PROD_Object.get("flavor");
                PROD_sizeML = (String) PROD_Object.get("sizeML");
                PROD_CtnPCS = (String) PROD_Object.get("CtnPCS");
                PROD_RetailPrice = (String) PROD_Object.get("RetailPrice");
                PROD_TradePrice = (String) PROD_Object.get("TradePrice");
                PROD_DistributorPrice = (String) PROD_Object.get("DistributorPrice");
                E_PROD_Code = (String) PROD_Object.get("E_Code");
                E_PROD_Name = (String) PROD_Object.get("E_Name");
                E_PROD_Category = (String) PROD_Object.get("E_Category");
                E_PROD_flavor = (String) PROD_Object.get("E_flavor");
                E_PROD_sizeML = (String) PROD_Object.get("E_sizeML");
                E_PROD_CtnPCS = (String) PROD_Object.get("E_CtnPCS");
                E_PROD_RetailPrice = (String) PROD_Object.get("E_RetailPrice");
                E_PROD_TradePrice = (String) PROD_Object.get("E_TradePrice");
                E_PROD_DistributorPrice = (String) PROD_Object.get("E_DistributorPrice");
            }
            {// Read data from the "Sales Return" object
                JSONObject PROD_Object = (JSONObject) jsonObject.get("Sales Return");
                SR_SearchInfo = (String) PROD_Object.get("SearchInfo");
                SR_DistributorSearch = (String) PROD_Object.get("DistributorSearch");
                SR_Store = (String) PROD_Object.get("Store");
                SR_Note = (String) PROD_Object.get("Note");
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return new String[]{};
    }
}
