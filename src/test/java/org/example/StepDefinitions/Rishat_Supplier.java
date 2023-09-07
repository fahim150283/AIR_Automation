package org.example.StepDefinitions;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

import java.awt.*;

public class Rishat_Supplier extends Page_Options {
    String[] inputData_arr = new String[20];
    String[] savedData_arr = new String[20];


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
        inputData_arr[0]="John Chikna";
        inputbyid(id, inputData_arr[0]);
        //Registered Address
        id = "reg_add";
        waitById(id);
        inputData_arr[1]="Moscow, Russia";
        inputbyid(id, inputData_arr[1]);
        //Billing Address
        id = "bill_add";
        waitById(id);
        inputData_arr[2]="Hiroshima, Japan";
        inputbyid(id,inputData_arr[2] );
        //Company phone
        id = "coy_phone";
        waitById(id);
        inputData_arr[3]="01333333333";
        inputbyid(id, inputData_arr[3]);
        //Company email
        id = "coy_email";
        waitById(id);
        inputData_arr[4]="DL@GG.com";
        inputbyid(id, inputData_arr[4]);
        //Trade Licence
        id = "tl_num";
        waitById(id);
        inputData_arr[17]="2913333222";
        inputbyid(id,  inputData_arr[17]);
        //TL Image
        id = "tl_img";
        waitById(id);
        inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Cucumber_For_AIR\\src\\main\\testing.jpg");
        //Tax Identification Number (TIN)
        id = "tin_num";
        waitById(id);
        inputData_arr[18]="3256478913";
        inputbyid(id, inputData_arr[18]);
        //TIN Image
        id = "tin_img";
        waitById(id);
        inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Cucumber_For_AIR\\src\\main\\testing.jpg");
        //Business Identification Number (BIN)
        id = "bin_num";
        waitById(id);
        inputData_arr[19]="5665656565";
        inputbyid(id, inputData_arr[19]);
        //BIN Image
        id = "bin_img";
        waitById(id);
        inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Cucumber_For_AIR\\src\\main\\testing.jpg");
        //Primary Contact Person
        id = "fp_name";
        waitById(id);
        inputData_arr[5]="Fahim";
        inputbyid(id, inputData_arr[5]);
        //Designation
        id = "fp_designation";
        waitById(id);
        inputData_arr[6]="Intern";
        inputbyid(id, inputData_arr[6]);
        //Phone
        id = "fp_phone";
        waitById(id);
        inputData_arr[7]="01338888333";
        inputbyid(id, inputData_arr[7]);
        //Email
        id = "fp_email";
        waitById(id);
        inputData_arr[8]="fahim@dl.com";
        inputbyid(id, inputData_arr[8]);
        //Secondary Contact Person:
        id = "sp_name";
        waitById(id);
        inputData_arr[9]="Rishat";
        inputbyid(id,  inputData_arr[9]);
        //Designation
        id = "sp_designation";
        waitById(id);
        inputData_arr[10]="trainee";
        inputbyid(id, inputData_arr[10]);
        //Phone
        id = "sp_phone";
        waitById(id);
        inputData_arr[11]="01222233311";
        inputbyid(id, inputData_arr[11]);
        //E-mail
        id = "sp_email";
        waitById(id);
        inputData_arr[12]="rishat@sp.com";
        inputbyid(id, inputData_arr[12]);
        //Emergency Contact Person
        id = "ep_name";
        waitById(id);
        inputData_arr[13]="Humpty Dumpty";
        inputbyid(id, inputData_arr[13]);
        //Designation
        id = "ep_designation";
        waitById(id);
        inputData_arr[14]="President";
        inputbyid(id, inputData_arr[14]);
        //Phone
        id = "ep_phone";
        waitById(id);
        inputData_arr[15]="01888888888";
        inputbyid(id, inputData_arr[15]);
        //Email
        id = "ep_email";
        waitById(id);
        inputData_arr[16]="HD@DL.com";
        inputbyid(id, inputData_arr[16]);
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

        for(int i=0;i< inputData_arr.length;i++){
            System.out.print(inputData_arr[i]+" , ");
        }
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
                savedData_arr[i] = s.substring(2);
                gononakorun1++;
            } else if (4 < i && i <= 16) {
                if (gononakorun2 <= 11) {
                    xpath = "//tbody[@id='part2_body']/tr[" + (gononakorun2 + 1) + "]/td[3]";
                    String s = get_row_text_byXpath(xpath);
                    savedData_arr[i] = s.substring(2);
                    gononakorun2++;
                }
            } else if (i > 16) {
                if ((gononakorun3 == 3) || (gononakorun3 == 5) || (gononakorun3 == 7) ){
                    xpath = "//tbody[@id='part3_body']/tr[1]/td[" + gononakorun3 + "]";
                    String s = get_row_text_byXpath(xpath);
                    savedData_arr[i] = s.substring(2);
                    gononakorun3 = gononakorun3 + 2;
                }
            }
        }
    }

    @Then("close  supplier for search after verification")
    public void close_supplier_for_search_after_verification() throws InterruptedException {



        closedriver();
    }
}
