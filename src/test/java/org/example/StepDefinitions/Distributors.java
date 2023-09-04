package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

import java.util.Random;

public class Distributors extends Page_Options {
    @Given("login for creation of a Distributor")
    public void login_for_creation_of_a_distributor() {
        Login(user_Fahim);

        cssSelector = ".menues-bar:nth-child(10) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }
    @And("create new Distributor")
    public void create_new_distributor() throws InterruptedException {
        //click the create new button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        Thread.sleep(1500);

        //Add photo or image
        id = "add_o_image";
        waitById(id);
        inputbyid(id,"G:\\Abul Hossain Chowdhury\\Projects\\Cucumber_For_AIR\\src\\main\\testing.jpg");
        Thread.sleep(1000);

        //Reference
        id = "add_ref";
        inputbyid(id,"Nobody");
        //SDF
        id = "add_sdf";
        inputbyid(id,"Nobody");
        //RDF
        id = "add_rdf";
        inputbyid(id,"Nobody");
        //date
        id = "add_start_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id,getToday());
        //Region
        id = "select2-region_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "Cumilla");
        cssSelectorPressEnter(cssSelector);

        //depot
        id = "select2-depot_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "Noakhali");
        cssSelectorPressEnter(cssSelector);

        //Area
        id = "select2-area_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "area");
        cssSelectorPressEnter(cssSelector);

        //territory
        id = "select2-add_territory_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "default");
        cssSelectorPressEnter(cssSelector);


        // Create a Random object
        Random random = new Random();
        // Generate a random number
        int randomNumber = random.nextInt(99999);
        // Concatenate the random number to the string
        String result = "TEST" + randomNumber;

        //B P code
        id = "add_code";
        waitById(id);
        inputbyid(id,result);

        //RSM
        Thread.sleep(1500);
        id = "select2-add_rsm_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "1221");
        cssSelectorPressEnter(cssSelector);

        //  ASM / Sr. ASM
        id = "select2-add_asm_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "1921");
        cssSelectorPressEnter(cssSelector);

        //FPR
        id = "select2-add_fpr_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "1924");
        cssSelectorPressEnter(cssSelector);

        //Running FPR
        id = "select2-add_running_fpr_list-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "2062");
        cssSelectorPressEnter(cssSelector);

        //Effective date
        xpath = "//*[@id=\"add_eff_running_fpr_start_date\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        inputbyxpath(xpath,getToday());



        //Proposed distributors information



        //Identity Of Distributor
        id = "select2-add_distri_identity-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "regular");
        cssSelectorPressEnter(cssSelector);

        //Type Of Distributorship
        id = "select2-add_distri_type-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "new");
        cssSelectorPressEnter(cssSelector);
        //distributor info
        id = "add_dist_info";
        waitById(id);
        inputbyid(id, "This distributor is created for testing purpose only");


        //Name Of Distributor/Firm
        String name = "TEST" + random.nextInt(99999);
        id = "add_name";
        waitById(id);
        inputbyid(id,name);

        //Proprietor Name
        id = "add_o_name";
        waitById(id);
        inputbyid(id, "Amar Vai Tomar Vai");

        //Proprietor Mobile Number
        id = "add_o_mobile";
        waitById(id);
        inputbyid(id, "TestStore");

        //Contact Person & Mobile Number
        id = "add_cp_mobile";
        waitById(id);
        inputbyid(id, "05234567890");

        //Farm Address
        id = "add_address";
        waitById(id);
        inputbyid(id, "Dotterhat");


        //Proprietor Permanent Address
        id = "add_o_address";
        waitById(id);
        inputbyid(id, "Maijdee");

        //Proprietor Present Address
        id = "add_o_pre_address";
        waitById(id);
        inputbyid(id, "Maijdee Bazar");

        //Proprietor National ID Number
        id = "add_o_nid";
        waitById(id);
        inputbyid(id, "456123547");

        //Trade License Number & Last Date
        id = "add_tl_number";
        waitById(id);
        inputbyid(id, "987654321");
        id= "add_tl_lastDate";
        waitById(id);
        clickbyId(id);
        inputbyid(id, "02/02/2026");

        //Bank Name & Branch
        id = "add_b_name_b_branch";
        clickbyId(id);
        inputbyid(id, "EBL");

        //Bank Account Number
        id = "add_b_account";
        clickbyId(id);
        inputbyid(id, "98787989845457879");

        //Name Of Existing Business
        id="add_exist_bus_name1";
        clickbyId(id);
        inputbyid(id, "Fisheries");
        id="add_exist_bus_name2";
        clickbyId(id);
        inputbyid(id, "Supershop");


        //Existing Business Starting Year
        id = "add_exist_start1";
        clickbyId(id);
        inputbyid(id, "2022");
        id = "add_exist_start2";
        clickbyId(id);
        inputbyid(id, "2021");

        //No. Of Existing Van Puller & Or DSR
        id = "add_exist_van_puller";
        clickbyId(id);
        inputbyid(id, "22");

        //Number Of Existing Ice Cream Van
        id = "add_exist_ice_van";
        clickbyId(id);
        inputbyid(id, "10");

        //Existing Godown Size (SQFT)
        id = "add_exist_gd_size";
        clickbyId(id);
        inputbyid(id, "2000");

        //Relation With Golden Group Entity
        id = "add_rel_gge";
        waitById(id);
        inputbyid(id,"none");


        //Market information


        //Area Demarcation
        xpath = "//*[@id=\"add_distributors_form\"]/div/div/div/div/div[3]/div/table/tbody/tr[1]/td[3]/span/span[1]/span";
        waitByxpath(xpath);
        inputbyxpath(xpath,"noakhali");
        pressEnterbyXpath(xpath);
        pressESCbyXpath(xpath);

        //Point Name
        id = "add_point_name";
        inputbyid(id,"Dotterhat,Maijdee");

        //Routes
        xpath = "//*[@id=\"add_distributors_form\"]/div/div/div/div/div[3]/div/table/tbody/tr[3]/td[3]/span/span[1]/span";
        waitByxpath(xpath);
        inputbyxpath(xpath,"default");
        pressEnterbyXpath(xpath);
        pressESCbyXpath(xpath);


        //Key Markets
        id = "add_k_market";
        waitById(id);
        inputbyid(id, "maijdee,Dotter hat, maijdee bazars");

        //Ice Cream Selling Outlets Territory
        id = "add_ice_outlets";
        waitById(id);
        inputbyid(id, "maijdee,Dotter hat, maijdee bazars");

        //Existing Avg Market Size (Tk) : (Yearly)
        id = "add_exist_avg_m_size";
        waitById(id);
        inputbyid(id,"6000000");


        //Discount Information




        //Special Discount

        //discount type
        id = "select2-special_discount_type-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, "%");
        cssSelectorPressEnter(cssSelector);
        //discount amount
        id = "special_discount";
        waitById(id);
        clearById(id);
        inputbyid(id,"7");



        //Competitors Intelligence : (Yearly)


        //Existing Market Contribution (Taka)
        //Igloo
        id = "add_ig_cont";
        waitById(id);
        inputbyid(id,"10000");
        // Polar
        id = "add_po_cont";
        waitById(id);
        inputbyid(id,"20000");
        // Lovello
        id = "add_lo_cont";
        waitById(id);
        inputbyid(id,"25000");
        // Kazi
        id = "add_ka_cont";
        waitById(id);
        inputbyid(id,"30000");
        // Bloop
        id = "add_bl_cont";
        waitById(id);
        inputbyid(id,"35000");
        // Kwality
        id = "add_kw_cont";
        waitById(id);
        inputbyid(id,"40000");
        // Others
        id = "add_others_cont";
        waitById(id);
        inputbyid(id,"45000");


        //D/F Quantity Of The Competitors
        //Igloo
        id = "add_ig_comp";
        waitById(id);
        inputbyid(id,"1000");
        // Polar
        id = "add_po_comp";
        waitById(id);
        inputbyid(id,"2000");
        // Lovello
        id = "add_lo_comp";
        waitById(id);
        inputbyid(id,"3000");
        // Kazi
        id = "add_ka_comp";
        waitById(id);
        inputbyid(id,"2500");
        // Bloop
        id = "add_bl_comp";
        waitById(id);
        inputbyid(id,"3500");
        // Kwality
        id = "add_kw_comp";
        waitById(id);
        inputbyid(id,"4000");
        // Others
        id = "add_others_comp";
        waitById(id);
        inputbyid(id,"4500");




        //Expected Sales


        //Expected Monthly Sales(in taka)
        id = "add_m1_sales";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m2_sales";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m3_sales";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m4_sales";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m5_sales";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m6_sales";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m7_sales";
        waitById(id);
        inputbyid(id,"1000");

        //Expected Number Of Freezers Injection
        id = "add_m1_inj";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m2_inj";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m3_inj";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m4_inj";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m5_inj";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m6_inj";
        waitById(id);
        inputbyid(id,"1000");
        id = "add_m7_inj";
        waitById(id);
        inputbyid(id,"1000");




        //Investment Information




        //Total Investment (Tk)
        id = "add_total_inv";
        waitById(id);
        inputbyid(id,"1000");

        //Initial Lifting (In Tk)
        id = "add_init_lifting";
        waitById(id);
        inputbyid(id,"1000");

        //Number Of SDFs :
        id = "add_num_SDF";
        waitById(id);
        inputbyid(id,"1000");

        //Godown Advance (Tk) :
        id = "add_gd_adv";
        waitById(id);
        inputbyid(id,"1000");

        //Value Of SDFs (Tk) :
        id = "add_val_SDF";
        waitById(id);
        inputbyid(id,"1000");

        //Market Credit :
        id = "add_m_credit";
        waitById(id);
        inputbyid(id,"1000");

        //Number Of Van(S) :
        id = "add_num_vans";
        waitById(id);
        inputbyid(id,"1000");

        //Running Capital :
        id = "add_run_capital";
        waitById(id);
        inputbyid(id,"1000");

        //Value Of Vans (Tk) :
        id = "add_val_vans";
        waitById(id);
        inputbyid(id,"1000");

        //Type Of Transaction :
        id = "add_transac_type";
        waitById(id);
        inputbyid(id,"1000");

        //RSM's (or ASM in absence of RSM) Recommendation
        id = "add_rsm_recom";
        waitById(id);
        inputbyid(id,"1000");

        //GM/DGM/AGM's Recommendation
        id = "add_gm_recom";
        waitById(id);
        inputbyid(id,"1000");



        //Agreement Image
        //Add photo or image
        id = "add_agree_image";
        waitById(id);
        inputbyid(id,"G:\\Abul Hossain Chowdhury\\Projects\\Cucumber_For_AIR\\src\\main\\agreement.jpg");
        Thread.sleep(1000);

        //Approval Image
        //Add photo or image
        id = "add_approval_image";
        waitById(id);
        inputbyid(id,"G:\\Abul Hossain Chowdhury\\Projects\\Cucumber_For_AIR\\src\\main\\approved.jpg");
        Thread.sleep(1000);

        //Trade License Image
        //Add photo or image
        id = "add_tl_image";
        waitById(id);
        inputbyid(id,"G:\\Abul Hossain Chowdhury\\Projects\\Cucumber_For_AIR\\src\\main\\trade licence.png");
        Thread.sleep(1000);

        //Status
        id = "add_status";
        waitById(id);
        clickbyId(id);
        xpath = "//option[. = 'Active']";
        waitByxpath(xpath);
        clickbyxpath(xpath);


        //Approve
        id = "add_is_approve";
        waitById(id);
        clickbyId(id);
        xpath = "//*[@id=\"add_is_approve\"]/option[1]";
        waitByxpath(xpath);
        clickbyxpath(xpath);


        //Approval Date
        id = "add_appr_start_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id,getLastMonth());

        //Closing Date:
        id = "add_appr_close_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id,"01/01/2030");


        //Save button
        id = "add_distributors";
        clickbyId(id);
    }
    @Then("close the Distributor window")
    public void close_the_distributor_window() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }


//    @Given("Login to Search Distributor")
//    public void login_to_search_distributor() {
//        url = "http://192.168.11.182/air_2/air";
//        navigatetourl(url);
//        id = "username";
//        inputbyid(id, "h.abul");
//        id = "password";
//        inputbyid(id, "savoy123");
//        id = "login";
//        clickbyId(id);
//
//        cssSelector = ".menues-bar:nth-child(10) .active";
//        waitByCssSelector(cssSelector);
//        clickbycssselector(cssSelector);
//    }
//    @When("search for Distributor")
//    public void search_for_distributor() throws InterruptedException {
//        Thread.sleep(2000);
//        id = "search_input1";
//        waitById(id);
//        inputbyid(id, "TEST123");
//    }
//
//    @And("description of a Distributor")
//    public void descriptionOfADistributor() throws InterruptedException {
//        Thread.sleep(2000);
//        cssSelector = "#btn_view";
//        waitByCssSelector(cssSelector);
//        clickbycssselector(cssSelector);
//    }
//
//    @Then("close Distributor for search")
//    public void close_distributor_for_search() throws InterruptedException {
//        Thread.sleep(2000);
//        closedriver();
//    }
//
//
//    @Given("Login to edit a Distributor")
//    public void login_to_edit_a_distributor() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("search for a Distributor to edit")
//    public void search_for_a_distributor_to_edit() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @And("edit")
//    public void edit() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("close Distributor for editing")
//    public void close_distributor_for_editing() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
}
