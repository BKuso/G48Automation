package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest{


    private LoginPage loginPage;

    @Before
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void checkNegativeLogin(){
        loginPage.login("admin","admin");
        loginPage.validateErrorMessage("Incorrect username or password.");
    }

    @Test
    public void showCommitMessageTest(){
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .openProjectG48()
                .showCommitMessage()
                .logout();
    }




}
