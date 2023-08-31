package org.example.StepDefinitions;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Page_Options;

public class Offer extends Page_Options {
//    String offer_type = "Gift"; //set as offer type
    String offer_type = "Cash"; //set as offer type
//    String offer_type = "Product"; //set as offer type
    String offerName = offer_type+"_" + randomTestString();



    /*
    creation of an offer
    */
    @Given("login for creation of an offer")
    public void login_for_creation_of_an_offer() {
        Login("h.abul");
        cssSelector = ".menues-bar:nth-child(14) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
        System.out.println(offerName);
    }

    @And("create new offer")
    public void create_new_offer() throws InterruptedException {
        //click create new button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        Thread.sleep(500);

        //offer info

        //offer name
        id = "add_offer_name";
        waitById(id);
        inputbyid(id, offerName);

        //valid from
        id = "valid_from";
        waitById(id);
        clickbyId(id);
        inputbyid(id, "08/25/002023'T'01:001P");
        pressEnterById(id);

        //valid to
        id = "valid_to";
        waitById(id);
        clickbyId(id);
        inputbyid(id, "08/08/002035'T'01:001P");


        //Products Included in the Offer

        //Number of categories
        int num_of_category = 3;
        for (int k = 0; k < num_of_category; k++) {
            //category
            id = "inc_prod_cat" + (k + 1);
            waitById(id);
            clickbyId(id);
            for (int i = 0; i < 5; i++) {
                pressDownbyid(id);
            }
            pressEnterById(id);

            //sub category
            id = "inc_prod_sub_cat" + (k + 1);
            waitById(id);
            clickbyId(id);
            for (int i = 0; i < 2; i++) {
                pressDownbyid(id);
            }
            pressEnterById(id);

            //product
            id = "inc_prod" + (k + 1);
            waitById(id);
            clickbyId(id);
            for (int i = 0; i < 9 - k; i++) {
                pressDownbyid(id);
            }
            waitById(id);
            pressEnterById(id);

            //Excluded items

            //sub category
            xpath = "//*[@id=\"raw-row-id" + (21 + k) + "\"]/td[5]/span/span[1]/span";
            waitByxpath(xpath);
            inputbyxpath(xpath, "cup");
            pressEnterbyXpath(xpath);
            pressEnterbyXpath(xpath);
            //products
            xpath = "//*[@id=\"raw-row-id" + (21 + k) + "\"]/td[6]/span/span[1]/span";
            waitByxpath(xpath);
            Thread.sleep(1000);
            clickbyxpath(xpath);
            for (int i = 0; i < 4 - k; i++) {
                pressDownbyXpath(xpath);
            }
            pressEnterbyXpath(xpath);
            pressESCbyXpath(xpath);

            if (k < num_of_category - 1) {
                Thread.sleep(1000);
                xpath = "//*[@id=\"prod_table\"]/tfoot/tr/td/span[1]";
                waitByxpath(xpath);
                clickbyxpath(xpath);
                Thread.sleep(500);
            }
        }

        //remove last category
        //click the checkbox
        Thread.sleep(500);
        xpath = "//tr[@id=\'raw-row-id23\']/td/label/span";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        //click the delete button
        xpath = "//table[@id=\'prod_table\']/tfoot/tr/td/span[2]/i";
        waitByxpath(xpath);
        clickbyxpath(xpath);


        //offer type
        id = "offer_type";
        waitById(id);
        clickbyId(id);


        if (offer_type == "Cash") {

            //choose the cash option
            id = "offer_type";
            pressDownbyid(id);
            pressEnterById(id);


            //Number of categories
            num_of_category = 3;
            for (int k = 0; k < num_of_category; k++) {

                //BDT or Precentage
                if (k % 2 == 0) {
                    //select percentage
                    id = "amount_type" + (k + 1);
                    clickbyId(id);
                    pressDownbyid(id);
                    pressEnterById(id);

                    //min amount
                    id = "c_min_amnt" + (k + 1);
                    waitById(id);
                    inputbyid(id, "" + (1000 * (k + 1)));

                    //Discount amount
                    id = "discount_amount" + (k + 1);
                    waitById(id);
                    inputbyid(id, "" + ((k + 1) * 10));

                } else {
                    //min amount
                    id = "c_min_amnt" + (k + 1);
                    waitById(id);
                    inputbyid(id, "" + (1000 * (k + 1)));

                    //Discount amount
                    id = "discount_amount" + (k + 1);
                    waitById(id);
                    inputbyid(id, "" + (100 * (k + 1)));
                }

                //click plus button
                if (k < num_of_category - 1) {
                    Thread.sleep(1000);
                    xpath = "//*[@id=\"amount_group\"]/div/table/tfoot/tr/td/span[1]";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                    Thread.sleep(500);
                }
            }
            //delete the last category
            //click the checkbox
            xpath = "//tr[@id=\'raw-row-id33\']/td/label/span";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //click delete button
            xpath = "//div[2]/div/table/tfoot/tr/td/span[2]/i";
            waitByxpath(xpath);
            clickbyxpath(xpath);


        }
        else if (offer_type == "Product") {

            //select product as gift type
            id = "offer_type";
            pressDownbyid(id);
            pressDownbyid(id);
            pressEnterById(id);

            //category
            num_of_category = 3;
            for (int k = 0; k < num_of_category; k++) {
                //min inv amount
                id = "min_amnt" + (k + 1);
                waitById(id);
                inputbyid(id, "1000");

                //min prod qty
                id = "min_prod_qty" + (k + 1);
                waitById(id);
                inputbyid(id, "5");

                //prod type
                id = "min_prod_type" + (k + 1);
                clickbyId(id);
                pressDownbyid(id);
                pressEnterById(id);

                //product category
                id = "prod_cat" + (k + 1);
                clickbyId(id);
                for (int i = 0; i < 4 - k; i++) {
                    pressDownbyid(id);
                }
                pressEnterById(id);

                //ctn
                id = "ctn" + (k + 1);
                clearById(id);
                inputbyid(id, "3");


                //click the plus button to add a category
                if (k < num_of_category - 1) {
                    Thread.sleep(1000);
                    xpath = "//*[@id=\"prod_cat_group\"]/div/table/tfoot/tr/td/span[1]";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                    Thread.sleep(500);
                }

            }

            //click the checkbox
            xpath = "//tr[@id='raw-row-id3']/td/label/span";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //click the delete button
            xpath = "//div[@id='prod_cat_group']/div/table/tfoot/tr/td/span[2]/i";
            waitByxpath(xpath);
            clickbyxpath(xpath);

        }
        else if (offer_type == "Gift") {

            //choose gift
            id = "offer_type";
            pressDownbyid(id);
            pressDownbyid(id);
            pressDownbyid(id);
            pressEnterById(id);

            num_of_category = 3;
            for (int k = 0; k < num_of_category; k++) {
                //min amount
                id = "g_min_amnt"+(k+1);
                waitById(id);
                inputbyid(id, "1000");

                //gift name
                id = "gift_name"+(k+1);
                clickbyId(id);
                pressDownbyid(id);
                pressEnterById(id);

                //quantity
                id = "quantity"+(k+1);
                waitById(id);
                inputbyid(id, "8");

                //click plus button
                if (k < num_of_category - 1) {
                    Thread.sleep(1000);
                    xpath = "//*[@id=\"gift_grp\"]/div/table/tfoot/tr/td/span[1]";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                    Thread.sleep(500);
                }
            }
            //delete the last category
            //click the checkbox
            xpath = "//*[@id=\"raw-row-id43\"]/td[1]/label/span";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //click delete button
            xpath = "//*[@id=\"gift_grp\"]/div/table/tfoot/tr/td/span[2]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
        }

        //choose the region
        xpath = "//*[@id=\"add_offer_form\"]/div/div[4]/div[1]/span/span[1]/span/span/textarea";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        for (int i=0; i<3; i++) {
            pressDownbyXpath(xpath);
        }
        pressEnterbyXpath(xpath);
        pressESCbyXpath(xpath);

        //choose the depot
        xpath = "//*[@id=\"depot_grp\"]/span/span[1]/span/span/textarea";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        pressDownbyXpath(xpath);
        pressEnterbyXpath(xpath);
        pressESCbyXpath(xpath);

        //choose the area
        xpath = "//*[@id=\"area_grp\"]/span/span[1]/span/span/textarea";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        pressDownbyXpath(xpath);
        pressEnterbyXpath(xpath);
        pressESCbyXpath(xpath);

        //choose the territory
        xpath = "//*[@id=\"territory_grp\"]/span/span[1]/span/span/textarea";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        for (int i = 0; i < 3; i++) {
            pressDownbyXpath(xpath);
        }
        pressEnterbyXpath(xpath);
        pressESCbyXpath(xpath);

        //choose the Distributor
        xpath = "//*[@id=\"distributor_grp\"]/span/span[1]/span/span/textarea";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        pressEnterbyXpath(xpath);
        pressESCbyXpath(xpath);

        //choose the Excluded Distributors
        xpath = "//*[@id=\"ex_distributor_grp\"]/span/span[1]/span/span/textarea";
        waitByxpath(xpath);
        inputbyxpath(xpath,"liton");
        pressEnterbyXpath(xpath);
        pressESCbyXpath(xpath);

        //save and send for approval
        xpath = "//*[@id=\"submit_offer_add_sent\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

    }

    @Then("close the offer window")
    public void close_the_offer_window() throws InterruptedException {
        closedriver();
    }



    /*
    creation of an offer
    */
    @Given("login to check if the offer is created")
    public void login_to_check_if_the_offer_is_created() {
        Login("h.abul");
        cssSelector = ".menues-bar:nth-child(14) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
        System.out.println(offerName);
    }
    @Given("search for the offer")
    public void search_for_the_offer() {

    }
    @Then("close the window to search for the offer")
    public void close_the_window_to_search_for_the_offer() {

    }
}
