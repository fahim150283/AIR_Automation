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
                Distributors_Reference = (String) distributorsObject.get("Reference");
                Distributors_SDF = (String) distributorsObject.get("SDF");
                Distributors_RDF = (String) distributorsObject.get("RDF");
                Distributors_Region = (String) distributorsObject.get("Region");
                Distributors_depot = (String) distributorsObject.get("depot");
                Distributors_Area = (String) distributorsObject.get("Area");
                Distributors_territory = (String) distributorsObject.get("territory");
                Distributors_B_P_code = (String) distributorsObject.get("B P code");
                Distributors_RSM = (String) distributorsObject.get("RSM");
                Distributors_ASM_Sr_ASM = (String) distributorsObject.get("ASM / Sr. ASM");
                Distributors_FPR = (String) distributorsObject.get("FPR");
                Distributors_Running_FPR = (String) distributorsObject.get("Running FPR");
                Distributors_Identity_Of_Distributor = (String) distributorsObject.get("Identity Of Distributor");
                Distributors_Type_Of_Distributorship = (String) distributorsObject.get("Type Of Distributorship");
                Distributors_distributor_info = (String) distributorsObject.get("distributor info");
                Distributors_Name_Of_Distributor_Firm = (String) distributorsObject.get("Name Of Distributor/Firm");
                Distributors_Proprietor_Name = (String) distributorsObject.get("Proprietor Name");
                Distributors_Proprietor_Mobile_Number = (String) distributorsObject.get("Proprietor Mobile Number");
                Distributors_Contact_Person_Mobile_Number = (String) distributorsObject.get("Contact Person & Mobile Number");
                Distributors_Farm_Address = (String) distributorsObject.get("Farm Address");
                Distributors_Proprietor_Permanent_Address = (String) distributorsObject.get("Proprietor Permanent Address");
                Distributors_Proprietor_Present_Address = (String) distributorsObject.get("Proprietor Present Address");
                Distributors_Proprietor_National_ID_Number = (String) distributorsObject.get("Proprietor National ID Number");
                Distributors_Trade_License_Number_Last_Date = (String) distributorsObject.get("Trade License Number & Last Date");
                Distributors_Bank_Name_Branch = (String) distributorsObject.get("Bank Name & Branch");
                Distributors_Bank_Account_Number = (String) distributorsObject.get("Bank Account Number");
                Distributors_Name_Of_Existing_Business1 = (String) distributorsObject.get("Name Of Existing Business1");
                Distributors_Name_Of_Existing_Business2 = (String) distributorsObject.get("Name Of Existing Business2");
                Distributors_Existing_Business1_Starting_Year = (String) distributorsObject.get("Existing Business1 Starting Year");
                Distributors_Existing_Business2_Starting_Year = (String) distributorsObject.get("Existing Business2 Starting Year");
                Distributors_No_Of_Existing_Van_Puller_Or_DSR = (String) distributorsObject.get("No. Of Existing Van Puller & Or DSR");
                Distributors_Number_Of_Existing_Ice_Cream_Van = (String) distributorsObject.get("Number Of Existing Ice Cream Van");
                Distributors_Existing_Godown_Size_SQFT = (String) distributorsObject.get("Existing Godown Size (SQFT)");
                Distributors_Relation_With_Golden_Group_Entity = (String) distributorsObject.get("Relation With Golden Group Entity");
                Distributors_Area_Demarcation = (String) distributorsObject.get("Area Demarcation");
                Distributors_Point_Name = (String) distributorsObject.get("Point Name");
                Distributors_Routes = (String) distributorsObject.get("Routes");
                Distributors_Key_Markets = (String) distributorsObject.get("Key Markets");
                Distributors_Ice_Cream_Selling_Outlets_Territory = (String) distributorsObject.get("Ice Cream Selling Outlets Territory");
                Distributors_Existing_Avg_Market_Size_Tk_Yearly = (String) distributorsObject.get("Existing Avg Market Size (Tk) : (Yearly)");
                Distributors_discount_type = (String) distributorsObject.get("discount type");
                Distributors_discount_amount = (String) distributorsObject.get("discount amount");
                Distributors_C_Igloo = (String) distributorsObject.get("C_Igloo");
                Distributors_C_Polar = (String) distributorsObject.get("C_Polar");
                Distributors_C_Lovello = (String) distributorsObject.get("C_Lovello");
                Distributors_C_Kazi = (String) distributorsObject.get("C_Kazi");
                Distributors_C_Bloop = (String) distributorsObject.get("C_Bloop");
                Distributors_C_Kwality = (String) distributorsObject.get("C_Kwality");
                Distributors_C_Others = (String) distributorsObject.get("C_Others");
                Distributors_D_F_Igloo = (String) distributorsObject.get("D/F_Igloo");
                Distributors_D_F_Polar = (String) distributorsObject.get("D/F_Polar");
                Distributors_D_F_Lovello = (String) distributorsObject.get("D/F_Lovello");
                Distributors_D_F_Kazi = (String) distributorsObject.get("D/F_Kazi");
                Distributors_D_F_Bloop = (String) distributorsObject.get("D/F_Bloop");
                Distributors_D_F_Kwality = (String) distributorsObject.get("D/F_Kwality");
                Distributors_D_F_Others = (String) distributorsObject.get("D/F_Others");
                Distributors_S_Igloo = (String) distributorsObject.get("S_Igloo");
                Distributors_S_Polar = (String) distributorsObject.get("S_Polar");
                Distributors_S_Lovello = (String) distributorsObject.get("S_Lovello");
                Distributors_S_Kazi = (String) distributorsObject.get("S_Kazi");
                Distributors_S_Bloop = (String) distributorsObject.get("S_Bloop");
                Distributors_S_Kwality = (String) distributorsObject.get("S_Kwality");
                Distributors_S_Others = (String) distributorsObject.get("S_Others");
                Distributors_F_Igloo = (String) distributorsObject.get("F_Igloo");
                Distributors_F_Polar = (String) distributorsObject.get("F_Polar");
                Distributors_F_Lovello = (String) distributorsObject.get("F_Lovello");
                Distributors_F_Kazi = (String) distributorsObject.get("F_Kazi");
                Distributors_F_Bloop = (String) distributorsObject.get("F_Bloop");
                Distributors_F_Kwality = (String) distributorsObject.get("F_Kwality");
                Distributors_F_Others = (String) distributorsObject.get("F_Others");
                Distributors_Total_Investment_Tk = (String) distributorsObject.get("Total Investment (Tk)");
                Distributors_Initial_Lifting_In_Tk = (String) distributorsObject.get("Initial Lifting (In Tk)");
                Distributors_Number_Of_SDFs = (String) distributorsObject.get("Number Of SDFs");
                Distributors_Godown_Advance = (String) distributorsObject.get("Godown Advance");
                Distributors_Value_Of_SDFs = (String) distributorsObject.get("Value Of SDFs");
                Distributors_Market_Credit = (String) distributorsObject.get("Market Credit");
                Distributors_Number_Of_Van_S = (String) distributorsObject.get("Number Of Van(S)");
                Distributors_Running_Capital = (String) distributorsObject.get("Running Capital");
                Distributors_Value_Of_Vans_Tk = (String) distributorsObject.get("Value Of Vans (Tk)");
                Distributors_Type_Of_Transaction = (String) distributorsObject.get("Type Of Transaction");
                Distributors_RSMs_or_ASM_in_absence_of_RSM_Recommendation = (String) distributorsObject.get("RSM's (or ASM in absence of RSM) Recommendation");
                Distributors_GM_DGM_AGMs_Recommendation = (String) distributorsObject.get("GM/DGM/AGM's Recommendation");
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        String[] array = {};
        return array;
    }
}
