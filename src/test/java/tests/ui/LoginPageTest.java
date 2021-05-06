package tests.ui;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pages.LoginPage;

@Story("Positive")
@Feature("Github Authorization")
@Owner("BKuso")
@Severity(SeverityLevel.CRITICAL)
public class LoginPageTest extends BaseTest{


    private LoginPage loginPage;

    @Before
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @Ignore("Дублирует параметризированный тест")
    @Test
    public void checkNegativeLogin(){
        loginPage.login("BKuso","1243asdsxx");
        loginPage.validateErrorMessage("Incorrect username or password.");
    }


    @Description("Тест нужен чтобы показать последнее сообщение коммита")
    @DisplayName("Показать сообщение коммита")
    @Test
    public void showCommitMessageTest(){
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .openProjectG48()
                .showCommitMessage()
                .logout();
    }




}
