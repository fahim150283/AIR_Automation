package org.example.StepDefinitions;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class Rishat_Supplier extends Page_Options {
    String[] data_arr = new String[20];


    /*
    create a new supplier
    */
    @Given("login for creating new  supplier")
    public void login_for_creating_new_supplier() throws InterruptedException {
        Login(user_Siam);
        Thread.sleep(1000);
        driver.get("http://192.168.11.182/bpu/views/suppliers/");
    }

    @And("create new  supplier")
    public void create_new_supplier() throws InterruptedException {
        //click the plus button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[1]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        Thread.sleep(1000);

        //Supplier name
        id = "supplier_name";
        waitById(id);
        inputbyid(id, "John Cena");
        //Registered Address
        id = "reg_add";
        waitById(id);
        inputbyid(id, "Moscow, Russia");
        //Billing Address
        id = "bill_add";
        waitById(id);
        inputbyid(id, "Hiroshima, Japan");
        //Company phone
        id = "coy_phone";
        waitById(id);
        inputbyid(id, "01333333333");
        //Company email
        id = "coy_email";
        waitById(id);
        inputbyid(id, "DL@GG.com");
        //Trade Licence
        id = "tl_num";
        waitById(id);
        inputbyid(id, "2913333222");
        //TL Image
        id = "tl_img";
        waitById(id);
        inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Cucumber_For_AIR\\src\\main\\testing.jpg");
        //Tax Identification Number (TIN)
        id = "tin_num";
        waitById(id);
        inputbyid(id, "3256478913");
        //TIN Image
        id = "tin_img";
        waitById(id);
        inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Cucumber_For_AIR\\src\\main\\testing.jpg");
        //Business Identification Number (BIN)
        id = "bin_num";
        waitById(id);
        inputbyid(id, "5665656565");
        //BIN Image
        id = "bin_img";
        waitById(id);
        inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Cucumber_For_AIR\\src\\main\\testing.jpg");
        //Primary Contact Person
        id = "fp_name";
        waitById(id);
        inputbyid(id, "Fahim");
        //Designation
        id = "fp_designation";
        waitById(id);
        inputbyid(id, "Intern");
        //Phone
        id = "fp_phone";
        waitById(id);
        inputbyid(id, "01338888333");
        //Email
        id = "fp_email";
        waitById(id);
        inputbyid(id, "fahim@dl.com");
        //Secondary Contact Person:
        id = "sp_name";
        waitById(id);
        inputbyid(id, "Rishat");
        //Designation
        id = "sp_designation";
        waitById(id);
        inputbyid(id, "trainee");
        //Phone
        id = "sp_phone";
        waitById(id);
        inputbyid(id, "01222233311");
        //E-mail
        id = "sp_email";
        waitById(id);
        inputbyid(id, "rishat@sp.com");
        //Emergency Contact Person
        id = "ep_name";
        waitById(id);
        inputbyid(id, "Humpty Dumpty");
        //Designation
        id = "ep_designation";
        waitById(id);
        inputbyid(id, "President");
        //Phone
        id = "ep_phone";
        waitById(id);
        inputbyid(id, "01888888888");
        //Email
        id = "ep_email";
        waitById(id);
        inputbyid(id, "HD@DL.com");
        //Status
        Boolean active = true;
        if (active == false) {
            id = "add_status";
            waitById(id);
            clickbyId(id);
            pressDownbyid(id);
            pressEnterById(id);
        }
        //save
        xpath = "//*[@id=\"add_supplier_form\"]/div/div[15]/div/button";
        waitByxpath(xpath);
        clickbyxpath(xpath);
    }

    @Then("print the supplier list and close the supplier window")
    public void print_the_supplier_list_and_close_the_supplier_window() throws InterruptedException {
        Thread.sleep(1000);
        //click the print button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        Thread.sleep(5000);
        closedriver();
    }


    /*
    Search a  supplier
    */
    @Given("Login to Search supplier")
    public void login_to_search_supplier() throws InterruptedException {
        Login(user_Siam);
        Thread.sleep(1000);
        driver.get("http://192.168.11.182/bpu/views/suppliers/");
    }

    @When("search for supplier and copy important elements suppliers")
    public void search_for_supplier_and_copy_important_elements_suppliers() throws InterruptedException {
        Thread.sleep(1000);
        //search for supplier
        id = "search_input";
        waitById(id);
        inputbyid(id, "John Cena");
        Thread.sleep(500);

        //click the action button
        row_element_click_By_xpath_and_id("//td[p='John Cena']/ancestor::tr", "btn_view");

        //store the data
        int gononakorun1 = 0;
        int gononakorun2 = 0;
        int gononakorun3 = 3;
        Thread.sleep(1500);
        for (int i = 0; i < 21; i++) {
            if (i < 5) {
                xpath = "//tbody[@id='part1_body']/tr[" + (gononakorun1 + 2) + "]/td[3]";
                String s = get_row_text_byXpath(xpath);
                data_arr[i] = s.substring(2);
                gononakorun1++;
            } else if (4 < i && i <= 16) {
                if (gononakorun2 <= 11) {
                    xpath = "//tbody[@id='part2_body']/tr[" + (gononakorun2 + 1) + "]/td[3]";
                    String s = get_row_text_byXpath(xpath);
                    data_arr[i] = s.substring(2);
                    gononakorun2++;
                }
            } else if (i > 16) {
                if ((gononakorun3 == 3) || (gononakorun3 == 5) || (gononakorun3 == 7) ){
                    xpath = "//tbody[@id='part3_body']/tr[1]/td[" + gononakorun3 + "]";
                    String s = get_row_text_byXpath(xpath);
                    data_arr[i] = s.substring(2);
                    gononakorun3 = gononakorun3 + 2;
                }
            }
        }

        for (int i=0;i<20;i++){
            System.out.print(data_arr[i]+" , ");
        }
    }

    @Then("close  supplier for search")
    public void close_supplier_for_search() {

    }
}
