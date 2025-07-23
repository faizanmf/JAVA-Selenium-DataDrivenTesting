package stepDeinition;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.LoginData;
import pages.LoginPage;
import utils.DBUtil;
import utils.ExcelUtil;

public class LoginSteps extends BaseClass {


    LoginPage login;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        initialize();
        login = new LoginPage(driver);
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        //--------to fetch data with row num and col num -------------//
//        String username = ExcelUtil.getCellData("LoginTest", 1, 0);
//        String password = ExcelUtil.getCellData("LoginTest", 1, 1);

        //--------to fetch data with row num and header name -------------//
//        String username = ExcelUtil.getCellDataByHeader("LoginTest", 1, "username");
//        String password = ExcelUtil.getCellDataByHeader("LoginTest", 1, "password");

        //--------to fetch data with database -------------//
        LoginData data = DBUtil.getLoginData();

        login.enterUsername(data.getUsername());
        login.enterPassword(data.getPassword());
//        login.enterUsername(username);
//        login.enterPassword(password);
        login.clickLogin();
    }

    @Then("User should be logged in")
    public void user_should_be_logged_in() {
        System.out.println("Login success - add validations as needed");
        teardown();
    }

}

