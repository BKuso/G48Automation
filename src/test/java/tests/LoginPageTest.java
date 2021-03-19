package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;

public class LoginPageTest extends BaseTest{


    private LoginPageObject loginPage;

    @Before
    public void setUp(){
        loginPage = new LoginPageObject(driver);
    }

    @Test
    public void checkLogin(){
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        //  loginPage.validateErrorMessage("Incorrect username or password.");
    }




}
